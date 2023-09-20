package gamegrub.gui.entrees;

import gamegrub.data.Item;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Entree;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
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
 * Class for the EntreePanel of Gui.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class EntreePanel extends ItemPanel {

    protected ParentPanel parent;
    protected Entree entree;
    protected JComboBox<Base> base;
    protected int gridynum;
    HashMap<Toppings, JCheckBox> toppingBox;

    /**
     * EntreePanel Method.
     *
     *<p>This method designs the GUI to display
     the name of the entree of the selected button
     with the choice to edit the base, ingredients,
     and toppings of the provided Entree. This
     class is extended in subclasses to add
     more depth to the panel.
     *
     * @param parent panel parent set to primary window
     * @param anEntree Entree provided by subclass for customization
     */
    public EntreePanel(ParentPanel parent, Entree anEntree) {
        super();
        if (anEntree instanceof Clue) {
            this.entree = (Clue) anEntree;
        } else if (anEntree instanceof Chess) {
            this.entree = (Chess) anEntree;
        } else if (anEntree instanceof Jenga) {
            this.entree = (Jenga) anEntree;
        } else if (anEntree instanceof Monopoly) {
            this.entree = (Monopoly) anEntree;
        } else if (anEntree instanceof Yahtzee) {
            this.entree = (Yahtzee) anEntree;
        } else {
            throw new IllegalArgumentException();
        }

        gridynum = 0;
        toppingBox = new HashMap<>();
        this.parent = parent;

        this.setPreferredSize(new Dimension(724, 740));
        this.setLayout(new GridBagLayout());

        // GridBagConstraints titlegbc = new GridBagConstraints();
        // titlegbc.gridx = 0;
        // titlegbc.gridy = 0;
        // titlegbc.insets = new Insets(2, 2, 2, 2);
        JLabel title = new JLabel(entree.getName());
        //this.add(title, titlegbc);
        this.add(title, this.makeGbc(gridynum++, true));

        base = new JComboBox<>(Base.values());
        base.setSelectedItem(entree.getBase());
        // GridBagConstraints basegbc = new GridBagConstraints();
        // basegbc.gridx = 0;
        // basegbc.gridy = 1;
        // basegbc.anchor = GridBagConstraints.LINE_START;
        // basegbc.insets = new Insets(2, 2, 2, 2);
        this.add(base, this.makeGbc(gridynum++, true));

        int i = 2;
        if (entree instanceof Chess || entree instanceof Jenga) {
            i += 2;
        } else if (entree instanceof Yahtzee) {
            i += 3;
        } else if (entree instanceof Monopoly || entree instanceof Clue) {
            i += 4;
        }

        JLabel top = new JLabel("Toppings");
        this.add(top, this.makeGbc(i, true));
        i++;

        for (Toppings t : Toppings.values()) {
            JCheckBox check = new JCheckBox(t.toString());
            check.setSelected(entree.getToppings().contains(t));
            // GridBagConstraints checkgbc = new GridBagConstraints();
            // checkgbc.gridx = 0;
            // checkgbc.gridy = i;
            // i += 1;
            // checkgbc.anchor = GridBagConstraints.LINE_START;
            // checkgbc.insets = new Insets(2, 2, 2, 2);
            toppingBox.put(t, check);
            this.add(check, this.makeGbc(i, true));
            i++;
        }

        if (this.parent instanceof PrimaryWindow) {
            JButton save = new JButton("Save");
            save.setActionCommand("save");
            save.addActionListener(this);
            GridBagConstraints savegbc = new GridBagConstraints();
            savegbc.gridx = 0;
            savegbc.gridy = i;
            savegbc.insets = new Insets(2, 2, 2, 2);
            this.add(save, savegbc);

            JButton cancel = new JButton("Cancel");
            cancel.setActionCommand("cancel");
            cancel.addActionListener(this);
            GridBagConstraints cancelGbc = new GridBagConstraints();
            cancelGbc.gridx = 0;
            cancelGbc.gridy = i + 1;
            cancelGbc.insets = new Insets(2, 2, 2, 2);
            this.add(cancel, cancelGbc);
        }
    }

    /**
    * Construct a GridBagConstraints object.
    *
    * @param y the y coordinate of the object
    * @param start set anchor to LINE_START
    * @return the constructed GridBagConstraints object
    */
    protected GridBagConstraints makeGbc(int y, boolean start) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = y;
        if (start) {
            gbc.anchor = GridBagConstraints.LINE_START;
        }
        gbc.insets = new Insets(2, 2, 2, 2);
        return gbc;
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
            this.parent.loadMenuPanel();
        } else if ("cancel".equals(e.getActionCommand())) {
            parent.loadMenuPanel();
        }
    }
}