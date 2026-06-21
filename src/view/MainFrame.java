package view;

import controller.TransaksiController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    // Deklarasi Komponen (Bisa diakses oleh Controller)
    private JTextField txtKode, txtNama, txtDetail, txtBiaya, txtCari;
    private JComboBox<String> cbTipe, cbStatus;
    private JButton btnSimpan, btnHapus, btnCetak;
    private JTable tabelTransaksi;
    private TransaksiController controller;

    public MainFrame() {
        // Konfigurasi Window Utama
        setTitle("Aplikasi Counter HP - Pure Code Version");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panggil perakitan UI
        inisialisasiUI();
        
        // Hubungkan ke Controller
        controller = new TransaksiController(this);
        controller.refreshTabel();
    }

    private void inisialisasiUI() {
        // Panel Utama dengan BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // 1. PANEL FORM INPUT (Menggunakan GridLayout)
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Borang Input Data"));

        formPanel.add(new JLabel("Kode Transaksi:"));
        txtKode = new JTextField();
        formPanel.add(txtKode);

        formPanel.add(new JLabel("Nama Pelanggan:"));
        txtNama = new JTextField();
        formPanel.add(txtNama);

        formPanel.add(new JLabel("Tipe Transaksi:"));
        cbTipe = new JComboBox<>(new String[]{"-- Pilih Tipe --", "Produk", "Servis"});
        formPanel.add(cbTipe);

        formPanel.add(new JLabel("Detail / Keluhan:"));
        txtDetail = new JTextField();
        formPanel.add(txtDetail);

        formPanel.add(new JLabel("Biaya (Rp):"));
        txtBiaya = new JTextField();
        formPanel.add(txtBiaya);

        formPanel.add(new JLabel("Status Proses:"));
        cbStatus = new JComboBox<>(new String[]{"-- Pilih Status --", "Selesai", "Proses"});
        formPanel.add(cbStatus);

        // 2. PANEL TOMBOL AKSI & PENCARIAN
        JPanel actionPanel = new JPanel(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
        btnSimpan = new JButton("Simpan Data");
        btnHapus = new JButton("Hapus");
        btnCetak = new JButton("Cetak Laporan");
        
        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnHapus);
        buttonPanel.add(btnCetak);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        searchPanel.add(new JLabel("Cari Data:"));
        txtCari = new JTextField(15);
        searchPanel.add(txtCari);

        actionPanel.add(buttonPanel, BorderLayout.WEST);
        actionPanel.add(searchPanel, BorderLayout.EAST);

        // Penggabungan Bagian Atas (Form + Tombol)
        JPanel topContainer = new JPanel(new BorderLayout(10, 10));
        topContainer.add(formPanel, BorderLayout.CENTER);
        topContainer.add(actionPanel, BorderLayout.SOUTH);

        // 3. PANEL TABEL DATA (Center)
        String[] header = {"KODE", "PELANGGAN", "TIPE", "DETAIL/KELUHAN", "BIAYA", "STATUS"};
        DefaultTableModel tableModel = new DefaultTableModel(header, 0);
        tabelTransaksi = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelTransaksi);

        // Susun ke Panel Utama
        mainPanel.add(topContainer, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Pasang ke JFrame
        add(mainPanel);

        // --- BINDING EVENT HANDLER (OTOMATIS TANPA DOUBLE CLICK DESIGN) ---
        btnSimpan.addActionListener(e -> controller.simpanData());
        btnHapus.addActionListener(e -> controller.hapusData());
        btnCetak.addActionListener(e -> {
            try {
                tabelTransaksi.print(JTable.PrintMode.FIT_WIDTH, 
                    new java.text.MessageFormat("LAPORAN DATA TRANSAKSI COUNTER HP"), 
                    new java.text.MessageFormat("Halaman {0} - Muhamad Ario Isnandar"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gagal Cetak: " + ex.getMessage());
            }
        });
        
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                controller.cariData();
            }
        });

        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelTransaksi.getSelectedRow();
                txtKode.setText(tabelTransaksi.getValueAt(row, 0).toString());
                txtNama.setText(tabelTransaksi.getValueAt(row, 1).toString());
                cbTipe.setSelectedItem(tabelTransaksi.getValueAt(row, 2).toString());
                txtDetail.setText(tabelTransaksi.getValueAt(row, 3).toString());
                txtBiaya.setText(tabelTransaksi.getValueAt(row, 4).toString());
                cbStatus.setSelectedItem(tabelTransaksi.getValueAt(row, 5).toString());
            }
        });
    }

    // Encapsulation Getter agar bisa dibaca Controller secara dinamis
    public JTextField getTxtKode() { return txtKode; }
    public JTextField getTxtNama() { return txtNama; }
    public JComboBox<String> getCbTipe() { return cbTipe; }
    public JTextField getTxtDetail() { return txtDetail; }
    public JTextField getTxtBiaya() { return txtBiaya; }
    public JComboBox<String> getCbStatus() { return cbStatus; }
    public JTextField getTxtCari() { return txtCari; }
    public JTable getTabelTransaksi() { return tabelTransaksi; }

}