package com.OX.app;

import Exceptions.FieldAlreadyTakenException;

/**
 * @author Bartosz Kupajski
 */
public class Move {

    Coordinates coordinates;
    Player player;

    Move(Coordinates coordinates, Player player) {
        this.coordinates = coordinates;
        this.player = player;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    void makeAMove(Board tabX0) {

        int length = tabX0.playingBoard.length;

        if(tabX0.playingBoard[coordinates.x][coordinates.y]!=Sign.N ){
            throw new FieldAlreadyTakenException();
        }else{
            tabX0.playingBoard[coordinates.x][coordinates.y]=player.getSign();
        }

    }
}
