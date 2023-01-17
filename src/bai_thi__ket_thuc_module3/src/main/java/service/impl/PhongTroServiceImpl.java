package service.impl;

import model.PhongTro;
import repository.IPhongTroRepository;
import repository.impl.PhongTroRepositoryImpl;
import service.IPhongTroService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhongTroServiceImpl implements IPhongTroService {
    IPhongTroRepository iPhongTroRepository = new PhongTroRepositoryImpl();

    @Override
    public List<PhongTro> getList() {
        return iPhongTroRepository.getList();
    }

    @Override
    public void remove(Integer id) {
        iPhongTroRepository.remove(id);
    }

    @Override
    public Map<String, String> save(PhongTro phongTro) {
        Map<String, String> map = new HashMap<>();
        if (map.isEmpty()) {
            iPhongTroRepository.save(phongTro);
        }
        return map;
    }

    @Override
    public List<PhongTro> search(String maPhongTro, String tenNguoiThue, String hinhThucThanhToan) {
        if(!hinhThucThanhToan.equals("")) {
            int hinhThucThanhToanNum = Integer.parseInt(hinhThucThanhToan);
            return iPhongTroRepository.searchByMaPhongTroAndTenNguoiThueAndHinhThucThanhToan(maPhongTro, tenNguoiThue, hinhThucThanhToanNum);
        } else
          return iPhongTroRepository.searchByMaPhongTroVaNguoiThue(maPhongTro,tenNguoiThue);
    }
}
