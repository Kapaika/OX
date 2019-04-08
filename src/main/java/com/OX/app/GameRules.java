package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
class GameRules {

    Integer inLineToWinCondition;
    Coordinates sizeOfABoard;

    GameRules() {
    }

    GameRules(Integer inLineToWinCondition, Coordinates sizeOfABoard) {
        this.inLineToWinCondition = inLineToWinCondition;
        this.sizeOfABoard = sizeOfABoard;
    }

    /**
     * Setting the winningCondition providing the situation with smaller than 3 condition
     * as well as too big(bigger than board)
     *
     * @param inLineToWin
     * @throws toSmallWinningConditionExceptionException
     * @throws winningConditionMoreThanASizeOfBoardExcetpion
     */
    void setInLineToWinCondition(Integer inLineToWin) throws toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoardExcetpion {
        if (inLineToWin < 3) {
            throw new toSmallWinningConditionExceptionException();
        }
        if (inLineToWin > sizeOfABoard.x || inLineToWin > sizeOfABoard.y) {
            throw new winningConditionMoreThanASizeOfBoardExcetpion();
        }
        this.inLineToWinCondition = inLineToWin;
    }

    /**
     * Setting the size of a Board providing the situation with Board smaller than 3x3.
     *
     * @param a
     * @param b
     * @throws toSmallBoardException
     */
    void sizeOfABoard(int a, int b) throws toSmallBoardException {
        if (a < 3 || b < 3) {
            throw new toSmallBoardException();
        }
        this.sizeOfABoard = new Coordinates(a, b);
    }

}
