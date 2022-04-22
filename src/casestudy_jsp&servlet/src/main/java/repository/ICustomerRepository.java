package repository;

import dto.CustomerListDTO;
import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerRepository extends ICrudRepository<Customer> {
    Customer findById(Integer id);

    List<Customer> search(String customerTypeId, String keyWordName , String keyWordEmail);


}
