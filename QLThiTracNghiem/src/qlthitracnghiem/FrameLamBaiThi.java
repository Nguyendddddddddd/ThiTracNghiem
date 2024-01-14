/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlthitracnghiem;

import java.sql.Time;
import DAO.DAOCauHoi;
import DAO.DAODapAn;
import DAO.DAODeThi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import model.CauHoi;
import model.DapAn;
import model.DeThi;
import model.KetQuaKiemTra;

/**
 *
 * @author ADMIN
 */
public class FrameLamBaiThi extends javax.swing.JFrame {

    private String MaDe;
    private String MaSV = "SV1";
    private boolean[] trangThaiDungSaiCacCau;
    private int Giay = 10;
    private int Phut = 1;

    /**
     * Creates new form FrameLamBaiThi
     */
    public void nopBai() {
        DAOCauHoi dAOCauHoi = new DAOCauHoi();
        int soLuongCauHoi = dAOCauHoi.countCauHoiByIdDe(MaDe);

        int socauDung = 0;
        for (int i = 0; i < trangThaiDungSaiCacCau.length; i++) {
            if (trangThaiDungSaiCacCau[i]) {
                socauDung++;

            }
        }
        float SoDiemDatDuoc = (float) (10.0 / soLuongCauHoi) * socauDung;
        KetQuaKiemTra kq = new KetQuaKiemTra("kq1", MaSV, MaDe, SoDiemDatDuoc, LocalDateTime.now());
        FrameKetQuaKiemTra Fkqkt = new FrameKetQuaKiemTra(kq, socauDung, soLuongCauHoi);
        Fkqkt.setVisible(true);
        this.dispose();
    }

    public void demNguoc() {

        Timer Dem = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Giay--;
                if (Giay <= 0) {
                    Giay = 60;
                    Phut--;
                }
                if (Phut <= -1) {
                    Timer t = (Timer) e.getSource();
                    Giay = 0;
                    nopBai();
                    t.stop();
                }

                lbPhut.setText(Phut + "");
                lbGiay.setText(Giay + "");
            }
        });
        Dem.start();

    }

    public void loadDanhSachCauHoi() {
        DAOCauHoi dAOCauHoi = new DAOCauHoi();
        pnlListCauHoi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        int soLuongCauHoi = dAOCauHoi.countCauHoiByIdDe(MaDe);
        trangThaiDungSaiCacCau = new boolean[soLuongCauHoi];
        for (int i = 1; i <= soLuongCauHoi; i++) {
            JButton cauhoi = new JButton(i + "");
            cauhoi.setPreferredSize(new Dimension(40, 40));
            Font buttonFont = new Font("Arial", Font.PLAIN, 10);
            cauhoi.setFont(buttonFont);
            cauhoi.setBackground(Color.white);
            pnlListCauHoi.add(cauhoi);
            cauhoi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    int cauThu = Integer.parseInt(btn.getText());
                    System.out.println(cauThu + "");
                    jScrollPane2.getViewport().setViewPosition(new Point(0, 165 * cauThu - 165));
                }

            });
        }
    }

    public void loadCauHoi() {
        DAOCauHoi dAOCauHoi = new DAOCauHoi();
        DAODapAn dAODapAn = new DAODapAn();
        pnlCauHoi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        int soLuongCauHoi = dAOCauHoi.countCauHoiByIdDe(MaDe);
        pnlCauHoi.setLayout(new BoxLayout(pnlCauHoi, BoxLayout.Y_AXIS));
        ArrayList<CauHoi> listCauHoi = dAOCauHoi.selectAllbyIdDe(MaDe);
        Collections.shuffle(listCauHoi);
        for (int i = 1; i <= soLuongCauHoi; i++) {
            CauHoi ch = listCauHoi.get(i - 1);
            DapAn da = dAODapAn.selectByIdCauHoi(ch.getMaCauHoi());
            String noidungcau = ch.getNoiDungCauHoi();
            List listTronDapAn = new ArrayList();
            listTronDapAn.add(da.getDapAnDung());
            listTronDapAn.add(da.getDapAn1());
            listTronDapAn.add(da.getDapAn2());
            listTronDapAn.add(da.getDapAn3());
            Collections.shuffle(listTronDapAn);
            String dapAn1 = listTronDapAn.get(0).toString();
            String dapAn2 = listTronDapAn.get(1).toString();
            String dapAn3 = listTronDapAn.get(2).toString();
            String dapAn4 = listTronDapAn.get(3).toString();
            CauHoivaDapAn cauHoivaDapAn = new CauHoivaDapAn(i, noidungcau, dapAn1, dapAn2, dapAn3, dapAn4);
            pnlCauHoi.add(cauHoivaDapAn);
            ItemListener itemListener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton rdo = (JRadioButton) e.getSource();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        cauHoivaDapAn.setTrangThaiDungSai(cauHoivaDapAn.kiemTraDapAnDung(da.getDapAnDung(), rdo.getText()));
                        trangThaiDungSaiCacCau[cauHoivaDapAn.getCauThu() - 1] = cauHoivaDapAn.getTrangThaiDungSai();
                        Component[] coms = pnlListCauHoi.getComponents();
                        for (int i = 0; i < coms.length; i++) {
                            if (i == cauHoivaDapAn.getCauThu() - 1) {
                                if (coms[i] instanceof JButton) {
                                    coms[i].setBackground(new Color(46, 149, 105));
                                }
                            }
                        }

                    }
                }
            };
            cauHoivaDapAn.getrdoCauA().addItemListener(itemListener);
            cauHoivaDapAn.getrdoCauB().addItemListener(itemListener);
            cauHoivaDapAn.getrdoCauC().addItemListener(itemListener);
            cauHoivaDapAn.getrdoCauD().addItemListener(itemListener);
        }
    }

    public FrameLamBaiThi() {
        initComponents();
        loadDanhSachCauHoi();
        loadCauHoi();
        demNguoc();
    }

    public FrameLamBaiThi(String MaDe) {
        initComponents();
        this.MaDe = MaDe;
        DAODeThi DT = new DAODeThi();
        DeThi deThi = DT.selectById(MaDe);
        Time TGLB = deThi.getThoiGianLamBai();

        int phut = TGLB.getMinutes();
        int giay = TGLB.getSeconds();
        this.Phut = phut;
        this.Giay = giay;
        loadDanhSachCauHoi();
        loadCauHoi();
        demNguoc();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbPhut = new javax.swing.JLabel();
        lbGiay = new javax.swing.JLabel();
        lbPhut1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlListCauHoi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlCauHoi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 251, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 140));

        btnDangXuat.setBackground(new java.awt.Color(167, 217, 245));
        btnDangXuat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDangXuat.setText("Nộp bài");
        btnDangXuat.setPreferredSize(new java.awt.Dimension(149, 39));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(240, 251, 255));

        jPanel4.setBackground(new java.awt.Color(240, 251, 255));

        lbPhut.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbPhut.setText("15");

        lbGiay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbGiay.setText("60");

        lbPhut1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbPhut1.setText(":");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lbPhut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPhut1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGiay)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhut)
                    .addComponent(lbGiay)
                    .addComponent(lbPhut1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(240, 251, 255));

        pnlListCauHoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlListCauHoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlListCauHoi.setPreferredSize(new java.awt.Dimension(221, 472));

        javax.swing.GroupLayout pnlListCauHoiLayout = new javax.swing.GroupLayout(pnlListCauHoi);
        pnlListCauHoi.setLayout(pnlListCauHoiLayout);
        pnlListCauHoiLayout.setHorizontalGroup(
            pnlListCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        pnlListCauHoiLayout.setVerticalGroup(
            pnlListCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        jScrollPane2.setToolTipText("");

        javax.swing.GroupLayout pnlCauHoiLayout = new javax.swing.GroupLayout(pnlCauHoi);
        pnlCauHoi.setLayout(pnlCauHoiLayout);
        pnlCauHoiLayout.setHorizontalGroup(
            pnlCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        pnlCauHoiLayout.setVerticalGroup(
            pnlCauHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pnlCauHoi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlListCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlListCauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        nopBai();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameLamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLamBaiThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLamBaiThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbGiay;
    private javax.swing.JLabel lbPhut;
    private javax.swing.JLabel lbPhut1;
    private javax.swing.JPanel pnlCauHoi;
    private javax.swing.JPanel pnlListCauHoi;
    // End of variables declaration//GEN-END:variables
}
