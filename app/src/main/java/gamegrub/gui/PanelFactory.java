package gamegrub.gui;

import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
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
import gamegrub.data.enums.Size;
import gamegrub.data.menu.Menu;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import gamegrub.gui.MenuPanel;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.CandyPanel;
import gamegrub.gui.drinks.CraniumPanel;
import gamegrub.gui.drinks.DrinksPanel;
import gamegrub.gui.drinks.SorryPanel;
import gamegrub.gui.entrees.ChessPanel;
import gamegrub.gui.entrees.CluePanel;
import gamegrub.gui.entrees.EntreePanel;
import gamegrub.gui.entrees.JengaPanel;
import gamegrub.gui.entrees.MonopolyPanel;
import gamegrub.gui.entrees.YahtzeePanel;
import gamegrub.gui.sides.SidePanel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * PanelFactory class.
 *
 *<p>This is a factory for all panels to use to remove
 repeated code and load correct panels to correct places.
 *
 * @author Travis Leikam
 * @version v0.7
 */
public class PanelFactory {

    /**
     * getPanel method with name.
     *
     *<p>This panel uses a string provided by an action ActionListener
     to load the correct panel.
     *
     * @param name String provided by ActionListener
     * @param parent the parent window to the class
     *
     */
    public static JPanel getPanel(String name, ParentPanel parent) {
        if ("Chess Chicken Parmesan".equals(name)) {
            return new ChessPanel(parent, new Chess());
        } else if ("Clue Chili".equals(name)) {
            return new CluePanel(parent, new Clue());
        } else if ("Jenga Nachos".equals(name)) {
            return new JengaPanel(parent, new Jenga());
        } else if ("Monopoly Bowl".equals(name)) {
            return new MonopolyPanel(parent, new Monopoly());
        } else if ("Yahtzee Poke".equals(name)) {
            return new YahtzeePanel(parent, new Yahtzee());
        } else if ("Risk Bites".equals(name)) {
            return new SidePanel(parent, new Risk());
        } else if ("Junior Risk Bites".equals(name)) {
            return new SidePanel(parent, new Risk());
        } else if ("Classic Risk Bites".equals(name)) {
            Risk risk = new Risk();
            risk.setSize(Size.CLASSIC);
            return new SidePanel(parent, risk);
        } else if ("Winner Risk Bites".equals(name)) {
            Risk risk = new Risk();
            risk.setSize(Size.WINNER);
            return new SidePanel(parent, risk);
        } else if ("Potato Dice".equals(name)) {
            return new SidePanel(parent, new Dice());
        } else if ("Junior Potato Dice".equals(name)) {
            return new SidePanel(parent, new Dice());
        } else if ("Classic Potato Dice".equals(name)) {
            Dice dice = new Dice();
            dice.setSize(Size.CLASSIC);
            return new SidePanel(parent, dice);
        } else if ("Winner Potato Dice".equals(name)) {
            Dice dice = new Dice();
            dice.setSize(Size.WINNER);
            return new SidePanel(parent, dice);
        } else if ("Catan Skewers".equals(name)) {
            return new SidePanel(parent, new Catan());
        } else if ("Junior Catan Skewers".equals(name)) {
            return new SidePanel(parent, new Catan());
        } else if ("Classic Catan Skewers".equals(name)) {
            Catan catan = new Catan();
            catan.setSize(Size.CLASSIC);
            return new SidePanel(parent, catan);
        } else if ("Winner Catan Skewers".equals(name)) {
            Catan catan = new Catan();
            catan.setSize(Size.WINNER);
            return new SidePanel(parent, catan);
        } else if ("Junior Cranium Coffee".equals(name)) {
            return new CraniumPanel(parent, new Cranium());
        } else if ("Cranium Coffee".equals(name)) {
            return new CraniumPanel(parent, new Cranium());
        } else if ("Classic Cranium Coffee".equals(name)) {
            Cranium cranium = new Cranium();
            cranium.setSize(Size.CLASSIC);
            return new CraniumPanel(parent, cranium);
        } else if ("Winner Cranium Coffee".equals(name)) {
            Cranium cranium = new Cranium();
            cranium.setSize(Size.WINNER);
            return new CraniumPanel(parent, cranium);
        } else if ("Junior Candy Land Shake".equals(name)) {
            return new CandyPanel(parent, new Candy());
        } else if ("Candy Land Shake".equals(name)) {
            return new CandyPanel(parent, new Candy());
        } else if ("Classic Candy Land Shake".equals(name)) {
            Candy candy = new Candy();
            candy.setSize(Size.CLASSIC);
            return new CandyPanel(parent, candy);
        } else if ("Winner Candy Land Shake".equals(name)) {
            Candy candy = new Candy();
            candy.setSize(Size.WINNER);
            return new CandyPanel(parent, candy);
        } else if ("Junior Sorry Soda".equals(name)) {
            return new SorryPanel(parent, new Sorry());
        } else if ("Classic Sorry Soda".equals(name)) {
            Sorry sorry = new Sorry();
            sorry.setSize(Size.CLASSIC);
            return new SorryPanel(parent, sorry);
        } else if ("Winner Sorry Soda".equals(name)) {
            Sorry sorry = new Sorry();
            sorry.setSize(Size.WINNER);
            return new SorryPanel(parent, sorry);
        } else if ("Sorry Soda".equals(name)) {
            Sorry sorry = new Sorry();
            sorry.setSize(Size.JUNIOR);
            return new SorryPanel(parent, sorry);
        } else if ("Combo".equals(name)) {
            return new ComboPanelSelector((PrimaryWindow) parent);
        } else if ("Game Night".equals(name)) {
            return new ComboPanel(parent, new Combo("Game Night"));
        } else if ("Roll the Dice".equals(name)) {
            return new ComboPanel(parent, new Combo("Roll the Dice"));
        } else if ("Big Appetite".equals(name)) {
            return new ComboPanel(parent, new Combo("Big Appetite"));
        } else if ("The Winner".equals(name)) {
            return new ComboPanel(parent, new Combo("The Winner"));
        } else if ("Custom Combo".equals(name)) {
            return new ComboPanel(parent, new Combo());
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * getPanel method with item
     *
     *<p>This panel uses an item provided by an action ActionListener
     to load the correct panel.
     *
     * @param item item provided by ActionListener
     * @param parent the parent window to the class
     *
     */
    public static JPanel getPanel(Item item, ParentPanel parent) {
        if (item instanceof Chess) {
            Chess chess = (Chess) item;
            return new ChessPanel((ParentPanel) parent, chess);
        } else if (item instanceof Clue) {
            Clue clue = (Clue) item;
            return new CluePanel((ParentPanel) parent, clue);
        } else if (item instanceof Jenga) {
            Jenga jenga = (Jenga) item;
            return new JengaPanel((ParentPanel) parent, jenga);
        } else if (item instanceof Monopoly) {
            Monopoly monopoly = (Monopoly) item;
            return new MonopolyPanel((ParentPanel) parent, monopoly);
        } else if (item instanceof Yahtzee) {
            Yahtzee yahtzee = (Yahtzee) item;
            return new YahtzeePanel(parent, yahtzee);
        } else if (item instanceof Risk) {
            Risk risk = (Risk) item;
            return new SidePanel(parent, risk);
        } else if (item instanceof Dice) {
            Dice dice = (Dice) item;
            return new SidePanel(parent, dice);
        } else if (item instanceof Catan) {
            Catan catan = (Catan) item;
            return new SidePanel(parent, catan);
        } else if (item instanceof Cranium) {
            Cranium cranium = (Cranium) item;
            return new CraniumPanel(parent, cranium);
        } else if (item instanceof Candy) {
            Candy candy = (Candy) item;
            return new CandyPanel(parent, candy);
        } else if (item instanceof Sorry) {
            Sorry sorry = (Sorry) item;
            return new SorryPanel(parent, sorry);
        } else {
            throw new IllegalArgumentException();
        }
    }
}