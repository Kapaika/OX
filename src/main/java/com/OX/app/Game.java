package com.OX.app;

import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
 class Game {

     private GameCompetitors gameCompetitors;
     private GameRules gameRules;

    Game(GameCompetitors gameCompetitors, GameRules gameRules) {
        this.gameCompetitors = gameCompetitors;
        this.gameRules = gameRules;
    }

     void init(){

        List<Player> listOfPlayers = gameCompetitors.getListOfPlayers();
        BoardCreator boardCreator = new BoardCreator(gameRules.sizeOfABoard.x,gameRules.sizeOfABoard.y);

        Player currentPlayer = gameCompetitors.startingPlayer;

        singleGame(listOfPlayers,currentPlayer,boardCreator);
        gameResult(currentPlayer,changePlayer(listOfPlayers,currentPlayer));
        //System.out.println(listOfPlayers.get(0).name + " " + listOfPlayers.get(0).score + " | " + listOfPlayers.get(1).name + " "  + listOfPlayers.get(1).score);
    }

    private Player changePlayer(List<Player> list, Player player){
        if(player == list.get(0)){
            return list.get(1);
        }
        return list.get(0);
    }

    private void singleGame(List<Player> listOfPlayers, Player currentPlayer, BoardCreator boardCreator){

        int counter = 0;

        //Best of Three here
        while(counter<3){
            //single game inside
            Boolean winResult = false;
            Board board = new Board(boardCreator.createBoard());
            BoardPrinter boardPrinter = new BoardPrinter(board);
            boardPrinter.printBoard();
            WinningChecker winningChecker = new WinningChecker();
            TieChecker tieChecker = new TieChecker();

            while(!winResult){
                Coordinates moveCoordinates;
                Move move;
                System.out.println("What's you move " + currentPlayer.name + " ?  [r,c]");
                try{
                    moveCoordinates = new Coordinates(InputProvider.nextInt(),InputProvider.nextInt());
                    move = new Move(moveCoordinates,currentPlayer);
                }
                catch(InputMismatchException e){
                    InputProvider.nextLine();
                    continue;
                }
                try{
                    move.makeAMove(board);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Out of bounds....");
                    continue;
                }
                catch(FieldAlreadyTakenException e){
                    System.out.println("Field already taken....");
                    continue;
                }
                boardPrinter.printBoard();
                if(tieChecker.check(board.playingBoard)){
                    System.out.println("It is a tie!");
                    for(Player player: listOfPlayers){
                        player.score = player.score + 1;
                    }
                    counter++;
                    break;
                }
                winResult = winningChecker.check(board,move,3);
                if(winResult){
                    System.out.println(currentPlayer + " won a round!");
                    currentPlayer.score = currentPlayer.score + 3 ;
                    counter++;
                }

                currentPlayer = changePlayer(listOfPlayers,currentPlayer);
            }
        }
    }

    private void gameResult(Player firstPlayer, Player secondPlayer){
        if(firstPlayer.score>secondPlayer.score){
            System.out.println("Wygral" + firstPlayer);
        }else if(firstPlayer.score<secondPlayer.score){
            System.out.println("Wygral" + secondPlayer);
        }else{
            System.out.println("Remis");
        }
    }
}
