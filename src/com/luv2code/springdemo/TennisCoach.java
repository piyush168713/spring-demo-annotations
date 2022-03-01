package com.luv2code.springdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @Component("thatSillyCoach")       // here bean id = "thatSillyCoach"

@Component     // It use default bean id i.e. "tennisCoach"
// @Scope("prototype")                 // uses MyCustomBeanProcessor.java class & BeanProcessorDemoApp.java
//public class TennisCoach implements Coach, DisposableBean {    // used for prototype scope
    public class TennisCoach implements Coach {


    @Autowired                                // Field Injection
    @Qualifier("randomFortuneService")                   // @Qualifier annotation is used to implement 1 class at a time.
    private FortuneService fortuneService;


    // define a default constructor (no-arg constructor)
    public TennisCoach(){

        System.out.println(">> TennisCoach: inside default constructor");
    }


    // define my init mwthod
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside my doMyCleanupStuff()");
    }


    // Constructor defined for injections with @Autowired annotation
    // autowired checks if any class that implements FortuneService interface then inject that. i.e. HappyFortuneService
//    @Autowired                                                 // Constructor Injection
//    public TennisCoach(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }



//    Using Qualifier with Construction injection

//    @Autowired
//    public TennisCoach(@Qualifier("randomFortuneService")            // Qualifier annotation
//            FortuneService theFortuneService) {
//        System.out.println(">>TenisCoach: inside constructor using @autowired and @qualifier");
//        fortuneService = theFortuneService;
//    }



    /*
    // create/define any method for FortuneService instead of creating setter mtd. (Method Injection)
    // autowired checks if any class that implements FortuneService interface then inject that. i.e. HappyFortuneService
    @Autowired                     // configure the dependency injection
    public void doSomeCrazyStuff(FortuneService theFortuneService) {

        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
        fortuneService = theFortuneService;
    }
    */


//  Using Qualifier with Method Injection

    /*@Autowired
    //@Qualifier("randomFortuneService")
    public void doSomeCrazyStuff( @Qualifier("randomFortuneService")
            FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }*/





    @Override
    public String getDailyWorkout(){

        return "Practice 1 hr tennis daily";
    }

    // declared a method in this class
    @Override
    public String getDailyFortune() {

        return fortuneService.getFortune();
    }



//    @Override                                        // defines for prototype scope
//    public void destroy() throws Exception {
//        System.out.println(">> TennisCoach: inside destroy()");
//
//    }
}
