package com.github.patbattb;

import java.io.IOException;
import java.util.List;

import com.github.patbattb.domain.Color;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.exceptions.BusyCellException;
import com.github.patbattb.exceptions.InvalidMoveException;
import com.github.patbattb.exceptions.WhiteCellException;
import com.github.patbattb.services.CheckersDeployer;
import com.github.patbattb.services.DeskPrinter;
import com.github.patbattb.services.GameStep;
import com.github.patbattb.services.Reader;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        List<String> lines;
        try {
            lines = Reader.read();
            if (lines.size() < 2) {
                throw new RuntimeException("Input data is invalid.");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        var desk = new GameDesk();
        CheckersDeployer.deploy(lines.get(0), desk, Color.WHITE);
        CheckersDeployer.deploy(lines.get(1), desk, Color.BLACK);
        try {
            GameStep.runSteps(lines, desk);
        } catch (WhiteCellException e) {
            System.out.println("white cell");
            System.exit(0);
        } catch (BusyCellException e) {
            System.out.println("busy cell");
            System.exit(0);
        } catch (InvalidMoveException e) {
            System.out.println("invalid move");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("general error");
            System.exit(0);
        }

        DeskPrinter.printResult(desk);
    }
}
