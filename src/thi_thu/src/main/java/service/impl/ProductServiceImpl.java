package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
    IProductRepository iProductRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> getList() {
        return iProductRepository.getList();
    }

    @Override
    public Map<String, String> save(Product product) {
        Map<String,String> map = new HashMap<>();
        if(product.getProductName().equals("")) {
            map.put("name","name is not be empty");
        }

        if(map.isEmpty()) {
            iProductRepository.save(product);
        }
        return map;
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.remove(id);
    }
}
