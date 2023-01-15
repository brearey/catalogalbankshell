package ru.oktemsec.catalogalbankshell.component;

import jakarta.validation.constraints.Size;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.oktemsec.catalogalbankshell.service.MainService;

@ShellComponent
public class MainComponent {

    private final MainService mainService;

    public MainComponent(MainService _mainService) {
        this.mainService = _mainService;
    }

    @ShellMethod(key = "add_category", value = "Добавить категорию {add_category компьютеры}")
    public void add_category(@ShellOption(arity = 1) @Size(min = 1, max = 255) String name) {
        mainService.addCategory(name);
    }

    @ShellMethod(key = "get_catalog", value = "Получить список категорий {get_catalog}")
    public void get_catalog() {
        mainService.getCatalog();
    }

    @ShellMethod(key = "delete_category", value = "Удалить категорию по его ID {delete_category 1}")
    public void delete_category(@ShellOption(arity = 1) int id) {
        mainService.deleteCategory(id);
    }

    @ShellMethod(key = "rename_category", value = "Переименовать категорию по его ID {rename_category 1 мониторы}")
    public void rename_category(@ShellOption(arity = 1) int id, @ShellOption(arity = 1) String name) {
        mainService.renameCategory(id, name);
    }

    // Commands for one category
    @ShellMethod(key = "add_position", value = "Добавить позицию в категорию {add_position [ID категории] [название позиции] [едицина измерения] [стоимость] [количество]}")
    public void add_position(
            @ShellOption(arity = 1) int categoryId,
            @ShellOption(arity = 1) @Size(min = 1, max = 255) String positionName,
            @ShellOption(arity = 1) @Size(min = 1, max = 20) String positionUnit,
            @ShellOption(arity = 1) float positionPrice,
            @ShellOption(arity = 1) int positionCount
    ) {
        mainService.addPosition(categoryId, positionName, positionUnit, positionPrice, positionCount);
    }

    @ShellMethod(key = "get_category", value = "Получить список позиций в категории с ID {get_category 1}")
    public void get_category(@ShellOption(arity = 1) int categoryId) {
        mainService.getCategory(categoryId);
    }
}
