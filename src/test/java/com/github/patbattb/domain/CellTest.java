package com.github.patbattb.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

    Cell blackCell;
    Cell whiteCell;
    Checker checker;

    @BeforeEach
    void createObjects() {
        blackCell = new Cell(Color.BLACK);
        whiteCell = new Cell(Color.WHITE);
        checker = new CheckerWhite();
    }

    @Test
    void getColor() {
        Assertions.assertThat(Color.WHITE).isEqualTo(whiteCell.getColor());
        Assertions.assertThat(Color.BLACK).isEqualTo(blackCell.getColor());
    }

    @Test
    void getChecker() {
        blackCell.setChecker(checker);
        Assertions.assertThat(checker).isEqualTo(blackCell.getChecker());
    }

    @Test
    void setChecker() {
        blackCell.setChecker(checker);
        whiteCell.setChecker(checker);
        Assertions.assertThat(whiteCell.getChecker()).isEqualTo(blackCell.getChecker());
    }
}