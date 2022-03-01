package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:mylogger.properties")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public MyLoggerConfig1 myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                         @Value("${printed.logger.level}") String printedLoggerLevel) {

        MyLoggerConfig1 myLoggerConfig = new MyLoggerConfig1(rootLoggerLevel, printedLoggerLevel);

        return myLoggerConfig;
    }

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        // return new SwimCoach(sadFortuneService());
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
        return mySwimCoach;

    }
}