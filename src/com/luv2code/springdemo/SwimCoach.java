package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${foo.email}")
    public String email;

    @Value("${foo.team}")
    public String team;

    public SwimCoach(FortuneService fortuneService){         // constructor injection
        this.fortuneService= fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Swim 1000 meters daily";
    }

    public String getDailyFortune(){
        return fortuneService.getFortune();
    }

    // getter and setter mwthods for email and team
    public String getEmail(){
        return email;
    }

    public String getTeam(){
        return team;
    }

}
