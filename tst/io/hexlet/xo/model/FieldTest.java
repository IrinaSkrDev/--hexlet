package io.hexlet.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getFieldSize() {
        final int expectedValue = 3;
        final Field field = new Field();

        final int actualValue = field.getFieldSize();

        assertEquals(expectedValue, actualValue);
    }

    // @Test
    // void getFigure() {
    // }

    @Test
    void setFigure() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputFigure, inputPoint);

        assertEquals(inputFigure, field.getFigure(inputPoint));


    }
}