package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
 class Board {

    Sign[][] playingBoard;

    Board(Sign[][] playingBoard) {
        this.playingBoard = playingBoard;
    }

    void makeAMove(Move move) throws ArrayIndexOutOfBoundsException {

        int x = move.coordinates.x;
        int y = move.coordinates.y;
        Player player = move.player;

        if (playingBoard[x][y] != Sign.N) {
            throw new FieldAlreadyTakenException();
        } else {
            playingBoard[x][y] = player.getSign();
        }
    }

}
