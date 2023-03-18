package com.github.patbattb.services.turns;

import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
import com.github.patbattb.services.CoordsConverter;
import com.github.patbattb.services.Parser;
import com.github.patbattb.services.validators.CellValidator;
import com.github.patbattb.services.validators.NearbyCellsScanner;

import java.util.List;
/*
Ход съедания
 */
public final class FightTurn {
    private FightTurn() { }

    public static void makeTurn(String step, GameDesk desk, Movement movement) {
        List<String> coordinates = Parser.parseOneTurn(step);
        int startX = CoordsConverter.getX(coordinates.get(0));
        int startY = CoordsConverter.getY(coordinates.get(0));
        for (int i = 1; i < coordinates.size(); i++) {
            int endX = CoordsConverter.getX(coordinates.get(i));
            int endY = CoordsConverter.getY(coordinates.get(i));

            CellValidator.ckeckOut(desk, endX, endY);
            int oppX = (startX + endX) / 2;
            int oppY = (startY + endY) / 2;

            if (desk.getCell(oppX, oppY) != movement.getOppCellColor()) {
                throw new RuntimeException("No opponent checker on the fight line");
            }

            desk.setCell(startX, startY, GameDesk.EMPTY_CELL);
            desk.setCell(oppX, oppY, GameDesk.EMPTY_CELL);
            desk.setCell(endX, endY, movement.getOwnCellColor());

            startX = endX;
            startY = endY;
        }

        NearbyCellsScanner.scan(desk, startX, startY, movement);
    }
}
