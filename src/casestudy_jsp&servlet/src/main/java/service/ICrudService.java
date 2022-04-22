package service;



import java.util.List;
import java.util.Map;

public interface ICrudService<E> {
    List<E> getList();

    Map<String, String> updateUser(E e);


    void remove(Integer id);

    Map<String, String> save(E e);
}
