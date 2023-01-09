package com.ocheejeh.learnspringframework01.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 *  App creates a spring application context
 *  and use a config file to run to start the
 *  app thus imitating spring behaviour
 */
public class AppGamingBasic02Java {

    public static void main(String[] args) {
        // 1. launch spring application context
        // 2. configure what we want spring to manage
        // using the provided configuration file class
        // see demo
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
       try( var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class))
       {
           //getting a beans already configured via @Configuration annotation from the spring application context
           System.out.println("target bean name => " + context.getBean("name"));
           System.out.println("target bean age => " + context.getBean("age"));
           System.out.println("target bean person => " + context.getBean("person"));
           System.out.println("target bean person address => " + context.getBean("address"));
           System.out.println("target bean person address2 => " + context.getBean("address2"));
           System.out.println("bean via method => " + context.getBean("person2MethodCall"));
           System.out.println("bean via parameter injection => " + context.getBean("personParametersCall"));
           //you must prioritize by using @qualifier or @Primary on the target bean when there is more than bean pointing to the same class/record
           // before the below line will work without error
           System.out.println(context.getBean(Address.class));
           System.out.println("******* Beans currently managed by spring IOC");
           //this will print the name of all the beans present in the context
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
       }
    }

}
