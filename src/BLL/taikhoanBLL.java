package BLL;

import java.util.ArrayList;

import DAL.taikhoanDAL;
import DTO.taikhoanDTO;

public class taikhoanBLL {
    taikhoanDAL taikhoandal = new taikhoanDAL();
    public static ArrayList<taikhoanDTO> dssp;
    
    public ArrayList<taikhoanDTO> getAlltaikhoan() {
        return taikhoandal.getAlltaikhoan();
    }
    
    public int inserttaikhoan(taikhoanDTO taikhoandto) {
        int result = taikhoandal.inserttaikhoan(taikhoandto);
        return result;
    }
     
    public int updatetaikhoan(taikhoanDTO taikhoandto) {
        int result = taikhoandal.updatetaikhoan(taikhoandto);
        return result;
    }

    public int deletetaikhoan(taikhoanDTO taikhoandto) {
        int result = taikhoandal.deletetaikhoan(taikhoandto);
        return result;
    }
    
    public ArrayList<taikhoanDTO> search_taikhoan(String keyword) {
        return taikhoandal.searchtaikhoan(keyword);
    }
}
