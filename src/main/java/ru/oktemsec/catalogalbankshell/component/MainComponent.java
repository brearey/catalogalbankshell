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

    @ShellMethod(key = "add_category", value = "Добавить категорию [add_category компьютеры]")
    public void add_category(@ShellOption(arity = 1) @Size(min = 1, max = 255) String name) {
        mainService.addCategory(name);
    }

    @ShellMethod(key = "get_catalog", value = "Получить список категорий [get_catalog]")
    public void get_catalog() {
        mainService.getCatalog();
    }

    @ShellMethod(key = "delete_category", value = "Удалить категорию по его ID [delete_category 1]")
    public void delete_category(@ShellOption(arity = 1) int id) {
        mainService.deleteCategory(id);
    }

    @ShellMethod(key = "rename_category", value = "Переименовать категорию по его ID [rename_category 1 мониторы]")
    public void rename_category(@ShellOption(arity = 1) int id, @ShellOption(arity = 1) String name) {
        mainService.renameCategory(id, name);
    }

}
