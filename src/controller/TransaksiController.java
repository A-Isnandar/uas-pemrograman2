package controller;

import dao.TransaksiDAO;
import dao.TransaksiDAOImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;
import view.MainFrame;

public class TransaksiController {
    private MainFrame view;
    private TransaksiDAO dao;

    public TransaksiController(MainFrame view) {
        this.view = view;
        this.dao = new TransaksiDAOImpl();
    }

    public void refreshTabel() {
        loadData(dao.getAll());
    }

    public void cariData() {
        loadData(dao.search(view.getTxtCari().getText()));
    }

    private void loadData(List<Transaksi> list) {
        DefaultTableModel model = (DefaultTableModel) view.getTabelTransaksi().getModel();
        model.setRowCount(0);
        for (Transaksi t : list) {
            model.addRow(new Object[]{t.getKodeTransaksi(), t.getNamaPelanggan(), t.getTipeTransaksi(), t.getDetailItem(), t.getBiaya(), t.getStatusProses()});
        }
    }

    public void simpanData() {
        String kode = view.getTxtKode().getText();
        String nama = view.getTxtNama().getText();
        String tipe = view.getCbTipe().getSelectedItem().toString();
        String detail = view.getTxtDetail().getText();
        String status = view.getCbStatus().getSelectedItem().toString();

        if (kode.isEmpty() || nama.isEmpty() || detail.isEmpty() || view.getTxtBiaya().getText().isEmpty() || tipe.contains("--") || status.contains("--")) {
            JOptionPane.showMessageDialog(view, "Semua input wajib diisi!"); return;
        }

        try {
            int biaya = Integer.parseInt(view.getTxtBiaya().getText());
            Transaksi t = new Transaksi(kode, nama, tipe, detail, biaya, status);
            boolean isUpdate = dao.getAll().stream().anyMatch(item -> item.getKodeTransaksi().equals(kode));
            
            if (isUpdate ? dao.update(t) : dao.insert(t)) {
                JOptionPane.showMessageDialog(view, isUpdate ? "Data Diperbarui!" : "Data Tersimpan!");
                bersihkanForm(); refreshTabel();
            } else {
                JOptionPane.showMessageDialog(view, "Gagal simpan ke database!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Biaya harus angka!");
        }
    }

    public void hapusData() {
        int row = view.getTabelTransaksi().getSelectedRow();
        if (row == -1) { JOptionPane.showMessageDialog(view, "Pilih data di tabel!"); return; }
        
        String kode = view.getTabelTransaksi().getValueAt(row, 0).toString();
        if (JOptionPane.showConfirmDialog(view, "Yakin hapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (dao.delete(kode)) {
                JOptionPane.showMessageDialog(view, "Terhapus!");
                bersihkanForm(); refreshTabel();
            }
        }
    }

    public void bersihkanForm() {
        view.getTxtKode().setText(""); view.getTxtNama().setText("");
        view.getTxtDetail().setText(""); view.getTxtBiaya().setText("");
        view.getCbTipe().setSelectedIndex(0); view.getCbStatus().setSelectedIndex(0);
        view.getTxtCari().setText(""); view.getTxtKode().requestFocus();
    }
}