package com.ocheejeh.learnspringframework02.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// note: default qualifier name is snake case of intended class e.g.
// "SuperContraGame" = "superContraGame"
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{
    public void up() {
        System.out.println("Up");
    }

    public void down(){
        System.out.println("Sit down");
    }

    public void left(){
        System.out.println("Go back");
    }

    public void right(){
        System.out.println("Shoot a bullet");
    }
}
