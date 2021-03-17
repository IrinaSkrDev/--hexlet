package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupaidEcxeption;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(final Game<Figure> game) {
        final Field<Figure> field = game.getField();
        System.out.format("Game name: %s\n", game.getName());
        for (int x = 0; x < field.getFieldSize(); x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(field, x);

        }

    }


    public boolean move(final Game<Figure> game) {
        final Field<Figure> field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        if (currentFigure == null) {
            System.out.println("No winner and no move left!\n");
            return false;
        }
        System.out.format("Please enter move Point for %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(point, currentFigure, field);

        } catch (InvalidPointException | PointAlreadyOccupaidEcxeption e) {
            //e.printStackTrace();
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        int coordinateX = askCoordinate("X") - 1;
        int coordinateY = askCoordinate("Y") - 1;
        return new Point(coordinateX, coordinateY);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please enter coordinate %s", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Введеные не кореектные координаты! Попробуйте снова!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field<Figure> field,
                           final int x) {
        for (int y = 0; y < field.getFieldSize(); y++) {
            Figure figure;

            try {
                figure = (Figure) field.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(" ");
            System.out.print(figure != null ? figure : " ");
            if (y != field.getFieldSize() - 1) {
                System.out.print(" ");
                System.out.print("|");
            }

        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }
}
