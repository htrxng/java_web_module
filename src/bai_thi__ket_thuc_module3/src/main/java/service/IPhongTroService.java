package service;

import model.PhongTro;

import java.util.List;
import java.util.Map;

public interface IPhongTroService {
    List<PhongTro> getList();

    void remove(Integer id);

    Map<String, String> save(PhongTro phongTro);

    List<PhongTro> search(String maPhongTro, String tenNguoiThue, String soDienThoai);
}
