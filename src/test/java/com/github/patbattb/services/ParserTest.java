package com.github.patbattb.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ParserTest {

    String line;
    List<String> lines;
    String step;
    List<String> returnedList;


    @Test
    @DisplayName("Checking returning positions from empty string")
    void parseStartingPositionsFromEmptyList() {
        line = "";
        returnedList = new ArrayList<>();
        Assertions.assertThat(Parser.parseStartingPositions(line)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning positions from invalid data string")
    void parseStartingPositionsFromInvalidList() {
        line = "aaad5";
        returnedList = new ArrayList<>();
        Assertions.assertThat(Parser.parseStartingPositions(line)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning positions from correct data string")
    void parseStartingPositionsFromCorrectList() {
        line = "a1 c3 h8";
        returnedList = new ArrayList<>();
        returnedList.add("a1");
        returnedList.add("c3");
        returnedList.add("h8");
        Assertions.assertThat(Parser.parseStartingPositions(line)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning list of turns from list with various data")
    void parseTurnsFromVariousList() {
        lines = new ArrayList<>();
        lines.add("a1 a3 b2 c1 c3 d2 e1 e3 f2 g1 g3 h2");
        lines.add("g3-f4 f6-e5");
        lines.add("c3-d4 e5:c3");
        lines.add("");
        lines.add("g3f4 f6 e5 e6:f8:h3");

        returnedList = new ArrayList<>();
        returnedList.add("g3-f4");
        returnedList.add("f6-e5");
        returnedList.add("c3-d4");
        returnedList.add("e5:c3");
        returnedList.add("e6:f8:h3");

        Assertions.assertThat(Parser.parseTurns(lines)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning list of turns from empty list")
    void parseTurnsFromEmptyList() {
        lines = new ArrayList<>();
        returnedList = new ArrayList<>();
        Assertions.assertThat(Parser.parseTurns(lines)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning list of coordinates from data string with move turn")
    void parseOneCorrectMoveTurn() {
        step = "g3-f4";
        returnedList = new ArrayList<>();
        returnedList.add("g3");
        returnedList.add("f4");
        Assertions.assertThat(Parser.parseOneTurn(step)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning list of coordinates from data string with single fight turn")
    void parseOneCorrectSimpleFightTurn() {
        step = "g3:f4";
        returnedList = new ArrayList<>();
        returnedList.add("g3");
        returnedList.add("f4");
        Assertions.assertThat(Parser.parseOneTurn(step)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning list of coordinates from data string with multiply fight turn")
    void parseOneCorrectMultiplyFightTurn() {
        step = "g3:f4";
        returnedList = new ArrayList<>();
        returnedList.add("g3");
        returnedList.add("f4");
        Assertions.assertThat(Parser.parseOneTurn(step)).isEqualTo(returnedList);
    }

    @Test
    @DisplayName("Checking returning list of coordinates from invalid data string")
    void parseOneInvalidTurn() {
        step = "g3safdf4";
        returnedList = new ArrayList<>();
        Assertions.assertThat(Parser.parseOneTurn(step)).isEqualTo(returnedList);
    }
}