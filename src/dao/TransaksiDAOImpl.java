package dao;

import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;

public class TransaksiDAOImpl implements TransaksiDAO {
    private Connection conn = DatabaseConnection.getConnection();

    @Override
    public boolean insert(Transaksi t) {
        String sql = "INSERT INTO transaksi VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getKodeTransaksi());
            ps.setString(2, t.getNamaPelanggan());
            ps.setString(3, t.getTipeTransaksi());
            ps.setString(4, t.getDetailItem());
            ps.setInt(5, t.getBiaya());
            ps.setString(6, t.getStatusProses());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean update(Transaksi t) {
        String sql = "UPDATE transaksi SET nama_pelanggan=?, tipe_transaksi=?, detail_item=?, biaya=?, status_proses=? WHERE kode_transaksi=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getNamaPelanggan());
            ps.setString(2, t.getTipeTransaksi());
            ps.setString(3, t.getDetailItem());
            ps.setInt(4, t.getBiaya());
            ps.setString(5, t.getStatusProses());
            ps.setString(6, t.getKodeTransaksi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean delete(String kodeTransaksi) {
        String sql = "DELETE FROM transaksi WHERE kode_transaksi=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeTransaksi);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public List<Transaksi> getAll() {
        List<Transaksi> list = new ArrayList<>();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM transaksi")) {
            while (rs.next()) list.add(new Transaksi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
        } catch (SQLException e) {}
        return list;
    }

    @Override
    public List<Transaksi> search(String keyword) {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi WHERE kode_transaksi LIKE ? OR nama_pelanggan LIKE ? OR detail_item LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            String param = "%" + keyword + "%";
            ps.setString(1, param); ps.setString(2, param); ps.setString(3, param);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(new Transaksi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (SQLException e) {}
        return list;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
            ps.setString(1, username); ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        } catch (SQLException e) { return false; }
    }
}