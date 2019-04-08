package com.OX.app;

import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
class Game {


//    private GameCompetitors gameCompetitors;
//    private GameRules gameRules;
    final private Settings settings;
    final private Language language = Language.getInstance();
    final private InputProvider inputProvider;

    Game(Settings settings, InputProvider inputProvider) {
        this.settings = settings;
        this.inputProvider = inputProvider;
    }

    /**
     * Initialization of a game - contains BoardCreator which creates a playing Board based on
     * data from GameRules. Game is played here - the requirements to started it is list of Players, playingBoard
     * and Player who starts.
     * . At the end the result of game is printed.
     */
    void init(){

        GameCompetitors gameCompetitors = settings.gameCompetitors;
        GameRules gameRules = settings.gameRules;
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

            //Single game played 3 times
            if(singleGame(listOfPlayers,currentPlayer,boardCreator)){
                counter++;
            }

            //Changing player after every game
            currentPlayer = changePlayer(listOfPlayers,currentPlayer);
        }
    }

    @SuppressWarnings("SameReturnValue")
    private boolean singleGame(List<Player> listOfPlayers, Player currentPlayer, BoardCreator boardCreator){

        boolean gameResult = false;
        Board board = boardCreator.createBoard();
        Integer inLineToWin = settings.gameRules.inLineToWinCondition;
        BoardPrinter boardPrinter = new BoardPrinter(board);
        boardPrinter.printBoard();

        while (!gameResult) {

            System.out.println(currentPlayer.name + " " + language.getString("move"));

            //Checking if move is valid
            Move move = moveValidator(inputProvider,currentPlayer,board);

            //Printing Board after correct move
            boardPrinter.printBoard();
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            //Checking game result
            gameResult = resultChecker(listOfPlayers,inLineToWin,board,move,currentPlayer);

            //Changing player after every move
            currentPlayer = changePlayer(listOfPlayers, currentPlayer);

        }

        return true;
    }

    private void gameResult(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer.score > secondPlayer.score) {
            System.out.println(language.getString("wonAGame") + " " + firstPlayer);
        } else if (firstPlayer.score < secondPlayer.score) {
            System.out.println(language.getString("wonAGame") + " " + secondPlayer);
        } else {
            System.out.println(language.getString("tieAGame"));
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
                moveCoordinates = new Coordinates(inputProvider.getIntFromUser(), inputProvider.getIntFromUser());
                move = new Move(moveCoordinates, currentPlayer);
                break;
            } catch (InputMismatchException e) {
                System.out.println(language.getString("shouldBeNumeric"));
            } catch (GameInterruptedByUserException e) {
                System.out.println("Wyszedles z gry, przegrales!");
                System.exit(0);
            }
        }
        return move;
    }

    private boolean moveValidation(Move move, Board board){

            try {
                board.makeAMove(move);
                return true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(language.getString("outOfBounds"));
                return false;
            } catch (FieldAlreadyTakenException e) {
                System.out.println(language.getString("alreadyTaken"));
                return false;
            }

    }

    private Move moveValidator(InputProvider inputProvider, Player currentPlayer, Board board){

        Move move;

        do {
             move = moveCreation(inputProvider, currentPlayer);

        } while (!moveValidation(move, board));

        return move;
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

        //Checking winning situation
        if (winningChecker.check2(board, move, inLineToWin)){
            currentPlayer.score = currentPlayer.score + 3;
            System.out.println(currentPlayer + " " + language.getString("wonARound") + " points:"  + currentPlayer.score);
            return true;
        }

        return false;
    }

}
