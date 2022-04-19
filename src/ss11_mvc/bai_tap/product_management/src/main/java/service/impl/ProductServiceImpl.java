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
        Map<String, String> map = new HashMap<>();
        if (product.getNameProduct().equals("")) {
            map.put("name", "Tên không được để trống");
        } else if (!product.getNameProduct().matches("^[a-zA-Z ]+$")) {
            map.put("name", "Tên không hợp lệ");
        }
        if (map.isEmpty()) {
            iProductRepository.save(product);
        }
        return map;
    }

    @Override
    public String update(int id, Product product) {
        String notice = "";
        if (product.getNameProduct().equals("")) {
            notice = "Name of Product can not be empty!";
        } else if (!product.getNameProduct().matches("^[a-zA-Z ]+$")) {
            notice = "Product Name is invalid!";
        }
        if (notice.equals("")) {
            iProductRepository.update(id, product);
            notice = "Update successful!";
        }
        return notice;
    }

    @Override
    public void remove(int id) {
        int index = -1;
        for (int i = 0; i < this.getList().size(); i++) {
            if (this.getList().get(i).getId() == id) {
                index = i;
                break;
            }
        }
        iProductRepository.remove(index);
    }

    @Override
    public Product findByID(int id) {
        int index = -1;
        for (int i = 0; i < this.getList().size(); i++) {
            if (this.getList().get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return iProductRepository.findByID(index);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
