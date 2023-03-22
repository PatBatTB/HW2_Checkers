package com.github.patbattb.services.validators;

import com.github.patbattb.domain.Checker;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
import com.github.patbattb.exceptions.InvalidMoveException;

/*
Перебирает в цикле все шашки (чей ход) и вызывает метод скана соседних клеток.
 */
public final class FightMoveValidator {
    private FightMoveValidator() { }

    public static void checkOut(GameDesk desk, Movement movement) throws InvalidMoveException {
        for (int i = 0; i < GameDesk.SIZE; i++) {
            for (int j = 0; j < GameDesk.SIZE; j++) {
                Checker checker = desk.getCell(i, j).getChecker();
                if (checker != null && checker.getColor() == movement.getOwnColor()) {
                    //разделить на дамку и обычную.
                    if (checker.isQueen()) {
                        NearbyCellsScanner.queenScan(desk, i, j, movement);
                    } else {
                        NearbyCellsScanner.scan(desk, i, j, movement);
                    }
                }
            }
        }
    }
}
