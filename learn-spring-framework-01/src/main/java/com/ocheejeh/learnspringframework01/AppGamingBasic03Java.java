package com.ocheejeh.learnspringframework01;


import com.ocheejeh.learnspringframework01.game.GameConfig;
import com.ocheejeh.learnspringframework01.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * basic java gaming using
 * spring context.
 * autowiring, bean,
 * config file, etc
 */
public class AppGamingBasic03Java {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GameConfig.class)){
            //call gaming console bean
            //context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }
    }

}