package DAL;

import DTO.taikhoanDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import DBUtils.DBUtils;
import java.beans.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class taikhoanDAL {
    private static taikhoanDAL instance;
    taikhoanDTO taikhoandto = new taikhoanDTO();
    
     public static taikhoanDAL getInstance() {
        if (instance == null) {
            instance = new taikhoanDAL();
        }
        return instance;
    }

    public static void setInstance(taikhoanDAL instance) {
        taikhoanDAL.instance = instance;
    }
    
    public taikhoanDTO GetAccount() {
        return taikhoandto;
    }
    
    public Boolean DoiMatKhau(String userID, String password) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `account` SET ` userID=?, password`=? WHERE userID=?");
            pstmt.setString(1, password);
            pstmt.setString(2, password);
            pstmt.setString(3, userID);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(taikhoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<taikhoanDTO> getAlltaikhoan() {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<taikhoanDTO> taikhoanarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from account");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                taikhoanDTO taikhoandto = new taikhoanDTO();
                taikhoandto.setUserID(rs.getString("userID"));
                taikhoandto.setUsername(rs.getString("username"));
                taikhoandto.setPassword(rs.getString("password"));
                taikhoandto.setManhanvien(rs.getString("manhanvien"));
                taikhoandto.setHotenhanvien(rs.getString("hotennhanvien"));
                taikhoandto.setGioitinh(rs.getString("gioitinh"));
                taikhoandto.setDiachi(rs.getString("diachi"));
                taikhoandto.setQuyen(rs.getString("quyen"));

                taikhoanarr.add(taikhoandto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return taikhoanarr;
    }

    public int inserttaikhoan(taikhoanDTO taikhoandto) {
        int result = 0;
        String sql = "insert into account value (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, taikhoandto.getUserID());
            pre.setString(2, taikhoandto.getUsername());
            pre.setString(3, taikhoandto.getPassword());
            pre.setString(4, taikhoandto.getManhanvien());
            pre.setString(5, taikhoandto.getHotenhanvien());
            pre.setString(6, taikhoandto.getGioitinh());
            pre.setString(7, taikhoandto.getDiachi());
            pre.setString(8, taikhoandto.getQuyen());

            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatetaikhoan(taikhoanDTO taikhoandto) {
        int result = 0;
        String sql = "update account set userID=?, username=?, password=?, manhanvien=?, hotennhanvien=?, gioitinh=?, diachi=?, quyen=? where userID=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, taikhoandto.getUserID());
            pre.setString(2, taikhoandto.getUsername());
            pre.setString(3, taikhoandto.getPassword());
            pre.setString(4, taikhoandto.getManhanvien());
            pre.setString(5, taikhoandto.getHotenhanvien());
            pre.setString(6, taikhoandto.getGioitinh());
            pre.setString(7, taikhoandto.getDiachi());
            pre.setString(8, taikhoandto.getQuyen());
            pre.setString(9, taikhoandto.getUserID());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletetaikhoan(taikhoanDTO taikhoandto) {
        int result = 0;
        String sql = "delete from account where userID = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, taikhoandto.getUserID());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<taikhoanDTO> searchtaikhoan(String keyword) {
                ArrayList<taikhoanDTO> taikhoanarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from account where userid like '%" + keyword + "%' "
                    + "or username like '%" + keyword + "%'"
                    + " or password like '%" + keyword + "%'"
                    + " or manhanvien like '%" + keyword + "%'"
                    + " or hotennhanvien like '%" + keyword + "%'"
                    + " or gioitinh like '%" + keyword + "%'"
                    + " or diachi like '%" + keyword + "%'"
                    + " or quyen like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                taikhoanDTO taikhoandto = new taikhoanDTO();
                taikhoandto.setUserID(rs.getString(1));
                taikhoandto.setUsername(rs.getString(2));
                taikhoandto.setPassword(rs.getString(3));
                taikhoandto.setManhanvien(rs.getString(4));
                taikhoandto.setHotenhanvien(rs.getString(5));
                taikhoandto.setGioitinh(rs.getString(6));
                taikhoandto.setDiachi(rs.getString(7));
                taikhoandto.setQuyen(rs.getString(8));
                
                taikhoanarr.add(taikhoandto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                con.close();   
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return taikhoanarr ; 
    }
    
}
