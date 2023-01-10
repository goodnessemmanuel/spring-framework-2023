package com.ocheejeh.learnspringframework02.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //spring is able to create object for us when needed
@Primary //Give this bean preference when multiple GamingConsole objects are being considered for autowiring
public class MarioGame implements GamingConsole {

    @Override
    public void up(){
        System.out.println("Up Start");
    }

    @Override
    public void down(){
        System.out.println("Down break");
    }

    @Override
    public void left(){
        System.out.println("Left reverse");
    }

    @Override
    public void right(){
        System.out.println("Right accelerate");
    }
}