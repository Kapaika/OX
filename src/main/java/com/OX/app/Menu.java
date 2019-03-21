package com.OX.app;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu program contain implemented TicTacToe game that firstly ask player
 *  about settings and next leads game turns and display playing Board.
 *
 * @author  Bartosz Kupajski
 * @version 1.0
 * @since   2019-03-21
 */
class Menu {

    InputProvider inputProvider;

    Menu(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    void start() {

        GameCompetitors gameCompetitors = new GameCompetitors();
        GameRules gameRules = new GameRules();
        int gameStarterRequirements = 0;


        Language resourceBundle = Language.getInstance();

        while (gameStarterRequirements < 4) {

            if (gameCompetitors.listOfPlayers.size() < 2) {
                System.out.println(resourceBundle.getString("who'splaying"));
                gameCompetitors.addingPlayersWithNameAndSign(this.inputProvider.nextLine());
                gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
                gameStarterRequirements++;
            }
            if (gameRules.sizeOfABoard == null) {
                System.out.println(resourceBundle.getString("size"));
                try {
                    gameRules.sizeOfABoard(inputProvider.nextInt(), inputProvider.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println(resourceBundle.getString("shouldBeNumeric"));
                    inputProvider.nextLine();
                    continue;
                } catch (toSmallBoardException e) {
                    System.out.println(resourceBundle.getString("smallBoard"));
                    inputProvider.nextLine();
                    continue;
                }
                gameStarterRequirements++;
            }
            if (gameRules.inLineToWinCondition == null) {
                System.out.println(resourceBundle.getString("winningCondition"));
                try {
                    gameRules.setInLineToWinCondition(inputProvider.nextInt());
                } catch (toSmallWinningConditionExceptionException e) {
                    System.out.println(resourceBundle.getString("smallCondition"));
                    continue;
                } catch (winningConditionMoreThanASizeOfBoardExcetpion e) {
                    System.out.println(resourceBundle.getString("equalToBoard"));
                    continue;
                } catch (InputMismatchException e) {
                    System.out.println(resourceBundle.getString("shouldBeNumeric"));
                    inputProvider.nextLine();
                    continue;
                }
                inputProvider.nextLine();
                gameStarterRequirements++;
            }
            if (gameCompetitors.startingPlayer == null) {
                System.out.println(resourceBundle.getString("startingQ"));
                try {
                    gameCompetitors.chooseStartingPlayer(inputProvider.nextLine());
                } catch (NoSuchPlayerException e) {
                    System.out.println(resourceBundle.getString("noPlayer"));
                    continue;
                }
                gameStarterRequirements++;
            }
        }

        Game game = new Game(gameCompetitors, gameRules, inputProvider);
        game.init();
    }

//    }
}
