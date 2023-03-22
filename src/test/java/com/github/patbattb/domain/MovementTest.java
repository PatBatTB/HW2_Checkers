package com.github.patbattb.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementTest {

    Movement black;
    Movement white;
    int COUNT_OF_ELEMENTS = 2;

    @BeforeEach
    void createObjects() {
        black = Movement.BLACK;
        white = Movement.WHITE;
    }

    @Test
    void getOwnColor() {
        Assertions.assertThat(white.getOwnColor()).isEqualTo(Color.WHITE);
        Assertions.assertThat(black.getOwnColor()).isEqualTo(Color.BLACK);
    }

    @Test
    void getOppColor() {
        Assertions.assertThat(white.getOppColor()).isEqualTo(Color.BLACK);
        Assertions.assertThat(black.getOppColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void switchTurn() {
        white = white.switchTurn();
        Assertions.assertThat(white).isEqualTo(Movement.BLACK);
        white = white.switchTurn();
        Assertions.assertThat(white).isEqualTo(Movement.WHITE);
    }

    @Test
    @DisplayName("Checking the \"value\" method for content")
    void enumShouldContainsWhiteAndBlack() {
        Assertions.assertThat(Movement.values()).containsExactly(white, black);
    }

    @Test
    @DisplayName("Checking that the class has two elements")
    void enumShouldHaveTwoElements() {
        Assertions.assertThat(Movement.values().length).isEqualTo(COUNT_OF_ELEMENTS);
    }

    @Test
    void valueOf() {
        Assertions.assertThat(Movement.valueOf("WHITE")).isEqualTo(white);
    }
}