package KETNOI_CSDL;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connection_CSDL {

    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///qlthitracnghiem?useSSL=false";
            String user = "root";
            String pass = "vertrigo";
            c = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection_CSDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connection_CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void closeConnection(Connection c) {

        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection_CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void addData(String maDe, String tenDe, String maGV, LocalTime tg, int soCH) {
        try {
            Connection c = getConnection();
            Statement st = c.createStatement();
            try {
                int kq = st.executeUpdate("INSERT INTO `dekiemtra`(`MaDe`, `TenDe`, `MaGV`, `ThoiGianLamBai`, `SoCauHoi`) VALUES ('" + maDe + "','" + tenDe + "','" + maGV + "','" + tg + "','" + soCH + "')");
                if (kq > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
                }
            } catch (MySQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Mã đề thi đã tồn tại, hãy nhập mã đề khác");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connection_CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void removeData(String maDe) {
        try {
            Connection c = getConnection();
            Statement st = c.createStatement();
            try {
                int kq = st.executeUpdate("DELETE FROM `dekiemtra` WHERE MaDe='" + maDe + "'");

                if (kq > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa không thành công");
                }
            } catch (MySQLIntegrityConstraintViolationException ex) {
                    JOptionPane.showMessageDialog(null, "Hãy xóa câu hỏi trước khi xóa đề");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connection_CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void UpdateData(String tenDe, LocalTime tgLamBai, int soCauHoi, String maDe) {
        try {
            Connection c = getConnection();
            Statement st = c.createStatement();
            int kq = st.executeUpdate("UPDATE `dekiemtra` SET `TenDe`='" + tenDe + "',`ThoiGianLamBai`='" + tgLamBai + "',`SoCauHoi`=" + soCauHoi + " WHERE MaDe='" + maDe + "'");
            if (kq > 0) {
                JOptionPane.showMessageDialog(null, "Sữa thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Sữa không thành công");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connection_CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
