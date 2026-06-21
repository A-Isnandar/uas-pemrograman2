package model;

public class Transaksi {
    private String kodeTransaksi, namaPelanggan, tipeTransaksi, detailItem, statusProses;
    private int biaya;

    public Transaksi(String kodeTransaksi, String namaPelanggan, String tipeTransaksi, String detailItem, int biaya, String statusProses) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.tipeTransaksi = tipeTransaksi;
        this.detailItem = detailItem;
        this.biaya = biaya;
        this.statusProses = statusProses;
    }

    public String getKodeTransaksi() { return kodeTransaksi; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getTipeTransaksi() { return tipeTransaksi; }
    public String getDetailItem() { return detailItem; }
    public int getBiaya() { return biaya; }
    public String getStatusProses() { return statusProses; }
}