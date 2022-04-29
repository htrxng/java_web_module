package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface ICrudService<E> {
     List<E> getList();

    Map<String, String> save(E e);
}
