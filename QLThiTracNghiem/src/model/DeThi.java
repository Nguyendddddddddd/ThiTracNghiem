/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
/**
 *
 * @author ADMIN
 */
public class DeThi {

    private String maDe;
    private String tenDe;
    private String maGV;
    private Time thoiGianLamBai;

    public DeThi() {
    }

    public DeThi(String maDe, String tenDe, String maGV, Time thoiGianLamBai) {
        this.maDe = maDe;
        this.tenDe = tenDe;
        this.maGV = maGV;
        this.thoiGianLamBai = thoiGianLamBai;
    }

    public String getMaDe() {
        return maDe;
    }

    public String getTenDe() {
        return tenDe;
    }

    public String getMaGV() {
        return maGV;
    }

    public Time getThoiGianLamBai() {
        return thoiGianLamBai;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    public void setTenDe(String tenDe) {
        this.tenDe = tenDe;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public void setThoiGianLamBai(Time thoiGianLamBai) {
        this.thoiGianLamBai = thoiGianLamBai;
    }
    
}
