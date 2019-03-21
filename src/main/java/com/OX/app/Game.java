package com.OX.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
 class Game {

     private GameCompetitors gameCompetitors;
     private GameRules gameRules;
     private Language language = Language.getInstance();
     private InputProvider2 inputProvider2;

    Game(GameCompetitors gameCompetitors, GameRules gameRules, InputProvider2 inputProvider2) {
        this.gameCompetitors = gameCompetitors;
        this.gameRules = gameRules;
        this.inputProvider2=inputProvider2;
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
                System.out.println(currentPlayer.name + " " + language.getString("move"));

                //Checking if boardSize is not illegal
                try{
                    moveCoordinates = new Coordinates(inputProvider2.nextInt(),inputProvider2.nextInt());
                    move = new Move(moveCoordinates,currentPlayer);
                }
                catch(InputMismatchException e){
                    inputProvider2.nextLine();
                    continue;
                }

                //Checking if move is valid
                try{
                    move.makeAMove(board);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(language.getString("outOfBounds"));
                    continue;
                }
                catch(FieldAlreadyTakenException e){
                    System.out.println(language.getString("alreadyTaken"));
                    continue;
                }
                boardPrinter.printBoard();

                //Checking tie situation
                if(tieChecker.check(board.playingBoard)){
                    System.out.println(language.getString("tie"));
                    for(Player player: listOfPlayers){
                        player.score = player.score + 1;
                    }
                    counter++;
                    break;
                }

                //Checking Win situation
                winResult = winningChecker.check(board,move,3);
                if(winResult){
                    System.out.println(currentPlayer + " " +  language.getString("wonARound"));
                    currentPlayer.score = currentPlayer.score + 3 ;
                    counter++;
                }

                currentPlayer = changePlayer(listOfPlayers,currentPlayer);
            }
        }
    }

    private void gameResult(Player firstPlayer, Player secondPlayer){
        if(firstPlayer.score>secondPlayer.score){
            System.out.println(language.getString("won") + firstPlayer);
        }else if(firstPlayer.score<secondPlayer.score){
            System.out.println(language.getString("won") + secondPlayer);
        }else{
            System.out.println(language.getString("tie"));
        }
    }
}
