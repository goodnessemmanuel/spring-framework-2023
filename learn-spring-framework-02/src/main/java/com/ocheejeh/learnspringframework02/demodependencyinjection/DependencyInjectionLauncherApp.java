package com.ocheejeh.learnspringframework02.demodependencyinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}


@Component
class MyBusinessClass {

    /**
     * demo field injection
     *
     * @Autowired
     * private Dependency1 dependency1;
     *
     * @Autowired
     * private Dependency2 dependency2;
     *
     */


    private Dependency1 dependency1;
    private Dependency2 dependency2;

    /**
     * demo constructor injection.
     * autowire is not mondatory here
     */
    public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection - MyBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    /**
     * demo setter injection
     *  @Autowired
     *  public void setDependency1(Dependency1 dependency1) {
     *      System.out.println("Setter Injection setDependency1");
     *      this.dependency1 = dependency1;
     *  }
     *
     *  @Autowired
     *  public void setDependency2(Dependency2 dependency2) {
     *      System.out.println("Setter Injection setDependency2");
     *      this.dependency2 = dependency2;
     *  }
     *
     */


    @Override
    public String toString() {
        return "InjectDependency{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}

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
@ComponentScan //automatically scans current package and its child directory/ies
// or @ComponentScan("com.ocheejeh.learnspringframework02.demodependencyinjection")
public class DependencyInjectionLauncherApp {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApp.class)){

            System.out.println(context.getBean(MyBusinessClass.class));
        }
    }

}
