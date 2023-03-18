package com.github.patbattb;

import java.util.List;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.services.CheckersDeployer;
import com.github.patbattb.services.DeskPrinter;
import com.github.patbattb.services.GameStep;
import com.github.patbattb.services.Reader;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        List<String> lines = Reader.read();
        var desk = new GameDesk();
        CheckersDeployer.deploy(lines.get(0), desk, GameDesk.BUSY_CELL_WHITE);
        CheckersDeployer.deploy(lines.get(1), desk, GameDesk.BUSY_CELL_BLACK);
        GameStep.runSteps(lines, desk);
        DeskPrinter.printResult(desk);

    }
}