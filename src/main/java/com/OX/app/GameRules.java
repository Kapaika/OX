package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
 class GameRules {

    Integer inLineToWinCondition;
    Coordinates sizeOfABoard;

    void setInLineToWinCondition(Integer inLineToWin) throws toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoardExcetpion {
        if(inLineToWin<3){
            throw new toSmallWinningConditionExceptionException();
        }
        if(inLineToWin>sizeOfABoard.x || inLineToWin>sizeOfABoard.y){
            throw new winningConditionMoreThanASizeOfBoardExcetpion();
        }
        this.inLineToWinCondition = inLineToWin;
        InputProvider.nextLine();
    }

    void sizeOfABoard(int a, int b) throws toSmallBoardException {
        if(a <3 || b<3){
            throw new toSmallBoardException();
        }
        this.sizeOfABoard = new Coordinates(a,b);
    }

}
