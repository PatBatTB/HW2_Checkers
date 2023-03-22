package com.github.patbattb.exceptions;

public final class BusyCellException extends Exception {

    public BusyCellException() {
        super("Некорректный ход, целевая клетка занята.");
    }
}
