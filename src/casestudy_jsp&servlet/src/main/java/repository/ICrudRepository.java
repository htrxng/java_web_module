package repository;

import dto.CustomerListDTO;
import model.Customer;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(Customer customer);

    List<E> search(String keyWord);

    void remove(Integer id);
}
