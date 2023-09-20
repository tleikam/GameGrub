package gamegrub.gui;

import edu.ksu.cs.cc410.register.CashDenomination;
import gamegrub.data.order.Order;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * CashDialog Class.
 *
 *<p>This class provides a display in the gui to 
 insert how much cash would be provided from the 
 customer.
 */
public class CashDialog extends JDialog implements ActionListener {

    HashMap<CashDenomination, JSpinner> amounts;
    String data; 
    int gridx;
    int gridy;

    /**
     * Constructor for the CashDialog Class.
     *
     * @param parent Takes a JFrame parent and inserts display inside of it
     * @param order Takes current order to give the total of
     */
    public CashDialog(JFrame parent, Order order) {
        super(parent, "Cash Drawer", true);
        this.data = "Not Saved!";
        this.setSize(new Dimension(700, 500));
        this.amounts = new HashMap<>();

        this.setLayout(new GridBagLayout());
        GridBagConstraints cashgbc = new GridBagConstraints();
        cashgbc.gridx = 1;
        cashgbc.gridy = 0;
        cashgbc.weightx = 0.25;
        cashgbc.weighty = 0.25;
        cashgbc.anchor = GridBagConstraints.LINE_END;
        cashgbc.insets = new Insets(2, 2, 2, 2);
        JLabel cashLabel = new JLabel("Cash ");
        this.add(cashLabel, cashgbc);

        GridBagConstraints labelgbc = new GridBagConstraints();
        labelgbc.gridx = 2;
        labelgbc.gridy = 0;
        labelgbc.weightx = 0.25;
        labelgbc.weighty = 0.25;
        labelgbc.anchor = GridBagConstraints.LINE_START;
        labelgbc.insets = new Insets(2, 2, 2, 2);
        JLabel orderLabel = new JLabel("Given");
        this.add(orderLabel, labelgbc);

        GridBagConstraints totallabelgbc = new GridBagConstraints();
        totallabelgbc.gridx = 1;
        totallabelgbc.gridy = 1;
        totallabelgbc.weightx = 0.5;
        totallabelgbc.weighty = 0.5;
        totallabelgbc.anchor = GridBagConstraints.LINE_END;
        totallabelgbc.insets = new Insets(2, 2, 2, 2);
        JLabel totalLabel = new JLabel("Total $");
        this.add(totalLabel, totallabelgbc);

        GridBagConstraints totalamountgbc = new GridBagConstraints();
        totalamountgbc.gridx = 2;
        totalamountgbc.gridy = 1;
        totalamountgbc.weightx = 0.5;
        totalamountgbc.weighty = 0.5;
        labelgbc.anchor = GridBagConstraints.LINE_START;
        labelgbc.insets = new Insets(2, 2, 2, 2);
        JLabel amountLabel = new JLabel(String.format("%.2f", order.getTotalCost()));
        this.add(amountLabel, totalamountgbc);

        //---- BASE LABELS CREATED || ADD SPINNERS HERE ----
        gridx = 0;
        gridy = 8;
        for (CashDenomination c : CashDenomination.values()) {
            if (gridx == 1) {
                gridx = 0;
            } else if (gridx == 3) {
                gridx = 2;
            }
            if (gridy == 2) {
                gridy = 8;
                gridx = 2;
            }

            GridBagConstraints cgbc = new GridBagConstraints();
            cgbc.gridx = gridx;
            cgbc.gridy = gridy;
            cgbc.weightx = 0.5;
            cgbc.weighty = 0.5;
            cgbc.fill = GridBagConstraints.HORIZONTAL;
            cgbc.insets = new Insets(2, 2, 2, 2);
            JLabel clabel = new JLabel("    " + c.toString());
            this.add(clabel, cgbc);
            gridx += 1;

            GridBagConstraints spinnergbc = new GridBagConstraints();
            spinnergbc.gridx = gridx;
            spinnergbc.gridy = gridy;
            spinnergbc.weightx = 0.5;
            spinnergbc.weighty = 0.5;
            spinnergbc.fill = GridBagConstraints.HORIZONTAL;
            spinnergbc.insets = new Insets(2, 2, 2, 2);
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(
                                            0, 0, 
                                            (int) Double.POSITIVE_INFINITY, 1));
            this.add(spinner, spinnergbc);
            gridy -= 1;

            //amounts.put(c, (int) spinner.getValue());
            amounts.put(c, spinner);

            // for cash denom:
            // spinner s = amounts.get(c);
            // value = s.getValue();

        }

        // GridBagConstraints hundredgbc = new GridBagConstraints();
        // hundredgbc.gridx = 0;
        // hundredgbc.gridy = 2;
        // hundredgbc.weightx = 0.5;
        // hundredgbc.weighty = 0.5;
        // hundredgbc.fill = GridBagConstraints.HORIZONTAL;
        // hundredgbc.insets = new Insets(2, 2, 2, 2);
        // JLabel hundredLabel = new JLabel("$100");
        // this.add(hundredLabel, hundredgbc);

        // GridBagConstraints spinnergbc = new GridBagConstraints();
        // spinnergbc.gridx = 1;
        // spinnergbc.gridy = 2;
        // spinnergbc.weightx = 0.5;
        // spinnergbc.weighty = 0.5;
        // spinnergbc.fill = GridBagConstraints.HORIZONTAL;
        // spinnergbc.insets = new Insets(2, 2, 2, 2);
        // this.add(hundred, spinnergbc);

        // -------- ACTION EVENTS --------
        JButton save = new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);
        GridBagConstraints savegbc = new GridBagConstraints();
        savegbc.gridx = 1;
        savegbc.gridy = 9;
        savegbc.insets = new Insets(2, 2, 2, 2);
        savegbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(save, savegbc);

        JButton cancel = new JButton("Cancel");
        cancel.setActionCommand("cancel");
        cancel.addActionListener(this);
        GridBagConstraints cancelGbc = new GridBagConstraints();
        cancelGbc.gridx = 2;
        cancelGbc.gridy = 9;
        cancelGbc.insets = new Insets(2, 2, 2, 2);
        cancelGbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(cancel, cancelGbc);

        // -------- ADDTIONAL SPACER FOR BOTTOM OF CASH DIALOG POP OUT ------
        GridBagConstraints spacer = new GridBagConstraints();
        spacer.gridx = 0;
        spacer.gridy = 9 + 1;
        spacer.weightx = 0.2;
        spacer.weighty = 0.2;
        spacer.fill = GridBagConstraints.HORIZONTAL;
        spacer.insets = new Insets(2, 2, 2, 2);
        JLabel space = new JLabel("            ");
        this.add(space, spacer);
    }

    /**
     * getAmounts Method.
     *
     *<p>This class returns a hashmap for the provided
     cash denomination, and the value related to the spinner
     and returns it to the order panel.
     *
     * @return Hashmap of the provided cash values
     */
    public HashMap<CashDenomination, JSpinner> getAmounts() {
        return this.amounts;
    }

    /**
     * Action performed method.
     *
     *<p>This method simply just overrides the actionPerformed
     method to ensure the buttons in the display work correctly.
     *
     * @param event event to occur from pressing of button
     */
    public void actionPerformed(ActionEvent event) {
        if ("save".equals(event.getActionCommand())) {
            //amounts.forEach((k, v) -> System.out.println(k + " : " + (v)));
            this.data = "I got saved!";
            this.dispose();
        } else if ("cancel".equals(event.getActionCommand())) {
            this.amounts = null;
            this.dispose();
        }
    }

    /**
     * run method.
     *
     *<p>This method makes the display visible over the parent window
     and return the Hashmap of the CashDenom with value related to it.
     *
     * @return returns the values necessary to process transaction
     */
    public HashMap<CashDenomination, JSpinner> run() {
        this.setVisible(true);
        return this.amounts;
    }

}