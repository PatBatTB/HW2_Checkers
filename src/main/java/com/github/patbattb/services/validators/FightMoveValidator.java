package com.github.patbattb.services.validators;

import com.github.patbattb.domain.Checker;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
/*
Перебирает в цикле все шашки (чей ход) и вызывает метод скана соседних клеток.
 */
public final class FightMoveValidator {
    private FightMoveValidator() { }

    public static void checkOut(GameDesk desk, Movement movement) {
        for (int i = 0; i < GameDesk.SIZE; i++) {
            for (int j = 0; j < GameDesk.SIZE; j++) {
                Checker checker = desk.getCell(i, j).getChecker();
                if (checker != null && checker.getColor() == movement.getOwnColor()) {
                    NearbyCellsScanner.scan(desk, i, j, movement);
                }
            }
        }
    }
}
