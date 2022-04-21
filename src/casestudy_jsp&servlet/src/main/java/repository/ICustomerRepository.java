package repository;

import dto.CustomerListDTO;
import model.Customer;

public interface ICustomerRepository extends ICrudRepository<CustomerListDTO> {
    Customer findById(Integer id);
}
