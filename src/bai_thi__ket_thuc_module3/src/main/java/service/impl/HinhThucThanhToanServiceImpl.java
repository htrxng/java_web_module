package service.impl;

import model.HinhThucThanhToan;
import repository.IHinhThucThanhToanRepository;
import repository.impl.HinhThucThanhToanRepositoryImpl;
import service.IHinhThucThanhToanService;

import java.util.List;

public class HinhThucThanhToanServiceImpl  implements IHinhThucThanhToanService {
    IHinhThucThanhToanRepository iHinhThucThanhToanRepository = new HinhThucThanhToanRepositoryImpl();
    @Override
    public List<HinhThucThanhToan> getList() {
        return iHinhThucThanhToanRepository.getList();
    }
}
