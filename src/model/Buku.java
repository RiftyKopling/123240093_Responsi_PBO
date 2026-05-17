/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Buku extends ItemPerpustakaan implements Pinjamable{
    private String pengarang;
    private String isbn;
    private boolean dipinjam;

    public Buku(int id, String judul, int tahunTerbit, String pengarang, String isbn) {
        super(id, judul, tahunTerbit);
        this.pengarang = pengarang;
        this.isbn = isbn;
    }
    
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDipinjam() {
        return dipinjam;
    }

    public void setDipinjam(boolean dipinjam) {
        this.dipinjam = dipinjam;
    }
    
    @Override
    public void pinjam() {
        if (!dipinjam) {
            this.dipinjam = true;
            System.out.println("Buku '" + getJudul() + "' berhasil dipinjam.");
        } else {
            System.out.println("Buku '" + getJudul() + "' sedang dipinjam.");
        }
    }

    @Override
    public void kembalikan() {
        if (dipinjam) {
            this.dipinjam = false;
            System.out.println("Buku '" + getJudul() + "' berhasil dikembalikan.");
        } else {
            System.out.println("Buku '" + getJudul() + "' tidak sedang dipinjam.");
        }
    }
    
    @Override
    public void tampilInfo() {
        System.out.println("Buku: " + getJudul() + " | Pengarang: " + pengarang + " | ISBN: " + isbn);
    }
}
