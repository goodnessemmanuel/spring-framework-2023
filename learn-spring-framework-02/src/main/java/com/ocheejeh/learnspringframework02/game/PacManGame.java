package com.ocheejeh.learnspringframework02.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("pacman Up");
    }

    @Override
    public void down() {
        System.out.println("pacman down");
    }

    @Override
    public void left() {
        System.out.println("pacman left");
    }

    @Override
    public void right() {
        System.out.println("pacman right");
    }
}
