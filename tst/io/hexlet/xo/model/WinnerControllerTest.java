package io.hexlet.xo.model;

import io.hexlet.xo.controllers.WinnerController;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(Figure.X, new Point(i, 0));
            field.setFigure(Figure.X, new Point(i, 1));
            field.setFigure(Figure.X, new Point(i, 2));
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(Figure.X, new Point(i, 0));
            field.setFigure(Figure.X, new Point(i, 1));
            field.setFigure(Figure.O, new Point(i, 2));
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(Figure.O, new Point(i, 0));
            field.setFigure(Figure.X, new Point(i, 1));
            field.setFigure(Figure.X, new Point(i, 2));
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(Figure.X, new Point(0, i));
            field.setFigure(Figure.X, new Point(1, i));
            field.setFigure(Figure.X, new Point(2, i));
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(Figure.X, new Point(0, i));
            field.setFigure(Figure.X, new Point(1, i));
            field.setFigure(Figure.O, new Point(2, i));
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(Figure.X, new Point(0, 0));
        field.setFigure(Figure.X, new Point(1, 1));
        field.setFigure(Figure.X, new Point(2, 2));
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(Figure.X, new Point(0, 0));
        field.setFigure(Figure.X, new Point(1, 1));
        field.setFigure(Figure.O, new Point(2, 2));
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(Figure.X, new Point(0, 2));
        field.setFigure(Figure.X, new Point(1, 1));
        field.setFigure(Figure.X, new Point(2, 0));
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(Figure.X, new Point(0, 2));
        field.setFigure(Figure.X, new Point(1, 1));
        field.setFigure(Figure.O, new Point(2, 0));
        assertNull(winnerController.getWinner(field));
    }

}
