/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class CauHoi {
    String maCauHoi;
    String maDe;
    String noiDungCauHoi;

    public CauHoi() {
    }

    public CauHoi(String maCauHoi, String maDe, String noiDungCauHoi) {
        this.maCauHoi = maCauHoi;
        this.maDe = maDe;
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public String getMaDe() {
        return maDe;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }
    
}
