package repository.impl;

import model.Category;
import repository.BaseRepository;
import repository.ICategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CATEGORY = "select category_id,category_name from category;";
    @Override
    public List<Category> getList() {
        List<Category> categoryList = new ArrayList<>();
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDatabase()
                    .prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category;
            while (resultSet.next()) {
                category = new Category();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                categoryList.add(category);
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
        return categoryList;
    }

    @Override
    public void save(Category category) {

    }
}
