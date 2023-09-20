package gamegrub.gui;

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
import gamegrub.data.menu.Menu;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import gamegrub.gui.OrderPanel;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.CandyPanel;
import gamegrub.gui.drinks.CraniumPanel;
import gamegrub.gui.drinks.DrinksPanel;
import gamegrub.gui.drinks.SorryPanel; 
import gamegrub.gui.entrees.ChessPanel;
import gamegrub.gui.entrees.CluePanel;
import gamegrub.gui.entrees.JengaPanel;
import gamegrub.gui.entrees.MonopolyPanel;
import gamegrub.gui.entrees.YahtzeePanel;
import gamegrub.gui.sides.SidePanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * MenuPanel Class.
 *
 *<p>This class provides the GUI with a 
 list of buttons to select from to add
 an item to an order.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class MenuPanel extends JPanel implements ActionListener {

    private PrimaryWindow parent;

    /**
     * MenuPanel Constructor.
     *
     *<p>This method creates a panel providing buttons
     that can be selected to add an item to the order
     from available items on the menu. It sets the 
     primary window to the provided parent and sets
     the panel to a Dimension of 724x740.
     *
     * @param parent sets PrimaryWindow as parent
     */
    public MenuPanel(PrimaryWindow parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(724, 740));
        this.setLayout(new GridBagLayout());

        int i = 0;
        for (Item item : Menu.getEntrees()) {
            Entree entree = (Entree) item;
            JButton button = new JButton(entree.getName());
            button.setActionCommand(entree.getName());
            button.addActionListener(this);
            GridBagConstraints entreegbc = new GridBagConstraints();
            entreegbc.gridx = 0;
            entreegbc.gridy = i;
            i += 1;
            entreegbc.weightx = 1.0;
            entreegbc.weighty = 1.0;
            entreegbc.fill = GridBagConstraints.BOTH;
            entreegbc.insets = new Insets(2, 2, 2, 2);
            this.add(button, entreegbc);
        }

        JButton combo = new JButton("Combo");
        combo.setActionCommand("Combo");
        combo.addActionListener(this);
        GridBagConstraints comboGbc = new GridBagConstraints();
        comboGbc.gridx = 0;
        comboGbc.gridy = i;
        comboGbc.fill = GridBagConstraints.BOTH;
        comboGbc.insets = new Insets(2, 2, 2, 2);
        this.add(combo, comboGbc);

        i = 0;
        for (Item side : Menu.getSides()) {
            JButton button = new JButton(side.toString());
            button.setActionCommand(side.toString());
            button.addActionListener(this);
            GridBagConstraints sidegbc = new GridBagConstraints();
            sidegbc.gridx = 1;
            sidegbc.gridy = i;
            i += 1;
            sidegbc.weightx = 1.0;
            sidegbc.weighty = 1.0;
            sidegbc.fill = GridBagConstraints.BOTH;
            sidegbc.insets = new Insets(2, 2, 2, 2);
            this.add(button, sidegbc);
        }

        i = 0;
        for (Item drink : Menu.getDrinks()) {
            JButton button = new JButton(drink.toString());
            button.setActionCommand(drink.toString());
            button.addActionListener(this);
            GridBagConstraints drinkgbc = new GridBagConstraints();
            drinkgbc.gridx = 2;
            drinkgbc.gridy = i;
            i += 1;
            drinkgbc.weightx = 1.0;
            drinkgbc.weighty = 1.0;
            drinkgbc.fill = GridBagConstraints.BOTH;
            drinkgbc.insets = new Insets(2, 2, 2, 2);
            this.add(button, drinkgbc);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        // ---- REPLACE ALL BELOW WITH THE FACTORY METHODS ----
        this.parent.loadPanel(PanelFactory.getPanel(e.getActionCommand(), this.parent));

        // if ("Chess Chicken Parmesan".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new ChessPanel(parent, new Chess()));
        // }
        // if ("Clue Chili".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new CluePanel(parent, new Clue()));
        // }
        // if ("Jenga Nachos".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new JengaPanel(parent, new Jenga()));
        // }
        // if ("Monopoly Bowl".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new MonopolyPanel(parent, new Monopoly()));
        // }
        // if ("Yahtzee Poke".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new YahtzeePanel(parent, new Yahtzee()));
        // }

        // // vvvvvvvvvvv creating new instance, fix here
        // if ("Junior Risk Bites".equals(e.getActionCommand()) 
        //         || "Classic Risk Bites".equals(e.getActionCommand())
        //         || "Winner Risk Bites".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new SidePanel(parent, new Risk()));
        // }
        // if ("Junior Potato Dice".equals(e.getActionCommand()) 
        //         || "Classic Potato Dice".equals(e.getActionCommand())
        //         || "Winner Potato Dice".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new SidePanel(parent, new Dice()));
        // }
        // if ("Junior Catan Skewers".equals(e.getActionCommand()) 
        //         || "Classic Catan Skewers".equals(e.getActionCommand())
        //         || "Winner Catan Skewers".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new SidePanel(parent, new Catan()));
        // }
        // if ("Junior Cranium Coffee".equals(e.getActionCommand()) 
        //         || "Classic Cranium Coffee".equals(e.getActionCommand())
        //         || "Winner Cranium Coffee".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new CraniumPanel(parent, new Cranium()));
        // }
        // if ("Junior Candy Land Shake".equals(e.getActionCommand()) 
        //         || "Classic Candy Land Shake".equals(e.getActionCommand())
        //         || "Winner Candy Land Shake".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new CandyPanel(parent, new Candy()));
        // }
        // if ("Junior Sorry Soda".equals(e.getActionCommand()) 
        //         || "Classic Sorry Soda".equals(e.getActionCommand())
        //         || "Winner Sorry Soda".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new SorryPanel(parent, new Sorry()));
        // }
    }
}