package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field<T> {

    private final static int MIN_COORDINATE = 0;
    private final T[][] field;

    private final int fieldSize;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = (T[][]) new Object[fieldSize][fieldSize];
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final T figure, final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }


        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length - 1) && checkCoordinate(point.y, field.length - 1);

    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate <= maxCoordinate;
    }
}
