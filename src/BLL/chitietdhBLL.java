/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.chitietdhDAL;
import DTO.chitietdhDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class chitietdhBLL {
    chitietdhDAL chitietdhdal = new chitietdhDAL();
    public static ArrayList<chitietdhDTO> dssp;
    
    public List<chitietdhDTO> getAlldathang(String id) {
        return chitietdhdal.getchitietdhByidkhachhang(id);
    }
}
