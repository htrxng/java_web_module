package service;

import model.Product;

public interface IProductService extends ICrudService<Product> {
    void remove(Integer id);
}
