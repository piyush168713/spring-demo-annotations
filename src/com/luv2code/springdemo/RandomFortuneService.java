package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    // Create an array of Strings
    private String[] data={
            "You will enjoy in the mountains",
            "You will have a tough time",
            "You will meet a special person today"
    };

    // Create a Random number generator
    private Random myRandom = new Random();


    @Override
    public String getFortune(){

        // Pick a random string from the array
        int Index = myRandom.nextInt(data.length);

        String theFortune = data[Index];
        return theFortune;
    }
}
