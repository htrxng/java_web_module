package service;

import model.Service;

import java.util.List;
import java.util.Map;

public interface IServiceService {
    List<Service> getList();

    Map<String, String> save(Service service);
}
