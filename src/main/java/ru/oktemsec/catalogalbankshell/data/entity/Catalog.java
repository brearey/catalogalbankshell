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

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void deleteCategory(int categoryId) {
        this.categories.remove(categoryId);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
