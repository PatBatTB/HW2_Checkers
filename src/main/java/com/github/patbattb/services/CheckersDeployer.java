package com.github.patbattb.services;

import com.github.patbattb.domain.Color;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Cell;
import com.github.patbattb.domain.CheckerWhite;
import com.github.patbattb.domain.CheckerBlack;

import java.util.List;
/*
Принимает строку с начальными координатами. Размещает шашки на поле.
 */
public final class CheckersDeployer {
    private CheckersDeployer() { }

    public static void deploy(String line, GameDesk field, Color color) {
        List<String> positions = Parser.parseStartingPositions(line);

        for (String position : positions) {
            int x = CoordsConverter.getX(position);
            int y = CoordsConverter.getY(position);
            Cell cell = field.getCell(x, y);
            var checker = color == Color.WHITE ? new CheckerWhite(position) : new CheckerBlack(position);
            cell.setChecker(checker);
        }
    }
}
