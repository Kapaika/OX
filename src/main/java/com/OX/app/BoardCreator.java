package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
class BoardCreator {

    private int row;
    private int col;

    BoardCreator(int row, int col) {
        this.row = row;
        this.col = col;
    }

    Sign[][] createBoard(){

        Sign[][] tabXO = new Sign[row][col];

        for(int i = 0 ; i<row; i++){
            for(int j=0; j<col;j++){
                tabXO[i][j]= Sign.N;
            }
        }

        return tabXO;
    }
}
