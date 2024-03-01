package BLL;

import java.util.ArrayList;

import DAL.nhacungcapDAL;
import DTO.nhacungcapDTO;

public class nhacungcapBLL {
     nhacungcapDAL nhacungcapdal = new nhacungcapDAL();
    public static ArrayList<nhacungcapDTO> dssp;
    
    public ArrayList<nhacungcapDTO> getAllnhacungcap() {
        return nhacungcapdal.getAllnhacungcap();
    }

    public ArrayList<nhacungcapDTO> getmanhacungcap(nhacungcapDTO nhacungcapdto) {
        return nhacungcapdal.getmanhacungcap(nhacungcapdto);
    }
    
    
    public int insertnhacungcap(nhacungcapDTO nhacungcapdto) {
        int result = nhacungcapdal.insertnhacungcap(nhacungcapdto);
        return result;
    }
     
    public int updatenhacungcap(nhacungcapDTO nhacungcapdto) {
        int result = nhacungcapdal.updatenhacungcap(nhacungcapdto);
        return result;
    }

    public int deletenhacungcap(nhacungcapDTO nhacungcapdto) {
        int result = nhacungcapdal.deletenhacungcap(nhacungcapdto);
        return result;
    }

    public ArrayList<nhacungcapDTO> search_nhacungcap(String keyword) {
        return nhacungcapdal.searchnhacungcap(keyword);
    }
}
