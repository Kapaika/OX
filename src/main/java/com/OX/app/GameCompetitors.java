package com.OX.app;

import java.util.ArrayList;

/**
 * Keep information about players who playing game
 * and the player who start a game.
 *
 * @author Bartosz Kupajski
 */
class GameCompetitors {

    ArrayList<Player> listOfPlayers = new ArrayList<>();
    Player startingPlayer;
    private Language language = Language.getInstance();

    GameCompetitors() {
    }

    GameCompetitors(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    /**
     * Adding player to game by passing its name -
     * sign of a player is also added here.
     *
     * @param name
     */
    void addingPlayersWithNameAndSign(String name) {
        if (listOfPlayers.size() < 1) {
            Player player = new Player(name);
            System.out.println(language.getString("firstPlayer") + " : " + name);
            player.setSign(Sign.O);
            addPlayer(player);
        } else {
            Player player = new Player(name);
            System.out.println(language.getString("secondPlayer") + " :  " + name);
            player.setSign(Sign.X);
            addPlayer(player);
        }
    }

    /**
     * Game have to choose who is starting first. It provides the situation
     * adding more than 2 players.
     *
     * @param startingPlayerName
     * @throws NoSuchPlayerException
     */
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
