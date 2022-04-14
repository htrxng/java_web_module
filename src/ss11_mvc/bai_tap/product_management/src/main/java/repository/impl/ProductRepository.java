package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static  List<Product> productList = new ArrayList<>();
        static {
            productList.add(new Product(1,"Book",100.0,50));
            productList.add(new Product(2,"Pen",5.0,50));
            productList.add(new Product(3,"Pencil",3.0,50));
            productList.add(new Product(4,"Ruler",6.0,50));
        }



    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
