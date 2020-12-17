package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class ConsoleView {
    public void show(final Game game) {
        final Field field = game.getField();
        System.out.format("GAme name: %s", game.getName())
        for (int x = 0; x < field.getFieldSize(); x++) {
            printLine(field, x);
        }
        printSeparator();

    }


    public void move(final Game game) {

    }

    private void printLine(final Field field,
                           final int x) {
        printSeparator();
        for (int y = 0; y < field.getFieldSize(); y++) {
            Figure figure;
            System.out.println("|");
            try {
                figure = field.getFigure(new Point(x, y);
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            System.out.println(figure != null ? Figure : " ");
            System.out.println("|");

        }

    }

    private void printSeparator() {
        System.out.println("~~~~~~");
    }
}
