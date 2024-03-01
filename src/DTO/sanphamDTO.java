package DTO;

import java.util.Date;

public class sanphamDTO {
    private int masanpham;
    private String tensanpham;
    private String loaisanpham;
    public int giasanpham;
    private String nhacungcap;
    private int thoigianbaohanh;

    public sanphamDTO() {
    }
    
    public sanphamDTO(int masanpham, String tensanpham) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
    }

    public sanphamDTO(int masanpham, String tensanpham, String loaisanpham, int giasanpham, String nhacungcap, int thoigianbaohanh) {
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.loaisanpham = loaisanpham;
        this.giasanpham = giasanpham;
        this.nhacungcap = nhacungcap;
        this.thoigianbaohanh = thoigianbaohanh;
    }

    
    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    public int getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(int giasanpham) {
        this.giasanpham = giasanpham;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public int getThoigianbaohanh() {
        return thoigianbaohanh;
    }

    public void setThoigianbaohanh(int thoigianbaohanh) {
        this.thoigianbaohanh = thoigianbaohanh;
    }
    
    @Override
    public String toString() {
        return tensanpham;
    }
}
