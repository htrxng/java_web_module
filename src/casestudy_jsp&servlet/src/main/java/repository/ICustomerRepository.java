package repository;

import dto.CustomerListDTO;
import model.Customer;

import java.util.Map;

public interface ICustomerRepository extends ICrudRepository<Customer> {
    Customer findById(Integer id);

    void updateUser(Customer customer);
}
