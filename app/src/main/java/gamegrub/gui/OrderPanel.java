package gamegrub.gui;

import edu.ksu.cs.cc410.register.CardReader;
import edu.ksu.cs.cc410.register.CardTransactionResult;
import edu.ksu.cs.cc410.register.CashDenomination;
import edu.ksu.cs.cc410.register.CashDrawer;
import edu.ksu.cs.cc410.register.ReceiptPrinter;
import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Entree;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.menu.Menu;
import gamegrub.data.order.Order;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import gamegrub.gui.ComboPanel;
import gamegrub.gui.MenuPanel;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.ReceiptWrapper;
import gamegrub.gui.RegisterWrapper;
import gamegrub.gui.drinks.CandyPanel;
import gamegrub.gui.drinks.CraniumPanel;
import gamegrub.gui.drinks.SorryPanel;
import gamegrub.gui.entrees.ChessPanel;
import gamegrub.gui.entrees.CluePanel;
import gamegrub.gui.entrees.EntreePanel;
import gamegrub.gui.entrees.JengaPanel;
import gamegrub.gui.entrees.MonopolyPanel;
import gamegrub.gui.entrees.YahtzeePanel;
import gamegrub.gui.sides.SidePanel;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;


/**
 * OrderPanel Class.
 *
 *<p>This class creates a panel containing a list
 of all the items in an order with displaying
 order number, subtotal, tax, and total.
 *
 * @author Travis Leikam
 * @version 0.1
 */ 
public class OrderPanel extends JPanel implements ActionListener {

    private PrimaryWindow parent;
    private JLabel orderNumber;
    private Order order;
    // private JList<Item> orderList;
    private JTree orderList;
    private DefaultMutableTreeNode orderListRoot;
    private HashMap<DefaultMutableTreeNode, Item> items;
    static CashDrawer cashDrawer;
    JLabel subTotalAmountLabel;
    JLabel taxAmountLabel;
    JLabel totalamountLabel;
    GridBagConstraints listgbc;
    CardReader reader;
    ReceiptPrinter printer;
    HashMap<CashDenomination, JSpinner> output;
    

    /**
     * Constructor for the OrderPanel.
     *
     *<p>This method creates the OrderPanel to a panel size of 
     300, 740 pixels and assigns the PrimaryWindow as the
     parent. It first creates a label for the order number,
     then creates a list for all items in the order, followed
     by creating labels for subtotal, tax, and total cost.
     Also creates an 'Edit' button to edit the order if needed.
     *
     * @param parent assigns the primary window as the parent
     */
    public OrderPanel(PrimaryWindow parent) {
        this.parent = parent;
        this.setPreferredSize(new Dimension(300, 740));
        this.setLayout(new GridBagLayout());
        this.items = new HashMap<>();
        this.order = new Order();
        this.reader = new CardReader();
        this.cashDrawer = new CashDrawer();

        GridBagConstraints olabelgbc = new GridBagConstraints();
        olabelgbc.gridx = 0;
        olabelgbc.gridy = 0;
        olabelgbc.weightx = 0.5;
        olabelgbc.insets = new Insets(2, 2, 2, 2);
        JLabel orderLabel = new JLabel("Order #");
        this.add(orderLabel, olabelgbc);

        orderNumber = new JLabel("000");
        GridBagConstraints onumbergbc = new GridBagConstraints();
        onumbergbc.gridx = 1;
        onumbergbc.gridy = 0;
        onumbergbc.weightx = 0.5;
        onumbergbc.insets = new Insets(2, 2, 2, 2);
        onumbergbc.anchor = GridBagConstraints.LINE_START;
        this.add(orderNumber, onumbergbc);

        // orderList = new JList<>();
        // orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listgbc = new GridBagConstraints();
        listgbc.gridx = 0;
        listgbc.gridy = 1;
        listgbc.gridwidth = 2;
        listgbc.weightx = 1.0;
        listgbc.weighty = 1.0;
        listgbc.fill = GridBagConstraints.BOTH;

        orderListRoot = new DefaultMutableTreeNode("root");
        orderList = new JTree(orderListRoot);
        orderList.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        orderList.setRootVisible(false);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setOpenIcon(null);
        renderer.setClosedIcon(null);
        orderList.setCellRenderer(renderer);
        orderList.setShowsRootHandles(true);

        this.add(new JScrollPane(orderList), listgbc);

        GridBagConstraints editgbc = new GridBagConstraints();
        editgbc.gridx = 0;
        editgbc.gridy = 2;
        editgbc.weightx = 1.0;
        editgbc.fill = GridBagConstraints.HORIZONTAL;
        editgbc.insets = new Insets(2, 2, 2, 2);
        JButton editButton = new JButton("Edit");
        editButton.setActionCommand("edit");
        editButton.addActionListener(this);
        this.add(editButton, editgbc);

        GridBagConstraints deleteGbc = new GridBagConstraints();
        deleteGbc.gridx = 1;
        deleteGbc.gridy = 2;
        deleteGbc.fill = GridBagConstraints.BOTH;
        deleteGbc.weightx = 1.0;
        deleteGbc.insets = new Insets(2, 2, 2, 2);
        JButton delete = new JButton("Delete");
        delete.setActionCommand("delete");
        delete.addActionListener(this);
        this.add(delete, deleteGbc);

        GridBagConstraints subtotalgbc = new GridBagConstraints();
        subtotalgbc.gridx = 0;
        subtotalgbc.gridy = 3;
        subtotalgbc.weightx = 0.5;
        subtotalgbc.insets = new Insets(2, 2, 2, 2);
        subtotalgbc.anchor = GridBagConstraints.LINE_END;
        JLabel subTotalLabel = new JLabel("Subtotal $");
        this.add(subTotalLabel, subtotalgbc);

        GridBagConstraints subtotalamountgbc = new GridBagConstraints();
        subtotalamountgbc.gridx = 1;
        subtotalamountgbc.gridy = 3;
        subtotalamountgbc.weightx = 0.5;
        subtotalamountgbc.insets = new Insets(2, 2, 2, 2);
        subtotalamountgbc.anchor = GridBagConstraints.LINE_START;
        subTotalAmountLabel = new JLabel(String.format("%.2f", order.getSubTotal()));
        this.add(subTotalAmountLabel, subtotalamountgbc);

        GridBagConstraints taxgbc = new GridBagConstraints();
        taxgbc.gridx = 0;
        taxgbc.gridy = 4;
        taxgbc.weightx = 0.5;
        taxgbc.insets = new Insets(2, 2, 2, 2);
        taxgbc.anchor = GridBagConstraints.LINE_END;
        JLabel taxLabel = new JLabel("Tax $");
        this.add(taxLabel, taxgbc);

        GridBagConstraints taxamountgbc = new GridBagConstraints();
        taxamountgbc.gridx = 1;
        taxamountgbc.gridy = 4;
        taxamountgbc.weightx = 0.5;
        taxamountgbc.insets = new Insets(2, 2, 2, 2);
        taxamountgbc.anchor = GridBagConstraints.LINE_START;
        taxAmountLabel = new JLabel(String.format("%.2f", order.getTotalTax()));
        this.add(taxAmountLabel, taxamountgbc);

        GridBagConstraints totalgbc = new GridBagConstraints();
        totalgbc.gridx = 0;
        totalgbc.gridy = 5;
        totalgbc.weightx = 0.5;
        totalgbc.insets = new Insets(2, 2, 2, 2);
        totalgbc.anchor = GridBagConstraints.LINE_END;
        JLabel totalLabel = new JLabel("Total $");
        this.add(totalLabel, totalgbc);

        GridBagConstraints totalamountgbc = new GridBagConstraints();
        totalamountgbc.gridx = 1;
        totalamountgbc.gridy = 5;
        totalamountgbc.weightx = 0.5;
        totalamountgbc.insets = new Insets(2, 2, 2, 2);
        totalamountgbc.anchor = GridBagConstraints.LINE_START;
        totalamountLabel = new JLabel(String.format("%.2f", order.getTotalTax()));
        this.add(totalamountLabel, totalamountgbc);

        GridBagConstraints newOrdergbc = new GridBagConstraints();
        newOrdergbc.gridx = 0;
        newOrdergbc.gridy = 6;
        newOrdergbc.weightx = 1.0;
        // newOrdergbc.weighty = 1.0;
        newOrdergbc.insets = new Insets(2, 2, 2, 2);
        newOrdergbc.fill = GridBagConstraints.HORIZONTAL;
        JButton newOrderButton = new JButton("New Order");
        newOrderButton.setActionCommand("new order");
        newOrderButton.addActionListener(this);
        this.add(newOrderButton, newOrdergbc);

        GridBagConstraints checkoutgbc = new GridBagConstraints();
        checkoutgbc.gridx = 1;
        checkoutgbc.gridy = 6;
        checkoutgbc.weightx = 1.0;
        // checkoutgbc.weighty = 1.0;
        checkoutgbc.insets = new Insets(2, 2, 2, 2);
        checkoutgbc.fill = GridBagConstraints.HORIZONTAL;
        JButton checkoutbutton = new JButton("Checkout");
        checkoutbutton.setActionCommand("checkout");
        checkoutbutton.addActionListener(this);
        this.add(checkoutbutton, checkoutgbc);
    }

    /**
     * Override ActionPerformed.
     *
     *<p>This method overrides actionPerformed
     and provides functionality to the gui with
     items such as edit/delete.
     *
     * @param event Action event inside GUI
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand().toString());
        if ("edit".equals(event.getActionCommand())) {
            DefaultMutableTreeNode node = 
                    (DefaultMutableTreeNode) this.orderList.getLastSelectedPathComponent();
            if (node != null) {
                while (!this.items.containsKey(node)) {
                    node = (DefaultMutableTreeNode) node.getParent();
                }
                Item item = this.items.get(node);
                if (item instanceof Entree) {
                    if (item instanceof Chess) {
                        this.parent.loadPanel(new ChessPanel(this.parent, (Chess) item));
                    }
                    if (item instanceof Clue) {
                        this.parent.loadPanel(new CluePanel(this.parent, (Clue) item));
                    }
                    if (item instanceof Jenga) {
                        this.parent.loadPanel(new JengaPanel(this.parent, (Jenga) item));
                    }
                    if (item instanceof Monopoly) {
                        this.parent.loadPanel(new MonopolyPanel(this.parent, (Monopoly) item));
                    }
                    if (item instanceof Yahtzee) {
                        this.parent.loadPanel(new YahtzeePanel(this.parent, (Yahtzee) item));
                    }
                } else if (item instanceof Drink) {
                    if (item instanceof Candy) {
                        this.parent.loadPanel(new CandyPanel(this.parent, (Candy) item));
                    }
                    if (item instanceof Cranium) {
                        this.parent.loadPanel(new CraniumPanel(this.parent, (Cranium) item));
                    }
                    if (item instanceof Sorry) {
                        this.parent.loadPanel(new SorryPanel(this.parent, (Sorry) item));
                    }
                } else if (item instanceof Side) {
                    this.parent.loadPanel(new SidePanel(this.parent, (Side) item));
                } else if (item instanceof Combo) {
                    this.parent.loadPanel(new ComboPanel(this.parent, (Combo) item));
                }
            }
            updateLabel();
        } else if ("delete".equals(event.getActionCommand())) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode) this.orderList.getLastSelectedPathComponent();
            if (node != null) {
                while (!this.items.containsKey(node)) {
                    node = (DefaultMutableTreeNode) node.getParent();
                }
                Item item = this.items.get(node);
                this.order.removeItem(item);
                updateLabel();
                this.items.remove(node);
                this.orderListRoot.remove(node);
                ((DefaultTreeModel) this.orderList.getModel()).reload(this.orderListRoot);
                for (int i = 0; i < this.orderList.getRowCount(); i++) {
                    this.orderList.expandRow(i);
                }
            }
        }
        if ("checkout".equals(event.getActionCommand())) {
            String[] checkoutOptions = {"Cash", "Credit/Debit", "Cancel"};
            int n = JOptionPane.showOptionDialog(this.parent, "Cash or Credit/Debit?", 
                                                 "Checkout", JOptionPane.YES_NO_CANCEL_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE, null, 
                                                  checkoutOptions, checkoutOptions[2]);
            if (n == 0) {
                CashDialog dialog = new CashDialog(this.parent, this.order);
                output = dialog.run();
                double amountReceived = 0.0;
                HashMap<CashDenomination, Integer> fixedOutput = new HashMap<>();
                for (CashDenomination c : CashDenomination.values()) {
                    JSpinner spinner = output.get(c);
                    int value = (int) spinner.getValue();
                    fixedOutput.put(c, value);
                }
                if (output != null) {
                    for (CashDenomination c : CashDenomination.values()) {
                        JSpinner spinner = output.get(c);
                        int value = (int) spinner.getValue();
                        amountReceived += value * c.getValue();
                    }
                    if (amountReceived < this.order.getTotalCost()) {
                        JOptionPane.showMessageDialog(this.parent, "Not Enough Cash.", 
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (amountReceived >= this.order.getTotalCost()) {
                        double change = amountReceived - this.order.getTotalCost();
                        JOptionPane.showMessageDialog(this.parent, "Success \n Change Due: $"
                                                    + String.format("%.2f", change), 
                                                    "Cash Result", JOptionPane.INFORMATION_MESSAGE);
                        
                        // ************ PRINT RECEIPT ************
                        ReceiptWrapper recWrap = new ReceiptWrapper(this.order,
                                                                    true, amountReceived);
                        recWrap.printReceipt();

                        // Handle register
                        String floatingpointscaresme = String.format("%.2f", change);
                        double safeChange = Double.parseDouble(floatingpointscaresme);
                        String stotal = String.format("%.2f", this.order.getTotalCost());
                        double safeTotal = Double.parseDouble(stotal);
                        RegisterWrapper regWrap = new 
                                                RegisterWrapper(fixedOutput, 
                                                                this, amountReceived, 
                                                                safeChange, safeTotal);

                        // Finalize order and make new
                        this.order = new Order();
                        orderListRoot.removeAllChildren();
                        ((DefaultTreeModel) this.orderList.getModel()).reload(this.orderListRoot);
                        updateLabel();
                    }
                }
                


                
                
                
            } else if (n == 1) {
                CardTransactionResult result = this.reader.runCard();
                if (result == CardTransactionResult.APPROVED) {
                    JOptionPane.showMessageDialog(this.parent, result.toString(), 
                                                  "Success", JOptionPane.INFORMATION_MESSAGE);


                    // ************ PRINT RECEIPT ************
                    ReceiptWrapper creditReceipt = new ReceiptWrapper(this.order, false, 0.0);
                    creditReceipt.printReceipt();

                    // Finalize order and make new
                    this.order = new Order();
                    orderListRoot.removeAllChildren();
                    ((DefaultTreeModel) this.orderList.getModel()).reload(this.orderListRoot);
                    updateLabel();

                } else {
                    while (result != CardTransactionResult.APPROVED) {
                        String[] errorOptions = {"Yes", "No"};
                        int k = JOptionPane.showOptionDialog(
                                                    this.parent, result.toString()
                                                     + "\nTry Again?", 
                                                    "Error", JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.ERROR_MESSAGE, null,
                                                    errorOptions, errorOptions[1]);
                        if (k == 0) {
                            result = this.reader.runCard();
                            if (result == CardTransactionResult.APPROVED) {
                                JOptionPane.showMessageDialog(this.parent, result.toString(), 
                                                  "Success", JOptionPane.INFORMATION_MESSAGE);


                                // ************ PRINT RECEIPT ************
                                ReceiptWrapper creditReceipt = new ReceiptWrapper(this.order, 
                                                                                  false, 0.0);
                                creditReceipt.printReceipt();

                                // Finalize order and make new
                                this.order = new Order();
                                orderListRoot.removeAllChildren();
                                ((DefaultTreeModel) this.orderList.getModel()
                                                    ).reload(this.orderListRoot);
                                updateLabel();

                            }
                        } else if (k == 1) {
                            break;
                        }
                    }
                }
            }
        }
        if ("new order".equals(event.getActionCommand())) {
            String[] options = {"Yes", "Cancel"};
            int n = JOptionPane.showOptionDialog(this.parent, 
                                                 "This will erase the order, are you sure?",
                                                 "New Order", JOptionPane.OK_CANCEL_OPTION,
                                                 JOptionPane.QUESTION_MESSAGE, null,
                                                 options, options[1]);
            if (n == 0) {
                this.order = new Order();
                orderListRoot.removeAllChildren();
                ((DefaultTreeModel) this.orderList.getModel()).reload(this.orderListRoot);
                updateLabel();
            }
        }
        updateLabel();
    }

    /**
     * AddItem method.
     *
     *<p>This method adds an item to a tree
     if no value is present, or it updates
     the value if the item is already in
     the Tree.
     *
     * @param item item to check/add to tree
     */
    public void addItem(Item item) {
        for (HashMap.Entry<DefaultMutableTreeNode, Item> element : this.items.entrySet()) {
            if (item == element.getValue()) {
                System.out.println(item.toString());
                // for loop for special instructions add here
                this.updateTree(item, element.getKey());
                return;
            }
        }
        DefaultMutableTreeNode node = this.updateTree(item, null);
        this.items.put(node, item);
    }

    /**
     * updateTree Method.
     *
     *<p>This method checks to see if the node argument is null, and if it is, it
     creates a TreeNode and places it in the orderList. Adding special
     instructions to the item added to the orderList and expands
     the list provided.
     *
     * @param item item to add to the tree
     * @param node node to check if already in tree
     */
    public DefaultMutableTreeNode updateTree(Item item, DefaultMutableTreeNode node) {
        if (node == null) {
            this.order.addItem(item);
            updateLabel();
            if (!(item instanceof Combo)) {
                node = new DefaultMutableTreeNode(item);
            } else {
                Combo combo = (Combo) item;
                node = new DefaultMutableTreeNode("Combo");
            }
            this.orderListRoot.add(node);
        }
        node.removeAllChildren();
        if (!(item instanceof Combo)) {
            for (String s : item.getSpecialInstructions()) {
                DefaultMutableTreeNode instruct = new DefaultMutableTreeNode(s);
                instruct.setAllowsChildren(false);
                node.add(instruct);
            }
        } else {
            Combo combo = (Combo) item;
            if (combo.getEntreeInstance() != null) {
                Entree comboEntree = combo.getEntreeInstance();
                DefaultMutableTreeNode ent = new DefaultMutableTreeNode(
                                             combo.getEntreeInstance().getName());
                ent.setAllowsChildren(true);
                node.add(ent);
                for (String s : comboEntree.getSpecialInstructions()) {
                    DefaultMutableTreeNode instruct = new DefaultMutableTreeNode(s);
                    instruct.setAllowsChildren(false);
                    ent.add(instruct);
                }
            }
            if (combo.getSideInstance() != null) {
                Side comboSide = combo.getSideInstance();
                DefaultMutableTreeNode si = new DefaultMutableTreeNode(
                                            combo.getSideInstance().toString());
                si.setAllowsChildren(true);
                node.add(si);
                for (String s : comboSide.getSpecialInstructions()) {
                    DefaultMutableTreeNode instruct = new DefaultMutableTreeNode(s);
                    instruct.setAllowsChildren(false);
                    si.add(instruct);
                }
            }
            if (combo.getDrinkInstance() != null) {
                Drink comboDrink = combo.getDrinkInstance();
                DefaultMutableTreeNode drinky = new DefaultMutableTreeNode(
                                                combo.getDrinkInstance().toString());
                drinky.setAllowsChildren(true);
                node.add(drinky);
                for (String s : comboDrink.getSpecialInstructions()) {
                    DefaultMutableTreeNode instruct = new DefaultMutableTreeNode(s);
                    instruct.setAllowsChildren(false);
                    drinky.add(instruct);
                }
            }
        }
        
        ((DefaultTreeModel) this.orderList.getModel()).reload(this.orderListRoot);
        for (int i = 0; i < this.orderList.getRowCount(); i++) {
            this.orderList.expandRow(i);
        }
        return node;
    }

    /**
     * updateLabel method.
     *
     *<p>This method is used to update the labels to the correct amount
     after items are added, removed, or modified in the order.
     */
    public void updateLabel() {
        this.subTotalAmountLabel.setText(String.format("%.2f", this.order.getSubTotal()));
        this.taxAmountLabel.setText(String.format("%.2f", this.order.getTotalTax()));
        this.totalamountLabel.setText(String.format("%.2f", this.order.getTotalCost()));
        this.orderNumber.setText(this.order.getOrderNumber() + "");
    }

    /**
     * getRegister method.
     *
     *<p>Getter for register attribute
     *
     * @return cashDrawer
     */
    public CashDrawer getRegister() {
        return this.cashDrawer;
    }
}