package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

import javax.swing.text.View;

public class XOCLI {
    public static void main(final String[] args) {
        final String name1 = "Pasha";
        final String name2 = "Masha";
        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        final Game<Figure> gameXO = new Game<>(players, new Field<>(3), "ХО");
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }

    }
}
