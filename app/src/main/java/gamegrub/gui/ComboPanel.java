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
import gamegrub.gui.ItemPanel;
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
 * ComboPanel Class.
 *
 *<p>This ComboPanel loads potential combos into the gui
 with a panel for entree, side, and drink for customization.
 */
public class ComboPanel extends JPanel implements ParentPanel, ActionListener {

    private ParentPanel parent;
    Combo combo;
    Entree entree;
    Side side;
    Drink drink;
    JComboBox<String> entreeBox;
    JComboBox<String> sideBox;
    JComboBox<String> drinkBox;
    GridBagConstraints entreePanelGbc;
    GridBagConstraints sidePanelGbc;
    GridBagConstraints drinkPanelGbc;
    ItemPanel entreePanel;
    ItemPanel sidePanel;
    ItemPanel drinkPanel;

    /**
     * Main Constructor.
     *
     * @param parent parent window to the class
     * @param combo provided combo to load and modify
     */
    public ComboPanel(ParentPanel parent, Combo combo) {
        if (combo != null) {
            this.parent = parent;
            this.combo = combo;
            this.entree = combo.getEntreeInstance();
            this.side = combo.getSideInstance();
            this.drink = combo.getDrinkInstance();
        } else {
            this.parent = parent;
            this.combo = new Combo();
            this.entree = null;
            this.side = null;
            this.drink = null;
        }

        this.setLayout(new GridBagLayout());

        if ("Custom Combo".equals(combo.getName())) {
            GridBagConstraints titleGbc = new GridBagConstraints();
            titleGbc.gridx = 1;
            titleGbc.gridy = 0;
            titleGbc.insets = new Insets(2, 2, 2, 2);
            JLabel title = new JLabel("Custom Combo");
            this.add(title, titleGbc);
        } else {
            GridBagConstraints titleGbc = new GridBagConstraints();
            titleGbc.gridx = 1;
            titleGbc.gridy = 0;
            titleGbc.insets = new Insets(2, 2, 2, 2);
            JLabel title = new JLabel(combo.getName());
            this.add(title, titleGbc);
        }

        // ------------ENTREE----------
        // ____BOX___
        GridBagConstraints entreeGbc = new GridBagConstraints();
        entreeGbc.gridx = 0;
        entreeGbc.gridy = 1;
        entreeGbc.insets = new Insets(2, 2, 2, 2);
        entreeGbc.fill = GridBagConstraints.HORIZONTAL;
        entreeGbc.weightx = 1.0;

        entreeBox = new JComboBox<>();
        entreeBox.addItem("No Selection");
        Menu menu = new Menu();
        LinkedList<Item> entreeItems = menu.getEntrees();
        for (Item it : entreeItems) {
            Entree ent = (Entree) it;
            entreeBox.addItem(ent.getName());
        }
        if (combo != null) {
            for (int i = 0; i < entreeBox.getItemCount(); i++) {
                if (this.entree == null) {
                    entreeBox.setSelectedItem(0);
                    this.validate();
                    this.repaint();
                } else if (entreeBox.getItemAt(i).equals(this.entree.getName())) {
                    entreeBox.setSelectedItem(entreeBox.getItemAt(i));
                    this.validate();
                    this.repaint();
                    break;
                }
            }
        } else {
            entreeBox.setSelectedItem(0);
        }
        this.add(entreeBox, entreeGbc);

        // ___PANEL___
        entreePanelGbc = new GridBagConstraints();
        entreePanelGbc.gridx = 0;
        entreePanelGbc.gridy = 2;
        entreePanelGbc.insets = new Insets(2, 2, 2, 2);
        entreePanelGbc.fill = GridBagConstraints.BOTH;
        entreePanelGbc.weightx = 1.0;
        entreePanelGbc.weighty = 1.0;

        if (this.entree != null) {
            this.entreePanel = (EntreePanel) PanelFactory.getPanel(
                                (Item) this.entree, this);
        } else {
            //this.entreePanel = new EntreePanel(this, null);
            this.entreePanel = new ItemPanel();
        }
        this.add(entreePanel, entreePanelGbc);

        entreeBox.addActionListener(this);


        // ------------SIDES-----------
        // ____BOX___
        GridBagConstraints sideGbc = new GridBagConstraints();
        sideGbc.gridx = 1;
        sideGbc.gridy = 1;
        sideGbc.insets = new Insets(2, 2, 2, 2);
        sideGbc.fill = GridBagConstraints.HORIZONTAL;
        sideGbc.weightx = 1.0;

        sideBox = new JComboBox<>();
        sideBox.addItem("No Selection");
        LinkedList<Item> sideItems = menu.getSides();
        LinkedList<String> viewed = new LinkedList<>();
        for (Item it : sideItems) {
            Side s = (Side) it;
            sideBox.addItem(s.toString());
            // if(!(viewed.contains(s.getName()))) {
            //     viewed.add(s.getName());
            //     for (Size size : Size.values()) {
            //         sideBox.addItem(size.toString() + " " + s.getName());
            //     }
            // }
        }
        if (combo != null) {
            for (int i = 0; i < sideBox.getItemCount(); i++) {
                if (this.side == null) {
                    sideBox.setSelectedItem(0);
                    this.validate();
                    this.repaint();
                } else if (this.side.toString().equals(sideBox.getItemAt(i))) {
                    sideBox.setSelectedItem(sideBox.getItemAt(i));
                    this.validate();
                    this.repaint();
                    break;
                }
            }
        } else {
            sideBox.setSelectedItem(0);
        }
        this.add(sideBox, sideGbc);

        // ___PANEL___
        sidePanelGbc = new GridBagConstraints();
        sidePanelGbc.gridx = 1;
        sidePanelGbc.gridy = 2;
        sidePanelGbc.insets = new Insets(2, 2, 2, 2);
        sidePanelGbc.fill = GridBagConstraints.BOTH;
        sidePanelGbc.weightx = 1.0;
        sidePanelGbc.weighty = 1.0;

        if (this.side != null) {
            this.sidePanel = (SidePanel) PanelFactory.getPanel(
                             this.side, this);
        } else {
            this.sidePanel = new ItemPanel();
        }
        this.add(sidePanel, sidePanelGbc);

        sideBox.addActionListener(this);

        // ------------DRINKS----------
        // ____BOX___
        GridBagConstraints drinkGbc = new GridBagConstraints();
        drinkGbc.gridx = 2;
        drinkGbc.gridy = 1;
        drinkGbc.insets = new Insets(2, 2, 2, 2);
        drinkGbc.fill = GridBagConstraints.HORIZONTAL;
        drinkGbc.weightx = 1.0;

        drinkBox = new JComboBox<>();
        drinkBox.addItem("No Selection");
        LinkedList<Item> drinkItems = menu.getDrinks();
        // viewed = new LinkedList<>();
        for (Item it : drinkItems) {
            Drink d = (Drink) it;
            drinkBox.addItem(d.toString());
            // if(!(viewed.contains(d.getName()))){
            //     viewed.add(d.getName());
            //     drinkBox.addItem(d.getName());
            // }
        }
        if (combo != null) {
            for (int i = 0; i < drinkBox.getItemCount(); i++) {
                if (this.drink == null) {
                    drinkBox.setSelectedItem(0);
                    this.validate();
                    this.repaint(); 
                } else if (this.drink.toString().equals(drinkBox.getItemAt(i))) {
                    drinkBox.setSelectedItem(drinkBox.getItemAt(i));
                    this.validate();
                    this.repaint();
                    break;
                }
            }
        } else {
            drinkBox.setSelectedItem(0);
        }
        this.add(drinkBox, drinkGbc);

        // ___PANEL___
        drinkPanelGbc = new GridBagConstraints();
        drinkPanelGbc.gridx = 2;
        drinkPanelGbc.gridy = 2;
        drinkPanelGbc.insets = new Insets(2, 2, 2, 2);
        drinkPanelGbc.fill = GridBagConstraints.BOTH;
        drinkPanelGbc.weightx = 1.0;
        drinkPanelGbc.weighty = 1.0;

        if (this.drink != null) {
            this.drinkPanel = (DrinksPanel) PanelFactory.getPanel(
                              (Item) this.drink, this);
        } else {
            this.drinkPanel = new ItemPanel();
        }
        this.add(drinkPanel, drinkPanelGbc);

        drinkBox.addActionListener(this);

        // SAVE
        JButton save = new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);
        GridBagConstraints savegbc = new GridBagConstraints();
        savegbc.gridx = 0;
        savegbc.gridy = 3;
        savegbc.insets = new Insets(2, 2, 2, 2);
        this.add(save, savegbc);

        // CANCEL
        JButton cancel = new JButton("Cancel");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        GridBagConstraints cancelGbc = new GridBagConstraints();
        cancelGbc.gridx = 2;
        cancelGbc.gridy = 3;
        cancelGbc.insets = new Insets(2, 2, 2, 2);
        this.add(cancel, cancelGbc);
    }

    /**
     * actionPerformed method.
     *
     *<p>This method takes an action event from the buttons
     provided in the gui and creates actions Performed
     from the occuring event.
     *
     * @param event event that occured from ActionEvent
     */

    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.entreeBox)) {
            if (this.entreePanel != null) {
                this.remove(this.entreePanel);
            }
            String selected = (String) this.entreeBox.getSelectedItem();
            if (!selected.equals("No Selection")) {
                this.entreePanel = (EntreePanel) PanelFactory.getPanel(
                                    selected, this);
            } else {
                this.entreePanel = new ItemPanel();
            }
            this.add(this.entreePanel, entreePanelGbc);
            this.validate();
            this.repaint();
        }
        if (event.getSource().equals(this.sideBox)) {
            if (this.sidePanel != null) {
                this.remove(this.sidePanel);
            }
            String selected = (String) this.sideBox.getSelectedItem();
            if (!selected.equals("No Selection")) {
                this.sidePanel = (SidePanel) PanelFactory.getPanel(
                                  selected, this);
            } else {
                this.sidePanel = new ItemPanel();
            }
            this.add(this.sidePanel, sidePanelGbc);
            this.validate();
            this.repaint();
        }
        if (event.getSource().equals(this.drinkBox)) {
            if (this.drinkPanel != null) {
                this.remove(this.drinkPanel);
            }
            String selected = (String) this.drinkBox.getSelectedItem();
            if (!selected.equals("No Selection")) {
                this.drinkPanel = (DrinksPanel) PanelFactory.getPanel(
                                   selected, this);
            } else {
                this.drinkPanel = new ItemPanel();
            }
            this.add(this.drinkPanel, drinkPanelGbc);
            this.validate();
            this.repaint();
        }
        if ("cancel".equals(event.getActionCommand())) {
            this.parent.loadMenuPanel();
        }
        if ("save".equals(event.getActionCommand())) {
            if (!((String) this.entreeBox.getSelectedItem()).equals("No Selection")) {
                this.entreePanel.actionPerformed(new ActionEvent(this.entreePanel, 0, "save"));
            } else {
                this.combo.setEntreeInstance(null);
            }
            if (!((String) this.sideBox.getSelectedItem()).equals("No Selection")) {
                this.sidePanel.actionPerformed(new ActionEvent(this.sidePanel, 0, "save"));
            } else {
                this.combo.setSideInstance(null);
            }
            if (!((String) this.drinkBox.getSelectedItem()).equals("No Selection")) {
                this.drinkPanel.actionPerformed(new ActionEvent(this.drinkPanel, 0, "save"));
            } else {
                this.combo.setDrinkInstance(null);
            }
            if (this.combo != null) {
                this.parent.addItem(this.combo);
            }
            this.parent.loadMenuPanel();
        }
    }

    /**
     * AddItem Method.
     *
     *<p>This method adds an item to either the combo
     for the parent depending on what it is an instance
     of.
     *
     * @param item item to check instanceof
     */
    public void addItem(Item item) {
        if (item instanceof Entree) {
            Entree entree = (Entree) item;
            this.combo.setEntreeInstance(entree);
        }
        if (item instanceof Side) {
            Side side = (Side) item;
            this.combo.setSideInstance(side);
        }
        if (item instanceof Drink) {
            Drink drink = (Drink) item;
            this.combo.setDrinkInstance(drink);
        }
        if (item instanceof Combo) {
            parent.addItem(this.combo);
            parent.loadMenuPanel();
        }
    }

    /**
     * LoadMenuPanel method.
     *
     *<p>This literally does nothing.
     */
    public void loadMenuPanel() {
        // do nothing yet
    }
}