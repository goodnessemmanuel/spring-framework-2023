package com.ocheejeh.learnspringframework02.practice.example_a2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass{} //Scope is Singleton by default

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{
}

@Configuration
@ComponentScan
public class AppBeanScopeLauncher {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppLazyInitializationLauncher.class)){

            System.out.println("******** Available beans are: **********");
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println("***Initialization of spring context completed***");

            //since normal class bean scope is singleton by default, same instance will be printed for all three
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            //since prototype class bean scope is singleton, different instance will be printed for all three
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));


        }
    }

}