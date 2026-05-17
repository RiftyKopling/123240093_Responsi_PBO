-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Bulan Mei 2026 pada 15.02
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `item_perpustakaan`
--

CREATE TABLE `item_perpustakaan` (
  `id` int(11) NOT NULL,
  `tipe` varchar(20) DEFAULT NULL,
  `judul` varchar(200) DEFAULT NULL,
  `tahun_terbit` int(11) DEFAULT NULL,
  `pengarang` varchar(100) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `penerbit` varchar(100) DEFAULT NULL,
  `edisi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `item_perpustakaan`
--

INSERT INTO `item_perpustakaan` (`id`, `tipe`, `judul`, `tahun_terbit`, `pengarang`, `isbn`, `penerbit`, `edisi`) VALUES
(3, 'Majalah', 'sukacita berkoding', 2050, NULL, NULL, 'fikrimumbul', 'anjay'),
(4, 'Majalah', 'sukacita berkoding', 2050, NULL, NULL, 'fikrimumbul', 'anjay'),
(5, 'Buku', 'anjaygaming', 1992, 'gokil1', '12343', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nama_lengkap` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `nama_lengkap`, `username`, `password`) VALUES
(1, 'asep', 'asep', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `item_perpustakaan`
--
ALTER TABLE `item_perpustakaan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `item_perpustakaan`
--
ALTER TABLE `item_perpustakaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
