package ru.oktemsec.catalogalbankshell;

import ru.oktemsec.catalogalbankshell.data.entity.Category;
import ru.oktemsec.catalogalbankshell.data.entity.Position;
import ru.oktemsec.catalogalbankshell.util.Printer;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Category comps = new Category("comps");

        comps.addPosition("Corei3", "шт.", 8000, 12);
        comps.addPosition("Corei5", "шт.", 8000, 12);
        comps.addPosition("Corei7", "шт.", 8000, 12);

        Category monics = new Category("monics");

        monics.addPosition("Dell", "шт.", 8000, 5);
        monics.addPosition("Acer", "шт.", 8000, 5);
        monics.addPosition("LG", "шт.", 8000, 5);

        Printer.printPositions(comps.getPositions());
        Printer.printPositions(monics.getPositions());
    }
}
