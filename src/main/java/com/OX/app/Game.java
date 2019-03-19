package com.OX.app;

import Exceptions.TooManyPlayersException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
 class Game {

    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private Board board = new Board();

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
       listOfPlayers.get(0).setState();
       listOfPlayers.get(1).setState();
    }

}
