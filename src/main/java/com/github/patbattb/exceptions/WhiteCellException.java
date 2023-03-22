package com.github.patbattb.exceptions;

public final class WhiteCellException extends Exception {

    public WhiteCellException() {
        super("Шашки ходят только по черным клеткам, целевая клетка - белая.");
    }
}
