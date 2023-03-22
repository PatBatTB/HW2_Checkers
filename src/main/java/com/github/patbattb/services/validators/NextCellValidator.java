package com.github.patbattb.services.validators;

import com.github.patbattb.domain.Checker;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.exceptions.InvalidMoveException;

/*
Принимает кооординату активной шашки и координату радом стоящей шашки оппонента.
Проверяет следующую клетку, если свободна - выбрасывает исключение.
 */
public final class NextCellValidator {
    private NextCellValidator() { }

    public static void checkOut(GameDesk desk, int x, int y) throws InvalidMoveException {

        if (CoordsInFieldValidator.checkOut(x, y)) {
            Checker checker = desk.getCell(x, y).getChecker();
            if (checker == null) {
                throw new InvalidMoveException();
            }
        }
    }
}
