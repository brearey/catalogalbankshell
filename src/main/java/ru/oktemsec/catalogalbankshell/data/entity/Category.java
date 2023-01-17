package ru.oktemsec.catalogalbankshell.data.entity;

import java.util.ArrayList;

public class Category {
    static int count;

    private final int id;
    private String name;

    private int positionId;
    private final ArrayList<Position> positions;

    static {
        count = 0;
    }

    public Category(String name) {
        this.name = name;
        positionId = 0;
        count++;
        id = count;
        positions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Result addPosition(String positionName, String positionUnit, float positionPrice, int positionCount) {
        Result result = new Result();
        positionId++;
        Position position = new Position(
                this,
                positionName,
                positionPrice,
                positionCount,
                positionUnit
        );

        try {
            this.positions.add(position);
            result.isSuccess = true;
            result.message = "Позиция " + position.getName() + " успешно добавлена";
        } catch (Exception e) {
            result.isSuccess = false;
            result.message = e.getMessage();
        }
        return result;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public Result deletePosition(int positionId) {
        Result result = new Result();
        Position toDeletePosition = findPositionById(positionId);
        try {
            positions.remove(toDeletePosition);
            result.isSuccess = true;
            result.message = "Позиция " + toDeletePosition.getName() + " успешно удалена";
        } catch (Exception e) {
            result.isSuccess = false;
            result.message = e.getMessage();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Category.count = count;
    }

    public Position findPositionById(int id) {
        for (Position pos : positions) {
            if (pos.getId() == id) {
                return pos;
            }
        }
        return null;
    }

    public int getPositiond() {
        return positionId;
    }
}
