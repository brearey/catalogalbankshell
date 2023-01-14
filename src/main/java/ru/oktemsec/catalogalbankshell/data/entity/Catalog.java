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

    public void deleteCategory(int categoryId) {
        this.categories.remove(categoryId);
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }
}
