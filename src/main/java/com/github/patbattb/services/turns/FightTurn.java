package com.github.patbattb.services.turns;

import com.github.patbattb.domain.Cell;
import com.github.patbattb.domain.Checker;
import com.github.patbattb.domain.GameDesk;
import com.github.patbattb.domain.Movement;
import com.github.patbattb.exceptions.BusyCellException;
import com.github.patbattb.exceptions.GeneralErrorException;
import com.github.patbattb.exceptions.InvalidMoveException;
import com.github.patbattb.exceptions.WhiteCellException;
import com.github.patbattb.services.CoordsConverter;
import com.github.patbattb.services.Parser;
import com.github.patbattb.services.validators.CellValidator;
import com.github.patbattb.services.validators.NearbyCellsScanner;

import java.util.List;
/*
Ход съедания
 */
public final class FightTurn {
    private FightTurn() { }

    public static void makeTurn(String step, GameDesk desk, Movement movement)
            throws GeneralErrorException, InvalidMoveException, BusyCellException, WhiteCellException {
        List<String> coordinates = Parser.parseOneTurn(step);
        int startX = CoordsConverter.getX(coordinates.get(0));
        int startY = CoordsConverter.getY(coordinates.get(0));
        Checker checker = desk.getCell(startX, startY).getChecker();
        if (checker.isQueen()) {
            for (int i = 1; i < coordinates.size(); i++) {
                int endX = CoordsConverter.getX(coordinates.get(i));
                int endY = CoordsConverter.getY(coordinates.get(i));
                CellValidator.ckeckOut(desk, endX, endY);

                int oppX = startX;
                int oppY = startY;
                while (oppX != endX && oppY != endY) {
                    oppX += Integer.signum(endX - startX);
                    oppY += Integer.signum(endY - startY);
                    checker = desk.getCell(oppX, oppY).getChecker();
                    if (checker != null && checker.getColor() == movement.getOppColor()) {
                        break;
                    }
                }
                if (oppX == endX && oppY == endY) {
                    throw new GeneralErrorException("No opponent checker on the fight line");
                }

                Cell startCell = desk.getCell(startX, startY);
                Cell oppCell = desk.getCell(oppX, oppY);
                Cell endCell = desk.getCell(endX, endY);

                endCell.setChecker(startCell.getChecker());
                startCell.setChecker(null);
                oppCell.setChecker(null);

                startX = endX;
                startY = endY;
            }

            NearbyCellsScanner.queenScan(desk, startX, startY, movement);

        } else {
            for (int i = 1; i < coordinates.size(); i++) {
                int endX = CoordsConverter.getX(coordinates.get(i));
                int endY = CoordsConverter.getY(coordinates.get(i));
                CellValidator.ckeckOut(desk, endX, endY);

                int oppX = (startX + endX) / 2;
                int oppY = (startY + endY) / 2;

                checker = desk.getCell(oppX, oppY).getChecker();
                if (checker.getColor() != movement.getOppColor()) {
                    throw new GeneralErrorException("No opponent checker on the fight line");
                }

                Cell startCell = desk.getCell(startX, startY);
                Cell oppCell = desk.getCell(oppX, oppY);
                Cell endCell = desk.getCell(endX, endY);

                endCell.setChecker(startCell.getChecker());
                startCell.setChecker(null);
                oppCell.setChecker(null);

                if (endX == 0 && movement == Movement.WHITE || endX == 7 && movement == Movement.BLACK) {
                    endCell.getChecker().setQueen(true);
                }

                startX = endX;
                startY = endY;
            }

            NearbyCellsScanner.scan(desk, startX, startY, movement);
        }
    }
}
