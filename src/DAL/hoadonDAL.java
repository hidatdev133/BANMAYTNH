package DAL;

import DTO.hoadonDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import DBUtils.DBUtils;
import DTO.sanphamDTO;
import java.beans.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class hoadonDAL {
    private static hoadonDAL instance;

    public hoadonDAL() {
    }

    public static hoadonDAL getInstance() {
        if (instance == null) {
            instance = new hoadonDAL();
        }
        return instance;
    }

    public int getuncheckHoadonByidkhachhang(String id) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `hoadon` WHERE `makhachhang` = ? AND `trangthai` = 0");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
//                Invoices invoices = new Invoices(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                return rs.getInt(1);
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
        return -1;
    }
    
   public ArrayList<hoadonDTO> getAllhoadon() {
         // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<hoadonDTO> hoadonarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from hoadon");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                hoadonDTO hoadondto = new hoadonDTO();
                hoadondto.setMahoadon(rs.getInt("mahoadon"));
                hoadondto.setMakhachhang(rs.getString("makhachhang"));
                hoadondto.setTenkhachhang(rs.getString("tenkhachhang"));
                hoadondto.setSoluong(rs.getInt("soluong"));
                hoadondto.setTensanpham(rs.getString("tensanpham"));
                hoadondto.setGiasanpham(rs.getInt("giasanpham"));
                hoadondto.setThanhtien(rs.getInt("thanhtien"));
               
                hoadonarr.add(hoadondto);
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
        return hoadonarr ;
    }
    
    public ArrayList<hoadonDTO> searchhoadon(String keyword) {
        ArrayList<hoadonDTO> hoadonarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from hoadon where mahoadon like '%" + keyword + "%' "
                    + " or makhachhang like '%" + keyword + "%'"
                    + " or tenkhachhang like '%" + keyword + "%'"
                    + " or soluong like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                hoadonDTO hoadondto = new hoadonDTO();
                hoadondto.setMahoadon(rs.getInt(1));
                hoadondto.setMakhachhang(rs.getString(2));
                hoadondto.setTenkhachhang(rs.getString(3));
                hoadondto.setSoluong(rs.getInt(4));
                
                hoadonarr.add(hoadondto);
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
        return hoadonarr ; 
    }
    public Boolean inserthoadon(String idTaikhoan) {
        Connection con = DBUtils.getConnection();
        try {
            java.sql.Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO `hoadon`(`makhachhang`, `trangthai`) VALUES ('" + idTaikhoan + "',0)");
            if (i > 0) {
                return true;
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
        return false;
    }
    public int inserthoadon(hoadonDTO hoadondto) {
        int result = 0;
        String sql = "insert into hoadon value (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hoadondto.getMahoadon());
            pre.setString(2, hoadondto.getMakhachhang());
            pre.setString(3, hoadondto.getTenkhachhang());
            pre.setInt(4, hoadondto.getSoluong());
            pre.setString(5, hoadondto.getTensanpham());
            pre.setInt(6, hoadondto.getGiasanpham());
            pre.setInt(7, hoadondto.getThanhtien());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void update(int id, int tongtien) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("UPDATE hoadon SET trangthai = 1, thanhtien = ? WHERE mahoadon = ?");
            pre.setInt(1, tongtien);
            pre.setInt(2, id);
            pre.executeUpdate();
//                int i = pstmt.executeUpdate();
//                if (i > 0) {
//                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int updatehoadon(hoadonDTO hoadondto) {
        int result = 0;
        String sql = "update hoadon set mahoadon=?, makhachhang=?, tenkhachhang=?, soluong=? where mahoadon=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hoadondto.getMahoadon());
            pre.setString(2, hoadondto.getMakhachhang());
            pre.setString(3, hoadondto.getTenkhachhang());
            pre.setInt(4, hoadondto.getSoluong());
            pre.setInt(5, hoadondto.getMahoadon());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int GetMaxIdInvoice() {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT max(mahoadon) FROM `hoadon`");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }
    public int deletehoadon(hoadonDTO hoadondto) {
        int result = 0;
        String sql = "delete from hoadon where mahoadon = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hoadondto.getMahoadon());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
   
//    public void tongtien(int makhachhang, int tongtien) {
//                Connection con = DBUtility.openConnection();
//        try {
//            PreparedStatement pstmt = con.prepareStatement("update `invoice` SET `status`= 1, `total_price` = ? WHERE `ID` = ?");
//            pstmt.setInt(1, totalPrice);
//            pstmt.setInt(2, id);
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(InvoicesDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
