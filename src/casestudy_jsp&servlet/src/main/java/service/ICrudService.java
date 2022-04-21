package service;

import dto.CustomerListDTO;
import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICrudService<E> {
    List<E> getList();


    List<E> search(String keyWord);

    void remove(Integer id);

}
