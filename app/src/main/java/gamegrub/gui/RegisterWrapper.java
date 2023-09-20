package gamegrub.gui;

import edu.ksu.cs.cc410.register.CashDenomination;
import edu.ksu.cs.cc410.register.CashDrawer;
import java.lang.Math;
import java.util.HashMap;
import javax.swing.JSpinner;

/**
 * RegisterWrapper class.
 */
public class RegisterWrapper {

    /**
     * Constructor for the RegisterWrapper.
     *
     *<p>This method takes the denominations received, the orderpanel, 
     the amountReceived from the customer, the change to give back, and 
     the total cost of the order. It handles the cashdrawer by inserting
     the denominations received and calculates the amount of change to give
     back with the appropriate number of denomination.
     *
     * @param receiving hashmap of values of each cashdenom received
     * @param op OrderPanel for required information
     * @param amountReceived amount of money added up from receiving
     * @param change amount of change to give back
     * @param total total cost of the order
     */
    public RegisterWrapper(HashMap<CashDenomination, Integer> receiving, 
                           OrderPanel op, double amountReceived, double change, double total) {
        double count = op.getRegister().getTotal();
        op.getRegister().open(total);

        // add received amount to the drawer
        for (CashDenomination c : CashDenomination.values()) {
            int value = receiving.get(c);
            op.getRegister().addCount(c, value);
        }

        

        // Handle Change Here 
        int fixedChange = (int) (change * 100);

        int hundred = (int) Math.floor(fixedChange / 10000);
        fixedChange = fixedChange - (10000 * hundred);
        op.getRegister().removeCount(CashDenomination.HUNDRED_DOLLAR_BILL, hundred);

        int fifty = (int) Math.floor(fixedChange / 5000);
        fixedChange = fixedChange - (5000 * fifty);
        op.getRegister().removeCount(CashDenomination.FIFTY_DOLLAR_BILL, fifty);

        int twenty = (int) Math.floor(fixedChange / 2000);
        fixedChange = fixedChange - (2000 * twenty);
        op.getRegister().removeCount(CashDenomination.TWENTY_DOLLAR_BILL, twenty);

        int ten = (int) Math.floor(fixedChange / 1000);
        fixedChange = fixedChange - (1000 * ten);
        op.getRegister().removeCount(CashDenomination.TEN_DOLLAR_BILL, ten);

        int five = (int) Math.floor(fixedChange / 500);
        fixedChange = fixedChange - (500 * five);
        op.getRegister().removeCount(CashDenomination.FIVE_DOLLAR_BILL, five);

        int dollar = (int) Math.floor(fixedChange / 100);
        fixedChange = fixedChange - (100 * dollar);
        op.getRegister().removeCount(CashDenomination.ONE_DOLLAR_BILL, dollar);

        int dollarcoin = (int) Math.floor(fixedChange / 100);
        fixedChange  = fixedChange - (100 * dollarcoin);
        op.getRegister().removeCount(CashDenomination.DOLLAR_COIN, dollarcoin);

        int fiftycent = (int) Math.floor(fixedChange / 50);
        fixedChange = fixedChange - (50 * fiftycent);
        op.getRegister().removeCount(CashDenomination.HALF_DOLLAR, fiftycent);

        int quarter = (int) Math.floor(fixedChange / 25);
        fixedChange = fixedChange - (25 * quarter);
        op.getRegister().removeCount(CashDenomination.QUARTER, quarter);

        int dime = (int) Math.floor(fixedChange / 10);
        fixedChange = fixedChange - (10 * dime);
        op.getRegister().removeCount(CashDenomination.DIME, dime);

        int nickel = (int) Math.floor(fixedChange / 5);
        fixedChange = fixedChange - (5 * nickel);
        op.getRegister().removeCount(CashDenomination.NICKEL, nickel);

        int penny = (int) Math.floor(fixedChange / 1);
        fixedChange = fixedChange - (1 * penny);
        op.getRegister().removeCount(CashDenomination.PENNY, penny);
        
        // while (fixedChange > 0) {
        //     if (fixedChange % 10000 != fixedChange) {
        //         fixedChange = fixedChange % 10000;
        //         op.getRegister().removeCount(CashDenomination.HUNDRED_DOLLAR_BILL, 1);
        //     } else if (fixedChange % 5000 != fixedChange) {
        //         fixedChange = fixedChange % 5000;
        //         op.getRegister().removeCount(CashDenomination.FIFTY_DOLLAR_BILL, 1);
        //     } else if (fixedChange % 2000 != fixedChange) {
        //         fixedChange = fixedChange % 2000;
        //         op.getRegister().removeCount(CashDenomination.TWENTY_DOLLAR_BILL, 1);
        //     } else if (fixedChange % 1000 != fixedChange) {
        //         fixedChange = fixedChange % 1000;
        //         op.getRegister().removeCount(CashDenomination.TEN_DOLLAR_BILL, 1);
        //     } else if (fixedChange % 500 != fixedChange) {
        //         fixedChange = fixedChange % 500;
        //         op.getRegister().removeCount(CashDenomination.FIVE_DOLLAR_BILL, 1);
        //     } else if (fixedChange % 100 != fixedChange) {
        //         fixedChange = fixedChange % 100;
        //         op.getRegister().removeCount(CashDenomination.ONE_DOLLAR_BILL, 1);
        //     } else if (fixedChange % 100 != fixedChange) {
        //         fixedChange = fixedChange % 100;
        //         op.getRegister().removeCount(CashDenomination.DOLLAR_COIN, 1);
        //     } else if (fixedChange % 50 != fixedChange) {
        //         fixedChange = fixedChange % 50;
        //         op.getRegister().removeCount(CashDenomination.HALF_DOLLAR, 1);
        //     } else if (fixedChange % 25 != fixedChange) {
        //         fixedChange = fixedChange % 25;
        //         op.getRegister().removeCount(CashDenomination.QUARTER, 1);
        //     } else if (fixedChange % 10 != fixedChange) {
        //         fixedChange = fixedChange % 10;
        //         op.getRegister().removeCount(CashDenomination.DIME, 1);
        //     } else if (fixedChange % 5 != fixedChange) {
        //         fixedChange = fixedChange % 5;
        //         op.getRegister().removeCount(CashDenomination.NICKEL, 1);
        //     } else if (fixedChange % 1 != fixedChange) {
        //         fixedChange = fixedChange % 1;
        //         op.getRegister().removeCount(CashDenomination.PENNY, 1);
        //     }
        // }


        op.getRegister().close();
        // for (CashDenomination denom : CashDenomination.values()) {
        //     System.out.println(denom.getValue() + " count :" + op.getRegister().getCount(denom));
        // }
    }
    
}