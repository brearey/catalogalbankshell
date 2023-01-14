package ru.oktemsec.catalogalbankshell.component;

import jakarta.validation.constraints.Size;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.oktemsec.catalogalbankshell.data.entity.Catalog;
import ru.oktemsec.catalogalbankshell.data.repository.CategoryRepositoryImpl;
import ru.oktemsec.catalogalbankshell.service.MainService;

import java.util.logging.Logger;
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

    @ShellMethod(key = "get_category", value = "Получить список категорий [get_category]")
    public void get_category() {
        mainService.getCategory();
    }

}
