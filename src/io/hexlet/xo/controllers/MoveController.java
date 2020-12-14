package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupaidEcxeption;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Point point,
                            final Figure figure,
                            final Field field) throws InvalidPointException, PointAlreadyOccupaidEcxeption {
        if (field.getFigure(point) != null) {
            throw new PointAlreadyOccupaidEcxeption();
        }
        field.setFigure(figure, point);
    }
}
