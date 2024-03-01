package BLL;


import java.util.ArrayList;

import DAL.hoadonDAL;
import DAL.sanphamDAL;
import DTO.hoadonDTO;
import DTO.sanphamDTO;


public class hoadonBLL {
   
    hoadonDAL hoadondal = new hoadonDAL();
    public static ArrayList<hoadonDTO> dsnv;
    
    
    public ArrayList<hoadonDTO> getAllhoadon() {
        return hoadondal.getAllhoadon();
    }
    
    public int inserthoadon(hoadonDTO hoadondto) {
        int result = hoadondal.inserthoadon(hoadondto);
        return result;
    }
     
    public int updatehoadon(hoadonDTO hoadondto) {
        int result = hoadondal.updatehoadon(hoadondto);
        return result;
    }

    public int deletehoadon(hoadonDTO hoadondto) {
        int result = hoadondal.deletehoadon(hoadondto);
        return result;
    }
    
    public ArrayList<hoadonDTO> search_hoadon(String keyword) {
        return hoadondal.searchhoadon(keyword);
    }

  
}
