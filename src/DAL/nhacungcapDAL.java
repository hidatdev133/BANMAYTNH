package DAL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import DTO.nhacungcapDTO;
import DBUtils.DBUtils;
import java.beans.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class nhacungcapDAL {
    public ArrayList<nhacungcapDTO> getAllnhacungcap() {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<nhacungcapDTO> nhacungcaparr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from nhacungcap");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nhacungcapDTO nhacungcapdto = new nhacungcapDTO();
                nhacungcapdto.setManhacungcap(rs.getString("manhacungcap"));
                nhacungcapdto.setTennhacungcap(rs.getString("tennhacungcap"));
                nhacungcapdto.setDiachi(rs.getString("diachi"));
                nhacungcapdto.setSdt(rs.getString("sdt"));
                nhacungcaparr.add(nhacungcapdto);
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
    return nhacungcaparr ;
    }
    
    public ArrayList<nhacungcapDTO> searchnhacungcap(String keyword) {
        ArrayList<nhacungcapDTO> nhacungcaparr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            String sql = "select * from nhacungcap where manhacungcap like '%" + keyword + "%' "
                    + "or tennhacungcap like '%" + keyword + "%'"
                    + " or diachi like '%" + keyword + "%'"
                    + " or sdt like '%" + keyword + "%'";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nhacungcapDTO nhacungcapdto = new nhacungcapDTO();
                nhacungcapdto.setManhacungcap(rs.getString(1));
                nhacungcapdto.setTennhacungcap(rs.getString(2));
                nhacungcapdto.setDiachi(rs.getString(3));
                nhacungcapdto.setSdt(rs.getString(4));
                nhacungcaparr.add(nhacungcapdto);
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
        return nhacungcaparr ; 
    }
    
    public ArrayList<nhacungcapDTO> getmanhacungcap(nhacungcapDTO nhacungcapdto) {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<nhacungcapDTO> nhacungcaparr = new ArrayList<>();
        String sqlmanhacungcap = "select * from nhacungcap where manhacungcap =? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement  pre = con.prepareStatement(sqlmanhacungcap);
            pre.setString(1, nhacungcapdto.getManhacungcap());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nhacungcapDTO nhacungcap = new nhacungcapDTO();
                nhacungcapdto.setManhacungcap(rs.getString("manhacungcap"));
                nhacungcapdto.setTennhacungcap(rs.getString("tennhacungcap"));
                nhacungcapdto.setDiachi(rs.getString("diachi"));
                nhacungcapdto.setDiachi(rs.getString("sdt"));
                nhacungcaparr.add(nhacungcap);
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
    return nhacungcaparr ;
    }

public int insertnhacungcap(nhacungcapDTO nhacungcapdto) {
        int result = 0;
        String sql = "insert into nhacungcap value (?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nhacungcapdto.getManhacungcap());
            pre.setString(2, nhacungcapdto.getTennhacungcap());
            pre.setString(3, nhacungcapdto.getDiachi());
            pre.setString(4, nhacungcapdto.getSdt());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int updatenhacungcap(nhacungcapDTO nhacungcapdto) {
        int result = 0;
        String sql = "update nhacungcap set manhacungcap=?, tennhacungcap=?, diachi=?, sdt=? where manhacungcap=? ";
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nhacungcapdto.getManhacungcap());
            pre.setString(2, nhacungcapdto.getTennhacungcap());
            pre.setString(3, nhacungcapdto.getDiachi());
            pre.setString(4, nhacungcapdto.getSdt());
            pre.setString(5, nhacungcapdto.getManhacungcap());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletenhacungcap(nhacungcapDTO nhacungcapdto) {
        int result = 0;
        String sql = "delete from nhacungcap where manhacungcap = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, nhacungcapdto.getManhacungcap());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
