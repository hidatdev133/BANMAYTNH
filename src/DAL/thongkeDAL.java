package DAL;

import DTO.thongkeDTO;
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
public class thongkeDAL {
    
    
   public ArrayList<thongkeDTO> getAllhoadon() {
         // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<thongkeDTO> hoadonarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from hoadon");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                thongkeDTO hoadondto = new thongkeDTO();
                hoadondto.setMahoadon(rs.getString("mahoadon"));
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
    
    public ArrayList<thongkeDTO> searchhoadon(String keyword) {
        ArrayList<thongkeDTO> hoadonarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from hoadon where mahoadon like '%" + keyword + "%' "
                    + " or makhachhang like '%" + keyword + "%'"
                    + " or tenkhachhang like '%" + keyword + "%'"
                    + " or soluong like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                thongkeDTO hoadondto = new thongkeDTO();
                hoadondto.setMahoadon(rs.getString(1));
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

    public int inserthoadon(thongkeDTO hoadondto) {
        int result = 0;
        String sql = "insert into hoadon value (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, hoadondto.getMahoadon());
            pre.setString(2, hoadondto.getMakhachhang());
            pre.setString(3, hoadondto.getTenkhachhang());
            pre.setInt(4, hoadondto.getSoluong());
            pre.setString(5, hoadondto.getTensanpham());
            pre.setInt(6, hoadondto.getGiasanpham());
            pre.setInt(8, hoadondto.getThanhtien());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatehoadon(thongkeDTO hoadondto) {
        int result = 0;
        String sql = "update hoadon set mahoadon=?, makhachhang=?, tenkhachhang=?, soluong=? where mahoadon=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, hoadondto.getMahoadon());
            pre.setString(2, hoadondto.getMakhachhang());
            pre.setString(3, hoadondto.getTenkhachhang());
            pre.setInt(4, hoadondto.getSoluong());
            pre.setString(5, hoadondto.getMahoadon());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletehoadon(thongkeDTO hoadondto) {
        int result = 0;
        String sql = "delete from hoadon where mahoadon = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, hoadondto.getMahoadon());
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
