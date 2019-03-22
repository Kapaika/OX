package com.OX.app;


import java.util.InputMismatchException;
import java.util.List;

/**
 * Menu contain implemented TicTacToe game that firstly ask player
 * about settings and next leads game turns and display playing Board.
 *
 * @author Bartosz Kupajski
 * @version 1.0
 * @since 2019-03-21
 */
class Menu {

    /**
     * InputProvider is as Scanner wrapper
     */
    private InputProvider inputProvider;

    /**
     * Create new Meny with InputProvider in it.
     *
     * @param inputProvider
     */
    Menu(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    /**
     * Creation of the game Settings; Language, Who is playing, Size of a Board and Winning Condition
     * and passing them to the game.
     */
//    void start() {
//
//        GameCompetitors gameCompetitors = new GameCompetitors();
//        GameRules gameRules = new GameRules();
//
//        languageChoice();
//
////        while (gameStarterRequirements < 4) {
////
////            if (gameCompetitors.listOfPlayers.size() < 2) {
////                System.out.println(language.getString("who'splaying"));
////                gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
////                gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
////                gameStarterRequirements++;
////            }
////            if (gameRules.sizeOfABoard == null) {
////                System.out.println(language.getString("size"));
////                try {
////                    gameRules.sizeOfABoard(inputProvider.nextInt(), inputProvider.nextInt());
////                } catch (InputMismatchException e) {
////                    System.out.println(language.getString("shouldBeNumeric"));
////                    inputProvider.nextLine();
////                    continue;
////                } catch (toSmallBoardException e) {
////                    System.out.println(language.getString("smallBoard"));
////                    inputProvider.nextLine();
////                    continue;
////                }
////                gameStarterRequirements++;
////            }
////            if (gameRules.inLineToWinCondition == null) {
////                System.out.println(language.getString("winningCondition"));
////                try {
////                    gameRules.setInLineToWinCondition(inputProvider.nextInt());
////                } catch (toSmallWinningConditionExceptionException e) {
////                    System.out.println(language.getString("smallCondition"));
////                    continue;
////                } catch (winningConditionMoreThanASizeOfBoardExcetpion e) {
////                    System.out.println(language.getString("equalToBoard"));
////                    continue;
////                } catch (InputMismatchException e) {
////                    System.out.println(language.getString("shouldBeNumeric"));
////                    inputProvider.nextLine();
////                    continue;
////                }
////                inputProvider.nextLine();
////                gameStarterRequirements++;
////            }
////            if (gameCompetitors.startingPlayer == null) {
////                System.out.println(language.getString("startingQ"));
////                try {
////                    gameCompetitors.chooseStartingPlayer(inputProvider.nextLine());
////                } catch (NoSuchPlayerException e) {
////                    System.out.println(language.getString("noPlayer"));
////                    continue;
////                }
////                gameStarterRequirements++;
////            }
////        }
//
//        addingPlayer(gameCompetitors);
//        sizeOfBoard(gameRules);
//        winningCondition(gameRules);
//        startingPlayer(gameCompetitors);
//
//        Game game = new Game(gameCompetitors, gameRules, inputProvider);
//        game.init();
//    }
//
//    private void languageChoice() {
//
//        Language language = Language.getInstance();
//        boolean languageChoice = true;
//
//        while (languageChoice) {
//            System.out.println(language.getString("languageChoice"));
//            System.out.println("1." + language.getString("english"));
//            System.out.println("2." + language.getString("polish"));
//            String result = inputProvider.nextLine();
//            if (result.equals("2")) {
//                language.changeLangugae();
//                languageChoice = false;
//            } else if (result.equals("1")) {
//                languageChoice = false;
//            }
//        }
//    }
//
//    private void addingPlayer(GameCompetitors gameCompetitors) {
//
//        List<Player> listOfPlayers = gameCompetitors.listOfPlayers;
//        Language language = Language.getInstance();
//
//        if (listOfPlayers.size() < 2) {
//            System.out.println(language.getString("who'splaying"));
//            gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
//            gameCompetitors.addingPlayersWithNameAndSign(inputProvider.nextLine());
//        }
//
//
//    }
//
//    private void sizeOfBoard(GameRules gameRules) {
//
//        Language language = Language.getInstance();
//
//        if (gameRules.sizeOfABoard == null) {
//            System.out.println(language.getString("size"));
//            while (true) {
//                try {
//                    gameRules.sizeOfABoard(inputProvider.nextInt(), inputProvider.nextInt());
//                    break;
//                } catch (InputMismatchException e) {
//                    System.out.println(language.getString("shouldBeNumeric"));
//                    inputProvider.nextLine();
//                } catch (toSmallBoardException e) {
//                    System.out.println(language.getString("smallBoard"));
//                    inputProvider.nextLine();
//                }
//            }
//        }
//    }
//
//    private void winningCondition(GameRules gameRules) {
//
//        Language language = Language.getInstance();
//
//        if (gameRules.inLineToWinCondition == null) {
//            System.out.println(language.getString("winningCondition"));
//            while (true) {
//                try {
//                    gameRules.setInLineToWinCondition(inputProvider.nextInt());
//                    break;
//                } catch (toSmallWinningConditionExceptionException e) {
//                    System.out.println(language.getString("smallCondition"));
//                } catch (winningConditionMoreThanASizeOfBoardExcetpion e) {
//                    System.out.println(language.getString("equalToBoard"));
//                } catch (InputMismatchException e) {
//                    System.out.println(language.getString("shouldBeNumeric"));
//                    inputProvider.nextLine();
//                }
//            }
//            inputProvider.nextLine();
//        }
//    }
//
//    private void startingPlayer(GameCompetitors gameCompetitors) {
//
//        Language language = Language.getInstance();
//
//        if (gameCompetitors.startingPlayer == null) {
//            System.out.println(language.getString("startingQ"));
//            while (true) {
//                try {
//                    gameCompetitors.chooseStartingPlayer(inputProvider.nextLine());
//                    break;
//                } catch (NoSuchPlayerException e) {
//                    System.out.println(language.getString("noPlayer"));
//                }
//            }
//        }
//    }
    void start(){

        Settings settings = new Settings(inputProvider);
        settings.setSettings();

        Game game = new Game(settings,inputProvider);
        game.init();
    }
}
