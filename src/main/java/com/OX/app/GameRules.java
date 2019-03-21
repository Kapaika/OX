package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
 class GameRules {

    Integer inLineToWinCondition;
    Coordinates sizeOfABoard;
    private InputProvider2 inputProvider2 = new InputProvider2(new Scanner(System.in));

    void setInLineToWinCondition(Integer inLineToWin) throws toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoardExcetpion {
        if(inLineToWin<3){
            throw new toSmallWinningConditionExceptionException();
        }
        if(inLineToWin>sizeOfABoard.x || inLineToWin>sizeOfABoard.y){
            throw new winningConditionMoreThanASizeOfBoardExcetpion();
        }
        this.inLineToWinCondition = inLineToWin;
    }

    void sizeOfABoard(int a, int b) throws toSmallBoardException {
        if(a <3 || b<3){
            throw new toSmallBoardException();
        }
        this.sizeOfABoard = new Coordinates(a,b);
    }

}
