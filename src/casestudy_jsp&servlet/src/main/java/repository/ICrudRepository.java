package repository;

import dto.CustomerListDTO;
import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);

    void updateUser(E e);

    void remove(Integer id);
}
