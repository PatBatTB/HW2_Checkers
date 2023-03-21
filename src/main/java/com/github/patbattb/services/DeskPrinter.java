package com.github.patbattb.services;

import com.github.patbattb.domain.Checker;
import com.github.patbattb.domain.Color;
import com.github.patbattb.domain.GameDesk;
/*
Выводит в stdout координаты расположения шашек
В первой строке белые шашки.
Во второй - черные.
 */
public final class DeskPrinter {
    private DeskPrinter() { }

    public static void printResult(GameDesk desk) {
        for (int i = 0; i < GameDesk.SIZE; i++) {
            for (int j = GameDesk.SIZE - 1; j >= 0; j--) {
                Checker checker = desk.getCell(j, i).getChecker();
                if (checker != null && checker.getColor() == Color.WHITE) {
                    System.out.print(CoordsConverter.getPosition(j, i, checker.isQueen()) + " ");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < GameDesk.SIZE; i++) {
            for (int j = GameDesk.SIZE - 1; j >= 0; j--) {
                Checker checker = desk.getCell(j, i).getChecker();
                if (checker != null && checker.getColor() == Color.BLACK) {
                    System.out.print(CoordsConverter.getPosition(j, i, checker.isQueen()) + " ");
                }
            }
        }
        System.out.println();
    }
}
