package gamegrub.gui.drinks;

import gamegrub.data.Item;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.ItemPanel;
import gamegrub.gui.OrderPanel;
import gamegrub.gui.ParentPanel;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.CandyPanel;
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
 * Class for the DrinkPanel of Gui.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class DrinksPanel extends ItemPanel {

    protected ParentPanel parent;
    private Drink drink;
    protected JComboBox<Size> size;
    protected int ynum;

    /**
     * DrinksPanel Method.
     *
     *<p>This method designs the GUI to display
     the name of the drink of the selected button
     with the choice to edit size and ingredients
     of the provided Drink. This class is extended 
     in subclasses to add more depth to the panel.
     *
     * @param parent panel parent set to primary window
     * @param adrink Droml provided by subclass for customization
     */
    public DrinksPanel(ParentPanel parent, Drink adrink) {
        super();
        if (adrink instanceof Candy) {
            drink = (Candy) adrink;
        } else if (adrink instanceof Cranium) {
            drink = (Cranium) adrink;
        } else if (adrink instanceof Sorry) {
            drink = (Sorry) adrink;
        } else {
            throw new IllegalArgumentException();
        }

        this.parent = parent;
        this.setPreferredSize(new Dimension(724, 740));
        this.setLayout(new GridBagLayout());
        ynum = 0;

        String[] split = adrink.toString().split(" ");
        String labeled = "";
        for (int i = 1; i < split.length; i++) {
            labeled = labeled + split[i] + " ";
        }

        JLabel title = new JLabel(labeled);
        this.add(title, this.makeGbc(ynum++, true));

        size = new JComboBox<>(Size.values());
        size.setSelectedItem(drink.getSize());
        this.add(size, this.makeGbc(ynum++, true));

        int i = 2;
        if (adrink instanceof Candy) {
            i = 5;
        } else {
            i = 6;
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
            i += 1;

            GridBagConstraints cancelGbc = new GridBagConstraints();
            cancelGbc.gridx = 0;
            cancelGbc.gridy = i;
            cancelGbc.insets = new Insets(2, 2, 2, 2);
            JButton cancel = new JButton("Cancel");
            cancel.setActionCommand("cancel");
            cancel.addActionListener(this);
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
            parent.loadMenuPanel();
        } else if ("cancel".equals(e.getActionCommand())) {
            parent.loadMenuPanel();
        }
    }
}