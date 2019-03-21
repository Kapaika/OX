package com.OX.app;

import Exceptions.FieldAlreadyTakenException;

/**
 * @author Bartosz Kupajski
 */
 class Move {

    Coordinates coordinates;
    Player player;

    public Move() {
    }

    Move(Coordinates coordinates, Player player) {
        this.coordinates = coordinates;
        this.player = player;
    }

    //TODO:Obsluzyc wyjatek wyzej
    void makeAMove(Board tabX0) throws ArrayIndexOutOfBoundsException {
        if(tabX0.playingBoard[coordinates.x][coordinates.y]!=Sign.N ){
            throw new FieldAlreadyTakenException();
        }else{
            tabX0.playingBoard[coordinates.x][coordinates.y]=player.getSign();
        }

    }
}
