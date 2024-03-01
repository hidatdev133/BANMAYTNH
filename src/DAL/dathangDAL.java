package DAL;

import DBUtils.DBUtils;
import DTO.dathangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dathangDAL {
    private static dathangDAL instance;

    public dathangDAL() {
    }

    public static dathangDAL getInstance() {
        if (instance == null) {
            instance = new dathangDAL();
        }
        return instance;
    }
    public ArrayList<dathangDTO> getAlldathang() {
        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
        ArrayList<dathangDTO> dathangarr = new ArrayList<>();
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select *from dathang");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                dathangDTO dathangdto = new dathangDTO();
                dathangdto.setMadathang(rs.getInt("madathang"));
                dathangdto.setMasanpham(rs.getString("masanpham"));
                dathangdto.setMahoadon(rs.getString("mahoadon"));
                dathangdto.setSoluong(rs.getInt("soluong"));
                dathangarr.add(dathangdto);
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
    return dathangarr ;
    }
    public Boolean insertdathang(int masanpham, int mahoadon, int soluong) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `dathang`(`masanpham`, `soluong`, `mahoadon`) VALUES (?,?,?)");
            pstmt.setInt(1, masanpham);
            pstmt.setInt(2, soluong);
            pstmt.setInt(3, mahoadon);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public int insertdathang(dathangDTO dathangdto) {
        int result = 0;
        String sql = "insert into dathang value (?, ?, ?, ?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, dathangdto.getMadathang());
            pre.setString(2, dathangdto.getMasanpham());
            pre.setString(3, dathangdto.getMahoadon());
            pre.setInt(4, dathangdto.getSoluong());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
