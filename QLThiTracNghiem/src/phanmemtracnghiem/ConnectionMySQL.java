package phanmemtracnghiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConnectionMySQL {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///qlthitracnghiem";
            String user = "root";
            String password = "vertrigo";
            conn = (Connection) DriverManager.getConnection(url, user, password);
            //System.out.println("Thanh cong");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void excuteSQL(String sql, Object... params) throws SQLException {

        Connection conn = getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            preparedStatement.executeUpdate();
        }
            closeConnection(conn);
    }
}
