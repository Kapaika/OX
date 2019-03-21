package com.OX.app;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
public class Main {

    public static void main(String[] args) {

        GameCompetitors gameCompetitors = new GameCompetitors();
        GameRules gameRules = new GameRules();
        int gameStarterRequirements=0;
        InputProvider2 inputProvider2 = new InputProvider2(new Scanner(System.in));


        Language resourceBundle = Language.getInstance();
        //resourceBundle.changeLanguage();
        //ResourceBundle resourceBundle = ResourceBundle.getBundle("OX",new Locale("pl","PL"));

        while(gameStarterRequirements<4){

            if(gameCompetitors.listOfPlayers.size()<2){
                System.out.println(resourceBundle.getString("who'splaying"));
                gameCompetitors.addingPlayersWithNameAndSign(inputProvider2.nextLine());
                gameCompetitors.addingPlayersWithNameAndSign(inputProvider2.nextLine());
                gameStarterRequirements++;
            }
            if(gameRules.sizeOfABoard == null){
                System.out.println(resourceBundle.getString("size"));
                try{
                    gameRules.sizeOfABoard(inputProvider2.nextInt(),inputProvider2.nextInt());
                }catch(InputMismatchException e){
                    System.out.println(resourceBundle.getString("shouldBeNumeric"));
                    inputProvider2.nextLine();
                    continue;
                } catch (toSmallBoardException e) {
                    System.out.println(resourceBundle.getString("smallBoard"));
                    inputProvider2.nextLine();
                    continue;
                }
                gameStarterRequirements++;
            }
            if(gameRules.inLineToWinCondition==null){
                System.out.println(resourceBundle.getString("winningCondition"));
                try {
                    gameRules.setInLineToWinCondition(inputProvider2.nextInt());
                }catch(toSmallWinningConditionExceptionException e){
                    System.out.println(resourceBundle.getString("smallCondition"));
                    continue;
                }catch(winningConditionMoreThanASizeOfBoardExcetpion e){
                    System.out.println(resourceBundle.getString("equalToBoard"));
                    continue;
                }catch (InputMismatchException e){
                    System.out.println(resourceBundle.getString("shouldBeNumeric"));
                    inputProvider2.nextLine();
                    continue;
                }
                inputProvider2.nextLine();
                gameStarterRequirements++;
            }
            if(gameCompetitors.startingPlayer==null){
                System.out.println(resourceBundle.getString("startingQ"));
                try {
                    gameCompetitors.chooseStartingPlayer(inputProvider2.nextLine());
                } catch (NoSuchPlayerException e){
                    System.out.println(resourceBundle.getString("noPlayer"));
                    continue;
                }
                gameStarterRequirements++;
            }
        }

        Game game = new Game(gameCompetitors,gameRules,inputProvider2);
        game.init();
    }

//    }
}
