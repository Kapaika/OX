package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
 class BoardPrinter {

     Board board;

    public BoardPrinter(Board board) {
        this.board = board;
    }

    void printBoard(){

        Sign[][] tabXO = board.playingBoard;

        for (int i = 0; i < tabXO.length; i++) {
            for (int j = 0; j < tabXO.length; j++) {
                if(j==tabXO.length-1){
                    System.out.print(" " + tabXO[i][j].getText());
                }else {
                    System.out.print(" " + tabXO[i][j].getText() + " |");
                }
            }
            System.out.println();
            if(i!=tabXO.length-1) {
                for (int j = 0; j < tabXO.length; j++) {
                    if (j == tabXO.length - 1) {
                        System.out.println("---");
                    } else {
                        System.out.print("---+");
                    }
                }
            }
        }

    }
}
