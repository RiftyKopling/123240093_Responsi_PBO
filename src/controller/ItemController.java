/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Buku;
import model.Majalah;
import model.ItemDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class ItemController {
    private ItemDAO itemDAO;

    public ItemController() {
        this.itemDAO = new ItemDAO();
    }

    public void tambahBuku(String judul, String tahunStr, String pengarang, String isbn) {
        if (judul.isEmpty() || tahunStr.isEmpty() || pengarang.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua data buku harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int tahun = Integer.parseInt(tahunStr);
            Buku buku = new Buku(0, judul, tahun, pengarang, isbn);

            if (itemDAO.tambahBuku(buku)) {
                JOptionPane.showMessageDialog(null, "Data buku berhasil disimpan!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format tahun harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tambahMajalah(String judul, String tahunStr, String penerbit, String edisi) {
        if (judul.isEmpty() || tahunStr.isEmpty() || penerbit.isEmpty() || edisi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua data majalah harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int tahun = Integer.parseInt(tahunStr);
            Majalah majalah = new Majalah(0, judul, tahun, penerbit, edisi);

             if (itemDAO.tambahMajalah(majalah)) { 
                 JOptionPane.showMessageDialog(null, "Data majalah berhasil disimpan!");
             }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format tahun harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateBuku(int id, String judul, String tahunStr, String pengarang, String isbn) {
        if (judul.isEmpty() || tahunStr.isEmpty() || pengarang.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua data buku harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int tahun = Integer.parseInt(tahunStr);
            Buku buku = new Buku(id, judul, tahun, pengarang, isbn);

            if (itemDAO.updateBuku(buku)) {
                JOptionPane.showMessageDialog(null, "Data buku berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengupdate data buku.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format tahun harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMajalah(int id, String judul, String tahunStr, String penerbit, String edisi) {
        if (judul.isEmpty() || tahunStr.isEmpty() || penerbit.isEmpty() || edisi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua data majalah harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int tahun = Integer.parseInt(tahunStr);
            Majalah majalah = new Majalah(id, judul, tahun, penerbit, edisi);

             if (itemDAO.updateMajalah(majalah)) {
                 JOptionPane.showMessageDialog(null, "Data majalah berhasil diupdate!");
             } else {
                 JOptionPane.showMessageDialog(null, "Gagal mengupdate data majalah.", "Error", JOptionPane.ERROR_MESSAGE);
             }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Format tahun harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void hapusItem(int id) {
        int konfirmasi = JOptionPane.showConfirmDialog(null,
                "Apakah Anda yakin ingin menghapus item dengan ID: " + id + "?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            if (itemDAO.hapusItem(id)) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public java.sql.ResultSet getAllItems() {
        return itemDAO.getAllItems();
    }
}
