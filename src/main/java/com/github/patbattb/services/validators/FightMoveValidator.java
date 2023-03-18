package com.github.patbattb.services.validators;

import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
/*
Перебирает в цикле все шашки (чей ход) и вызывает метод скана соседних клеток.
 */
public final class FightMoveValidator {
    private FightMoveValidator() { }

    public static void checkOut(GameDesk desk, Movement movement) {
        //В цикле перебрать все белые шашки
        // Валидатор индексов, что бы не выходить за поле.
        // у каждой шашки просканировать соседние клетки.
        // если есть соседняя черная - просканировать следующую клетку
        // если пустая - выбрасываем исключение.
        //
        for (int i = 0; i < desk.getPlayField().length; i++) {
            for (int j = 0; j < desk.getPlayField()[0].length; j++) {
                if (desk.getCell(i, j) == movement.getOwnCellColor()) {
                    NearbyCellsScanner.scan(desk, i, j, movement);
                }
            }
        }
    }
}
