package com.ocheejeh.learnspringframework01.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * A record is a new feature introduced in JDK 16
 * With record, you don't toString, getters, setters e.t.c
 */
record Person(String name, int age, Address address){}
record Address(String firstLine, String city){}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Oche";
    }

    @Bean
    public Integer age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("James", 18, new Address("block 1", "Las vegas"));
    }

    @Bean(name = "address")
    @Primary //this ensures the 'address' bean takes priority when reference to Address.class record is made
    public Address address(){
        return new Address("Sherlock Homes", "Los Angeles");
    }

    @Bean(name = "address2")
    public Address anotherAddress(){
        return new Address("Primate Homes", "London");
    }

    @Bean
    @Qualifier("qualifierAddress")
    public Address address3(){
        return new Address("Pink valley", "Washington DC");
    }

    /**
     * method 1, passing bean as
     * parameter to another bean
     * calling
     * @return
     */
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), anotherAddress());
    }

    /**
     * method 2, bean call
     * spring will auto add this parameters
     * when creating this bean with parameter
     * names corresponding to any bean in spring
     * context with the same name
     * @param name
     * @param age
     * @param address3
     * @return
     */
    @Bean
    public Person personParametersCall(String name, int age, @Qualifier("qualifierAddress") Address address3){ //spring auto-wires the required parameters
        return new Person(name, age, address3);
    }
}

