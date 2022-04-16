package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Rung Na-uy", 100.0, "Tai ban lan 2", "ThienLong"));
        productList.add(new Product(2, "Pen", 5.0, "Blue", "ThienLong"));
        productList.add(new Product(3, "Pencil", 3.0, "2B", "DaiViet"));
        productList.add(new Product(4, "Ruler", 6.0, "20cm", "ThienLong"));
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
        for (Product p : productList
        ) {
            if (p.getId() == id) {
                p = product;
            }
        }
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByID(int id) {


        return productList.get(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productSearched = new ArrayList<>();
        for (Product p : productList) {
           if(p.getNameProduct().contains(name)) {
               productSearched.add(p);
           }
        }
        return productSearched;
    }
}
