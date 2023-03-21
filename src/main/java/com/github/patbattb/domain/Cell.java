package com.github.patbattb.domain;

public final class Cell {
    private final Color color;
    private Checker checker;

    public Cell(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }
}
