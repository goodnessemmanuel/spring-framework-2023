package com.ocheejeh.learnspringframework02;

import com.ocheejeh.learnspringframework02.game.GameRunner;
import com.ocheejeh.learnspringframework02.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * basic java gaming using
 * spring context.
 * autowiring, bean,
 * config file, etc
 */
@Configuration
/**
 * errors like this: No qualifying bean of type 'com.ocheejeh.learnspringframework02.game.GameRunner' available
 * occur because spring could not find the target component. using componentscan and specifying the directory
 * to look into during scanning solves such problem
 */
@ComponentScan("com.ocheejeh.learnspringframework02.game")
public class AppGameLauncher {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppGameLauncher.class)){
            //call gaming console bean
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }
    }

}