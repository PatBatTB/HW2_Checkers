package com.github.patbattb.services.validators;

import com.github.patbattb.domain.GameDesk;
/*
Проверяет валидность хода в клетку.
Если клетка белая или занята - кидает исключение.
 */
public final class CellValidator {
    private CellValidator() { }
    public static void ckeckOut(GameDesk desk, int x, int y) {
        char cell = desk.getCell(x, y);
        if (cell == GameDesk.INVALID_CELL) {
            throw new RuntimeException("White cell");
        } else if (cell != GameDesk.EMPTY_CELL) {
            throw new RuntimeException("Busy cell");
        }
    }
}
