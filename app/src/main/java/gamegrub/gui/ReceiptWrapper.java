package gamegrub.gui;

import edu.ksu.cs.cc410.register.ReceiptPrinter;
import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
import gamegrub.data.drinks.Drink;
import gamegrub.data.entrees.Entree;
import gamegrub.data.order.Order;
import gamegrub.data.sides.Side;
import java.io.IOException;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ReceiptWrapper class.
 */
public class ReceiptWrapper {

    ReceiptPrinter rp;
    Order order;
    double received;
    boolean cash;

    /**
     * ReceiptWrapper constructor.
     *
     * @param order takes in the current order
     * @param cash Boolean of if order was paid for in cash
     * @param received amount of cash Given
     */
    public ReceiptWrapper(Order order, boolean cash, double received) {
        try {
            rp = new ReceiptPrinter();
            this.order = order;
            this.received = received;
            this.cash = cash;
        } catch (IOException e) {
            System.out.println("No file accessable");
        }
    }

    /**
     * printReceipt method.
     *
     *<p>This method takes all the parameters from the constructor
     and uses the imported receipt printer class to print to a txt 
     file all the information related to the order transaction.
     */
    public void printReceipt() {
        try {
            // open new receipt
            rp.startReceipt();

            // start printing each line of receipt information 
            rp.printLine("ORDER #" + this.order.getOrderNumber() + "\n");
            
            // ----------- PRINT ALL ITEMS, PRICE, AND SPECIALS -----
            String items = "";
            for (int i = 0; i < this.order.size(); i++) {
                Item item = this.order.get(i);
                if (item instanceof Combo) {
                    Combo combo = (Combo) item;
                    rp.printLine(combo.getPrice() + "  " + combo.getName());
                    if (combo.getEntreeInstance() != null) {
                        rp.printLine("       " + combo.getEntreeInstance().getName());
                        for (String instruct : combo.getEntreeInstance().getSpecialInstructions()) {
                            rp.printLine("         -" + instruct);
                        }
                        rp.printLine(" ");
                    }
                    if (combo.getSideInstance() != null) {
                        rp.printLine("       " + combo.getSideInstance().toString());
                        for (String instruct : combo.getSideInstance().getSpecialInstructions()) {
                            rp.printLine("         -" + instruct);
                        }
                        rp.printLine(" ");
                    }
                    if (combo.getDrinkInstance() != null) {
                        rp.printLine("       " + combo.getDrinkInstance().toString());
                        for (String instruct : combo.getDrinkInstance().getSpecialInstructions()) {
                            rp.printLine("         -" + instruct);
                        }
                        rp.printLine(" ");
                    }
                } else {
                    if (item instanceof Entree) {
                        Entree entree = (Entree) item;
                        rp.printLine(entree.getPrice() + "  " + entree.getName());
                        for (String instruct : entree.getSpecialInstructions()) {
                            rp.printLine("       -" + instruct);
                        }
                        rp.printLine(" ");
                    }
                    if (item instanceof Side) {
                        Side side = (Side) item;
                        rp.printLine(side.getPrice() + "  " + side.toString());
                        for (String instruct : side.getSpecialInstructions()) {
                            rp.printLine("       -" + instruct);
                        }
                        rp.printLine(" ");
                    }
                    if (item instanceof Drink) {
                        Drink drink = (Drink) item;
                        rp.printLine(drink.getPrice() + "  " + drink.toString());
                        for (String instruct : drink.getSpecialInstructions()) {
                            rp.printLine("         -" + instruct);
                        }
                        rp.printLine(" ");
                    }
                }
            }



            // print subtotal, tax amount, and total amount
            String divider = "";
            for (int i = 0; i < 40; i++) {
                if (i < 10 || i >= 30) {
                    divider += " ";
                } else {
                    divider += "*";
                }
            }
            rp.printLine(divider);
            rp.printLine("Subtotal: $" + String.format("%.2f", this.order.getSubTotal()));
            rp.printLine("Tax: $" + String.format("%.2f", this.order.getTotalTax()));
            rp.printLine("Total: $" + String.format("%.2f", this.order.getTotalCost()));
            rp.printLine("----------");
            if (cash) {
                rp.printLine("Paid with Cash: $" + String.format("%.2f", this.received));
                rp.printLine("Change Due: $" + (String.format("%.2f", 
                                                (this.received - this.order.getTotalCost()))));
            } else {
                rp.printLine("Paid with Credit/Debit");
            }
            // close out receipt and close the writer
            rp.endReceipt();
            rp.close();
        } catch (IOException e) {
            System.out.println("No available file to reference to");
        } catch (IllegalArgumentException e) {
            System.out.println("Line too long");
        } catch (IllegalStateException e) {
            System.out.println("Receipt not in correct state");
        }
    }

}