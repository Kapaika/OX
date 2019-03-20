package com.OX.app;

import Exceptions.FieldAlreadyTakenException;
import Exceptions.TooManyPlayersException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
 class Game {

     private GameCompetitors gameCompetitors = new GameCompetitors();
     private GameRules gameRules= new GameRules();

    void init() {

        gameCompetitors.addingPlayersWithNameAndSign();
        gameCompetitors.addingPlayersWithNameAndSign();
        List<Player> listOfPlayers = gameCompetitors.getListOfPlayers();

        System.out.println("Size of a board?");
        gameRules.setSizeOfABoard(InputProvider.nextInt(),InputProvider.nextInt());
        BoardCreator boardCreator = new BoardCreator(gameRules.sizeOfABoard.x,gameRules.sizeOfABoard.y);


        Player currentPlayer = null;

        try {
            currentPlayer = chooseStartingPlayer(listOfPlayers);
        } catch (NoSuchPlayerException e) {
            e.printStackTrace();
        }
//        while(!result){
//            Integer a = InputProvider.nextInt();
//            Integer b = InputProvider.nextInt();
//            Coordinates moveCoordinates = new Coordinates(a,b);
//            Move move = new Move(moveCoordinates,currentPlayer);
//            try{
//                move.makeAMove(board);
//            }
//            catch (ArrayIndexOutOfBoundsException e){
//                System.out.println("Przekroczony zakres");
//                continue;
//            }
//            boardPrinter.printBoard();
//            result = winningChecker.check(board,move,3);
//            currentPlayer = changePlayer(listOfPlayers,currentPlayer);
//        }

        singleGame(listOfPlayers,currentPlayer,boardCreator);

        System.out.println(listOfPlayers.get(0).name + " " + listOfPlayers.get(0).score + " | " + listOfPlayers.get(1).name + " "  + listOfPlayers.get(1).score);
    }

    private Player changePlayer(List<Player> list, Player player){
        if(player == list.get(0)){
            return list.get(1);
        }
        return list.get(0);
    }

    private Player chooseStartingPlayer(List<Player> list) throws NoSuchPlayerException {
        System.out.println(list.get(0).name + " / " + list.get(1).name);
        System.out.println("Who's Starting?");
        InputProvider.nextLine();
        String name = InputProvider.nextLine();
        for(Player player: list){
            if(player.name.equals(name)){ return player; }
        }
        throw new NoSuchPlayerException();
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
                System.out.println("What's you move " + currentPlayer.name + " ?");
                Coordinates moveCoordinates = new Coordinates(InputProvider.nextInt(),InputProvider.nextInt());
                Move move = new Move(moveCoordinates,currentPlayer);
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
}
