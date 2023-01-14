package ru.oktemsec.catalogalbankshell.data.repository;

import ru.oktemsec.catalogalbankshell.data.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> getAllCategory();
}
