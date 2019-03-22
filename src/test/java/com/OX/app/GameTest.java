package com.OX.app;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
@Test
public class GameTest {

    public void endToEndTestWinHorizontal(){
        InputProvider inputProvider = new InputProvider(new Scanner("0\n0\n1\n1\n0\n1\n2\n2\n0\n2\n0\n0\n1\n1\n0\n1\n2\n2\n0\n2\n0\n0\n1\n1\n0\n1\n2\n2\n0\n2"));
        ArrayList<Player> playerArrayList = new ArrayList<>();
        GameRules gameRules = new GameRules(3,new Coordinates(3,3));
        GameCompetitors gameCompetitors = new GameCompetitors(playerArrayList);
        gameCompetitors.addingPlayersWithNameAndSign("Bartosz");
        gameCompetitors.addingPlayersWithNameAndSign("Maciej");
        gameCompetitors.chooseStartingPlayerRandomly();
        Settings settings = new Settings(inputProvider);
        settings.gameRules = gameRules;
        settings.gameCompetitors = gameCompetitors;
        Game game = new Game(settings,inputProvider);
        game.init();

        assert gameCompetitors.listOfPlayers.get(0).score == 6 ;
    }

    public void endToEndTestWinDiagonal(){
        InputProvider inputProvider = new InputProvider(new Scanner("0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2"));
        ArrayList<Player> playerArrayList = new ArrayList<>();
        GameRules gameRules = new GameRules(3,new Coordinates(3,3));
        GameCompetitors gameCompetitors = new GameCompetitors(playerArrayList);
        gameCompetitors.addingPlayersWithNameAndSign("Bartosz");
        gameCompetitors.addingPlayersWithNameAndSign("Maciej");
        gameCompetitors.chooseStartingPlayerRandomly();
        Settings settings = new Settings(inputProvider);
        settings.gameRules = gameRules;
        settings.gameCompetitors = gameCompetitors;
        Game game = new Game(settings,inputProvider);
        game.init();

        assert gameCompetitors.listOfPlayers.get(0).score == 6 && gameCompetitors.listOfPlayers.get(1).score == 3;
    }

    public void endToEndTestWinReverseDiagonal(){
        InputProvider inputProvider = new InputProvider(new Scanner("0\n2\n0\n0\n1\n1\n0\n1\n2\n0\n0\n2\n0\n0\n1\n1\n0\n1\n2\n0\n0\n2\n0\n0\n1\n1\n0\n1\n2\n0\n"));
        ArrayList<Player> playerArrayList = new ArrayList<>();
        GameRules gameRules = new GameRules(3,new Coordinates(3,3));
        GameCompetitors gameCompetitors = new GameCompetitors(playerArrayList);
        gameCompetitors.addingPlayersWithNameAndSign("Bartosz");
        gameCompetitors.addingPlayersWithNameAndSign("Maciej");
        gameCompetitors.chooseStartingPlayerRandomly();
        Settings settings = new Settings(inputProvider);
        settings.gameRules = gameRules;
        settings.gameCompetitors = gameCompetitors;
        Game game = new Game(settings,inputProvider);
        game.init();

        assert gameCompetitors.listOfPlayers.get(0).score == 6 && gameCompetitors.listOfPlayers.get(1).score == 3;

    }

    public void endToEndTestTie(){
        InputProvider inputProvider = new InputProvider(new Scanner("0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n0\n0\n0\n1\n1\n1\n0\n2\n2\n2" +
                "\n0\n0\n0\n1\n0\n2\n1\n1\n1\n0\n2\n0\n2\n1\n1\n2\n2\n2" +
                ""));
        ArrayList<Player> playerArrayList = new ArrayList<>();
        GameRules gameRules = new GameRules(3,new Coordinates(3,3));
        GameCompetitors gameCompetitors = new GameCompetitors(playerArrayList);
        gameCompetitors.addingPlayersWithNameAndSign("Bartosz");
        gameCompetitors.addingPlayersWithNameAndSign("Maciej");
        gameCompetitors.chooseStartingPlayerRandomly();
        Settings settings = new Settings(inputProvider);
        settings.gameRules = gameRules;
        settings.gameCompetitors = gameCompetitors;
        Game game = new Game(settings,inputProvider);
        game.init();

        assert gameCompetitors.listOfPlayers.get(0).score == 4
                && gameCompetitors.listOfPlayers.get(1).score == 4;

    }
}
