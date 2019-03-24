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
            String result = null;
            try {
                result = inputProvider.nextLine();
            } catch (GameInterruptedByUserException e) {
                System.out.println("koniec");
                System.exit(0);
            }
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
            try {
                gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
                gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
            } catch (GameInterruptedByUserException e) {
                System.out.println("Koniec gry!");
                System.exit(0);
            }
        }


    }

    private void sizeOfBoard(GameRules gameRules) {

        Language language = Language.getInstance();

        if (gameRules.sizeOfABoard == null) {
            System.out.println(language.getString("size"));
            while (true) {
                try {
                    Coordinates sizesOfBoard = new Coordinates(inputProvider.getIntFromUser(),inputProvider.getIntFromUser());
                    gameRules.sizeOfABoard(sizesOfBoard);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(language.getString("shouldBeNumeric"));
                } catch (TooSmallBoardException e) {
                    System.out.println(language.getString("smallBoard"));
                } catch (GameInterruptedByUserException e) {
                    System.out.println("Koniec gry");
                    System.exit(0);
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
                    gameRules.setInLineToWinCondition(inputProvider.getIntFromUser());
                    break;
                } catch (TooSmallWinningConditionExceptionException e) {
                    System.out.println(language.getString("smallCondition"));
                } catch (WinningConditionMoreThanASizeOfBoardExcetpion e) {
                    System.out.println(language.getString("equalToBoard"));
                } catch (InputMismatchException e) {
                    System.out.println(language.getString("shouldBeNumeric"));
                } catch (GameInterruptedByUserException e) {
                    e.printStackTrace();
                }
            }
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
                } catch (GameInterruptedByUserException e) {
                    System.out.println("Koniec gry");
                    System.exit(0);
                }
            }
        }
    }


}
