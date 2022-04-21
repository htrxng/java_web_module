package service.impl;

import model.Position;
import repository.IPositionRepository;
import repository.impl.PositionRepository;
import service.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    IPositionRepository iPositionRepository = new PositionRepository();
    @Override
    public List<Position> getList() {
        return iPositionRepository.getList();
    }
}
