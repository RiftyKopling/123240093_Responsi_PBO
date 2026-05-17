/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.User;
import model.UserDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class AuthController {
    private UserDAO userDAO;
    private static int loginAttempts = 0; // simpan jumlah percobaan

    public AuthController() {
        this.userDAO = new UserDAO();
    }

    public boolean register(String namaLengkap, String username, String password) {
        // validasi tidak boleh kosong
        if (namaLengkap.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        User user = new User(namaLengkap, username, password);
        boolean berhasil = userDAO.registerUser(user);

        if (berhasil) {
            JOptionPane.showMessageDialog(null, "Registrasi Berhasil! Silakan Login.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Registrasi Gagal! Username sudah terdaftar.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean login(String username, String password) {
        // vvalidasi input tidak boleh kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        boolean loginSukses = userDAO.loginUser(username, password);

        if (loginSukses) {
            JOptionPane.showMessageDialog(null, "Login Berhasil! Selamat Datang.");
            loginAttempts = 0; // reset sisa percobaan jika berhasil login
            return true;
        } else {
            loginAttempts++; // tambah sisa percobaan jika salah
            int sisaPercobaan = 3 - loginAttempts;

            if (loginAttempts >= 3) {
                JOptionPane.showMessageDialog(null, "Anda telah gagal login 3 kali! Aplikasi akan ditutup.", "Akses Ditolak", JOptionPane.ERROR_MESSAGE);
                System.exit(0); // tutup program otomatis
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah! Sisa percobaan: " + sisaPercobaan, "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }
}
