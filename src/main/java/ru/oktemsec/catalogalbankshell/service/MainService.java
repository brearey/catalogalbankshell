package ru.oktemsec.catalogalbankshell.service;

import org.springframework.stereotype.Service;
import ru.oktemsec.catalogalbankshell.data.entity.Catalog;
import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Result;
import ru.oktemsec.catalogalbankshell.data.repository.CategoryRepositoryImpl;

import java.util.ArrayList;

@Service
public class MainService {

    Catalog catalog = new Catalog();
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl(catalog);
    public void addCategory(String name)
    {
        Result result = categoryRepository.addCategory(new Category(name));
        if (result.isSuccess) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
        }
    }

    public void getCatalog() {
        ArrayList<Category> categories = categoryRepository.getAllCategory();
        if (categories.size() == 0) {
            System.out.println("Каталог пуст");
        } else {
            for (Category cat : categories) {
                System.out.println(cat.getId() + " " + cat.getName());
            }
        }
    }

    public void deleteCategory(int id)
    {
        Result result = categoryRepository.deleteCategoryById(id);
        if (result.isSuccess) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
        }
    }

    public void renameCategory(int id, String name)
    {
        Result result = categoryRepository.renameCategoryById(id, name);
        if (result.isSuccess) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
        }
    }
}