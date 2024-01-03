/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class DapAn {

    String dapAnDung;
    String dapAn1;
    String dapAn2;
    String dapAn3;
    String MaCauHoi;

    public DapAn() {
    }

    public DapAn(String dapAnDung, String dapAn1, String dapAn2, String dapAn3, String MaCauHoi) {
        this.dapAnDung = dapAnDung;
        this.dapAn1 = dapAn1;
        this.dapAn2 = dapAn2;
        this.dapAn3 = dapAn3;
        this.MaCauHoi = MaCauHoi;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public void setDapAn1(String dapAn1) {
        this.dapAn1 = dapAn1;
    }

    public void setDapAn2(String dapAn2) {
        this.dapAn2 = dapAn2;
    }

    public void setDapAn3(String dapAn3) {
        this.dapAn3 = dapAn3;
    }

    public void setMaCauHoi(String MaCauHoi) {
        this.MaCauHoi = MaCauHoi;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public String getDapAn1() {
        return dapAn1;
    }

    public String getDapAn2() {
        return dapAn2;
    }

    public String getDapAn3() {
        return dapAn3;
    }

    public String getMaCauHoi() {
        return MaCauHoi;
    }
    


}
