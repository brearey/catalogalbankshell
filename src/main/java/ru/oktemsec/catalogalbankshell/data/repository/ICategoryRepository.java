package ru.oktemsec.catalogalbankshell.data.repository;

import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Result;

import java.util.List;

public interface ICategoryRepository {
    List<Category> getAllCategory();

    Result addCategory(Category category);

    Result deleteCategoryById(int categoryId);

    Result renameCategoryById(int categoryId, String name);

    Category getCategory(int categoryId);
}
