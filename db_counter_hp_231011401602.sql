-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Jun 2026 pada 10.11
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
-- Database: `db_counter_hp_231011401602`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` varchar(10) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `tipe_transaksi` varchar(20) NOT NULL,
  `detail_item` varchar(255) NOT NULL,
  `biaya` int(11) NOT NULL,
  `status_proses` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `nama_pelanggan`, `tipe_transaksi`, `detail_item`, `biaya`, `status_proses`) VALUES
('TR001', 'Muhamad Ario Isnandar - 231011401602', 'Servis', 'Ganti LCD iPhone 13 Pro Max', 1500000, 'Selesai'),
('TR002', 'Ahmad Fauzi', 'Produk', 'Beli Charger Samsung Type-C 25W', 250000, 'Selesai'),
('TR003', 'Rizki Artinio', 'Servis', 'Flash Firmware Poco X3 Mati Total', 350000, 'Proses'),
('TR004', 'Putri Amalia', 'Produk', 'Tempered Glass Privacy iPhone 11', 75000, 'Proses'),
('TR005', 'Dedi Sandi', 'Servis', 'Ganti Baterai Asus ROG Phone 5', 600000, 'Proses'),
('TR006', 'Arfiannisa Kayla', 'Produk', 'Earphone Kabel JBL Quantum 50', 300000, 'Selesai'),
('TR007', 'Fachry Ramadhan', 'Servis', 'Perbaikan IC Audio iPhone 7 Plus', 450000, 'Selesai'),
('TR008', 'Dorra Lady', 'Produk', 'Powerbank Anker 20000mAh', 550000, 'Selesai'),
('TR009', 'Ihsan Maulana', 'Servis', 'Ganti Konektor Charger Redmi Note 10', 180000, 'Selesai'),
('TR010', 'Olivia Ramadhani', 'Produk', 'Casing Premium Spigen iPhone 14', 400000, 'Proses'),
('TR011', 'Septiano Alvian Ismau', 'Produk', 'Beli kabel charger lightning u-green', 100000, 'Selesai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
