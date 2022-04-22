package service;

import dto.CustomerListDTO;
import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService extends ICrudService<Customer> {
    Customer findByID(Integer id);
    List<Customer> search(String customerTypeId, String keyWordName , String keyWordEmail);
    Map<String, String> save(Customer customer);



//    Map<Integer,String> getListCustomerType();
}
