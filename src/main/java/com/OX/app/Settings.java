package com.OX.app;

import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
class Settings {

    GameCompetitors gameCompetitors = new GameCompetitors();
    GameRules gameRules = new GameRules();
    private InputProvider inputProvider;

    Settings(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    void setSettings(){
        languageChoice();
        addingPlayer(gameCompetitors);
        sizeOfBoard(gameRules);
        winningCondition(gameRules);
        startingPlayer(gameCompetitors);
    }


    private void languageChoice() {

        Language language = Language.getInstance();
        boolean languageChoice = true;

        while (languageChoice) {
            System.out.println(language.getString("languageChoice"));
            System.out.println("1." + language.getString("english"));
            System.out.println("2." + language.getString("polish"));
            String result = inputProvider.nextLine();
            if (result.equals("2")) {
                language.changeLangugae();
                languageChoice = false;
            } else if (result.equals("1")) {
                languageChoice = false;
            }
        }
    }

    private void addingPlayer(GameCompetitors gameCompetitors) {

        List<Player> listOfPlayers = gameCompetitors.listOfPlayers;
        Language language = Language.getInstance();

        if (listOfPlayers.size() < 2) {
            System.out.println(language.getString("who'splaying"));
            gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
            gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
        }


    }

    private void sizeOfBoard(GameRules gameRules) {

        Language language = Language.getInstance();

        if (gameRules.sizeOfABoard == null) {
            System.out.println(language.getString("size"));
            while (true) {
                try {
                    gameRules.sizeOfABoard(inputProvider.nextInt(), inputProvider.nextInt());
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(language.getString("shouldBeNumeric"));
                    inputProvider.nextLine();
                } catch (toSmallBoardException e) {
                    System.out.println(language.getString("smallBoard"));
                    inputProvider.nextLine();
                }
            }
        }
    }

    private void winningCondition(GameRules gameRules) {

        Language language = Language.getInstance();

        if (gameRules.inLineToWinCondition == null) {
            System.out.println(language.getString("winningCondition"));
            while (true) {
                try {
                    gameRules.setInLineToWinCondition(inputProvider.nextInt());
                    break;
                } catch (toSmallWinningConditionExceptionException e) {
                    System.out.println(language.getString("smallCondition"));
                } catch (winningConditionMoreThanASizeOfBoardExcetpion e) {
                    System.out.println(language.getString("equalToBoard"));
                } catch (InputMismatchException e) {
                    System.out.println(language.getString("shouldBeNumeric"));
                    inputProvider.nextLine();
                }
            }
            inputProvider.nextLine();
        }
    }

    private void startingPlayer(GameCompetitors gameCompetitors) {

        Language language = Language.getInstance();

        if (gameCompetitors.startingPlayer == null) {
            System.out.println(language.getString("startingQ"));
            while (true) {
                try {
                    gameCompetitors.chooseStartingPlayer(inputProvider.nextLine());
                    break;
                } catch (NoSuchPlayerException e) {
                    System.out.println(language.getString("noPlayer"));
                }
            }
        }
    }


}
