package BLL;

import java.util.ArrayList;

import DAL.khachhangDAL;
import DTO.khachhangDTO;

public class khachhangBLL {
    khachhangDAL khachhangdal = new khachhangDAL();
    public static ArrayList<khachhangDTO> dssp;
    
    public ArrayList<khachhangDTO> getAllkhachhang() {
        return khachhangdal.getAllkhachhang();
    }
    
    public int insertkhachhang(khachhangDTO khachhangdto) {
        int result = khachhangdal.insertkhachhang(khachhangdto);
        return result;
    }
    public int updatepaykhachhang(String id){
        int result = khachhangdal.updatepaykhachhang(id);
        return result;
    }
    public int updatethemkhachhang(String id){
        int result = khachhangdal.updatethemkhachhang(id);
        return result;
    }
    public int updatekhachhang(khachhangDTO khachhangdto) {
        int result = khachhangdal.updatekhachhang(khachhangdto);
        return result;
    }

    public int deletekhachhang(khachhangDTO khachhangdto) {
        int result = khachhangdal.deletekhachhang(khachhangdto);
        return result;
    }

    public ArrayList<khachhangDTO> search_khachhang(String keyword) {
        return khachhangdal.searchkhachhang(keyword);
    }
}
