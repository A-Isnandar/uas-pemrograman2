package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_counter_hp_231011401602";
                String user = "root";
                String password = ""; 
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Database Sukses!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Koneksi Gagal: " + e.getMessage());
            }
        }
        return connection;
    }
}