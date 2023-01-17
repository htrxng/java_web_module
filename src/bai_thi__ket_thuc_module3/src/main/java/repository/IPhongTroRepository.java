package repository;

import model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    List<PhongTro> getList();

    void remove(Integer id);

    void save(PhongTro phongTro);

    List<PhongTro> searchByMaPhongTroAndTenNguoiThueAndHinhThucThanhToan
            (String maPhongTro, String tenNguoiThue, int hinhThucThanhToan);

    List<PhongTro> searchByMaPhongTroVaNguoiThue(String maPhongTro, String tenNguoiThue);
}
