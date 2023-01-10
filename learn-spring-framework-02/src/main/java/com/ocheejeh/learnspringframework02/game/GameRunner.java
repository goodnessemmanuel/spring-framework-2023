package com.ocheejeh.learnspringframework02.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsole game;
    // Qualifier is used where you want a specific implementation irrespective
    // of preference. GamingConsole for instance has MarioGame as preference
    // but with the SuperContraGameQualifier, the super contra game will be used
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
