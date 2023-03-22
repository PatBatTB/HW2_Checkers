package com.github.patbattb.services;

import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
import com.github.patbattb.exceptions.BusyCellException;
import com.github.patbattb.exceptions.GeneralErrorException;
import com.github.patbattb.exceptions.InvalidMoveException;
import com.github.patbattb.exceptions.WhiteCellException;
import com.github.patbattb.services.turns.FightTurn;
import com.github.patbattb.services.turns.MoveTurn;

import java.util.List;

/**
 * Класс осуществляет функционал ходов шашек по полю по заданным координатам.
 */
public final class GameStep {
    private GameStep() { }

    private static Movement movement = Movement.WHITE;

    /**
     * Метод принимает строку с входными данными задачи, обрабатывает данные с ходами,
     * осуществляет перемещение шашек по доске.
     * @param lines - Список с входными данными задачи.
     * @param desk - доска с расставленными шашками.
     * @throws InvalidMoveException - некорректный ход (не была выбита шашка, когда была возможность)
     * @throws GeneralErrorException - остальные разные ошибки.
     * @throws BusyCellException - Некорректный ход (на занятую клетку).
     * @throws WhiteCellException - Некорректный ход (на белую клетку).
     */
    public static void runSteps(List<String> lines, GameDesk desk)
            throws InvalidMoveException, GeneralErrorException, BusyCellException, WhiteCellException {
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
