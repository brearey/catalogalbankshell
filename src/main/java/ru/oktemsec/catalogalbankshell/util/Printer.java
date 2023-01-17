package ru.oktemsec.catalogalbankshell.util;

import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Position;
import ru.oktemsec.catalogalbankshell.data.entity.Result;

import java.util.ArrayList;

public class Printer {

    public static void printResult(Result result) {
        if (result.isSuccess) {
            System.out.println(result.message);
        } else {
            System.err.println(result.message);
            System.out.println();
        }
    }
    public static void printPositions(ArrayList<Position> positions) {
        String leftAlignFormat = "| %-5d | %-20s | %-10s | %-17s |%n";

        System.out.format("+-------+----------------------+------------+-------------------+%n");
        System.out.format("| ID    | наименование товара  |   кол-во   |     стоимость     |%n");
        System.out.format("+-------+----------------------+------------+-------------------+%n");
        for (Position pos : positions) {
            System.out.format(leftAlignFormat, pos.getId(), pos.getName(), pos.getCount() + " " + pos.getUnit(), String.format("%.2f", pos.getPrice()) + " " + Position.currency);
        }
        System.out.format("+-------+----------------------+------------+-------------------+%n");
    }

    public static void printCatalog(ArrayList<Category> categories) {
        String leftAlignFormat = "| %-5d | %-20s | %-17s |%n";

        System.out.format("+-------+----------------------+-------------------+%n");
        System.out.format("| ID    |        Категория     |  Кол-во позиций   |%n");
        System.out.format("+-------+----------------------+-------------------+%n");
        for (Category cat : categories) {
            System.out.format(leftAlignFormat, cat.getId(), cat.getName(), cat.getPositions().size());
        }
        System.out.format("+-------+----------------------+-------------------+%n");
    }
}
