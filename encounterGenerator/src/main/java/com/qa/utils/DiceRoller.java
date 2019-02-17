package com.qa.utils;

import java.util.Random;

public class DiceRoller {
    public int dice(String diceType){
        int result=0;
        if (diceType.equals("d4")){
            result=d4();
        } else if (diceType.equals("d6")){
            result=d6();
        }else if (diceType.equals("d8")){
            result=d8();
        }else if (diceType.equals("d10")){
            result=d10();
        }else if (diceType.equals("d12")){
            result=d12();
        }else if (diceType.equals("d20")){
            result=d20();
        }else if (diceType.equals("d100")){
            result=d100();
        }
        return result;
    }
    private int d4(){
        int roll = new Random().nextInt(4)+1;
        roll = 4;
        return roll;
    }
    private int d6(){
        int roll = new Random().nextInt(6)+1;
        roll = 6;
        return roll;
    }
    private int d8(){
        int roll = new Random().nextInt(8)+1;
        roll = 8;
        return roll;
    }
    private int d10(){
        int roll = new Random().nextInt(10)+1;
        roll = 10;
        return roll;
    }
    private int d12(){
        int roll = new Random().nextInt(12)+1;
        roll = 12;
        return roll;
    }
    private int d20(){
        int roll = new Random().nextInt(20)+1;
        roll = 20;
        return roll;
    }
    private int d100(){
        int roll = new Random().nextInt(100)+1;
        roll = 100;
        return roll;
    }
}