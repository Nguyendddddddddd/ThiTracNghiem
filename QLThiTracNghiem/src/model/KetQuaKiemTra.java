/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author ADMIN
 */
public class KetQuaKiemTra {

    String maKQ;
    String maSV;
    String maDe;
    float soDiem;
    LocalDateTime ThoiGianNopBai;

    public KetQuaKiemTra(String maKQ, String maSV, String maDe, float soDiem, LocalDateTime ThoiGianNopBai) {
        this.maKQ = maKQ;
        this.maSV = maSV;
        this.maDe = maDe;
        this.soDiem = soDiem;
        this.ThoiGianNopBai = ThoiGianNopBai;
    }

    public void setMaKQ(String maKQ) {
        this.maKQ = maKQ;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    public void setSoDiem(float soDiem) {
        this.soDiem = soDiem;
    }

    public void setThoiGianNopBai(LocalDateTime ThoiGianNopBai) {
        this.ThoiGianNopBai = ThoiGianNopBai;
    }

    public String getMaKQ() {
        return maKQ;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getMaDe() {
        return maDe;
    }

    public float getSoDiem() {
        return soDiem;
    }

    public LocalDateTime getThoiGianNopBai() {
        return ThoiGianNopBai;
    }

    public KetQuaKiemTra() {
    }

}
