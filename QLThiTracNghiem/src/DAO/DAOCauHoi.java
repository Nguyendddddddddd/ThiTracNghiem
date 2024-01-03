/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CauHoi;
import model.DeThi;
import qlthitracnghiem.JDBCUtil;

/**
 *
 * @author ADMIN
 */
public class DAOCauHoi implements DAOInterface<CauHoi> {

    @Override
    public int insert(CauHoi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(CauHoi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(CauHoi t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CauHoi> selectAll() {
        ArrayList<CauHoi> ketQua = new ArrayList<CauHoi>();
        Connection c = JDBCUtil.getConnection();

        Statement st;
        try {
            st = c.createStatement();
            String sql = "select * from cauhoi";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaCauHoi = rs.getString("MaCauHoi");
                String MaDe = rs.getString("MaDe");
                String NoiDungCauHoi = rs.getString("NoiDungCauHoi");
                CauHoi cauHoi = new CauHoi(MaCauHoi, MaDe, NoiDungCauHoi);
                ketQua.add(cauHoi);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODeThi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JDBCUtil.closeConnection(c);
        return ketQua;
    }

    @Override
    public CauHoi selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CauHoi> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int countCauHoiByIdDe(String id) {
         int ketQua = 0;
        Connection c = JDBCUtil.getConnection();

        Statement st;
        try {
            st = c.createStatement();
            String sql = "select count(MaCauHoi) as SoCauHoi from cauhoi where MaDe = '"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ketQua = rs.getInt("SoCauHoi");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODeThi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JDBCUtil.closeConnection(c);
        return ketQua;
    }
    
    public ArrayList<CauHoi> selectAllbyIdDe(String id) {
        ArrayList<CauHoi> ketQua = new ArrayList<CauHoi>();
        Connection c = JDBCUtil.getConnection();

        Statement st;
        try {
            st = c.createStatement();
            String sql = "select * from cauhoi where MaDe = '"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaCauHoi = rs.getString("MaCauHoi");
                String MaDe = rs.getString("MaDe");
                String NoiDungCauHoi = rs.getString("NoiDungCauHoi");
                CauHoi cauHoi = new CauHoi(MaCauHoi, MaDe, NoiDungCauHoi);
                ketQua.add(cauHoi);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODeThi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JDBCUtil.closeConnection(c);
        return ketQua;
    }
}
