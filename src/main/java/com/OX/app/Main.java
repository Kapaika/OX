package com.OX.app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Bartosz Kupajski
 */
public class Main {

    public static void main(String[] args) {

        GameCompetitors gameCompetitors = new GameCompetitors();
        GameRules gameRules = new GameRules();
        int gameStarterRequirements=0;


        ResourceBundle resourceBundle = ResourceBundle.getBundle("OX",new Locale("pl","PL"));

        while(gameStarterRequirements<4){

            if(gameCompetitors.listOfPlayers.size()<2){
                System.out.println(resourceBundle.getString("who'splaying"));
                gameCompetitors.addingPlayersWithNameAndSign(InputProvider.nextLine());
                gameCompetitors.addingPlayersWithNameAndSign(InputProvider.nextLine());
                gameStarterRequirements++;
            }
            if(gameRules.sizeOfABoard == null){
                System.out.println(resourceBundle.getString("size"));
                try{
                    gameRules.sizeOfABoard(InputProvider.nextInt(),InputProvider.nextInt());
                }catch(InputMismatchException e){
                    System.out.println(resourceBundle.getString("shouldBeNumeric"));
                    InputProvider.nextLine();
                    continue;
                } catch (toSmallBoardException e) {
                    System.out.println(resourceBundle.getString("smallBoard"));
                    InputProvider.nextLine();
                    continue;
                }
                gameStarterRequirements++;
            }
            if(gameRules.inLineToWinCondition==null){
                System.out.println(resourceBundle.getString("winningCondition"));
                try {
                    gameRules.setInLineToWinCondition(InputProvider.nextInt());
                }catch(toSmallWinningConditionExceptionException e){
                    System.out.println(resourceBundle.getString("smallCondition"));
                    continue;
                }catch(winningConditionMoreThanASizeOfBoardExcetpion e){
                    System.out.println(resourceBundle.getString("equalToBoard"));
                    continue;
                }catch (InputMismatchException e){
                    System.out.println(resourceBundle.getString("shouldBeNumeric"));
                    InputProvider.nextLine();
                    continue;
                }
                gameStarterRequirements++;
            }
            if(gameCompetitors.startingPlayer==null){
                System.out.println(resourceBundle.getString("startingQ"));
                try {
                    gameCompetitors.chooseStartingPlayer(InputProvider.nextLine());
                } catch (NoSuchPlayerException e){
                    System.out.println(resourceBundle.getString("noPlayer"));
                    continue;
                }
                gameStarterRequirements++;
            }
        }

        Game game = new Game(gameCompetitors,gameRules);
        game.init();
    }

//    }
}
