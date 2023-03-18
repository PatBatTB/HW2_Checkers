package com.github.patbattb.services.turns;

import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
import com.github.patbattb.services.CoordsConverter;
import com.github.patbattb.services.Parser;
import com.github.patbattb.services.validators.CellValidator;
import com.github.patbattb.services.validators.FightMoveValidator;

import java.util.List;
/*
Ход перемещения (без съедания)
Перед ходом вызывает методы проверки целевой клетки на валидность и остальные шашки на вероятность съесть чужую шашку.
 */
public final class MoveTurn {

    private MoveTurn() { }

    public static void makeTurn(String step, GameDesk desk, Movement movement) {
        List<String> coordinates = Parser.parseOneTurn(step);
        int startX = CoordsConverter.getX(coordinates.get(0));
        int startY = CoordsConverter.getY(coordinates.get(0));
        int endX = CoordsConverter.getX(coordinates.get(1));
        int endY = CoordsConverter.getY(coordinates.get(1));

        CellValidator.ckeckOut(desk, endX, endY);
        FightMoveValidator.checkOut(desk, movement);

        desk.setCell(startX, startY, GameDesk.EMPTY_CELL);
        desk.setCell(endX, endY, movement.getOwnCellColor());


    }
}
