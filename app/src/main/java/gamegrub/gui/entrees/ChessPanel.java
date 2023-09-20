package gamegrub.gui.entrees;

import gamegrub.data.Item;
import gamegrub.data.entrees.Chess;
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
 * ChessPanel Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class ChessPanel extends EntreePanel {

    ParentPanel parent;
    Chess item;
    JCheckBox crispyChicken;
    JCheckBox redSauce;
    HashMap<Toppings, JCheckBox> toppingBoxes;

    /**
     * ChessPanel Constructor.
     *
     *<p>This method is used to extend the EntreePanel
     to give correct formatting to the GUI for the 
     provided ingredients of the entree and provides
     a check box for editing the menu item.
     *
     * @param parent Sets primary window as parent.
     */
    public ChessPanel(ParentPanel parent, Chess chess) {
        super(parent, chess);
        this.parent = parent;
        item = chess;
        crispyChicken = new JCheckBox("Crispy Chicken");
        crispyChicken.setSelected(item.getCrispyChicken());
        // GridBagConstraints crispyChickengbc = new GridBagConstraints();
        // crispyChickengbc.gridx = 0;
        // crispyChickengbc.gridy = 2;
        // crispyChickengbc.anchor = GridBagConstraints.LINE_START;
        // crispyChickengbc.insets = new Insets(2, 2, 2, 2);
        this.add(crispyChicken, this.makeGbc(gridynum++, true));

        redSauce = new JCheckBox("Red Sauce");
        redSauce.setSelected(item.getRedSauce());
        // GridBagConstraints redSaucegbc = new GridBagConstraints();
        // redSaucegbc.gridx = 0;
        // redSaucegbc.gridy = 3;
        // redSaucegbc.anchor = GridBagConstraints.LINE_START;
        // redSaucegbc.insets = new Insets(2, 2, 2, 2);
        this.add(redSauce, this.makeGbc(gridynum++, true));
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
            this.item.setCrispyChicken(this.crispyChicken.isSelected());
            this.item.setRedSauce(this.redSauce.isSelected());
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