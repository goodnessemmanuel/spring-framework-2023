package com.ocheejeh.learnspringframework01.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GameConfig {

    @Bean
    public GamingConsole game(){
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(){
        return new GameRunner(game());
    }
}
