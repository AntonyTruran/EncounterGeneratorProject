package com.qa.buisness;

import java.util.ArrayList;
import java.util.List;

public class EncounterChoice {
    public List<Object> table = new ArrayList();

    public String userInput(DiceRoller roll){
        //scanner for now then send to from table method
        String creature="unknown";
        int creatureChance = chance(roll);
        for (Object monster : table){
//        	find a way to draw the chance range out to be split or substring
//        	could use range array and split before using parse int
//        	int min = monster.getChanceRange.substring(" ");
//        	int max = monster.getChanceRange.substring(" ");
//        	parse int
            if (creatureChance  > min() && creatureChance< max()) {
            	
            }
        }
        return creature;
    }

    private boolean toArray(Creature creature){
        return table.add(creature);
    }

    private int chance(DiceRoller roll){
        int creatureChance = roll.dice("d100");
        return creatureChance;
    }
}
