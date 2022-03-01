package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class annotationBeanScopeDemoApp {
    public static void main(String[] args) {

        // load spring config files
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve beans from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // Check if they are same
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println("Pointing to the same object: " + result);
        System.out.println("\nMemory location: " + theCoach);
        System.out.println("\nMemory loaction: " + alphaCoach);

        // close the context
        context.close();
    }
}
