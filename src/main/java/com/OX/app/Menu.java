package com.OX.app;

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
     * Create new Menu with InputProvider in it.
     *
     * @param inputProvider - a Scanner wrapper
     */
    Menu(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    /**
     * Creation of the game Settings; Language, Who is playing, Size of a Board and Winning Condition
     * and passing them to the game.
     */
    void start(){

        Settings settings = new Settings(inputProvider);
        settings.setSettings();

        Game game = new Game(settings,inputProvider);
        game.init();
    }
}
