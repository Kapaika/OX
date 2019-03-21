package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
 class GameRules {

    Integer inLineToWinCondition;
    Coordinates sizeOfABoard;

    void setInLineToWinCondition(Integer inLineToWin) throws toSmallWinningConditionExceptionException, winningConditionMoreThanASizeOfBoard {
        if(inLineToWin<3){
            throw new toSmallWinningConditionExceptionException();
        }
        if(inLineToWin>sizeOfABoard.x || inLineToWin>sizeOfABoard.y){
            throw new winningConditionMoreThanASizeOfBoard();
        }
        this.inLineToWinCondition = inLineToWin;
        InputProvider.nextLine();
    }

    void setSizeOfABoard(int a, int b){
        this.sizeOfABoard = new Coordinates(a,b);
    }

}
