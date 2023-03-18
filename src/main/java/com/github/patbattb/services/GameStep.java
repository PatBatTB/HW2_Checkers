package com.github.patbattb.services;

import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
import com.github.patbattb.services.turns.FightTurn;
import com.github.patbattb.services.turns.MoveTurn;

import java.util.List;

public final class GameStep {
    private GameStep() { }

    private static Movement movement = Movement.WHITE;

    /*
    Принимает на вход доску с расставленными шашками и список строк с входными данными. В цикле обрабатывает все ходы.
     */
    public static void runSteps(List<String> lines, GameDesk desk) {
        List<String> steps = Parser.parseTurns(lines);
        for (String step : steps) {
            boolean isFightTurn = step.contains(":");
            if (isFightTurn) {

                FightTurn.makeTurn(step, desk, movement);

                movement = movement.switchTurn();
            } else {
                MoveTurn.makeTurn(step, desk, movement);
                movement = movement.switchTurn();
            }
        }
    }
}
