package com.github.patbattb.services;

public final class CoordsConverter {

    private static final int DESK_SIZE = 8;
    private static final int UTF_FIRST_DIGIT_INDEX = 48;
    private static final int UTF_FIRST_LOWERCASE_LETTER_INDEX = 97;
    private static final int UTF_FIRST_UPPERCASE_LETTER_INDEX = 65;

    /*
    конвертирует текстовые координаты в координаты индексов массива.
     */
    private CoordsConverter() { }

    public static int getX(String position) {
        return DESK_SIZE - (position.charAt(1) - UTF_FIRST_DIGIT_INDEX);
    }

    public static int getY(String position) {
        char letter = position.charAt(0);
        if (Character.isLowerCase(letter)) {
            return letter - UTF_FIRST_LOWERCASE_LETTER_INDEX;
        } else {
            return letter - UTF_FIRST_UPPERCASE_LETTER_INDEX;
        }
    }

    public static String getPosition(int x, int y) {
        char digit = (char) (DESK_SIZE - x + UTF_FIRST_DIGIT_INDEX);
        char letter = (char) (y + UTF_FIRST_LOWERCASE_LETTER_INDEX);
        return "" + letter + digit;
    }
}
