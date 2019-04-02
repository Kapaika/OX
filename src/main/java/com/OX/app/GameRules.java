package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
@SuppressWarnings("SameParameterValue")
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
     * @param inLineToWin - condition to win XO game
     * @throws TooSmallWinningConditionExceptionException - thrown when a condition is lower than 3
     * @throws WinningConditionMoreThanASizeOfBoardExcetpion - thrown when a condition is bigger
     * than a size of the playing board
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
