package DAL;

import DTO.nhanvienDTO;
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

public class nhanvienDAL {

    public ArrayList<nhanvienDTO> getAllnhanvien() {
         // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<nhanvienDTO> nhanvienarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from nhanvien");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nhanvienDTO nhanviendto = new nhanvienDTO();
                nhanviendto.setManhanvien(rs.getString("manhanvien"));
                nhanviendto.setHotennhanvien(rs.getString("hotennhanvien"));
                nhanviendto.setGioitinh(rs.getString("gioitinh"));
                nhanviendto.setNamsinh(rs.getString("namsinh"));
                nhanviendto.setDiachi(rs.getString("diachi"));
                nhanviendto.setSdt(rs.getString("sdt"));
                nhanvienarr.add(nhanviendto);
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
        return nhanvienarr ;
    }
    
    public ArrayList<nhanvienDTO> searchnhanvien(String keyword) {
        ArrayList<nhanvienDTO> nhanvienarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from nhanvien where manhanvien like '%" + keyword + "%' "
                    + "or hotennhanvien like '%" + keyword + "%'"
                    + " or gioitinh like '%" + keyword + "%'"
                    + " or namsinh like '%" + keyword + "%'"
                    + " or diachi like '%" + keyword + "%'"
                    + " or sdt like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nhanvienDTO nhanviendto = new nhanvienDTO();
                nhanviendto.setManhanvien(rs.getString(1));
                nhanviendto.setHotennhanvien(rs.getString(2));
                nhanviendto.setGioitinh(rs.getString(3));
                nhanviendto.setNamsinh(rs.getString(4));
                nhanviendto.setDiachi(rs.getString(5));
                nhanviendto.setSdt(rs.getString(6));
                
                nhanvienarr.add(nhanviendto);
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
        return nhanvienarr ; 
    }
    
    public ArrayList<nhanvienDTO> getmanhanvien(nhanvienDTO nhanviendto) {
                // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<nhanvienDTO> nhanvienarr = new ArrayList<>();
        String sqlmanhanvien = "select * from nhanvien where manhanvien =? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement  pre = con.prepareStatement(sqlmanhanvien);
            pre.setString(1, nhanviendto.getManhanvien());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nhanvienDTO nhanvien = new nhanvienDTO();
                nhanviendto.setManhanvien(rs.getString("manhanvien"));
                nhanviendto.setHotennhanvien(rs.getString("hotennhanvien"));
                nhanviendto.setGioitinh(rs.getString("gioitinh"));
                nhanviendto.setNamsinh(rs.getString("namsinh"));
                nhanviendto.setDiachi(rs.getString("diachi"));
                nhanviendto.setSdt(rs.getString("sdt"));
                nhanvienarr.add(nhanvien);
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
    return nhanvienarr ;
    }

    public int insertnhanvien(nhanvienDTO nhanviendto) {
        int result = 0;
        String sql = "insert into nhanvien value (?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nhanviendto.getManhanvien());
            pre.setString(2, nhanviendto.getHotennhanvien());
            pre.setString(3, nhanviendto.getGioitinh());
            pre.setString(4, nhanviendto.getNamsinh());
            pre.setString(5, nhanviendto.getDiachi());
            pre.setString(6, nhanviendto.getSdt());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatenhanvien(nhanvienDTO nhanviendto) {
        int result = 0;
        String sql = "update nhanvien set manhanvien=?, hotennhanvien=?, gioitinh=?, namsinh=?, diachi=?, sdt=? where manhanvien=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nhanviendto.getManhanvien());
            pre.setString(2, nhanviendto.getHotennhanvien());
            pre.setString(3, nhanviendto.getGioitinh());
            pre.setString(4, nhanviendto.getNamsinh());
            pre.setString(5, nhanviendto.getDiachi());
            pre.setString(6, nhanviendto.getSdt());
            pre.setString(7, nhanviendto.getManhanvien());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletenhanvien(nhanvienDTO nhanviendto) {
        int result = 0;
        String sql = "delete from nhanvien where manhanvien = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nhanviendto.getManhanvien());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    
    
    
    
}
