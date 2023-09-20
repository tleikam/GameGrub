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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 * ComboPanel selector class.
 *
 *<p>This is a panel to load choices for Combo panels
 which are provided by buttons of available combo choices.
 *
 * @author Travis Leikam
 * @version v0.7
 */
public class ComboPanelSelector extends JPanel implements ActionListener, ParentPanel {

    private PrimaryWindow parent;

    /**
     * ComboPanelConstructor.
     *
     *<p>This method takes a panel and loads all 
     available combos to it as buttons from the menu
     and adds a custom combo button.
     *
     * @param parent parent window to the class
     */
    public ComboPanelSelector(PrimaryWindow parent) {
        this.parent = parent;

        this.setLayout(new GridBagLayout());

        GridBagConstraints titleGbc = new GridBagConstraints();
        titleGbc.gridx = 0;
        titleGbc.gridy = 0;
        titleGbc.insets = new Insets(2, 2, 2, 2);
        JLabel title = new JLabel("Pick a Combo");
        this.add(title, titleGbc);

        int i = 1;
        for (Item item : Menu.getCombos()) {
            Combo combo = (Combo) item;
            JButton comboButton = new JButton(combo.getName());
            comboButton.setActionCommand(combo.getName());
            comboButton.addActionListener(this);
            GridBagConstraints combogbc = new GridBagConstraints();
            combogbc.gridx = 0;
            combogbc.gridy = i;
            i += 1;
            combogbc.weightx = 1.0;
            combogbc.weighty = 1.0;
            combogbc.fill = GridBagConstraints.BOTH;
            combogbc.insets = new Insets(2, 2, 2, 2);
            this.add(comboButton, combogbc);
        }

        JButton comboButton = new JButton("Custom Combo");
        comboButton.setActionCommand("Custom Combo");
        comboButton.addActionListener(this);
        GridBagConstraints combogbc = new GridBagConstraints();
        combogbc.gridx = 0;
        combogbc.gridy = i;
        i += 1;
        combogbc.weightx = 1.0;
        combogbc.weighty = 1.0;
        combogbc.fill = GridBagConstraints.BOTH;
        combogbc.insets = new Insets(2, 2, 2, 2);
        this.add(comboButton, combogbc);        
    }

    /**
     * Override for actionPerformed.
     *
     *<p>This method overrides the actionPerformed method
     and uses the PanelFactory to load the correct panel to the 
     gui.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        // replace all of these with the factory method once it works
        this.parent.loadPanel(PanelFactory.getPanel(e.getActionCommand(), this.parent));
        // if ("Game Night".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new ComboPanel(this.parent, new Combo("Game Night")));
        // }
        // if ("Roll the Dice".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new ComboPanel(parent, new Combo("Roll the Dice")));
        // }
        // if ("Big Appetite".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new ComboPanel(parent, new Combo("Big Appetite")));
        // }
        // if ("The Winner".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new ComboPanel(parent, new Combo("The Winner")));
        // }
        // if ("Custom Combo".equals(e.getActionCommand())) {
        //     this.parent.loadPanel(new ComboPanel(parent, new Combo()));
        // }
    }

    /**
     * loadMenuPanel method.
     *
     *<p>This method is just to sit here for now.
     */
    public void loadMenuPanel() {
        //do nothing
    }

    /**
     * AddItem method.
     *
     *<p>This method is just to sit here for now.
     */
    public void addItem(Item item) {
        //do nothing
    }
}