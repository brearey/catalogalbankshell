package ru.oktemsec.catalogalbankshell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.oktemsec.catalogalbankshell.service.HelloService;

@ShellComponent
public class HelloShell {

    private final HelloService helloService;

    public HelloShell(HelloService helloService) {
        this.helloService = helloService;
    }

    @ShellMethod(key = "hello-to", value = "Say hello to username")
    public String helloTo(@ShellOption({"username", "u"}) String username) {
        return helloService.helloTo(username);
    }
}
