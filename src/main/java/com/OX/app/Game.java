package com.OX.app;

import Exceptions.TooManyPlayersException;

import java.util.ArrayList;
import java.util.List;

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
       listOfPlayers.get(0).setSign(Sign.O);
       listOfPlayers.get(1).setSign(Sign.X);
    }
}
