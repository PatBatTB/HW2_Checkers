package com.github.patbattb.exceptions;

public final class InvalidMoveException extends Exception {

    public InvalidMoveException() {
        super("Неверный ход. Бить шашку соперника - обязательно.");
    }
}
