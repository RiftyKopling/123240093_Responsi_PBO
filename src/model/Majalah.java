/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Majalah extends ItemPerpustakaan implements Pinjamable{
    private String penerbit;
    private String edisi;
    private boolean dipinjam;

        public Majalah(int id, String judul, int tahunTerbit, String penerbit, String edisi) {
        super(id, judul, tahunTerbit);
        this.penerbit = penerbit;
        this.edisi = edisi;
    }
        
    public String getEdisi() {
        return edisi;
    }

    public void setEdisi(String edisi) {
        this.edisi = edisi;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
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
        System.out.println("Majalah: " + getJudul() + " | Penerbit: " + penerbit + " | Edisi: " + edisi);
    }

}
