package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
 class GameRules {

    Integer inLineToWinCondition;
    Coordinates sizeOfABoard;

    void setInLineToWinCondition(Integer inLineToWin) throws toSmallWinningConditionExceptionException {
        if(inLineToWin<3){
            throw new toSmallWinningConditionExceptionException();
        }
        this.inLineToWinCondition = inLineToWin;
        InputProvider.nextLine();
    }

    void setSizeOfABoard(int a, int b){
        this.sizeOfABoard = new Coordinates(a,b);
    }

}
