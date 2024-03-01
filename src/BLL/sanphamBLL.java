package BLL;

import java.util.ArrayList;

import DAL.sanphamDAL;
import DTO.sanphamDTO;

public class sanphamBLL {

    sanphamDAL sanphamdal = new sanphamDAL();
    public static ArrayList<sanphamDTO> dssp;
    
    public ArrayList<sanphamDTO> getAllsanpham() {
        return sanphamdal.getAllsanpham();
    }

    public ArrayList<sanphamDTO> getmasanpham(sanphamDTO sanphamdto) {
        return sanphamdal.getmasanpham(sanphamdto);
    }
    
    
    public int insertsanpham(sanphamDTO sanphamdto) {
        int result = sanphamdal.insertsanpham(sanphamdto);
        return result;
    }
     
    public int updatesanpham(sanphamDTO sanphamdto) {
        int result = sanphamdal.updatesanpham(sanphamdto);
        return result;
    }

    public int deletesanpham(sanphamDTO sanphamdto) {
        int result = sanphamdal.deletesanpham(sanphamdto);
        return result;
    }

    public ArrayList<sanphamDTO> search_sanpham(String keyword) {
        return sanphamdal.searchsanpham(keyword);
    }
}
