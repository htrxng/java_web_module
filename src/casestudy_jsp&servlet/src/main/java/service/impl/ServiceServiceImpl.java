package service.impl;

import model.Service;
import repository.IServiceRepository;
import repository.impl.ServiceRepositoryImpl;
import service.IServiceService;
import utils.RegularExpression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServiceImpl implements IServiceService {
    IServiceRepository iServiceRepository = new ServiceRepositoryImpl();
    RegularExpression reGex = new RegularExpression();

    @Override
    public List<Service> getList() {
        return iServiceRepository.getList();
    }

    @Override
    public Map<String, String> save(Service service) {
        Map<String, String> map = new HashMap<>();
        if (service.getServiceName().equals("")) {
            map.put("name", "Name is not be empty!");
        }
        if (!reGex.serviceCode(service.getServiceCode())) {
            map.put("serviceCode", "Code is not invalid! || model: [KH-XXXX] X is a number.");
        }
        if(!reGex.numberPositive(String.valueOf(service.getServiceMaxPeople()))) {
            map.put("capacity","amount people must be a positive number.");
        }
        if(!reGex.numberPositive(service.getNumberOfFloors())) {
            map.put("floorNumber","Number of floors must be a positive number.");
        }
        if(!reGex.numberPositive(String.valueOf(service.getServiceCost()))) {
            map.put("cost","cost must be a positive number");
        }
        if (map.isEmpty()) {
            iServiceRepository.save(service);
        }
        return map;
    }
}
