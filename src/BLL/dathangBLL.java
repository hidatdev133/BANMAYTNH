package BLL;
import java.util.ArrayList;

import DAL.dathangDAL;
import DTO.dathangDTO;

public class dathangBLL {
    dathangDAL dathangdal = new dathangDAL();
    public static ArrayList<dathangDTO> dssp;
    
    public ArrayList<dathangDTO> getAlldathang() {
        return dathangdal.getAlldathang();
    }
    
    public int insertdathang(dathangDTO dathangdto) {
        int result = dathangdal.insertdathang(dathangdto);
        return result;
    }
     
//    public int updatedathang(dathangDTO dathangdto) {
//        int result = dathangdal.updatedathang(dathangdto);
//        return result;
//    }
//
//    public int deletedathang(dathangDTO dathangdto) {
//        int result = dathangdal.deletedathang(dathangdto);
//        return result;
//    }
//
//    public ArrayList<dathangDTO> search_dathang(String keyword) {
//        return dathangdal.searchdathang(keyword);
//    }
}
