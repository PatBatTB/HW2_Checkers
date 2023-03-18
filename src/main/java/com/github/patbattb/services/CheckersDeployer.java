package com.github.patbattb.services;

import com.github.patbattb.domain.GameDesk;
import java.util.List;
/*
Принимает строку с начальными координатами. Размещает шашки на поле.
 */
public final class CheckersDeployer {
    private CheckersDeployer() { }

    public static void deploy(String line, GameDesk field, char color) {
        List<String> positions = Parser.parseStartingPositions(line);

        for (String position : positions) {
            int x = CoordsConverter.getX(position);
            int y = CoordsConverter.getY(position);
            field.setCell(x, y, color);
        }
    }
}
