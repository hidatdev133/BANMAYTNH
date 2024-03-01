package BLL;


import java.util.ArrayList;

import DAL.thongkeDAL;
import DAL.sanphamDAL;
import DTO.thongkeDTO;
import DTO.sanphamDTO;


public class thongkeBLL {
   
    thongkeDAL hoadondal = new thongkeDAL();
    public static ArrayList<thongkeDTO> dsnv;
    
    
    public ArrayList<thongkeDTO> getAllhoadon() {
        return hoadondal.getAllhoadon();
    }
    
    public int inserthoadon(thongkeDTO hoadondto) {
        int result = hoadondal.inserthoadon(hoadondto);
        return result;
    }
     
    public int updatehoadon(thongkeDTO hoadondto) {
        int result = hoadondal.updatehoadon(hoadondto);
        return result;
    }

    public int deletehoadon(thongkeDTO hoadondto) {
        int result = hoadondal.deletehoadon(hoadondto);
        return result;
    }
    
    public ArrayList<thongkeDTO> search_hoadon(String keyword) {
        return hoadondal.searchhoadon(keyword);
    }

  
}
