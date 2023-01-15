package ru.oktemsec.catalogalbankshell.data.repository;

import ru.oktemsec.catalogalbankshell.data.entity.Catalog;
import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Position;
import ru.oktemsec.catalogalbankshell.data.entity.Result;

import java.util.ArrayList;

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
        return catalog.deleteCategory(categoryId);
    }

    @Override
    public Result renameCategoryById(int categoryId, String name) {
        return catalog.renameCategory(categoryId, name);
    }

    @Override
    public Result addPositionToCategory(int categoryId, String positionName, String positionUnit, float positionPrice, int positionCount) {
        Position position = new Position(
                positionName,
                positionPrice,
                positionCount,
                positionUnit
        );
        return catalog.findCategoryById(categoryId).addPosition(position);
    }
}
