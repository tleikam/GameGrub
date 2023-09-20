package gamegrub.gui;

import gamegrub.data.Item;
import gamegrub.gui.MenuPanel;
import gamegrub.gui.OrderPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;

/**
 * PrimaryWindow class.
 *
 *<p>This is the PrimaryWindow to the GUI and
 is what will be used to display the panels
 and features provided in the GUI code.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class PrimaryWindow extends JFrame implements ParentPanel {

    private JPanel main;
    private OrderPanel sidebar;

    /**
     * PrimaryWindow Constructor.
     *
     *<p>This method creates a window in the Dimensions
     of 1024x740 pixels, titles the window 'gamegrub', 
     sets the layout, and close operations. It provides
     the window with a menu panel and a sidebar.
     */
    public PrimaryWindow() {
        this.setPreferredSize(new Dimension(1024, 740));
        this.setTitle("Game Grub");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.main = null;
        this.loadMenuPanel();

        this.sidebar = new OrderPanel(this);
        GridBagConstraints sidegbc = new GridBagConstraints();
        sidegbc.gridx = 1;
        sidegbc.gridy = 0;
        sidegbc.weighty = 1.0;
        sidegbc.weightx = 0.4;
        sidegbc.fill = GridBagConstraints.BOTH;
        sidegbc.insets = new Insets(10, 10, 10, 10);
        this.add(this.sidebar, sidegbc);

        this.pack();
    }

    /**
     * loadMenuPanel Class.
     *
     *<p>This method loads a new menu panel
     to display on the primary window of the 
     GUI.
     *
     */
    public void loadMenuPanel() {
        this.loadPanel(new MenuPanel(this));
    }

    /**
     * loadPanel Class.
     *
     *<p>This method sets the main panel on the 
     primary window to null if not already, and
     loads the desired panel provided as a 
     parameter into the window, then packs and
     repaints the primary window.
     *
     * @param panel desired panel to be loaded into the primary window
     */
    public void loadPanel(JPanel panel) {
        if (this.main != null) {
            this.remove(this.main);
        }
        this.main = panel;
        GridBagConstraints maingbc = new GridBagConstraints();
        maingbc.gridx = 0;
        maingbc.gridy = 0;
        maingbc.weighty = 1.0;
        maingbc.weightx = 1.0;
        maingbc.fill = GridBagConstraints.BOTH;
        maingbc.insets = new Insets(10, 10, 10, 10);
        this.add(this.main, maingbc);
        this.pack();
        this.repaint();
    }

    public void addItem(Item item) {
        this.sidebar.addItem(item);
    }
}