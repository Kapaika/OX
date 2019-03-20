package com.OX.app;

import Exceptions.TooManyPlayersException;
import java.util.ArrayList;

/**
 * @author Bartosz Kupajski
 */
public class GameCompetitors {

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

    void addingPlayersWithNameAndSign(){
        if(listOfPlayers.size()<1){
            System.out.println("What's first player name?");
            String name = InputProvider.nextLine();
            Player player = new Player(name);
            player.setSign(Sign.O);
            addPlayer(player);
        }else{
            System.out.println("What's second player name?");
            String name = InputProvider.nextLine();
            Player player = new Player(name);
            player.setSign(Sign.X);
            addPlayer(player);
        }
    }

}
