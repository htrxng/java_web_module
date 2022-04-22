package service.impl;

import model.ServiceType;
import repository.IServiceTypeRepository;
import repository.impl.ServiceTypeRepositoryImpl;
import service.IServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    IServiceTypeRepository iServiceTypeRepository = new ServiceTypeRepositoryImpl();

    @Override
    public List<ServiceType> getList() {
        return iServiceTypeRepository.getList();
    }
}
