//package com.luv2code.springdemo;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FileFortuneService implements FortuneService{
//
//    @Value("${FileFortuneService.fortune}")
//    private String[] fortune;
//
//    @Override
//    public String getFortune() {
//        int elementNo = (int) (Math.random() * 10);
//        if (elementNo <= 2) {
//            return fortune[elementNo];
//        } else {
//            return getFortune();
//        }
//    }
//}
