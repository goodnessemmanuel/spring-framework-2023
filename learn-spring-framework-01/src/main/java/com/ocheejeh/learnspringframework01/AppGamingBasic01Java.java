package com.ocheejeh.learnspringframework01;


import com.ocheejeh.learnspringframework01.game.GameRunner;
import com.ocheejeh.learnspringframework01.game.PacManGame;

/**
 * observe that this system is tightly coupled.
 * when you want to run any of the game type,
 * you need to enter the game runner class and
 * manually change the constructor to match your
 * target game
 */
public class AppGamingBasic01Java {

    public static void main(String[] args) {
        //var game = new MarioGame();
        //var game = new SuperContraGame();
        //two things we are doing manually here
        var game = new PacManGame(); //1. Object creation
        GameRunner gameRunner = new GameRunner(game); //2. Manual dependency injection
        gameRunner.run();

    }

}