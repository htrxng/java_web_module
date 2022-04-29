package repository.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl  implements IProductRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_PRODUCT = "select product_id,product_name,product_price,quantity,color_id,category_id from product;";

    @Override
    public List<Product> getList() {
        List<Product> productList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()){
                product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setColorId(resultSet.getInt("color_id"));
                product.setCategoryId(resultSet.getInt("category_id"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return productList;
    }
private static  final  String INSERT_PRODUCT = "insert into product(product_name,product_price,quantity,color_id,category_id) value (?,?,?,?,?);";
    @Override
    public void save(Product product) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setInt(4,product.getColorId());
            preparedStatement.setInt(5,product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static final String DELETE_PRODUCT = "delete from product where product_id = ?;";
    @Override
    public void remove(Integer id) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
