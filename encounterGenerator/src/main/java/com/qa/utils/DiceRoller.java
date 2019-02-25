package com.qa.utils;

import java.util.Random;

public class DiceRoller {
    public int dice(int dice){
    	if (dice==4||dice==6||dice==8||dice==10||dice==12||dice==20||dice==100) {
        	return new Random().nextInt(dice)+1;
    	}
		return 0;
    }
}