package gamegrub.data.menu;

import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
import gamegrub.data.combo.ComboBuilder;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class for listing Menu.
 */
public final class Menu implements Iterable<Item> {

    public LinkedList<Item> entrees;
    public LinkedList<Item> sides;
    public LinkedList<Item> drinks;
    public LinkedList<Item> combos;
    public LinkedList<Item> fullmenu;

    /**
     * Contructor for Menu.
     */
    public Menu() {
        this.entrees = this.getEntrees();
        this.drinks = this.getDrinks();
        this.sides = this.getSides();
        this.combos = this.getCombos();
        this.fullmenu = this.getFullMenu();
    }

    /**
     * Method to put all Entress in List.
     *
     * @return LinkedList containing all entrees
     */
    public static LinkedList<Item> getEntrees() {
        LinkedList<Item> entreeList = new LinkedList<>();
        entreeList.add(new Clue());
        entreeList.add(new Chess());
        entreeList.add(new Jenga());
        entreeList.add(new Yahtzee());
        entreeList.add(new Monopoly());
        return entreeList;
    }

    /**
     * Method to put all Drinks in List.
     *
     * @return LinkedList containing all drinks and sizes
     */
    public static LinkedList<Item> getDrinks() {
        LinkedList<Item> drinkList = new LinkedList<>();
        Cranium juniorCoffee = new Cranium();
        drinkList.add(juniorCoffee);
        Candy juniorShake = new Candy();
        drinkList.add(juniorShake);
        Sorry juniorSoda = new Sorry();
        drinkList.add(juniorSoda);
        Cranium classicCoffee = new Cranium();
        Candy classicShake = new Candy();
        Sorry classicSoda = new Sorry();
        classicCoffee.setSize(Size.CLASSIC);
        classicShake.setSize(Size.CLASSIC);
        classicSoda.setSize(Size.CLASSIC);
        drinkList.add(classicCoffee);
        drinkList.add(classicShake);
        drinkList.add(classicSoda);
        Cranium winnerCoffee = new Cranium();
        Candy winnerShake = new Candy();
        Sorry winnerSoda = new Sorry();
        winnerCoffee.setSize(Size.WINNER);
        winnerShake.setSize(Size.WINNER);
        winnerSoda.setSize(Size.WINNER);
        drinkList.add(winnerCoffee);
        drinkList.add(winnerShake);
        drinkList.add(winnerSoda);
        // for (Size size : sizes){
        //     coffee.setSize(size);
        //     shake.setSize(size);
        //     soda.setSize(size);
        //     drinkList.add(coffee);
        //     drinkList.add(shake);
        //     drinkList.add(soda);
        // }
        return drinkList;
    }

    /**
     * Method to put all Sides in List.
     *
     * @return LinkedList containing all sides and sizes
     */
    public static LinkedList<Item> getSides() {
        LinkedList<Item> sidesList = new LinkedList<>();
        Risk juniorBites = new Risk();
        sidesList.add(juniorBites);
        Dice juniorPotatos = new Dice();
        sidesList.add(juniorPotatos);
        Catan juniorSkewers = new Catan();
        sidesList.add(juniorSkewers);
        Risk classicBites = new Risk();
        Dice classicPotatos = new Dice();
        Catan classicSkewers = new Catan();
        classicBites.setSize(Size.CLASSIC);
        classicPotatos.setSize(Size.CLASSIC);
        classicSkewers.setSize(Size.CLASSIC);
        sidesList.add(classicBites);
        sidesList.add(classicPotatos);
        sidesList.add(classicSkewers);
        Risk winnerBites = new Risk();
        Dice winnerPotatos = new Dice();
        Catan winnerSkewers = new Catan();
        winnerBites.setSize(Size.WINNER);
        winnerPotatos.setSize(Size.WINNER);
        winnerSkewers.setSize(Size.WINNER);
        sidesList.add(winnerBites);
        sidesList.add(winnerPotatos);
        sidesList.add(winnerSkewers);
        // for (Size size : sizes){
        //     bites.setSize(size);
        //     potatos.setSize(size);
        //     skewers.setSize(size);
        //     sidesList.add(bites);
        //     sidesList.add(potatos);
        //     sidesList.add(skewers);
        // }
        return sidesList;
    }

    /**
     * Getter for list of combos.
     *
     * @return Returns a linked list of combos available
     */
    public static LinkedList<Item> getCombos() {
        LinkedList<Item> comboItems = new LinkedList<>();
        ComboBuilder builder = new ComboBuilder();
        Combo gameNight = builder.comboBuilder("Game Night");
        comboItems.add(gameNight);
        Combo rollTheDice = builder.comboBuilder("Roll the Dice");
        comboItems.add(rollTheDice);
        Combo bigAppetite = builder.comboBuilder("Big Appetite");
        comboItems.add(bigAppetite);
        Combo theWinner = builder.comboBuilder("The Winner");
        comboItems.add(theWinner);
        return comboItems;
    }

    /**
     * Method to put all Menu Items in List.
     *
     * @return LinkedList containing all menu items
     */
    public static LinkedList<Item> getFullMenu() {
        LinkedList<Item> fullMenu = new LinkedList<>();
        LinkedList<Item> entrees = getEntrees();
        for (Item item : entrees) {
            fullMenu.add(item);
        }
        LinkedList<Item> drinks = getDrinks();
        for (Item item : drinks) {
            fullMenu.add(item);
        }
        LinkedList<Item> sides = getSides();
        for (Item item : sides) {
            fullMenu.add(item);
        }
        LinkedList<Item> combos = getCombos();
        for (Item item : combos) {
            fullMenu.add(item);
        }
        return fullMenu;
    }

    /**
     * Method to iterate over entrees.
     *
     * @return an iterator for entrees
     */
    @Override
    public Iterator<Item> iterator() {
        return entrees.iterator();
    }

    /**
     * The number of Entress.
     *
     * @return the number of entrees
     */
    public int size() {
        return entrees.size();
    }
}