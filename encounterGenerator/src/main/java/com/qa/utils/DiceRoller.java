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
    	return new Random().nextInt(4)+1;
    }
    private int d6(){
		return new Random().nextInt(6)+1;
    }
    private int d8(){
		return  new Random().nextInt(8)+1;
    }
    private int d10(){
		return  new Random().nextInt(10)+1;
    }
    private int d12(){
		return  new Random().nextInt(12)+1;
    }
    private int d20(){
		return  new Random().nextInt(20)+1;
    }
    private int d100(){
		return  new Random().nextInt(100)+1;
    }
}