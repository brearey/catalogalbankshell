package ru.oktemsec.catalogalbankshell.service;

import org.springframework.stereotype.Service;
import ru.oktemsec.catalogalbankshell.data.entity.Catalog;
import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Position;
import ru.oktemsec.catalogalbankshell.data.entity.Result;
import ru.oktemsec.catalogalbankshell.data.repository.CategoryRepositoryImpl;
import ru.oktemsec.catalogalbankshell.util.FileExporter;
import ru.oktemsec.catalogalbankshell.util.Printer;

import java.util.ArrayList;

@Service
public class MainService {

    Catalog catalog = new Catalog();
    CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl(catalog);
    public void addCategory(String name)
    {
        Result result = categoryRepository.addCategory(new Category(name));
        Printer.printResult(result);
    }

    public void getCatalog() {
        ArrayList<Category> categories = categoryRepository.getAllCategory();
        if (categories.size() == 0) {
            System.out.println("Каталог пуст");
        } else {
            Printer.printCatalog(categories);
        }
    }

    public void deleteCategory(int id)
    {
        Result result = categoryRepository.deleteCategoryById(Math.abs(id));
        if (result.isSuccess) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
        }
    }

    public void renameCategory(int id, String name)
    {
        Result result = categoryRepository.renameCategoryById(Math.abs(id), name);
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
        Category category = catalog.findCategoryById(categoryId);
        Result result = category.addPosition(positionName, positionUnit, Math.abs(positionPrice), Math.abs(positionCount));
        Printer.printResult(result);
    }

    public void getCategory(int categoryId) {
        Result result = new Result();
        Category category = categoryRepository.getCategory(Math.abs(categoryId));
        if (category == null) {
            result.isSuccess = false;
            result.message = "Категория " + Math.abs(categoryId) + " не найдена";
            Printer.printResult(result);
        } else if (category.getPositions().size() == 0) {
            System.out.println("Категория пуста");
        } else {
            System.out.println("Категория " + category.getName() + " содержит:");

            // Вывод позиций с не нулевым количеством
            ArrayList<Position> _positions = new ArrayList<>();
            for (Position pos : category.getPositions()) {
                if (pos.getCount() != 0) {
                    _positions.add(pos);
                }
            }

            Printer.printPositions(_positions);
        }
    }

    public void deletePosition(int categoryId, int positionId) {
        Result result = new Result();
        Category category = categoryRepository.getCategory(Math.abs(categoryId));

        // Проверка категории
        if (category == null) {
            result.isSuccess = false;
            result.message = "Категория " + Math.abs(categoryId) + " не найдена";
            Printer.printResult(result);
        } else if (category.getPositions().size() == 0) {
            System.out.println("Категория пуста");
        } else if(category.findPositionById(Math.abs(positionId)) == null) {
            result.isSuccess = false;
            result.message = "В категории " + Math.abs(categoryId) +" позиция " + Math.abs(positionId) + " не найдена";
            Printer.printResult(result);
        }
        else {
            result = category.deletePosition(Math.abs(positionId));
            Printer.printResult(result);
        }
    }

    public void addPositionCount(int categoryId, int positionId, int positionCount) {

        categoryId = Math.abs(categoryId);
        positionId = Math.abs(positionId);
        positionCount = Math.abs(positionCount);

        Result result = new Result();
        Category category = categoryRepository.getCategory(categoryId);
        Position position = null;

        // Проверка категории
        if (category == null) {
            result.isSuccess = false;
            result.message = "Категория " + categoryId + " не найдена";
            Printer.printResult(result);
        } else if (category.getPositions().size() == 0) {
            System.out.println("Категория пуста");
        } else if(category.findPositionById(positionId) == null) {
            result.isSuccess = false;
            result.message = "В категории " + categoryId +" позиция " + positionId + " не найдена";
            Printer.printResult(result);
        }
        else {
            position = category.findPositionById(positionId);
            position.setCount( position.getCount() + positionCount );
            result.isSuccess = true;
            result.message = "Количество позиции " + position.getName() + " успешно изменено";
            Printer.printResult(result);
        }
    }

    public void subPositionCount(int categoryId, int positionId, int positionCount) {

        categoryId = Math.abs(categoryId);
        positionId = Math.abs(positionId);
        positionCount = Math.abs(positionCount);

        Result result = new Result();
        Category category = categoryRepository.getCategory(categoryId);
        Position position = null;

        // Проверка категории
        if (category == null) {
            result.isSuccess = false;
            result.message = "Категория " + categoryId + " не найдена";
            Printer.printResult(result);
        } else if (category.getPositions().size() == 0) {
            System.out.println("Категория пуста");
        } else if(category.findPositionById(positionId) == null) {
            result.isSuccess = false;
            result.message = "В категории " + categoryId +" позиция " + positionId + " не найдена";
            Printer.printResult(result);
        }
        else if (category.findPositionById(positionId).getCount() < positionCount) {
            result.isSuccess = false;
            result.message = "В категории " + categoryId +" количество позиции " + category.findPositionById(positionId) + " не достаточно";
            Printer.printResult(result);
        }
        else {
            position = category.findPositionById(positionId);
            position.setCount( position.getCount() - positionCount );
            result.isSuccess = true;
            result.message = "Количество позиции " + position.getName() + " успешно изменено";
            Printer.printResult(result);
        }
    }

    public void setPositionPrice(int categoryId, int positionId, float positionPrice) {
        categoryId = Math.abs(categoryId);
        positionId = Math.abs(positionId);
        positionPrice = Math.abs(positionPrice);

        Result result = new Result();
        Category category = categoryRepository.getCategory(categoryId);
        Position position = null;

        // Проверка категории на exist и пустоту
        if (category == null) {
            result.isSuccess = false;
            result.message = "Категория " + categoryId + " не найдена";
            Printer.printResult(result);
        } else if (category.getPositions().size() == 0) {
            System.out.println("Категория пуста");
        } else if(category.findPositionById(positionId) == null) {
            result.isSuccess = false;
            result.message = "В категории " + categoryId +" позиция " + positionId + " не найдена";
            Printer.printResult(result);
        }
        else {
            position = category.findPositionById(positionId);
            position.setPrice( positionPrice );
            result.isSuccess = true;
            result.message = "Стоимость позиции " + position.getName() + " успешно изменена";
            Printer.printResult(result);
        }
    }

    public void exportDemo() {
        String demoCommands = "add_category Компьютеры\n" +
                "add_category Мониторы\n" +
                "add_category \"Клавиатуры и мыши\"\n" +
                "\n" +
                "\n" +
                "add_position 1 Corei3 шт. 8000.00 12\n" +
                "add_position 1 Corei5 шт. 11000.00 8\n" +
                "add_position 1 Corei7 шт. 18000.00 4\n" +
                "\n" +
                "\n" +
                "add_position 2 Dell шт. 8000.00 5\n" +
                "add_position 2 Acer шт. 6000.00 4\n" +
                "add_position 2 LG шт. 7000.00 3\n" +
                "add_position 2 Sony шт. 9000.00 0\n" +
                "add_position 2 Apple шт. 49990.50 0\n" +
                "\n" +
                "\n" +
                "add_position 3 Logitech уп. 1500.00 10\n" +
                "add_position 3 Oclick уп. 1400.50 27\n" +
                "add_position 3 Genius уп. 1300.50 25\n" +
                "add_position 3 Razor уп. 3500.00 12\n" +
                "add_position 3 Aceline уп. 799.50 32\n" +
                "add_position 3 DEXP уп. 1250.50 24";

        String test = "test";
        Printer.printResult(FileExporter.export("demo", demoCommands));
    }
}