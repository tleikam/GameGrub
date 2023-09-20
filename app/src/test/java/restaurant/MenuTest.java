package restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.data.menu.Menu;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class for running tests on Menu Class.
 *
 *<p>This class is full of tests to ensure
 menu works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */

public class MenuTest {

    @Test
    public void testMenuHasCorrectNumberOfEntrees() {
        Menu menu = new Menu();
        LinkedList<Item> entrees = menu.getEntrees();
        assertTrue(entrees.size() == 5);
    }

    @Test
    public void testMenuHasClueInEntrees() {
        Menu menu = new Menu();
        LinkedList<Item> entrees = menu.getEntrees();
        boolean contains = false;
        for (Item entree : entrees) {
            if (entree instanceof Clue) {
                contains = true;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void testMenuHasChessInEntrees() {
        Menu menu = new Menu();
        LinkedList<Item> entrees = menu.getEntrees();
        boolean contains = false;
        for (Item entree : entrees) {
            if (entree instanceof Chess) {
                contains = true;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void testMenuHasYahtzeeInEntrees() {
        Menu menu = new Menu();
        LinkedList<Item> entrees = menu.getEntrees();
        boolean contains = false;
        for (Item entree : entrees) {
            if (entree instanceof Yahtzee) {
                contains = true;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void testMenuHasMonopolyInEntrees() {
        Menu menu = new Menu();
        LinkedList<Item> entrees = menu.getEntrees();
        boolean contains = false;
        for (Item entree : entrees) {
            if (entree instanceof Monopoly) {
                contains = true;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void testMenuHasJengaInEntrees() {
        Menu menu = new Menu();
        LinkedList<Item> entrees = menu.getEntrees();
        boolean contains = false;
        for (Item entree : entrees) {
            if (entree instanceof Jenga) {
                contains = true;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void testMenuHasCorrectNumberOfDrinks() {
        Menu menu = new Menu();
        LinkedList<Item> drinks = menu.getDrinks();
        assertTrue(drinks.size() == 9);
    }

    @Test
    public void testMenuHasAllSizesOfCandyShake() {
        Menu menu = new Menu();
        LinkedList<Item> drinks = menu.getDrinks();
        boolean juniorCandy = false;
        boolean classicCandy = false;
        boolean winnerCandy = false;
        for (Item drink : drinks) {
            Drink d = (Drink) drink;
            if (d instanceof Candy) {
                if (d.getSize() == Size.JUNIOR) {
                    juniorCandy = true;
                }
                if (d.getSize() == Size.CLASSIC) {
                    classicCandy = true;
                }
                if (d.getSize() == Size.WINNER) {
                    winnerCandy = true;
                }
            }
        }
        assertTrue(juniorCandy && classicCandy && winnerCandy);
    }

    @Test
    public void testMenuHasAllSizesOfCraniumCoffee() {
        Menu menu = new Menu();
        LinkedList<Item> drinks = menu.getDrinks();
        boolean juniorCranium = false;
        boolean classicCranium = false;
        boolean winnerCranium = false;
        for (Item drink : drinks) {
            Drink d = (Drink) drink;
            if (d instanceof Cranium) {
                if (d.getSize() == Size.JUNIOR) {
                    juniorCranium = true;
                }
                if (d.getSize() == Size.CLASSIC) {
                    classicCranium = true;
                }
                if (d.getSize() == Size.WINNER) {
                    winnerCranium = true;
                }
            }
        }
        assertTrue(juniorCranium && classicCranium && winnerCranium);
    }

    @Test
    public void testMenuHasAllSizesOfSorrySoda() {
        Menu menu = new Menu();
        LinkedList<Item> drinks = menu.getDrinks();
        boolean juniorSorry = false;
        boolean classicSorry = false;
        boolean winnerSorry = false;
        for (Item drink : drinks) {
            Drink d = (Drink) drink;
            if (d instanceof Sorry) {
                if (d.getSize() == Size.JUNIOR) {
                    juniorSorry = true;
                }
                if (d.getSize() == Size.CLASSIC) {
                    classicSorry = true;
                }
                if (d.getSize() == Size.WINNER) {
                    winnerSorry = true;
                }
            }
        }
        assertTrue(juniorSorry && classicSorry && winnerSorry);
    }

    @Test
    public void testMenuHasCorrectNumberOfSides() {
        Menu menu = new Menu();
        LinkedList<Item> sides = menu.getSides();
        assertTrue(sides.size() == 9);
    }

    @Test
    public void testMenuHasAllSizesOfRiskBites() {
        Menu menu = new Menu();
        LinkedList<Item> sides = menu.getSides();
        boolean juniorRisk = false;
        boolean classicRisk = false;
        boolean winnerRisk = false;
        for (Item side : sides) {
            Side s = (Side) side;
            if (s instanceof Risk) {
                if (s.getSize() == Size.JUNIOR) {
                    juniorRisk = true;
                }
                if (s.getSize() == Size.CLASSIC) {
                    classicRisk = true;
                }
                if (s.getSize() == Size.WINNER) {
                    winnerRisk = true;
                }
            }
        }
        assertTrue(juniorRisk && classicRisk && winnerRisk);
    }

    @Test
    public void testMenuHasAllSizesOfDicePotatos() {
        Menu menu = new Menu();
        LinkedList<Item> sides = menu.getSides();
        boolean juniorDice = false;
        boolean classicDice = false;
        boolean winnerDice = false;
        for (Item side : sides) {
            Side s = (Side) side;
            if (s instanceof Dice) {
                if (s.getSize() == Size.JUNIOR) {
                    juniorDice = true;
                }
                if (s.getSize() == Size.CLASSIC) {
                    classicDice = true;
                }
                if (s.getSize() == Size.WINNER) {
                    winnerDice = true;
                }
            }
        }
        assertTrue(juniorDice && classicDice && winnerDice);
    }

    @Test
    public void testMenuHasAllSizesOfCatanSkewers() {
        Menu menu = new Menu();
        LinkedList<Item> sides = menu.getSides();
        boolean juniorCatan = false;
        boolean classicCatan = false;
        boolean winnerCatan = false;
        for (Item side : sides) {
            Side s = (Side) side;
            if (s instanceof Catan) {
                if (s.getSize() == Size.JUNIOR) {
                    juniorCatan = true;
                }
                if (s.getSize() == Size.CLASSIC) {
                    classicCatan = true;
                }
                if (s.getSize() == Size.WINNER) {
                    winnerCatan = true;
                }
            }
        }
        assertTrue(juniorCatan && classicCatan && winnerCatan);
    }

    @Test
    public void testMenuHasCorrectNumberOfMenuItems() {
        Menu menu = new Menu();
        LinkedList<Item> items = menu.getFullMenu();
        assertTrue(items.size() == 27);
    }

    @Test
    public void testMenuHasAllMenuItems() {
        Menu menu = new Menu();
        LinkedList<Item> items = menu.getFullMenu();
        LinkedList<Item> entrees = menu.getEntrees();
        LinkedList<Item> drinks = menu.getDrinks();
        LinkedList<Item> sides = menu.getSides();
        LinkedList<Item> all = new LinkedList<>();
        for (Item side : sides) {
            all.add(side);
        }
        for (Item drink : drinks) {
            all.add(drink);
        }
        for (Item entree : entrees) {
            all.add(entree);
        }
        boolean inThere = true;
        for (Item item : all) {
            if (!items.contains(item)) {
                inThere = false;
            }
        }
        assertTrue(inThere);
    }
}