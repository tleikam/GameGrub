package gamegrub.gui.sides;

import gamegrub.data.Item;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import gamegrub.gui.ItemPanel;
import gamegrub.gui.OrderPanel;
import gamegrub.gui.ParentPanel;
import gamegrub.gui.PrimaryWindow;
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
 * Class for the SidePanel of Gui.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class SidePanel extends ItemPanel {

    ParentPanel parent;
    Side side;
    JComboBox<Size> size;

    /**
     * SidePanel Method.
     *
     *<p>This method designs the GUI to display
     the name of the Side of the selected button
     with the choice to edit size of the provided 
     Side.
     *
     * @param parent panel parent set to primary window
     * @param aside Side provided for labeling
     */
    public SidePanel(ParentPanel parent, Side aside) {
        super();
        if (aside instanceof Catan) {
            this.side = (Catan) aside;
        } else if (aside instanceof Dice) {
            this.side = (Dice) aside;
        } else if (aside instanceof Risk) {
            this.side = (Risk) aside;
        } else {
            throw new IllegalArgumentException();
        }

        this.parent = parent;
        this.setPreferredSize(new Dimension(724, 740));
        this.setLayout(new GridBagLayout());

        String[] split = side.toString().split(" ");
        String labeled = "";
        for (int i = 1; i < split.length; i++) {
            labeled = labeled + split[i] + " ";
        }

        GridBagConstraints titlegbc = new GridBagConstraints();
        titlegbc.gridx = 0;
        titlegbc.gridy = 0;
        titlegbc.insets = new Insets(2, 2, 2, 2);
        JLabel title = new JLabel(labeled);
        this.add(title, titlegbc);

        size = new JComboBox<>(Size.values());
        size.setSelectedItem(side.getSize());
        GridBagConstraints sizegbc = new GridBagConstraints();
        sizegbc.gridx = 0;
        sizegbc.gridy = 1;
        sizegbc.anchor = GridBagConstraints.LINE_START;
        sizegbc.insets = new Insets(2, 2, 2, 2);
        this.add(size, sizegbc);

        if (this.parent instanceof PrimaryWindow) {
            JButton save = new JButton("Save");
            save.setActionCommand("save");
            save.addActionListener(this);
            GridBagConstraints savegbc = new GridBagConstraints();
            savegbc.gridx = 0;
            savegbc.gridy = 2;
            savegbc.insets = new Insets(2, 2, 2, 2);
            this.add(save, savegbc);
            
            JButton cancel = new JButton("Cancel");
            cancel.setActionCommand("cancel");
            cancel.addActionListener(this);
            GridBagConstraints cancelgbc = new GridBagConstraints();
            cancelgbc.gridx = 0;
            cancelgbc.gridy = 3;
            cancelgbc.insets = new Insets(2, 2, 2, 2);
            this.add(cancel, cancelgbc);
        }
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
            this.side.setSize((Size) this.size.getSelectedItem());
            parent.addItem(this.side);
            parent.loadMenuPanel();
        } else if ("cancel".equals(e.getActionCommand())) {
            parent.loadMenuPanel();
        }
    }
}