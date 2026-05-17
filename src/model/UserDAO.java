/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
import util.DatabaseConnection;
/**
 *
 * @author HP
 */
public class UserDAO {
    public boolean registerUser(User user) {
        if (cekUsernameAda(user.getUsername())) {
            System.out.println("Error: Username sudah terdaftar!");
            return false;
        }
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            
            String sql = "INSERT INTO users (nama_lengkap, username, password) VALUES ('"
                    + user.getNamaLengkap() + "', '"
                    + user.getUsername() + "', '"
                    + user.getPassword() + "')";

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal register: " + e.getMessage());
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Gagal login: " + e.getMessage());
            return false;
        }
    }

    private boolean cekUsernameAda(String username) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);

            return rs.next();

        } catch (SQLException e) {
            return true;
        }
    }
}
