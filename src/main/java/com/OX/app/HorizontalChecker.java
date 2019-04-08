package com.OX.app;

public class HorizontalChecker implements GameChecker {

    @Override
    public boolean check(Board board, Move lastMove, Integer inLineToWin) {

        Coordinates coordinates = lastMove.coordinates;
        Integer row = coordinates.x;
        Integer col = coordinates.y;
        Integer horizontalCounter = 0;
        Sign sign = lastMove.player.sign;

        //Checking if horizontally on right from last move You have acquired line to win
        for (int i = row; i == row; i++) {
            for (int j = (col + inLineToWin); j > col; j--) {
                if (i < 0 || i > board.playingBoard.length - 1 || j > board.playingBoard[i].length - 1 || j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == sign) {
                    horizontalCounter++;
                }
            }
        }

        //Checking if horizontally on left from last move position You have acquired line to win
        for (int i = row; i == row; i++) {
            for (int j = (col - inLineToWin); j < col; j++) {
                if (i < 0 || i > board.playingBoard.length - 1 || j > board.playingBoard[i].length - 1 || j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == sign) {
                    horizontalCounter++;
                }
            }
        }

        return horizontalCounter.equals(inLineToWin);
    }
}
