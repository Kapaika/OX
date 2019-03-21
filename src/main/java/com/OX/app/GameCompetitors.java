package com.OX.app;

import java.util.ArrayList;

/**
 *  Keep information about players who playing game
 *      and the player who start a game.
 *
 * @author Bartosz Kupajski
 */
class GameCompetitors {

    ArrayList<Player> listOfPlayers = new ArrayList<>();
    Player startingPlayer;

    GameCompetitors() {}
    GameCompetitors(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    void addingPlayersWithNameAndSign(String name) {
        if (listOfPlayers.size() < 1) {
            Player player = new Player(name);
            player.setSign(Sign.O);
            addPlayer(player);
        } else {
            Player player = new Player(name);
            player.setSign(Sign.X);
            addPlayer(player);
        }
    }
    void chooseStartingPlayer(String startingPlayerName) throws NoSuchPlayerException {
        for (Player player : listOfPlayers) {
            if (player.name.equals(startingPlayerName)) {
                this.startingPlayer = player;
            }
        }
        if (startingPlayer == null) {
            throw new NoSuchPlayerException();
        }
    }
    private void addPlayer(Player player) {
        if (listOfPlayers.size() == 2) {
            throw new TooManyPlayersException();
        }
        listOfPlayers.add(player);
    }
    void chooseStartingPlayerRandomly() {
        this.startingPlayer = listOfPlayers.get(0);
    }
}
