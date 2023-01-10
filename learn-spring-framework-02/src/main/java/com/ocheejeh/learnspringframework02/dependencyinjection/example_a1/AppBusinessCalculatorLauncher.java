package com.ocheejeh.learnspringframework02.dependencyinjection.example_a1;

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
@ComponentScan
public class AppBusinessCalculatorLauncher {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppBusinessCalculatorLauncher.class)){

            System.out.println("BusinessCalculationService find max method value is: " +context.getBean(BusinessCalculationService.class).findMax());
        }
    }

}