package com.OX.app;

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
     * @param inLineToWin
     * @throws TooSmallWinningConditionExceptionException
     * @throws WinningConditionMoreThanASizeOfBoardExcetpion
     */
    void setInLineToWinCondition(Integer inLineToWin) throws TooSmallWinningConditionExceptionException, WinningConditionMoreThanASizeOfBoardExcetpion {
        if(inLineToWin<3){
            throw new TooSmallWinningConditionExceptionException();
        }
        if(inLineToWin>sizeOfABoard.x || inLineToWin>sizeOfABoard.y){
            throw new WinningConditionMoreThanASizeOfBoardExcetpion();
        }
        this.inLineToWinCondition = inLineToWin;
    }


    void sizeOfABoard(Coordinates coordinates) throws TooSmallBoardException {

        int a = coordinates.x;
        int b = coordinates.y;

        if(a <3 || b<3){
            throw new TooSmallBoardException();
        }
        this.sizeOfABoard = new Coordinates(a,b);
    }

}
