package service;

import model.Product;

import java.util.List;

public interface IProductService extends IService<Product> {

    List<Product> search(String name);
}
