package com.OX.app;

public class VerticalChecker implements GameChecker {

    @Override
    public boolean check(Board board, Move lastMove, Integer inLineToWin) {

        Coordinates coordinates = lastMove.coordinates;
        Integer row = coordinates.x;
        Integer col = coordinates.y;
        Sign sign = lastMove.player.sign;
        Integer diagonalCounter = 0;

        for (int i = col; i == col; i++) {
            for (int j = (row + inLineToWin); j > row; j--) {
                if (i < 0 || j < 0 || i > board.playingBoard[0].length - 1 || j > board.playingBoard.length - 1) {
                    continue;
                }
                if (board.playingBoard[j][i] == sign) {
                    diagonalCounter++;
                }
            }
        }

        for (int i = col; i == col; i++) {
            for (int j = (row - inLineToWin); j < row; j++) {
                if (i < 0 || j < 0 || i > board.playingBoard[0].length - 1 || j > board.playingBoard.length - 1) {
                    continue;
                }
                if (board.playingBoard[j][i] == sign) {
                    diagonalCounter++;
                }
            }
        }

        return diagonalCounter.equals(inLineToWin);
    }
}
