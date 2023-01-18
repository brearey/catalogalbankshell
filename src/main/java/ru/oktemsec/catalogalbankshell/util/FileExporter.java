package ru.oktemsec.catalogalbankshell.util;

import ru.oktemsec.catalogalbankshell.data.entity.Result;

import java.io.File;
import java.io.PrintWriter;

public class FileExporter {
    public static Result export(String fileName, String text) {
        Result result = new Result();
        File file = new File(fileName +".txt");
        try(PrintWriter out = new PrintWriter(file)) {
            out.println(text);
            result.isSuccess = true;
            result.message = "Файл успешно создан/перезаписан в: " + file.getAbsolutePath();
        } catch (Exception e) {
            result.isSuccess = false;
            result.message = e.getMessage();
        }
        return result;
    }
}
