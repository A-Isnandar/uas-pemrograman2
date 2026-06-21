package dao;

import java.util.List;
import model.Transaksi;

public interface TransaksiDAO {
    boolean insert(Transaksi t);
    boolean update(Transaksi t);
    boolean delete(String kodeTransaksi);
    List<Transaksi> getAll();
    List<Transaksi> search(String keyword);
    boolean checkLogin(String username, String password);
}