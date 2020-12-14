package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;


import java.awt.*;

public class WinnerController {
    int lines = 0;
    int columns = 1;
    int diagonalDown = 2;
    int diagonalUp = 3;
    int[] countX = new int[]{0, 0, 0, 0};
    int[] countO = new int[]{0, 0, 0, 0};

    public Figure getWinner(final Field field) {
        try {
            int size = field.getFieldSize();
            Figure figure;
            Figure results = null;
            countX = new int[]{0, 0, 0, 0};
            countO = new int[]{0, 0, 0, 0};
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    figure = field.getFigure(new Point(i, j));
                    results = countingWinner(lines, figure, size);
                    figure = null;
                    if (results != null) {
                        return results;
                    } else {
                        results = null;
                    }

                    figure = field.getFigure(new Point(j, i));
                    results = countingWinner(columns, figure, size);
                    figure = null;
                    if (results != null) {
                        return results;
                    } else {
                        results = null;
                    }
                }
                countX[lines] = 0;
                countO[lines] = 0;
                countO[columns] = 0;
                countX[columns] = 0;
                figure = field.getFigure(new Point(i, i));
                results = countingWinner(diagonalDown, figure, size);
                figure = null;
                if (results != null) {
                    return results;
                } else {
                    results = null;
                }

                figure = field.getFigure(new Point(i, (size - 1 - i)));
                results = countingWinner(diagonalUp, figure, size);
                figure = null;
                if (results != null) {
                    return results;
                } else {
                    results = null;
                }
            }
            return null;
        } catch (InvalidPointException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Figure countingWinner(int direction, Figure figure, int size) {
        if (figure == Figure.X) {
            countX[direction] = countX[direction] + 1;
            if (countX[direction] == size) {
                return Figure.X;
            }
        } else if (figure == Figure.O) {
            countO[direction] = countO[direction] + 1;
            if (countO[direction] == size) {
                return Figure.O;
            }
        }
        return null;
    }
}
