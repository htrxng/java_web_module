package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {
    // khởi tạo iRepository
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> getList() {
        List<Product> productList = iProductRepository.getList();
        return productList;
    }

    @Override
    public Map<String, String> save(Product product) {
        Map<String,String>map =new HashMap<>();

        // xử lí validate

    if(map.isEmpty()) {
        iProductRepository.save(product);
    }
        return map;
    }
}
