package com.github.patbattb.domain;

public final class GameDesk {
    private final char[][] playField;
    public static final int SIZE = 8;
    public static final char EMPTY_CELL = 'o';
    public static final char INVALID_CELL = 'x';
    public static final char BUSY_CELL_WHITE = 'w';
    public static final char BUSY_CELL_BLACK = 'b';

    public GameDesk() {
        playField = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) % 2 == 1) playField[i][j] = EMPTY_CELL;
                else playField[i][j] = INVALID_CELL;
            }
        }
    }

    public char[][] getPlayField() {
        return playField;
    }

    public char getCell(int x, int y) {
        return playField[x][y];
    }

    public void setCell(int x, int y, char value) {
        playField[x][y] = value;
    }
}
