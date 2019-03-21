package com.OX.app;

/**
 * @author Bartosz Kupajski
 */
public class Main {

    public static void main(String[] args){

        GameCompetitors gameCompetitors = new GameCompetitors();
        GameRules gameRules = new GameRules();
        int gameStarter=0;

        while(gameStarter<4){

            if(gameCompetitors.listOfPlayers.size()<2){
                System.out.println("Who's playing?");
                gameCompetitors.addingPlayersWithNameAndSign(InputProvider.nextLine());
                gameCompetitors.addingPlayersWithNameAndSign(InputProvider.nextLine());
                gameStarter++;
            }

            if(gameRules.sizeOfABoard == null){
                System.out.println("Size of a board?");
                gameRules.setSizeOfABoard(InputProvider.nextInt(),InputProvider.nextInt());
                gameStarter++;
            }

            if(gameRules.inLineToWinCondition==null){
                System.out.println("Winning condition?");
                try {
                    gameRules.setInLineToWinCondition(InputProvider.nextInt());
                } catch (toSmallWinningConditionExceptionException e){
                    System.out.println("It's have to be more than 3");
                    continue;
                }
                gameStarter++;
            }

            if(gameCompetitors.startingPlayer==null){
                System.out.println("Who's starting?");
                try {
                    gameCompetitors.chooseStartingPlayer(InputProvider.nextLine());
                } catch (NoSuchPlayerException e){
                    System.out.println("There is no such a player here");
                    continue;
                }
                gameStarter++;
            }

        }



        Game game = new Game(gameCompetitors,gameRules);
        game.init();
    }
}
