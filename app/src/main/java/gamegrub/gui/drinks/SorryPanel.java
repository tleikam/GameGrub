package gamegrub.gui.drinks;

import gamegrub.data.Item;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.OrderPanel;
import gamegrub.gui.ParentPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
 * Class for the SorryDrinkPanel of Gui.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class SorryPanel extends DrinksPanel {

    private ParentPanel parent;
    Sorry drink;
    JCheckBox cola;
    JCheckBox cherry;
    JCheckBox grape;
    JCheckBox orange;

    /**
     * SorryPanel Constructor.
     *
     *<p>This method is used to extend the DrinksPanel
     to give correct formatting to the GUI for the 
     provided ingredients of the drink and provides
     a check box for editing the menu item.
     *
     * @param parent Sets primary window as parent.
     */
    public SorryPanel(ParentPanel parent, Sorry sorry) {
        super(parent, sorry);
        this.parent = parent;
        drink = sorry;
        cola = new JCheckBox("Cola");
        cola.setSelected(drink.getCola());
        this.add(cola, this.makeGbc(ynum++, true));

        cherry = new JCheckBox("Cherry");
        cherry.setSelected(drink.getCherry());
        this.add(cherry, this.makeGbc(ynum++, true));

        grape = new JCheckBox("Grape");
        grape.setSelected(drink.getGrape());
        this.add(grape, this.makeGbc(ynum++, true));

        orange = new JCheckBox("Orange");
        orange.setSelected(drink.getOrange());
        this.add(orange, this.makeGbc(ynum++, true));
    }

    /**
     * Override for actionPerformed.
     *
     *<p>This overrides the actionPerformed method
     to save the item to the order and load the 
     previous menu.
     *
     * @param e Action Performed in method above
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if ("save".equals(e.getActionCommand())) {
            this.drink.setSize((Size) this.size.getSelectedItem());
            this.drink.setCola(this.cola.isSelected());
            this.drink.setCherry(this.cherry.isSelected());
            this.drink.setGrape(this.grape.isSelected());
            this.drink.setOrange(this.orange.isSelected());
            parent.addItem(this.drink);
            parent.loadMenuPanel();
        } else if ("cancel".equals(e.getActionCommand())) {
            parent.loadMenuPanel();
        }
    }
}