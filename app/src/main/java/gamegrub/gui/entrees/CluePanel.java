package gamegrub.gui.entrees;

import gamegrub.data.Item;
import gamegrub.data.entrees.Clue;
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
 * CluePanel Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CluePanel extends EntreePanel {
    
    ParentPanel parent;
    Clue item;
    JCheckBox spicyBeef;
    JCheckBox chili;
    JCheckBox redSauce;
    JCheckBox beans;

    /**
     * CluePanel Constructor.
     *
     *<p>This method is used to extend the EntreePanel
     to give correct formatting to the GUI for the 
     provided ingredients of the entree and provides
     a check box for editing the menu item.
     *
     * @param parent Sets primary window as parent.
     */
    public CluePanel(ParentPanel parent, Clue clue) {
        super(parent, clue);
        this.parent = parent;
        item = clue;
        spicyBeef = new JCheckBox("Spicy Beef");
        spicyBeef.setSelected(item.getSpicyBeef());
        // GridBagConstraints spicyBeefgbc = new GridBagConstraints();
        // spicyBeefgbc.gridx = 0;
        // spicyBeefgbc.gridy = 2;
        // spicyBeefgbc.anchor = GridBagConstraints.LINE_START;
        // spicyBeefgbc.insets = new Insets(2, 2, 2, 2);
        this.add(spicyBeef, this.makeGbc(gridynum++, true));

        chili = new JCheckBox("Chili");
        chili.setSelected(item.getChili());
        // GridBagConstraints chiligbc = new GridBagConstraints();
        // chiligbc.gridx = 0;
        // chiligbc.gridy = 3;
        // chiligbc.anchor = GridBagConstraints.LINE_START;
        // chiligbc.insets = new Insets(2, 2, 2, 2);
        this.add(chili, this.makeGbc(gridynum++, true));

        redSauce = new JCheckBox("Red Sauce");
        redSauce.setSelected(item.getRedSauce());
        // GridBagConstraints redSaucegbc = new GridBagConstraints();
        // redSaucegbc.gridx = 0;
        // redSaucegbc.gridy = 4;
        // redSaucegbc.anchor = GridBagConstraints.LINE_START;
        // redSaucegbc.insets = new Insets(2, 2, 2, 2);
        this.add(redSauce, this.makeGbc(gridynum++, true));

        beans = new JCheckBox("Beans");
        beans.setSelected(item.getBeans());
        // GridBagConstraints beansgbc = new GridBagConstraints();
        // beansgbc.gridx = 0;
        // beansgbc.gridy = 5;
        // beansgbc.anchor = GridBagConstraints.LINE_START;
        // beansgbc.insets = new Insets(2, 2, 2, 2);
        this.add(beans, this.makeGbc(gridynum++, true));
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
            this.item.setChili(this.chili.isSelected());
            this.item.setRedSauce(this.redSauce.isSelected());
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