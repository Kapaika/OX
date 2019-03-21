package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
class WinningChecker {

    Boolean check(Board board, Move lastMove, Integer inLineToWin) {
        Sign playersSign = lastMove.player.sign;
        inLineToWin = inLineToWin-1;
        Coordinates coordinates = lastMove.coordinates;
        Integer row = coordinates.x;
        Integer col = coordinates.y;

        Boolean verticalResult = verticalChecker(row,col,inLineToWin,board,playersSign);
        Boolean horizontalResult = horizontalChecker(row,col,inLineToWin,board,playersSign);
        Boolean diagonalResult = diagonalChecker(row,col,inLineToWin,board,playersSign);
        Boolean reverseDiagonalResult = reverseDiagonalChecker(row,col,inLineToWin,board,playersSign);

        return verticalResult||horizontalResult||diagonalResult||reverseDiagonalResult;
    }

    private boolean horizontalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign){

        Integer horizontalCounter = 0;
        //Checking if horizontally on right from last move You have acquired line to win
        for(int i=row ; i==row; i++){
            for(int j=(col + inLineToWin);j>col;j--){
                if(i>board.playingBoard.length - 1 || j>board.playingBoard[i].length -1 || i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[i][j]==sign){
                    horizontalCounter++;
                }
            }
        }

        //Checking if horizontally on left from last move position You have acquired line to win
        for(int i=row; i==row; i++){
            for(int j=(col-inLineToWin);j<col;j++){
                if(i>board.playingBoard.length - 1 || j>board.playingBoard[i].length -1 || i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[i][j]==sign){
                    horizontalCounter++;
                }
            }
        }

        if(horizontalCounter.equals(inLineToWin)){
            return true;
        }
        return false;
    }

    private boolean verticalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign){

        Integer diagonalCounter = 0;

        for(int i=col ; i==col; i++){
            for(int j=(row + inLineToWin);j>row;j--){
                if(i>=board.playingBoard.length || j>=board.playingBoard.length || i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[j][i]==sign){
                    diagonalCounter++;
                }
            }
        }

        for(int i=col; i==col; i++){
            for(int j=(row-inLineToWin);j<row;j++){
                if(i>=board.playingBoard.length || j>=board.playingBoard.length || i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[j][i]==sign){
                    diagonalCounter++;
                }
            }
        }

        if(diagonalCounter.equals(inLineToWin)){
            return true;
        }
        return false;
    }

    private boolean diagonalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign){

        Integer diagonalCounter = 0;

        for(int i=(row+inLineToWin);i>=row;i--){
            for(int j=(col+inLineToWin);j>=col;j--){
                if(i>=board.playingBoard.length-1 || j>=board.playingBoard.length-1|| i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[row][col]==board.playingBoard[i+1][j+1] && board.playingBoard[i][j]==sign){
                    diagonalCounter++;
                }
            }
        }

        for(int i=(row-inLineToWin); i<row;i++){
            for(int j=(col-inLineToWin);j<col;j++){
                if(i>=board.playingBoard.length || j>=board.playingBoard.length|| i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[row][col]==board.playingBoard[i+1][j+1] && board.playingBoard[i][j]==sign){
                    diagonalCounter++;
                }
            }
        }

        if(diagonalCounter==2){
            return true;
        }
        return false;
    }

    private boolean reverseDiagonalChecker(Integer row, Integer col, Integer inLineToWin, Board board, Sign sign){

        Integer reverseDiagonalCounter = 0;

        //TODO: Sprawdzić graniczne przypadki
        for(int i=(row-inLineToWin);i<row;i++){
            for(int j=(col+inLineToWin);j>col;j--){
                if(i>board.playingBoard.length-1 || j>board.playingBoard.length-1|| i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[i][j]==board.playingBoard[i+1][j-1] && board.playingBoard[i][j]==sign){
                    reverseDiagonalCounter++;
                }
            }
        }

        for(int i=(row+inLineToWin); i>row;i--){
            for(int j=(col-inLineToWin);j<col;j++){
                if(i>=board.playingBoard.length || j>=board.playingBoard.length|| i<0  || j<0){
                    continue;
                }
                if(board.playingBoard[i][j]==board.playingBoard[i-1][j+1] && board.playingBoard[i][j]==sign){
                    reverseDiagonalCounter++;
                }
            }
        }

        if(reverseDiagonalCounter==2){
            return true;
        }
        return false;
    }


}
