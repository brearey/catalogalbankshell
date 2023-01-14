package ru.oktemsec.catalogalbankshell.data.repository;

import ru.oktemsec.catalogalbankshell.data.entity.Catalog;
import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Result;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository {

    private final Catalog catalog;

    public CategoryRepositoryImpl(Catalog _catalog) {
        this.catalog = _catalog;
    }

    @Override
    public ArrayList<Category> getAllCategory() {
        return catalog.getCategories();
    }

    @Override
    public Result addCategory(Category category) {
        return catalog.addCategory(category);
    }

    @Override
    public Result deleteCategoryById(int categoryId) {
        return null;
    }

    @Override
    public Result renameCategoryById(int categoryId, String name) {
        return null;
    }
}
