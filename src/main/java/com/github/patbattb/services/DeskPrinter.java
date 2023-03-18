package com.github.patbattb.services;

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
                if (desk.getCell(j, i) == GameDesk.BUSY_CELL_WHITE) {
                    System.out.print(CoordsConverter.getPosition(j, i) + " ");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < GameDesk.SIZE; i++) {
            for (int j = GameDesk.SIZE - 1; j >= 0; j--) {
                if (desk.getCell(j, i) == GameDesk.BUSY_CELL_BLACK) {
                    System.out.print(CoordsConverter.getPosition(j, i) + " ");
                }
            }
        }
        System.out.println();
    }
}
