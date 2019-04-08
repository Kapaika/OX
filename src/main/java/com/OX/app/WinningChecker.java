package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
@SuppressWarnings("SameParameterValue")
class WinningChecker {


    Boolean check2(Board board, Move lastMove, Integer inLineToWin) {

        inLineToWin = inLineToWin - 1;
        int winningCheckerCounter = 0;
        HorizontalChecker horizontalChecker = new HorizontalChecker();
        VerticalChecker verticalChecker = new VerticalChecker();
        DiagonalChecker diagonalChecker = new DiagonalChecker();
        ReverseDiagonalChecker reverseDiagonalChecker = new ReverseDiagonalChecker();

        while (winningCheckerCounter < 4) {
            if (!horizontalChecker.check(board, lastMove, inLineToWin)) {
                winningCheckerCounter++;
                if (verticalChecker.check(board, lastMove, inLineToWin)) {
                    return true;
                }
                winningCheckerCounter++;
                if (diagonalChecker.check(board, lastMove, inLineToWin)) {
                    return true;
                }
                winningCheckerCounter++;
                if (reverseDiagonalChecker.check(board, lastMove, inLineToWin)) {
                    return true;
                }
                winningCheckerCounter++;
            } else {
                return true;
            }
        }
        return false;
    }

    Boolean check(Board board, Move lastMove, Integer inLineToWin) {

        Sign playersSign = lastMove.player.sign;
        inLineToWin = inLineToWin - 1;
        Coordinates coordinates = lastMove.coordinates;
        Integer row = coordinates.x;
        Integer col = coordinates.y;

        boolean verticalResult = verticalChecker(row, col, inLineToWin, board, playersSign);
        boolean horizontalResult = horizontalChecker(row, col, inLineToWin, board, playersSign);
        boolean diagonalResult = diagonalChecker(row, col, inLineToWin, board, playersSign);
        boolean reverseDiagonalResult = reverseDiagonalChecker(row, col, inLineToWin, board, playersSign);

        return verticalResult || horizontalResult || diagonalResult || reverseDiagonalResult;
    }

    private boolean horizontalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign) {

        Integer horizontalCounter = 0;
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

    private boolean verticalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign) {

        Integer diagonalCounter = 0;

        for (int i = col; i == col; i++) {
            for (int j = (row + inLineToWin); j > row; j--) {
                if (i < 0 || i >= board.playingBoard.length || j >= board.playingBoard[i].length || j < 0) {
                    continue;
                }
                if (board.playingBoard[j][i] == sign) {
                    diagonalCounter++;
                }
            }
        }

        for (int i = col; i == col; i++) {
            for (int j = (row - inLineToWin); j < row; j++) {
                if (i < 0 || i >= board.playingBoard.length || j >= board.playingBoard[i].length || j < 0) {
                    continue;
                }
                if (board.playingBoard[j][i] == sign) {
                    diagonalCounter++;
                }
            }
        }

        return diagonalCounter.equals(inLineToWin);
    }

    private boolean diagonalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign) {

        Integer diagonalCounter = 0;

        for (int i = (row + inLineToWin); i >= row; i--) {
            for (int j = (col + inLineToWin); j >= col; j--) {
                if (i < 0 || i >= board.playingBoard.length - 1 || j >= board.playingBoard[i].length - 1
                        || j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == board.playingBoard[i + 1][j + 1] && board.playingBoard[i][j] == sign) {
                    diagonalCounter++;
                }
            }
        }

        for (int i = (row - inLineToWin); i < row; i++) {
            for (int j = (col - inLineToWin); j < col; j++) {
                if (i < 0 || i >= board.playingBoard.length || j >= board.playingBoard[i].length || j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == board.playingBoard[i + 1][j + 1] && board.playingBoard[i][j] == sign) {
                    diagonalCounter++;
                }
            }
        }

        return diagonalCounter.equals(inLineToWin);
    }

    private boolean reverseDiagonalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign) {

        Integer reverseDiagonalCounter = 0;

        for (int i = (row - inLineToWin); i < row; i++) {
            for (int j = (col + inLineToWin); j > col; j--) {
                if (i < 0 || i > board.playingBoard.length - 1 || j > board.playingBoard[i].length - 1
                        || j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == board.playingBoard[i + 1][j - 1] && board.playingBoard[i][j] == sign) {
                    reverseDiagonalCounter++;
                }
            }
        }

        for (int i = (row + inLineToWin); i > row; i--) {
            for (int j = (col - inLineToWin); j < col; j++) {
                if (i < 0 || i >= board.playingBoard.length || j >= board.playingBoard[i].length || j < 0) {
                    continue;
                }
                if (board.playingBoard[i][j] == board.playingBoard[i - 1][j + 1] && board.playingBoard[i][j] == sign) {
                    reverseDiagonalCounter++;
                }
            }
        }

        return reverseDiagonalCounter.equals(inLineToWin);
    }


}
