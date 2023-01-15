package ru.oktemsec.catalogalbankshell.service;

import org.springframework.stereotype.Service;
import ru.oktemsec.catalogalbankshell.data.entity.Catalog;
import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Position;
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

    public void addPosition(
            int categoryId,
            String positionName,
            String positionUnit,
            float positionPrice,
            int positionCount
    )
    {
        Result result = categoryRepository.addPositionToCategory(categoryId, positionName, positionUnit, positionPrice, positionCount);
        printResult(result);
    }

    public void getCategory(int categoryId) {
        Result result = new Result();
        Category category = categoryRepository.getCategory(categoryId);
        if (category == null) {
            result.isSuccess = false;
            result.message = "Категория " + categoryId + " не найдена";
            printResult(result);
        } else if (category.getPositions().size() == 0) {
            System.out.println("Категория пуста");
        } else {
            printPositions(category.getPositions());
        }
    }

    private void printResult(Result result) {
        if (result.isSuccess) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
        }
    }

    private void printPositions(ArrayList<Position> positions) {
        System.out.println("--------------------------------------------------------");
        System.out.println("id\tнаименование\tколичество\tед.изм.\tстоимость");
        System.out.println("--------------------------------------------------------");
        for (Position pos : positions) {
            System.out.println(pos.getId() + "\t" + pos.getName() + "\t" + pos.getCount() + " " + pos.getUnit() + "\t" + String.format("%.2f", pos.getPrice()) + " " + Position.currency);
        }
        System.out.println("--------------------------------------------------------");
    }
}