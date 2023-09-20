package gamegrub.gui.entrees;

import gamegrub.data.Item;
import gamegrub.data.entrees.Yahtzee;
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
 * YahtzeePanel Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class YahtzeePanel extends EntreePanel {
    
    ParentPanel parent;
    Yahtzee item;
    JCheckBox tuna;
    JCheckBox veggies;
    JCheckBox seaweed;

    /**
     * YahtzeePanel Constructor.
     *
     *<p>This method is used to extend the EntreePanel
     to give correct formatting to the GUI for the 
     provided ingredients of the entree and provides
     a check box for editing the menu item.
     *
     * @param parent Sets primary window as parent.
     */
    public YahtzeePanel(ParentPanel parent, Yahtzee yahtzee) {
        super(parent, yahtzee);
        this.parent = parent;
        item = yahtzee;
        tuna = new JCheckBox("Tuna");
        tuna.setSelected(item.getTuna());
        // GridBagConstraints tunagbc = new GridBagConstraints();
        // tunagbc.gridx = 0;
        // tunagbc.gridy = 2;
        // tunagbc.anchor = GridBagConstraints.LINE_START;
        // tunagbc.insets = new Insets(2, 2, 2, 2);
        this.add(tuna, this.makeGbc(gridynum++, true));

        veggies = new JCheckBox("Veggies");
        veggies.setSelected(item.getVeggies());
        // GridBagConstraints veggiesgbc = new GridBagConstraints();
        // veggiesgbc.gridx = 0;
        // veggiesgbc.gridy = 3;
        // veggiesgbc.anchor = GridBagConstraints.LINE_START;
        // veggiesgbc.insets = new Insets(2, 2, 2, 2);
        this.add(veggies, this.makeGbc(gridynum++, true));

        seaweed = new JCheckBox("Seaweed");
        seaweed.setSelected(item.getSeaweed());
        // GridBagConstraints seaweedgbc = new GridBagConstraints();
        // seaweedgbc.gridx = 0;
        // seaweedgbc.gridy = 4;
        // seaweedgbc.anchor = GridBagConstraints.LINE_START;
        // seaweedgbc.insets = new Insets(2, 2, 2, 2);
        this.add(seaweed, this.makeGbc(gridynum++, true));
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
            this.item.setTuna(this.tuna.isSelected());
            this.item.setVeggies(this.veggies.isSelected());
            this.item.setSeaweed(this.seaweed.isSelected());
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