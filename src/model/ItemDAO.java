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
public class ItemDAO {
    public boolean tambahBuku(Buku buku) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
       
            String sql = "INSERT INTO item_perpustakaan (tipe, judul, tahun_terbit, pengarang, isbn) VALUES ('Buku', '"
                    + buku.getJudul() + "', "
                    + buku.getTahunTerbit() + ", '"
                    + buku.getPengarang() + "', '"
                    + buku.getIsbn() + "')";

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal tambah buku: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusItem(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM item_perpustakaan WHERE id = " + id;

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal hapus item: " + e.getMessage());
            return false;
        }
    }

    public boolean updateBuku(Buku buku) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "UPDATE item_perpustakaan SET judul = '" + buku.getJudul()
                    + "', tahun_terbit = " + buku.getTahunTerbit()
                    + ", pengarang = '" + buku.getPengarang()
                    + "', isbn = '" + buku.getIsbn()
                    + "' WHERE id = " + buku.getId();

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal update buku: " + e.getMessage());
            return false;
        }
    }
    
    public boolean tambahMajalah(Majalah majalah) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO item_perpustakaan (tipe, judul, tahun_terbit, penerbit, edisi) VALUES ('Majalah', '"
                    + majalah.getJudul() + "', "
                    + majalah.getTahunTerbit() + ", '"
                    + majalah.getPenerbit() + "', '"
                    + majalah.getEdisi() + "')";

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal tambah majalah: " + e.getMessage());
            return false;
        }
    }

    public boolean updateMajalah(Majalah majalah) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "UPDATE item_perpustakaan SET judul = '" + majalah.getJudul()
                    + "', tahun_terbit = " + majalah.getTahunTerbit()
                    + ", penerbit = '" + majalah.getPenerbit()
                    + "', edisi = '" + majalah.getEdisi()
                    + "' WHERE id = " + majalah.getId();

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal update majalah: " + e.getMessage());
            return false;
        }
    }
}
