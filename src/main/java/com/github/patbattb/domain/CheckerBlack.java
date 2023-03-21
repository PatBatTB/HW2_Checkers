package com.github.patbattb.domain;

public class CheckerBlack extends Checker {
    public CheckerBlack() {
        super(Color.BLACK);
    }

    public CheckerBlack(boolean isQueen) {
        super(Color.BLACK, isQueen);
    }

    public CheckerBlack(String coord) {
        super(Color.BLACK, coord);
    }
}
