package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import DTO.sanphamDTO;
import DBUtils.DBUtils;
import java.beans.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class sanphamDAL {
    private static sanphamDAL instance;
    public static sanphamDAL getInstance() {
        if (instance == null) {
            instance = new sanphamDAL();
        }
        return instance;
    }
    public ArrayList<sanphamDTO> getAllsanpham() {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<sanphamDTO> sanphamarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from sanpham");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sanphamDTO sanphamdto = new sanphamDTO();
                sanphamdto.setMasanpham(rs.getInt("masanpham"));
                sanphamdto.setTensanpham(rs.getString("tensanpham"));
                sanphamdto.setLoaisanpham(rs.getString("loaisanpham"));
                sanphamdto.setGiasanpham(rs.getInt("giasanpham"));
                sanphamdto.setNhacungcap(rs.getString("nhacungcap"));
                sanphamdto.setThoigianbaohanh(rs.getInt("thoigianbaohanh"));
                sanphamarr.add(sanphamdto);
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
    return sanphamarr ;
    }
    
    public ArrayList<sanphamDTO> searchsanpham(String keyword) {
        ArrayList<sanphamDTO> sanphamarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from sanpham where masanpham like '%" + keyword + "%' "
                    + "or tensanpham like '%" + keyword + "%'"
                    + " or loaisanpham like '%" + keyword + "%'"
                    + " or giasanpham like '%" + keyword + "%'"
                    + " or nhacungcap like '%" + keyword + "%'"
                    + " or thoigianbaohanh like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sanphamDTO sanphamdto = new sanphamDTO();
                sanphamdto.setMasanpham(rs.getInt(1));
                sanphamdto.setTensanpham(rs.getString(2));
                sanphamdto.setLoaisanpham(rs.getString(3));
                sanphamdto.setGiasanpham(rs.getInt(4));
                sanphamdto.setNhacungcap(rs.getString(5));
                sanphamdto.setThoigianbaohanh(rs.getInt(6));
                sanphamarr.add(sanphamdto);
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
        return sanphamarr ; 
    }
    
    public ArrayList<sanphamDTO> getmasanpham(sanphamDTO sanphamdto) {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<sanphamDTO> sanphamarr = new ArrayList<>();
        String sqlmasanpham = "select * from sanpham where masanpham =? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement  pre = con.prepareStatement(sqlmasanpham);
            pre.setInt(1, sanphamdto.getMasanpham());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sanphamDTO sanpham = new sanphamDTO();
                sanphamdto.setMasanpham(rs.getInt("masanpham"));
                sanphamdto.setTensanpham(rs.getString("tensanpham"));
                sanphamdto.setLoaisanpham(rs.getString("loaisanpham"));
                sanphamdto.setGiasanpham(rs.getInt("giasanpham"));
                sanphamdto.setNhacungcap(rs.getString("nhacungcap"));
                sanphamdto.setThoigianbaohanh(rs.getInt("thoigianbaohanh"));
                sanphamarr.add(sanpham);
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
    return sanphamarr ;
    }

public int insertsanpham(sanphamDTO sanphamdto) {
        int result = 0;
        String sql = "insert into sanpham value (?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, sanphamdto.getMasanpham());
            pre.setString(2, sanphamdto.getTensanpham());
            pre.setString(3, sanphamdto.getLoaisanpham());
            pre.setInt(4, sanphamdto.getGiasanpham());
            pre.setString(5, sanphamdto.getNhacungcap());
            pre.setInt(6, sanphamdto.getThoigianbaohanh());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int updatesanpham(sanphamDTO sanphamdto) {
        int result = 0;
        String sql = "update sanpham set masanpham=?, tensanpham=?, loaisanpham=?, giasanpham=?, nhacungcap=?, thoigianbaohanh=? where masanpham=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, sanphamdto.getMasanpham());
            pre.setString(2, sanphamdto.getTensanpham());
            pre.setString(3, sanphamdto.getLoaisanpham());
            pre.setInt(4, sanphamdto.getGiasanpham());
            pre.setString(5, sanphamdto.getNhacungcap());
            pre.setInt(6, sanphamdto.getThoigianbaohanh());
            pre.setInt(7, sanphamdto.getMasanpham());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletesanpham(sanphamDTO sanphamdto) {
        int result = 0;
        String sql = "delete from sanpham where masanpham = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, sanphamdto.getMasanpham());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
