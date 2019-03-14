package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
 class Board {

    Sign[][] playingBoard;
    Game game;

    Sign[][] createPlayingBoard(int row, int col) {
        return playingBoard = new Sign[row][col];
    }
}
