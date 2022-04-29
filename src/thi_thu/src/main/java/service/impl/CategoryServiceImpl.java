package service.impl;

import model.Category;
import repository.ICategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.ICategoryService;

import java.util.List;
import java.util.Map;

public class  CategoryServiceImpl implements ICategoryService {
    ICategoryRepository iCategoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> getList() {
        return iCategoryRepository.getList();
    }

    @Override
    public Map<String, String> save(Category category) {
        return null;
    }
}
