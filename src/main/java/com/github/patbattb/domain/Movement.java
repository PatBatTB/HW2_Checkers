package com.github.patbattb.domain;

public enum Movement {
    WHITE(GameDesk.BUSY_CELL_WHITE, GameDesk.BUSY_CELL_BLACK),
    BLACK(GameDesk.BUSY_CELL_BLACK, GameDesk.BUSY_CELL_WHITE);

    private final char ownCellColor;
    private final char oppCellColor;

    Movement(char ownCellColor, char oppCellColor) {
        this.ownCellColor = ownCellColor;
        this.oppCellColor = oppCellColor;
    }

    public char getOwnCellColor() {
        return ownCellColor;
    }

    public char getOppCellColor() {
        return oppCellColor;
    }

    public Movement switchTurn() {
        if (this.equals(WHITE)) return BLACK;
        return WHITE;
    }
}
