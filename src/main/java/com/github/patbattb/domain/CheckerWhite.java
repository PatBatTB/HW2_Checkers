package com.github.patbattb.domain;

public class CheckerWhite extends Checker {
    public CheckerWhite() {
        super(Color.WHITE);
    }

    public CheckerWhite(boolean isQueen) {
        super(Color.WHITE, isQueen);
    }

    public CheckerWhite(String coord) {
        super(Color.WHITE, coord);
    }

}
