package repository;

import model.Product;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);

    void update(int id, E e);

    void remove(int id);

    E findByID(int id);

    List<E> search(String name);
}
