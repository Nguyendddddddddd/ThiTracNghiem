/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.DeThi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;

import java.util.logging.Level;
import java.util.logging.Logger;
import qlthitracnghiem.JDBCUtil;

/**
 *
 * @author ADMIN
 */
public class DAODeThi implements DAOInterface<DeThi> {

    @Override
    public int insert(DeThi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(DeThi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(DeThi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DeThi> selectAll() {
        ArrayList<DeThi> ketQua = new ArrayList<DeThi>();
        Connection c = JDBCUtil.getConnection();

        Statement st;
        try {
            st = c.createStatement();
            String sql = "select * from dekiemtra";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maDe = rs.getString("MaDe");
                String tenDe =rs.getString("TenDe");
                String maGV = rs.getString("MaGV");
                Time thoiGianLamBai = rs.getTime("ThoiGianLamBai");
                DeThi deThi = new DeThi(maDe, tenDe, maGV, thoiGianLamBai);
                ketQua.add(deThi);   
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODeThi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JDBCUtil.closeConnection(c);

        return ketQua;
    }

    @Override
    public DeThi selectById(String id) {
         DeThi ketQua = null;
        Connection c = JDBCUtil.getConnection();

        Statement st;
        try {
            st = c.createStatement();
            String sql = "select * from dekiemtra where MaDe = '"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maDe = rs.getString("MaDe");
                String tenDe =rs.getString("TenDe");
                String maGV = rs.getString("MaGV");
                Time thoiGianLamBai = rs.getTime("ThoiGianLamBai");
                ketQua = new DeThi(maDe, tenDe, maGV, thoiGianLamBai);  
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODeThi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JDBCUtil.closeConnection(c);

        return ketQua;
    }

    @Override
    public ArrayList<DeThi> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
