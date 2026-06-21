# Tugas Akhir Pemrograman 2 - Aplikasi Counter HP

Aplikasi desktop berbasis Java Swing dan MySQL untuk manajemen transaksi (Produk & Servis) pada Counter HP. Dibangun mengimplementasikan arsitektur MVC (Model-View-Controller) dan DAO (Data Access Object).

## Identitas Mahasiswa
* **Nama:** Muhamad Ario Isnandar
* **NIM:** 231011401602
* **Kelas:** 06TPLE013
* **Objek:** Counter HP (Nomor 20)

## Fitur Aplikasi
1. Otentikasi Login (Admin)
2. Operasi CRUD (Create, Read, Update, Delete) Data Transaksi
3. Pencarian Data Real-time (Keyword Filtering)
4. Cetak Laporan PDF / Print Langsung
5. Validasi Input Lengkap & Keamanan PreparedStatement (Anti SQL Injection)

## Cara Menjalankan Aplikasi
1. Import database `db_counter_hp_231011401602.sql` ke dalam phpMyAdmin (MySQL).
2. Buka project ini menggunakan Apache NetBeans.
3. Pastikan library `mysql-connector-j.jar` (tersedia di folder `/lib`) sudah ditambahkan pada panel Libraries.
4. Jalankan (Run) file `LoginForm.java` pada package `view`.
5. Login menggunakan Username: `admin` dan Password: `admin123`.
