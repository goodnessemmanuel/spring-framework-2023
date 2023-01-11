package com.ocheejeh.learnspringframework02.practice.example_a2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{}

@Component
@Lazy //Don't initialize this class when app starts unless it is being used
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        //logic
        System.out.println("***Some ClassB initialization logic***");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class AppLazyInitializationLauncher {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppLazyInitializationLauncher.class)){

            System.out.println("******** Available beans are: **********");
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println("***Initialization of spring context completed***");

            //when classB is called is when it will initialize
            // via its constructor due to the @Lazy annotation
            context.getBean(ClassB.class);


        }
    }

}