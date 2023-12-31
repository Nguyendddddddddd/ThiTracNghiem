/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlthitracnghiem;

/**
 *
 * @author ADMIN
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCUtil {
    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///qlthitracnghiem";
            String user = "root";
            String password = "vertrigo";
            c = DriverManager.getConnection(url, user, password);      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
