package gamegrub.gui.entrees;

import gamegrub.data.Item;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import gamegrub.data.menu.Menu;
import gamegrub.gui.OrderPanel;
import gamegrub.gui.ParentPanel;
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
 * MonopolyPanel Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class MonopolyPanel extends EntreePanel {
    
    ParentPanel parent;
    Monopoly item;
    JCheckBox spicyBeef;
    JCheckBox crispyChicken;
    JCheckBox beans;
    JCheckBox veggies;

    /**
     * MonopolyPanel Constructor.
     *
     *<p>This method is used to extend the EntreePanel
     to give correct formatting to the GUI for the 
     provided ingredients of the entree and provides
     a check box for editing the menu item.
     *
     * @param parent Sets primary window as parent.
     */
    public MonopolyPanel(ParentPanel parent, Monopoly monopoly) {
        super(parent, monopoly);
        this.parent = parent;
        item = monopoly;
        spicyBeef = new JCheckBox("Spicy Beef");
        spicyBeef.setSelected(item.getSpicyBeef());
        // GridBagConstraints spicyBeefgbc = new GridBagConstraints();
        // spicyBeefgbc.gridx = 0;
        // spicyBeefgbc.gridy = 2;
        // spicyBeefgbc.anchor = GridBagConstraints.LINE_START;
        // spicyBeefgbc.insets = new Insets(2, 2, 2, 2);
        this.add(spicyBeef, this.makeGbc(gridynum++, true));

        crispyChicken = new JCheckBox("Crispy Chicken");
        crispyChicken.setSelected(item.getCrispyChicken());
        // GridBagConstraints crispyChickengbc = new GridBagConstraints();
        // crispyChickengbc.gridx = 0;
        // crispyChickengbc.gridy = 3;
        // crispyChickengbc.anchor = GridBagConstraints.LINE_START;
        // crispyChickengbc.insets = new Insets(2, 2, 2, 2);
        this.add(crispyChicken, this.makeGbc(gridynum++, true));

        beans = new JCheckBox("Beans");
        beans.setSelected(item.getBeans());
        // GridBagConstraints beansgbc = new GridBagConstraints();
        // beansgbc.gridx = 0;
        // beansgbc.gridy = 4;
        // beansgbc.anchor = GridBagConstraints.LINE_START;
        // beansgbc.insets = new Insets(2, 2, 2, 2);
        this.add(beans, this.makeGbc(gridynum++, true));

        veggies = new JCheckBox("Veggies");
        veggies.setSelected(item.getVeggies());
        // GridBagConstraints veggiesgbc = new GridBagConstraints();
        // veggiesgbc.gridx = 0;
        // veggiesgbc.gridy = 5;
        // veggiesgbc.anchor = GridBagConstraints.LINE_START;
        // veggiesgbc.insets = new Insets(2, 2, 2, 2);
        this.add(veggies, this.makeGbc(gridynum++, true));
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
            this.item.setBase((Base) this.base.getSelectedItem());
            this.item.setSpicyBeef(this.spicyBeef.isSelected());
            this.item.setCrispyChicken(this.crispyChicken.isSelected());
            this.item.setVeggies(this.veggies.isSelected());
            this.item.setBeans(this.beans.isSelected());
            for (Toppings t : Toppings.values()) {
                if (this.toppingBox.get(t).isSelected()) {
                    this.item.addTopping(t);
                } else {
                    this.item.removeTopping(t);
                }
            }
            parent.addItem(this.item);
            parent.loadMenuPanel();
        } else if ("cancel".equals(e.getActionCommand())) {
            parent.loadMenuPanel();
        }
    }
}