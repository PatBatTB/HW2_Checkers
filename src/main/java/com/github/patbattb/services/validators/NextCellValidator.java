package com.github.patbattb.services.validators;

import com.github.patbattb.domain.GameDesk;

/*
Принимает кооординату активной шашки и координату радом стоящей шашки оппонента.
Проверяет следующую клетку, если свободна - выбрасывает исключение.
 */
public final class NextCellValidator {
    private NextCellValidator() { }

    public static void checkOut(GameDesk desk, int ownX, int ownY, int x, int y) {
        int nextX = 2 * x - ownX;
        int nextY = 2 * y - ownY;

        if (CoordsInFieldValidator.checkOut(nextX, nextY)) {
            if (desk.getCell(nextX, nextY) == GameDesk.EMPTY_CELL) {
                throw new RuntimeException("Invalid move");
            }
        }
    }
}
