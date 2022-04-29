package repository;

import model.Product;

public interface IProductRepository extends ICrudRepository<Product> {
    void remove(Integer id);
}
