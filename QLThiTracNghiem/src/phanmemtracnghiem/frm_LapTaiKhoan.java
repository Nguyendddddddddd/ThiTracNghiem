package phanmemtracnghiem;

import java.awt.Color;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TRUONG147
 */
public class frm_LapTaiKhoan extends javax.swing.JFrame {

    public frm_LapTaiKhoan() {
        initComponents();
        getData();
        cboMa.setSelectedIndex(-1);
    }
    
    String tk, ma, mk;
    
    public void clearText()
    {
        txtTenDangNhap.setText("");
        txtMatKhau.setText("");
        txtXacNhanMatKhau.setText("");
        cboMa.setSelectedIndex(-1);
    }
    
    public boolean checkNotEmpty() {
        if (txtTenDangNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'tên đăng nhập'!");
            return false;
        } else if (txtMatKhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'mật khẩu'!");
            return false;
        } else if (txtXacNhanMatKhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'xác nhập mật khẩu'!");
            return false;
        } else if (cboMa.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn mã!");
            return false;
        }
        return true;
    }

    public void getData() {
        Connection conn = ConnectionMySQL.getConnection();
        String sql = "SELECT * FROM sinhvien";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cboMa.addItem(resultSet.getString("MaSV"));
            }
            resultSet.close();
            ConnectionMySQL.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(frm_CauHoi.class.getName()).log(Level.SEVERE, null, ex);
        }

        conn = ConnectionMySQL.getConnection();
        sql = "SELECT * FROM giaovien";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cboMa.addItem(resultSet.getString("MaGV"));
            }
            resultSet.close();
            ConnectionMySQL.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(frm_CauHoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCapTaiKhoan = new javax.swing.JLabel();
        lblTenDangNhap = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        lblXacNhanMatKhau = new javax.swing.JLabel();
        txtXacNhanMatKhau = new javax.swing.JTextField();
        lblMa = new javax.swing.JLabel();
        btnDangKy = new javax.swing.JButton();
        cboMa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(240, 251, 255));

        lblCapTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblCapTaiKhoan.setText("Cấp Tài Khoản");

        lblTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenDangNhap.setText("Tên đăng nhập");

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtTenDangNhap.setMargin(new java.awt.Insets(2, 10, 2, 10));

        lblMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMatKhau.setText("Mật khẩu");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtMatKhau.setMargin(new java.awt.Insets(2, 10, 2, 10));

        lblXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblXacNhanMatKhau.setText("Xác nhận mật khẩu");

        txtXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtXacNhanMatKhau.setMargin(new java.awt.Insets(2, 10, 2, 10));

        lblMa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMa.setText("Mã sinh viên");

        btnDangKy.setBackground(new java.awt.Color(167, 217, 245));
        btnDangKy.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnDangKy.setText("ĐĂNG KÝ");
        btnDangKy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnDangKy.setBorderPainted(false);
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        cboMa.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(lblCapTaiKhoan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTenDangNhap)
                            .addComponent(lblXacNhanMatKhau)
                            .addComponent(lblMatKhau)
                            .addComponent(txtMatKhau)
                            .addComponent(txtXacNhanMatKhau)
                            .addComponent(txtTenDangNhap)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblMa)
                                        .addGap(116, 116, 116))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboMa, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(lblCapTaiKhoan)
                .addGap(38, 38, 38)
                .addComponent(lblTenDangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblXacNhanMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//"SELECT * FROM sinhvien WHERE MaSV = " + cboMa.getSelectedItem().toString()
    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        if (checkNotEmpty()) {
            tk = txtTenDangNhap.getText();
            mk = txtMatKhau.getText();
            ma = cboMa.getSelectedItem().toString();
            boolean loi = false;
            if (txtMatKhau.getText().equals(txtXacNhanMatKhau.getText())) {
                Connection conn = ConnectionMySQL.getConnection();
                String sql = "SELECT * FROM sinhvien WHERE MaSV = '" + ma+"'";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next())
                        {
                            try {
                                sql = "Insert into taikhoangsinhvien(`TenTK`, `MatKhau`, `MaSV`) values (?, ?, ?)";
                                ConnectionMySQL.excuteSQL(sql, tk,mk,ma);
                            }
                            catch (Exception e)
                            {
                                JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại!");
                                loi = true;
                            }
                        }
                        else
                        {
                            try {
                                sql = "Insert into taikhoanggiaovien(`TenTK`, `MatKhau`, `MaGV`) values (?, ?, ?)";
                                ConnectionMySQL.excuteSQL(sql, tk,mk,ma);
                            }
                            catch (Exception e)
                            {
                                JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại!");
                                loi = true;
                            }
                            
                        }
                    }
                    if (loi == false)
                    {
                        JOptionPane.showMessageDialog(null, "Thành công!");
                        clearText();
                    }
                        
                    ConnectionMySQL.closeConnection(conn);

                } catch (SQLException ex) {
                    Logger.getLogger(frm_CauHoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không trùng khớp!");
            }
        }
    }//GEN-LAST:event_btnDangKyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */ //UIManager.getSystemLookAndFeelClassName());
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_LapTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_LapTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_LapTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_LapTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_LapTaiKhoan taikhoan = new frm_LapTaiKhoan();
                taikhoan.setVisible(true);
                taikhoan.getContentPane().setBackground(new Color(240, 251, 255));
                taikhoan.setSize(1015, 735);
                taikhoan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                taikhoan.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JComboBox<String> cboMa;
    private javax.swing.JLabel lblCapTaiKhoan;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JLabel lblXacNhanMatKhau;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}
