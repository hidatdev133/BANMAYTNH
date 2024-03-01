package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import DTO.khachhangDTO;
import DBUtils.DBUtils;
import java.beans.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;


public class khachhangDAL {
    private static khachhangDAL instance;

    public static khachhangDAL getInstance() {
        if (instance == null) {
            instance = new khachhangDAL();
        }
        return instance;
    }

    public static void setInstance(khachhangDAL instance) {
        khachhangDAL.instance = instance;
    }
    public ArrayList<khachhangDTO> getAllkhachhang() {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<khachhangDTO> khachhangarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select * from khachhang");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                khachhangDTO khachhangdto = new khachhangDTO();
                khachhangdto.setMakhachhang(rs.getString("makhachhang"));
                khachhangdto.setTenkhachhang(rs.getString("tenkhachhang"));
                khachhangdto.setGioitinh(rs.getString("gioitinh"));
                khachhangdto.setDiachi(rs.getString("diachi"));
                khachhangdto.setSdt(rs.getString("sdt"));
                khachhangdto.setTrangthai(rs.getInt("trangthai") == 0 ? "Chưa đặt hàng" : "Chờ thanh toán");
                khachhangarr.add(khachhangdto);
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
    return khachhangarr ;
    }
    
    public ArrayList<khachhangDTO> searchkhachhang(String keyword) {
        ArrayList<khachhangDTO> khachhangarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from khachhang where makhachhang like '%" + keyword + "%' "
                    + "or tenkhachhang like '%" + keyword + "%'"
                    + " or gioitinh like '%" + keyword + "%'"
                    + " or diachi like '%" + keyword + "%'"
                    + " or sdt like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                khachhangDTO khachhangdto = new khachhangDTO();
                khachhangdto.setMakhachhang(rs.getString(1));
                khachhangdto.setTenkhachhang(rs.getString(2));
                khachhangdto.setGioitinh(rs.getString(3));
                khachhangdto.setDiachi(rs.getString(4));
                khachhangdto.setSdt(rs.getString(5));
                khachhangarr.add(khachhangdto);
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
        return khachhangarr ; 
    }

    public int insertkhachhang(khachhangDTO khachhangdto) {
        int result = 0;
        String sql = "insert into khachhang value (?, ?, ?, ?, ?, 0)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, khachhangdto.getMakhachhang());
            pre.setString(2, khachhangdto.getTenkhachhang());
            pre.setString(3, khachhangdto.getGioitinh());
            pre.setString(4, khachhangdto.getDiachi());
            pre.setString(5, khachhangdto.getSdt());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int updatepaykhachhang(String id){
        int result = 0;
        Connection con = DBUtils.getConnection();
            PreparedStatement pre;
            try {
                    pre = con.prepareStatement("update khachhang set trangthai=0 where makhachhang=?");
                    pre.setString(1, id);
                    result = pre.executeUpdate();
            } catch (SQLException ex) {
                    ex.printStackTrace();
            }
        return result;
    }
    public int updatethemkhachhang(String id){
        int result = 0;
        Connection con = DBUtils.getConnection();
            PreparedStatement pre;
            try {
                    pre = con.prepareStatement("update khachhang set trangthai=1 where makhachhang=?");
                    pre.setString(1, id);
                    result = pre.executeUpdate();
            } catch (SQLException ex) {
                    ex.printStackTrace();
            }
        return result;
    }
    public int updatekhachhang(khachhangDTO khachhangdto) {
        int result = 0;
        String sql = "update khachhang set makhachhang=?, tenkhachhang=?, gioitinh=?, diachi=?, sdt=? where makhachhang=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, khachhangdto.getMakhachhang());
            pre.setString(2, khachhangdto.getTenkhachhang());
            pre.setString(3, khachhangdto.getGioitinh());
            pre.setString(4, khachhangdto.getDiachi());
            pre.setString(5, khachhangdto.getSdt());
            pre.setString(6, khachhangdto.getMakhachhang());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletekhachhang(khachhangDTO khachhangdto) {
        int result = 0;
        String sql = "delete from khachhang where makhachhang = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, khachhangdto.getMakhachhang());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
