package phanmemtracnghiem;

import PHAN_MEM.FormDangNhap;
import PHAN_MEM.FormTaoDe;
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
public class frm_CauHoi extends javax.swing.JFrame {

    String SelectedMaDe = "";
    String SelectedMaCauHoi = "";
    DefaultTableModel tableModel;

    public frm_CauHoi() {
        initComponents();
        showDe();
    }

    public void clearText() {
        txtDADung.setText("");
        txtDA1.setText("");
        txtDA2.setText("");
        txtDA3.setText("");
        txtCauHoi.setText("");
        txtMaCauHoi.setText("");
        btnThemCauHoi.setEnabled(true);
        btnBoChon.setEnabled(false);
    }

    public boolean checkNotEmpty() {
        if (SelectedMaDe == "") {
            JOptionPane.showMessageDialog(null, "Chưa chọn đề để thêm câu hỏi!");
            return false;
        } else if (txtMaCauHoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'mã câu hỏi'!");
            return false;
        } else if (txtCauHoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'câu hỏi'!");
            return false;
        } else if (txtDADung.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'đáp án đúng'!");
            return false;
        } else if (txtDA1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'đáp án 1'!");
            return false;
        } else if (txtDA2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'đáp án 2'!");
            return false;
        } else if (txtDA3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập 'đáp án 3'!");
            return false;
        }
        return true;
    }

    public void showDe() {
        tableModel = (DefaultTableModel) this.tblDSDe.getModel();
        tableModel.setNumRows(0);

        Connection conn = ConnectionMySQL.getConnection();

        String sql = "SELECT * FROM dekiemtra";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("MaDe")
                };
                tableModel.addRow(row);
            }
            resultSet.close();
            ConnectionMySQL.closeConnection(conn);

        } catch (SQLException ex) {
            Logger.getLogger(frm_CauHoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCauHoi(String made) {
        tableModel = (DefaultTableModel) this.tblDSCauHoi.getModel();
        tableModel.setNumRows(0);

        Connection conn = ConnectionMySQL.getConnection();

        String sql = "SELECT * FROM cauhoi where MaDe = '" + made + "'";
        String ma, getDapAn;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ma = resultSet.getString("MaCauHoi");
                getDapAn = "SELECT * FROM dapan where MaCauHoi = '" + ma + "'";
                statement = conn.prepareStatement(getDapAn);
                ResultSet resultSet2 = statement.executeQuery();
                while (resultSet2.next()) {
                    Object[] da = {
                        resultSet2.getString("DapAnDung"),
                        resultSet2.getString("DapAn1"),
                        resultSet2.getString("DapAn2"),
                        resultSet2.getString("DapAn3")
                    };

                    Object[] ch = {
                        resultSet.getString("MaCauHoi"),
                        resultSet.getString("MaDe"),
                        resultSet.getString("NoiDungCauHoi"),};
                    Object[] row = new Object[7];
                    System.arraycopy(ch, 0, row, 0, 3);
                    System.arraycopy(da, 0, row, 3, 4);
                    tableModel.addRow(row);
                }
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(frm_CauHoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showTTCauHoi(String macauhoi) {

        Connection conn = ConnectionMySQL.getConnection();
        String sql = "SELECT * FROM dapan where MaCauHoi = '" + macauhoi + "'";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                txtDADung.setText(resultSet.getString("DapAnDung"));
                txtDA1.setText(resultSet.getString("DapAn1"));
                txtDA2.setText(resultSet.getString("DapAn2"));
                txtDA3.setText(resultSet.getString("DapAn3"));
                txtMaCauHoi.setText(resultSet.getString("MaCauHoi"));
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSDe = new javax.swing.JTable();
        lblDSDeThi = new javax.swing.JLabel();
        lblTTCauHoi = new javax.swing.JLabel();
        txtDADung = new javax.swing.JTextField();
        txtDA1 = new javax.swing.JTextField();
        txtDA2 = new javax.swing.JTextField();
        txtDA3 = new javax.swing.JTextField();
        lblDaDung = new javax.swing.JLabel();
        lblDaAn1 = new javax.swing.JLabel();
        lblDaAn2 = new javax.swing.JLabel();
        lblDaAn3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSCauHoi = new javax.swing.JTable();
        lblDSCauHoi = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCauHoi = new javax.swing.JTextPane();
        txtMaCauHoi = new javax.swing.JTextField();
        lblMaCauHoi = new javax.swing.JLabel();
        btnBoChon = new javax.swing.JButton();
        btnThemCauHoi = new javax.swing.JButton();
        btnXoaCauHoi = new javax.swing.JButton();
        btnSuaCauHoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBackground(new java.awt.Color(240, 251, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(986, 54));

        jButton1.setBackground(new java.awt.Color(167, 217, 245));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setText("Quản lý đề thi");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton1.setPreferredSize(new java.awt.Dimension(149, 39));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(167, 217, 245));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton3.setText("Cấp tài khoảng");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton3.setPreferredSize(new java.awt.Dimension(149, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(167, 217, 245));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(240, 251, 255));

        tblDSDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Mã đề"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSDe.setColumnSelectionAllowed(true);
        tblDSDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSDeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSDe);
        tblDSDe.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblDSDe.getColumnModel().getColumnCount() > 0) {
            tblDSDe.getColumnModel().getColumn(0).setResizable(false);
        }

        lblDSDeThi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDSDeThi.setText("Danh sách đề thi");

        lblTTCauHoi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTTCauHoi.setText("Câu hỏi");

        txtDADung.setNextFocusableComponent(txtDA1);
        txtDADung.setPreferredSize(new java.awt.Dimension(64, 29));

        txtDA1.setNextFocusableComponent(txtDA2);
        txtDA1.setPreferredSize(new java.awt.Dimension(64, 29));

        txtDA2.setNextFocusableComponent(txtDA3);
        txtDA2.setPreferredSize(new java.awt.Dimension(64, 29));

        txtDA3.setNextFocusableComponent(btnThemCauHoi);
        txtDA3.setPreferredSize(new java.awt.Dimension(64, 29));

        lblDaDung.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDaDung.setText("Đáp án đúng");

        lblDaAn1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDaAn1.setText("Đán án 1");

        lblDaAn2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDaAn2.setText("Đán án 2");

        lblDaAn3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDaAn3.setText("Đán án 3");

        tblDSCauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã câu hỏi", "Mã đề", "Nội dung", "Đáp án đúng", "Đáp án 1", "Đáp án 2", "Đán án 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDSCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCauHoiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSCauHoi);
        if (tblDSCauHoi.getColumnModel().getColumnCount() > 0) {
            tblDSCauHoi.getColumnModel().getColumn(0).setMinWidth(100);
            tblDSCauHoi.getColumnModel().getColumn(0).setMaxWidth(100);
            tblDSCauHoi.getColumnModel().getColumn(1).setMinWidth(100);
            tblDSCauHoi.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        lblDSCauHoi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDSCauHoi.setText("Danh sách câu hỏi");

        txtCauHoi.setNextFocusableComponent(txtDADung);
        jScrollPane4.setViewportView(txtCauHoi);

        txtMaCauHoi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaCauHoi.setNextFocusableComponent(txtCauHoi);
        txtMaCauHoi.setPreferredSize(new java.awt.Dimension(64, 29));

        lblMaCauHoi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaCauHoi.setText("Mã câu hỏi");

        btnBoChon.setBackground(new java.awt.Color(255, 102, 102));
        btnBoChon.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnBoChon.setBorderPainted(false);
        btnBoChon.setEnabled(false);
        btnBoChon.setNextFocusableComponent(txtMaCauHoi);
        btnBoChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDSDeThi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMaCauHoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDaAn2)
                                    .addComponent(lblDaAn1)
                                    .addComponent(lblDaAn3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDA3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblDaDung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDADung, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTTCauHoi)
                            .addComponent(lblDSCauHoi))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDSDeThi)
                    .addComponent(lblTTCauHoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDADung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDaDung))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDaAn1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDaAn2)))
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDaAn3)
                            .addComponent(txtMaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaCauHoi)
                            .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(lblDSCauHoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemCauHoi.setBackground(new java.awt.Color(167, 217, 245));
        btnThemCauHoi.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnThemCauHoi.setText("Thêm câu");
        btnThemCauHoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnThemCauHoi.setBorderPainted(false);
        btnThemCauHoi.setNextFocusableComponent(txtMaCauHoi);
        btnThemCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCauHoiActionPerformed(evt);
            }
        });

        btnXoaCauHoi.setBackground(new java.awt.Color(167, 217, 245));
        btnXoaCauHoi.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnXoaCauHoi.setText("Xóa câu");
        btnXoaCauHoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnXoaCauHoi.setBorderPainted(false);
        btnXoaCauHoi.setNextFocusableComponent(txtMaCauHoi);
        btnXoaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCauHoiActionPerformed(evt);
            }
        });

        btnSuaCauHoi.setBackground(new java.awt.Color(167, 217, 245));
        btnSuaCauHoi.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnSuaCauHoi.setText("Sửa câu");
        btnSuaCauHoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        btnSuaCauHoi.setBorderPainted(false);
        btnSuaCauHoi.setNextFocusableComponent(txtMaCauHoi);
        btnSuaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCauHoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnThemCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnXoaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSuaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        clearText();
        tblDSCauHoi.clearSelection();
        btnThemCauHoi.setEnabled(true);
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void tblDSCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCauHoiMouseClicked
        btnBoChon.setEnabled(true);
        txtCauHoi.setText((String) tblDSCauHoi.getValueAt(tblDSCauHoi.getSelectedRow(), 2));
        SelectedMaCauHoi = (String) tblDSCauHoi.getValueAt(tblDSCauHoi.getSelectedRow(), 0);
        showTTCauHoi(SelectedMaCauHoi);
        if (tblDSCauHoi.getSelectedRow() != -1)
            btnThemCauHoi.setEnabled(false);
    }//GEN-LAST:event_tblDSCauHoiMouseClicked

    private void tblDSDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSDeMouseClicked
        SelectedMaDe = tblDSDe.getValueAt(tblDSDe.getSelectedRow(), 0).toString();
        showCauHoi(SelectedMaDe);
        clearText();
        btnThemCauHoi.setEnabled(true);
    }//GEN-LAST:event_tblDSDeMouseClicked

    private void btnThemCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCauHoiActionPerformed
        if (checkNotEmpty()) {
            Object[] valuesCauHoi = {
                txtMaCauHoi.getText(),
                SelectedMaDe,
                txtCauHoi.getText()
            };
            Object[] valuesDapAn = {
                txtDADung.getText(),
                txtDA1.getText(),
                txtDA2.getText(),
                txtDA3.getText(),
                txtMaCauHoi.getText()
            };
            try {
                ConnectionMySQL.excuteSQL("INSERT INTO cauhoi (MaCauHoi, MaDe, NoiDungCauHoi) VALUES (?, ?, ?)", valuesCauHoi);
                ConnectionMySQL.excuteSQL("INSERT INTO dapan (DapAnDung, DapAn1, DapAn2, DapAn3, MaCauHoi) VALUES (?, ?, ?, ?, ?)", valuesDapAn);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                return;
            }

            showCauHoi(SelectedMaDe);
            JOptionPane.showMessageDialog(null, "Thêm câu hỏi thành công!");
            clearText();
        }
    }//GEN-LAST:event_btnThemCauHoiActionPerformed

    private void btnXoaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCauHoiActionPerformed
        if (tblDSCauHoi.getSelectedRow() != -1) {
            try {
                ConnectionMySQL.excuteSQL("DELETE FROM dapan WHERE MaCauHoi = ?", txtMaCauHoi.getText());
                ConnectionMySQL.excuteSQL("DELETE FROM cauhoi WHERE MaCauHoi = ?", txtMaCauHoi.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                return;
            }

            showCauHoi(SelectedMaDe);
            JOptionPane.showMessageDialog(null, "Xóa câu hỏi thành công!");
            clearText();
        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn câu hỏi cần xóa");
        }
    }//GEN-LAST:event_btnXoaCauHoiActionPerformed

    private void btnSuaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCauHoiActionPerformed
        if (tblDSCauHoi.getSelectedRow() != -1) {
            Object[] valuesCauHoi = {
                txtMaCauHoi.getText(),
                SelectedMaDe,
                txtCauHoi.getText(),
                SelectedMaCauHoi
            };
            Object[] valuesDapAn = {
                txtDADung.getText(),
                txtDA1.getText(),
                txtDA2.getText(),
                txtDA3.getText(),
                txtMaCauHoi.getText(),
                SelectedMaCauHoi
            };
            try {
                ConnectionMySQL.excuteSQL("UPDATE dapan SET DapAnDung = ?, DapAn1 = ?, DapAn2 = ?, DapAn3 = ?, MaCauHoi = ? WHERE MaCauHoi = ?", valuesDapAn);
                ConnectionMySQL.excuteSQL("UPDATE cauhoi SET MaCauHoi = ?, MaDe = ?, NoiDungCauHoi = ? WHERE MaCauHoi = ?", valuesCauHoi);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                return;
            }
            showCauHoi(SelectedMaDe);
            JOptionPane.showMessageDialog(null, "Đã sửa câu hỏi");
            clearText();
        } else
            JOptionPane.showMessageDialog(null, "Chưa chọn câu hỏi cần sửa");
    }//GEN-LAST:event_btnSuaCauHoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormTaoDe formTaoDe = new FormTaoDe();
        formTaoDe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        frm_LapTaiKhoan fLapTaiKhoan = new frm_LapTaiKhoan();
        fLapTaiKhoan.setVisible(true);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        this.dispose();
        FormDangNhap FormDangNhap = new FormDangNhap();
        FormDangNhap.setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

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
            java.util.logging.Logger.getLogger(frm_CauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_CauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_CauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_CauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_CauHoi cauhoi = new frm_CauHoi();
                cauhoi.setVisible(true);
                cauhoi.getContentPane().setBackground(new Color(218, 251, 249));
                cauhoi.setSize(1015, 735);
                cauhoi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cauhoi.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnSuaCauHoi;
    private javax.swing.JButton btnThemCauHoi;
    private javax.swing.JButton btnXoaCauHoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDSCauHoi;
    private javax.swing.JLabel lblDSDeThi;
    private javax.swing.JLabel lblDaAn1;
    private javax.swing.JLabel lblDaAn2;
    private javax.swing.JLabel lblDaAn3;
    private javax.swing.JLabel lblDaDung;
    private javax.swing.JLabel lblMaCauHoi;
    private javax.swing.JLabel lblTTCauHoi;
    private javax.swing.JTable tblDSCauHoi;
    private javax.swing.JTable tblDSDe;
    private javax.swing.JTextPane txtCauHoi;
    private javax.swing.JTextField txtDA1;
    private javax.swing.JTextField txtDA2;
    private javax.swing.JTextField txtDA3;
    private javax.swing.JTextField txtDADung;
    private javax.swing.JTextField txtMaCauHoi;
    // End of variables declaration//GEN-END:variables
}
