package service;

import dto.CustomerListDTO;
import model.Customer;

import java.util.Map;

public interface ICustomerService extends ICrudService<Customer> {
    Customer findByID(Integer id);

    Map<String, String> save(Customer customer);

    String updateUser(Customer customer);

//    Map<Integer,String> getListCustomerType();
}
