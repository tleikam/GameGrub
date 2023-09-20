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
 * Class for the CandyDrinkPanel of Gui.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CandyPanel extends DrinksPanel implements ActionListener {

    Candy candy;
    private ParentPanel parent;
    JCheckBox chocolate;
    JCheckBox vanilla;
    JCheckBox strawberry;

    /**
     * CandyPanel Constructor.
     *
     *<p>This method is used to extend the DrinksPanel
     to give correct formatting to the GUI for the 
     provided ingredients of the drink and provides
     a check box for editing the menu item.
     *
     * @param parent Sets primary window as parent.
     */
    public CandyPanel(ParentPanel parent, Candy drink) {
        super(parent, drink);
        this.candy = drink;
        this.parent = parent;

        vanilla = new JCheckBox("Vanilla");
        vanilla.setSelected(candy.getVanilla());
        this.add(vanilla, this.makeGbc(ynum++, true));

        chocolate = new JCheckBox("Chocolate");
        chocolate.setSelected(candy.getChocolate());
        this.add(chocolate, this.makeGbc(ynum++, true));

        strawberry = new JCheckBox("Strawberry");
        strawberry.setSelected(candy.getStrawberry());
        this.add(strawberry, this.makeGbc(ynum++, true));

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
            this.candy.setSize((Size) this.size.getSelectedItem());
            this.candy.setVanilla(this.vanilla.isSelected());
            this.candy.setChocolate(this.chocolate.isSelected());
            this.candy.setStrawberry(this.strawberry.isSelected());
            parent.addItem(this.candy);
            parent.loadMenuPanel();
        } else if ("cancel".equals(e.getActionCommand())) {
            parent.loadMenuPanel();
        }
    }
}