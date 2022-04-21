package repository;

import dto.CustomerListDTO;
import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(Customer customer);

    List<E> search(String customerTypeId,String keyWordName , String keyWordEmail);

    void remove(Integer id);

}
