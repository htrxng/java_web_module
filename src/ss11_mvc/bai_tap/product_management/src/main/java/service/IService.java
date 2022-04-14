package service;

import java.util.List;
import java.util.Map;

public interface IService<E> {
    List<E> getList();

    Map<String,String> save(E e);
}
