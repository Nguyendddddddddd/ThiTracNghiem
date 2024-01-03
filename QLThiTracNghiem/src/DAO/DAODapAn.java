/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.DapAn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlthitracnghiem.JDBCUtil;

/**
 *
 * @author ADMIN
 */
public class DAODapAn implements DAOInterface<DapAn> {

    @Override
    public int insert(DapAn t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(DapAn t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(DapAn t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DapAn> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DapAn selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public DapAn selectByIdCauHoi(String id) {
        DapAn ketQua = null;

        Connection c = JDBCUtil.getConnection();
        Statement st;
        try {
            st = c.createStatement();
            String sql = "select * from DapAn where MaCauHoi = '" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String dapAnDung = rs.getString("DapAnDung");
                String dapAn1 = rs.getString("DapAn1");
                String dapAn2 = rs.getString("DapAn2");
                String dapAn3 = rs.getString("DapAn3");
                String maCauHoi = rs.getString("MaCauHoi");
                ketQua = new DapAn(dapAnDung, dapAn1, dapAn2, dapAn3, maCauHoi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODapAn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public ArrayList<DapAn> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
