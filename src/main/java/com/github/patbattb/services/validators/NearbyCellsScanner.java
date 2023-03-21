package com.github.patbattb.services.validators;

import com.github.patbattb.domain.Checker;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;

/*
сканирует соседние клетки,
если находит в соседней клетке шашку оппонента - вызывет метод, проверяющий клетку за ней.
 */
public final class NearbyCellsScanner {
    private NearbyCellsScanner() { }

    public static void scan(GameDesk desk, int ownX, int ownY, Movement movement) {
        int down = -1;
        int up = 1;
        for (int i = down; i <= up; i += 2) {
            for (int j = down; j <= up; j += 2) {
                int x = ownX + i;
                int y = ownY + j;
                if (CoordsInFieldValidator.checkOut(x, y)) {
                    Checker checker = desk.getCell(x, y).getChecker();
                    if (checker != null && checker.getColor() == movement.getOppColor()) {
                        NextCellValidator.checkOut(desk, ownX, ownY, x, y);
                    }
                }
            }
        }
    }
}
