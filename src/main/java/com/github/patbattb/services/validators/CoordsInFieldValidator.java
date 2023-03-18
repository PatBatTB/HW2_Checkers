package com.github.patbattb.services.validators;

/*
Проверяет координаты на валидность (что бы были внутри игрового поля.)
Возвращает true, если координата валидна.
 */
public final class CoordsInFieldValidator {
    private CoordsInFieldValidator() { }

    public static boolean checkOut(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;

    }
}
