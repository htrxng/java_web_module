package repository;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();

    void save(E e);

    void update(int id, E e);

    void remove(int id);
}
