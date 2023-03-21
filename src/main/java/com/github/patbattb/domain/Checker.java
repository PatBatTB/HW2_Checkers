package com.github.patbattb.domain;

public abstract class Checker {
    private final Color color;
    private boolean isQueen;

    public Checker(Color color) {
        this.color = color;
    }

    public Checker(Color color, boolean isQueen) {
        this.color = color;
        this.isQueen = isQueen;
    }

    public Checker(Color color, String coord) {
        this.color = color;
        isQueen = Character.isUpperCase(coord.charAt(0));
    }

    public final Color getColor() {
        return color;
    }

    public final boolean isQueen() {
        return isQueen;
    }

    public final void setQueen(boolean queen) {
        isQueen = queen;
    }
}
