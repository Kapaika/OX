package com.OX.app;

public class DiagonalChecker implements GameChecker {

    @Override
    public boolean check(Board board, Move lastMove, Integer inLineToWin) {

        Coordinates coordinates = lastMove.coordinates;
        Integer row = coordinates.x;
        Integer col = coordinates.y;
        Sign sign = lastMove.player.sign;
        Integer diagonalCounter = 0;

        for (int i = (row + inLineToWin); i >= row; i--) {
            for (int j = (col + inLineToWin); j >= col; j--) {
                if (i < 0 || i >= board.playingBoard.length - 1 || j >= board.playingBoard[i].length - 1
                        ||  j < 0 ) {
                    continue;
                }
                if (board.playingBoard[i][j] == board.playingBoard[i + 1][j + 1] && board.playingBoard[i][j] == sign) {
                    diagonalCounter++;
                }
            }
        }

        for (int i = (row - inLineToWin); i < row; i++) {
            for (int j = (col - inLineToWin); j < col; j++) {
                if (i<0 || i >= board.playingBoard.length || j >= board.playingBoard[i].length ||  j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == board.playingBoard[i + 1][j + 1] && board.playingBoard[i][j] == sign) {
                    diagonalCounter++;
                }
            }
        }

        return diagonalCounter.equals(inLineToWin);


    }
}
