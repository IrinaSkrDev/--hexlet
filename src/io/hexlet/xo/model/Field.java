package io.hexlet.xo.model;

import java.awt.*;

public class Field {
    private final static int FIELD_SIZE = 3;
    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getFieldSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(final Figure figure, final Point point) {
        field[point.x][point.y] = figure;
    }

}
