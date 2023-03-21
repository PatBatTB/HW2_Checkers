package com.github.patbattb.domain;

public enum Movement {
    WHITE(Color.WHITE, Color.BLACK),
    BLACK(Color.BLACK, Color.WHITE);

    private final Color ownColor;
    private final Color oppColor;

    Movement(Color ownColor, Color oppColor) {
        this.ownColor = ownColor;
        this.oppColor = oppColor;
    }

    public Color getOwnColor() {
        return ownColor;
    }

    public Color getOppColor() {
        return oppColor;
    }

    public Movement switchTurn() {
        if (this.equals(WHITE)) return BLACK;
        return WHITE;
    }
}
