package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupaidEcxeption;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getFieldSize() throws Exception {
        final int expectedValue = 3;
        final Field field = new Field();

        final int actualValue = field.getFieldSize();

        assertEquals(expectedValue, actualValue);
    }

    // @Test
    // void getFigure() {
    // }

    @Test
    void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.X;

        field.setFigure(inputFigure, inputPoint);

        assertEquals(inputFigure, field.getFigure(inputPoint));


    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        assertNull(field.getFigure(inputPoint));


    }

    @Test
    void testGetFigureWhenXLessZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }


    }

    @Test
    void testGetFigureWhenYLessZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }


    }

    @Test
    void testGetFigureWhenXYLessZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }


    }

    @Test
    void testGetFigureWhenXMoreSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getFieldSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }


    }

    @Test
    void testGetFigureWhenYMoreSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getFieldSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }


    }

    @Test
    void testGetFigureWhenXYMoreSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getFieldSize() + 1, field.getFieldSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }


    }
}