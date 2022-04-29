package repository;

import model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    List<PhongTro> getList();

    void remove(Integer id);

    void save(PhongTro phongTro);

    List<PhongTro> search(String maPhongTro, String tenNguoiThue, String soDienThoai);
}
