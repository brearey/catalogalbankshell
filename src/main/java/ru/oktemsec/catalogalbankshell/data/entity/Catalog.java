package ru.oktemsec.catalogalbankshell.data.entity;

import java.util.ArrayList;

public class Catalog {
    public static int count;
    private final ArrayList<Category> categories;

    static {
        count = 0;
    }

    public Catalog() {
        count++;
        categories = new ArrayList<>();
    }

    public Result addCategory(Category category) {
        Result result = new Result();

        try {
            this.categories.add(category);
            result.isSuccess = true;
            result.message = "Категория " + category.getName() + " успешно добавлена";
        } catch (Exception e) {
            result.isSuccess = false;
            result.message = e.getMessage();
        }
        return result;
    }

    public Result deleteCategory(int categoryId) {
        Result result = new Result();
        Category deletedCategory = findCategoryById(categoryId);

        if (deletedCategory == null) {
            result.isSuccess = false;
            result.message = "Категория с таким ID не найдена";
            return result;
        }

        try {
            int deleteId = deletedCategory.getId();
            String deletedName = deletedCategory.getName();
            this.categories.remove(deletedCategory);
            result.isSuccess = true;
            result.message = "Категория " + deleteId + " " + deletedName + " успешно удалена";
        } catch (Exception e) {
            result.isSuccess = false;
            result.message = e.getMessage();
        }
        return result;
    }

    public Result renameCategory(int categoryId, String name) {
        Result result = new Result();
        Category toRenameCategory = findCategoryById(categoryId);
        int index = categories.indexOf(toRenameCategory);

        if (toRenameCategory == null) {
            result.isSuccess = false;
            result.message = "Категория с таким ID не найдена";
            return result;
        }

        try {
            categories.get(index).setName(name);
            result.isSuccess = true;
            result.message = "Категория с ID:" + categoryId + " успешно переименована";
        } catch (Exception e) {
            result.isSuccess = false;
            result.message = e.getMessage();
        }
        return result;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    private Category findCategoryById(int id) {
        for (Category cat : categories) {
            if (cat.getId() == id) {
                return cat;
            }
        }
        return null;
    }
}
