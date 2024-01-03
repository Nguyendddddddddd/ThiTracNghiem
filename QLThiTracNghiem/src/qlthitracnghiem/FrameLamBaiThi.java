/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlthitracnghiem;

import DAO.DAOCauHoi;
import DAO.DAODapAn;
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
import javax.swing.border.LineBorder;
import model.CauHoi;
import model.DapAn;

/**
 *
 * @author ADMIN
 */
public class FrameLamBaiThi extends javax.swing.JFrame {

    private String MaDe;
    private boolean[] trangThaiDungSaiCacCau;

    /**
     * Creates new form FrameLamBaiThi
     */
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
            CauHoivaDapAn cauHoivaDapAn = new CauHoivaDapAn(i, noidungcau,dapAn1,dapAn2, dapAn3, dapAn4);
            pnlCauHoi.add(cauHoivaDapAn);
            ItemListener itemListener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton rdo = (JRadioButton) e.getSource();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        cauHoivaDapAn.setTrangThaiDungSai(cauHoivaDapAn.kiemTraDapAnDung(da.getDapAnDung(), rdo.getText()));
                        trangThaiDungSaiCacCau[cauHoivaDapAn.getCauThu() - 1] = cauHoivaDapAn.getTrangThaiDungSai();
                        Component[] coms =  pnlListCauHoi.getComponents();
                        for ( int i=0;i<coms.length;i++) {
                            if(i==cauHoivaDapAn.getCauThu() - 1)
                                if(coms[i] instanceof JButton)
                                     coms[i].setBackground(new Color(46,149,105));
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

    }

    public FrameLamBaiThi(String MaDe) {
        initComponents();
        this.MaDe = MaDe;
        loadDanhSachCauHoi();
        loadCauHoi();

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
        lbTongCauHoi = new javax.swing.JLabel();
        lbThoiGian = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlListCauHoi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlCauHoi = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lbTongCauHoi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTongCauHoi.setText("Tổng số câu:");

        lbThoiGian.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbThoiGian.setText("Thời gian:");

        jPanel2.setBackground(new java.awt.Color(240, 251, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("15:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTongCauHoi)
                    .addComponent(lbThoiGian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTongCauHoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbThoiGian))
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        int socauDung = 0;
        for(int i = 0;i<trangThaiDungSaiCacCau.length;i++){
            if(trangThaiDungSaiCacCau[i])
                socauDung++;
        }
        JOptionPane.showMessageDialog(null, socauDung+"");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbThoiGian;
    private javax.swing.JLabel lbTongCauHoi;
    private javax.swing.JPanel pnlCauHoi;
    private javax.swing.JPanel pnlListCauHoi;
    // End of variables declaration//GEN-END:variables
}
