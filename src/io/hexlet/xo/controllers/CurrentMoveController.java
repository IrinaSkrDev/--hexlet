package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int i = 0; i < field.getFieldSize(); i++) {
            countFigure = countFigure + countFigureOnField(field, i);
        }
        if (countFigure == field.getFieldSize() * field.getFieldSize()) {
            return null;
        }
        if (countFigure % 2 == 0) {
            return Figure.X;
        } else {
            return Figure.O;
        }
    }

    private int countFigureOnField(final Field field, final int row) {
        int countFigure = 0;
        for (int j = 0; j < field.getFieldSize(); j++) {
            try {
                if (field.getFigure(new Point(row, j)) != null) {
                    countFigure++;
                }

            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}
