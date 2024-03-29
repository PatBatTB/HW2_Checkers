package com.github.patbattb.services.validators;

import com.github.patbattb.domain.Cell;
import com.github.patbattb.domain.Color;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.exceptions.BusyCellException;
import com.github.patbattb.exceptions.WhiteCellException;

/*
Проверяет валидность хода в клетку.
Если клетка белая или занята - кидает исключение.
 */
public final class CellValidator {

    private CellValidator() { }

    public static void ckeckOut(GameDesk desk, int x, int y)
    throws WhiteCellException, BusyCellException {
        Cell cell = desk.getCell(x, y);
        if (cell.getColor() == Color.WHITE) {
            throw new WhiteCellException();
        } else if (cell.getChecker() != null) {
            throw new BusyCellException();
        }
    }
}
