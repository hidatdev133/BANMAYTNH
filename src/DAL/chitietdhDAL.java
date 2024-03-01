/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.chitietdhDTO;
import DBUtils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRI
 */
public class chitietdhDAL {

    private static chitietdhDAL instance;

    public chitietdhDAL() {
    }

    public static chitietdhDAL getInstance() {
        if (instance == null) {
            instance = new chitietdhDAL();
        }
        return instance;
    }

    public static void setInstance(chitietdhDAL instance) {
        chitietdhDAL.instance = instance;
    }

    public List<chitietdhDTO> getchitietdhByidkhachhang(String id) {
        List<chitietdhDTO> list = new ArrayList<chitietdhDTO>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("SELECT `sanpham`.`tensanpham`, `dathang`.`soluong`, `sanpham`.`giasanpham`, `dathang`.`soluong`*`sanpham`.`giasanpham` AS thanhtien FROM `dathang`, `hoadon`, `sanpham` WHERE `dathang`.`mahoadon` = `hoadon`.`mahoadon` AND `dathang`.`masanpham` = `sanpham`.`masanpham` AND `hoadon`.`trangthai` = 0 AND `hoadon`.`makhachhang` = ?");
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                chitietdhDTO menu = new chitietdhDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(menu);
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
        return list;
    }
}
