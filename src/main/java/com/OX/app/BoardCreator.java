package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
class BoardCreator {

    final private int rows;
    final private int cols;

    BoardCreator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    Board createBoard(){

        Sign[][] tabXO = new Sign[rows][cols];

        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                tabXO[i][j]= Sign.N;
            }
        }

        return new Board(tabXO);
    }
}
