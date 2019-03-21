package com.OX.app;

import java.util.InputMismatchException;

/**
 * @author Bartosz Kupajski
 */
public class Main {

    public static void main(String[] args){

        GameCompetitors gameCompetitors = new GameCompetitors();
        GameRules gameRules = new GameRules();
        int gameStarterRequirements=0;

        while(gameStarterRequirements<4){

            if(gameCompetitors.listOfPlayers.size()<2){
                System.out.println("Who's playing?");
                gameCompetitors.addingPlayersWithNameAndSign(InputProvider.nextLine());
                gameCompetitors.addingPlayersWithNameAndSign(InputProvider.nextLine());
                gameStarterRequirements++;
            }
            if(gameRules.sizeOfABoard == null){
                System.out.println("Size of a board?");
                try{
                    gameRules.setSizeOfABoard(InputProvider.nextInt(),InputProvider.nextInt());
                }catch(InputMismatchException e){
                    System.out.println("I thought that it should be numeric... did U?");
                    InputProvider.nextLine();
                    continue;
                }
                gameStarterRequirements++;
            }
            if(gameRules.inLineToWinCondition==null){
                System.out.println("Winning condition?");
                try {
                    gameRules.setInLineToWinCondition(InputProvider.nextInt());
                }catch(toSmallWinningConditionExceptionException e){
                    System.out.println("I told U ... It's have to be more than 3");
                    continue;
                }catch(winningConditionMoreThanASizeOfBoard e){
                    System.out.println("Please, make it at least equal to a size of the board");
                    continue;
                }catch (InputMismatchException e){
                    System.out.println("I thought that it should be numeric... did U?");
                    InputProvider.nextLine();
                    continue;
                }
                gameStarterRequirements++;
            }
            if(gameCompetitors.startingPlayer==null){
                System.out.println("Who's starting?");
                try {
                    gameCompetitors.chooseStartingPlayer(InputProvider.nextLine());
                } catch (NoSuchPlayerException e){
                    System.out.println("Dude... are You blind? - There is no such a player here");
                    continue;
                }
                gameStarterRequirements++;
            }
        }

        Game game = new Game(gameCompetitors,gameRules);
        game.init();
    }
}
