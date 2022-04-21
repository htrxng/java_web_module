package service;

import dto.CustomerListDTO;
import model.Customer;

import java.util.Map;

public interface ICustomerService extends ICrudService<CustomerListDTO> {
    Customer findByID(Integer id);

    Map<String, String> save(Customer customer);
}
