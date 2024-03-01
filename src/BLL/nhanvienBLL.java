package BLL;

import java.util.ArrayList;

import DAL.nhanvienDAL;
import DTO.nhanvienDTO;

public class nhanvienBLL {
    nhanvienDAL nhanviendal = new nhanvienDAL();
    public static ArrayList<nhanvienDTO> dsnv;

    public ArrayList<nhanvienDTO> getAllnhanvien() {
        return nhanviendal.getAllnhanvien();
    }

    public ArrayList<nhanvienDTO> getmanhanvien(nhanvienDTO nhanviendto) {
        return nhanviendal.getmanhanvien(nhanviendto);
    }
    
    
    public int insertnhanvien(nhanvienDTO nhanviendto) {
        int result = nhanviendal.insertnhanvien(nhanviendto);
        return result;
    }
     
    public int updatenhanvien(nhanvienDTO nhanviendto) {
        int result = nhanviendal.updatenhanvien(nhanviendto);
        return result;
    }

    public int deletenhanvien(nhanvienDTO nhanviendto) {
        int result = nhanviendal.deletenhanvien(nhanviendto);
        return result;
    }
    
    public ArrayList<nhanvienDTO> searchnhanvien(String keyword) {
        return nhanviendal.searchnhanvien(keyword);
    }
}
