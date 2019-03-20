package com.OX.app;

import Exceptions.TooManyPlayersException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
 class Game {

    private ArrayList<Player> listOfPlayers = new ArrayList<>();

    ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    void addPlayer(Player player){
        if(listOfPlayers.size()==2){
            throw new TooManyPlayersException();
        }
        listOfPlayers.add(player);
    }


    void init() {

        BoardCreator boardCreator = new BoardCreator(3,3);
        Board board = new Board(boardCreator.createBoard());
        WinningChecker winningChecker = new WinningChecker();
        BoardPrinter boardPrinter = new BoardPrinter(board);

        addPlayer(new Player("Bartosz"));
        addPlayer(new Player("Maciej"));
        listOfPlayers.get(0).setSign(Sign.O);
        listOfPlayers.get(1).setSign(Sign.X);
        boardPrinter.printBoard();

        Player currentPlayer = listOfPlayers.get(0);
        Boolean result = false;

        while(!result){
            Integer a = InputProvider.nextInt();
            Integer b = InputProvider.nextInt();
            Coordinates coordinates = new Coordinates(a,b);
            Move move = new Move(coordinates,currentPlayer);
            move.makeAMove(board);
            boardPrinter.printBoard();
            result = winningChecker.check(board,move,3);
            currentPlayer = changePlayer(listOfPlayers,currentPlayer);
        }
    }

    Player changePlayer(List<Player> list, Player player){
        if(player == list.get(0)){
            return list.get(1);
        }
        return list.get(0);
    }

    Player chooseStartingPlayer(List<Player> list, String name) throws NoSuchPlayerException {
        for(Player player: list){
            if(player.name.equals(name)){ return player; }
        }
        throw new NoSuchPlayerException();
    }

    void setBoard(Board board) {
        board = board;
    }
}
