package gamegrub.data.combo;

import gamegrub.data.Item;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Entree;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import java.lang.IllegalArgumentException;

/**
 * Builder pattern for combos.
 */
public class ComboBuilder {
    
    /**
     * Combo builder for combos.
     *
     * @param name Name of combo
     */
    public static Combo comboBuilder(String name) {
        Combo combo = new Combo();
        if ("Game Night".equals(name)) {
            combo.setName("Game Night");
            combo.setEntreeInstance(new Jenga());
            combo.setSideInstance(new Catan());
            combo.setDrinkInstance(new Sorry());
        } else if ("Roll the Dice".equals(name)) {
            combo.setName("Roll the Dice");
            combo.setEntreeInstance(new Yahtzee());
            combo.setSideInstance(new Dice());
            combo.setDrinkInstance(new Candy());
        } else if ("Big Appetite".equals(name)) {
            combo.setName("Big Appetite");
            combo.setEntreeInstance(new Chess());
            combo.setSideInstance(new Risk());
            combo.setDrinkInstance(new Cranium());
        } else if ("The Winner".equals(name)) {
            combo.setName("The Winner");
            combo.setEntreeInstance(new Monopoly());
            combo.setSideInstance(new Dice());
            combo.setDrinkInstance(new Sorry());
        } else {
            throw new IllegalArgumentException();
        }
        return combo;
    }
}