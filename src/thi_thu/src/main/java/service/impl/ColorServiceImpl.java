package service.impl;

import model.Color;
import repository.IColorRepository;
import repository.impl.ColorRepositoryImpl;
import service.IColorService;

import java.util.List;
import java.util.Map;

public class ColorServiceImpl implements IColorService {
    IColorRepository iColorRepository = new ColorRepositoryImpl();

    @Override
    public List<Color> getList() {
        return iColorRepository.getList();
    }

    @Override
    public Map<String, String> save(Color color) {
        return null;
    }
}
