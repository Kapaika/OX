package com.OX.app;

import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
class Game {


    private GameCompetitors gameCompetitors;
    private GameRules gameRules;
    private Language language = Language.getInstance();
    private InputProvider inputProvider;

    /**
     * Creates new Game with all rules, competitors
     * and InputProvider to contact with user.
     * @param gameCompetitors
     * @param gameRules
     * @param inputProvider
     */
    Game(GameCompetitors gameCompetitors, GameRules gameRules, InputProvider inputProvider) {
        this.gameCompetitors = gameCompetitors;
        this.gameRules = gameRules;
        this.inputProvider = inputProvider;
    }

    /**
     * Initialization of a game - contains BoardCreator which creates a playing Board based on
     * data from GameRules. Game is played here - the requirements to started it is list of Players, playingBoard
     * and Player who starts.
     * . At the end the result of game is printed.
     */
    void init() {

        List<Player> listOfPlayers = gameCompetitors.listOfPlayers;
        BoardCreator boardCreator = new BoardCreator(gameRules.sizeOfABoard.x, gameRules.sizeOfABoard.y);

        Player currentPlayer = gameCompetitors.startingPlayer;

        //Playing a game
        bestOfThreeGame(listOfPlayers, currentPlayer, boardCreator);

        //Printing the result
        gameResult(currentPlayer, changePlayer(listOfPlayers, currentPlayer));
    }

    private void bestOfThreeGame(List<Player> listOfPlayers, Player currentPlayer, BoardCreator boardCreator) {

        int counter = 0;

        //Best of Three here
        while (counter < 3) {

            //single game inside
//            boolean gameResult = false;
//            Integer inLineToWin = gameRules.inLineToWinCondition;
//            Board board = new Board(boardCreator.createBoard());
////            BoardPrinter boardPrinter = new BoardPrinter(board);
////            boardPrinter.printBoard();

//            while (!gameResult) {
//
//                Move move;
//                System.out.println(currentPlayer.name + " " + language.getString("move"));
//
//                //Checking if move coordinates are valid
//                move = moveCreation(inputProvider,currentPlayer);
//
//                //Checking if move is valid
//                moveValidation(move,board);
//
//                //Printing Board after correct move
//                boardPrinter.printBoard();
//
//                //Checking tie situation
//
//
////                if (tieChecker.check(board.playingBoard)) {
////                    System.out.println(language.getString("tie"));
////                    for (Player player : listOfPlayers) {
////                        player.score = player.score + 1;
////                    }
////                    counter++;
////                    break;
////                }
//
//
///*
////                winResult = winningChecker.check(board, move, inLineToWin);
////                if (winResult) {
////                    System.out.println(currentPlayer + " " + language.getString("wonARound"));
////                    currentPlayer.score = currentPlayer.score + 3;
////                    counter++;
////                }
//*/
//
//                //Checking game result
//                gameResult = resultChecker(listOfPlayers,inLineToWin,board,move,currentPlayer);
//
//                if(gameResult){
//                    counter++;
//                }
//
//                currentPlayer = changePlayer(listOfPlayers, currentPlayer);
//            }
            if(singleGame(listOfPlayers,currentPlayer,boardCreator)){
                counter++;
            }
            currentPlayer = changePlayer(listOfPlayers,currentPlayer);
        }
    }

    private boolean singleGame(List<Player> listOfPlayers,Player currentPlayer, BoardCreator boardCreator){

        boolean gameResult = false;
        Board board = new Board(boardCreator.createBoard());
        Integer inLineToWin = gameRules.inLineToWinCondition;
        BoardPrinter boardPrinter = new BoardPrinter(board);
        boardPrinter.printBoard();

        while (!gameResult) {

            System.out.println(currentPlayer.name + " " + language.getString("move"));

            //Checking if move coordinates are valid
            Move move = moveCreation(inputProvider,currentPlayer);

            //Checking if move is valid
            moveValidation(move,board);

            //Printing Board after correct move
            boardPrinter.printBoard();

            //Checking tie situation


//                if (tieChecker.check(board.playingBoard)) {
//                    System.out.println(language.getString("tie"));
//                    for (Player player : listOfPlayers) {
//                        player.score = player.score + 1;
//                    }
//                    counter++;
//                    break;
//                }



//                winResult = winningChecker.check(board, move, inLineToWin);
//                if (winResult) {
//                    System.out.println(currentPlayer + " " + language.getString("wonARound"));
//                    currentPlayer.score = currentPlayer.score + 3;
//                    counter++;
//                }


            //Checking game result
            gameResult = resultChecker(listOfPlayers,inLineToWin,board,move,currentPlayer);

            currentPlayer = changePlayer(listOfPlayers, currentPlayer);

        }

        return true;
    }

    private void gameResult(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer.score > secondPlayer.score) {
            System.out.println(language.getString("won") + firstPlayer);
        } else if (firstPlayer.score < secondPlayer.score) {
            System.out.println(language.getString("won") + secondPlayer);
        } else {
            System.out.println(language.getString("tie"));
        }
    }

    private Player changePlayer(List<Player> list, Player player) {
        if (player == list.get(0)) {
            return list.get(1);
        }
        return list.get(0);
    }

    private Move moveCreation(InputProvider inputProvider, Player currentPlayer){

        Coordinates moveCoordinates;
        Move move;
        Language language = Language.getInstance();

        while(true){
            try {
                moveCoordinates = new Coordinates(inputProvider.nextInt(), inputProvider.nextInt());
                move = new Move(moveCoordinates, currentPlayer);
                break;
            } catch (InputMismatchException e) {
                System.out.println(language.getString("shouldBeNumeric"));
                inputProvider.nextLine();
            }
        }
        return move;
    }

    private void moveValidation(Move move, Board board){

        while (true){
            try {
                move.makeAMove(board);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(language.getString("outOfBounds"));
            } catch (FieldAlreadyTakenException e) {
                System.out.println(language.getString("alreadyTaken"));
            }
        }
    }

    private boolean resultChecker(List<Player> listOfPlayers , Integer inLineToWin, Board board, Move move, Player currentPlayer){

        WinningChecker winningChecker = new WinningChecker();
        TieChecker tieChecker = new TieChecker();

        //Checking tie situation
        if(tieChecker.check(board.playingBoard)){
            System.out.println(language.getString("tie"));
            for (Player player : listOfPlayers) {
                player.score = player.score + 1;
            }
           return true;
        }

        //Checking Win situation
        if (winningChecker.check(board, move, inLineToWin)){
            System.out.println(currentPlayer + " " + language.getString("wonARound"));
            currentPlayer.score = currentPlayer.score + 3;
            return true;
        }

        return false;
    }

}
