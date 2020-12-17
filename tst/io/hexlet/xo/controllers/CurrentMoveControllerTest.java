package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentMoveControllerTest {
    @Test
    public void testCurrentMoveNextMoveO() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(Figure.X, new Point(i, 0));
            field.setFigure(Figure.O, new Point(i, 1));
            field.setFigure(Figure.X, new Point(i, 2));
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testCurrentMoveNextMoveX() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(Figure.X, new Point(i, 0));
            field.setFigure(Figure.O, new Point(i, 1));
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }


    @Test
    public void testCurrentMoveNonNextMove() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(Figure.X, new Point(0, 0));
        field.setFigure(Figure.O, new Point(0, 1));
        field.setFigure(Figure.X, new Point(0, 2));
        field.setFigure(Figure.O, new Point(1, 0));
        field.setFigure(Figure.X, new Point(1, 1));
        field.setFigure(Figure.O, new Point(1, 2));
        field.setFigure(Figure.X, new Point(2, 0));
        field.setFigure(Figure.O, new Point(2, 1));
        field.setFigure(Figure.X, new Point(2, 2));
        assertNull(currentMoveController.currentMove(field));

    }

}