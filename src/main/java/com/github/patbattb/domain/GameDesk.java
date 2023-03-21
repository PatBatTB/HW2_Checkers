package com.github.patbattb.domain;

public final class GameDesk {
    private final Cell[][] playField;
    public static final int SIZE = 8;

    public GameDesk() {
        playField = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) % 2 == 1) playField[i][j] = new Cell(Color.BLACK);
                else playField[i][j] = new Cell(Color.WHITE);
            }
        }
    }
    public Cell[][] getPlayField() {
        return playField;
    }

    public Cell getCell(int x, int y) {
        return playField[x][y];
    }
}
