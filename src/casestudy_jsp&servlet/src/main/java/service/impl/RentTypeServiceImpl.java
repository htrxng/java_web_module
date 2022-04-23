package service.impl;

import model.ServiceRentType;
import repository.IRentTypeRepository;
import repository.impl.RentTypeRepositoryImpl;
import service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    IRentTypeRepository iRentTypeRepository = new RentTypeRepositoryImpl();

    @Override
    public List<ServiceRentType> getList() {
        return iRentTypeRepository.getList();
    }
}
