/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author TRI
 */
public class chitietdhDTO {

    private String tensanpham;
    private int soluong;
    private int gia;
    private int thanhtien;

    public chitietdhDTO() {
    }

    public chitietdhDTO(String tensanpham, int soluong, int gia, int thanhtien) {
        this.tensanpham = tensanpham;
        this.soluong = soluong;
        this.gia = gia;
        this.thanhtien = thanhtien;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
}
