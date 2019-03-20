package com.OX.app;

import Exceptions.TooManyPlayersException;

import java.util.ArrayList;

/**
 * @author Bartosz Kupajski
 */
class GameRules {

    Integer inLineToWinCondition;
    Coordinates sizeOfABoard;

    void setInLineToWinCondition(Integer inLineToWin){
        System.out.println("How many in line to win?");
        this.inLineToWinCondition = inLineToWin;
    }

    void setSizeOfABoard(int a, int b){
//        Integer a = InputProvider.nextInt();
//        Integer b = InputProvider.nextInt();s
        this.sizeOfABoard = new Coordinates(a,b);
    }

}
