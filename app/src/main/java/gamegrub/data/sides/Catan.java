package gamegrub.data.sides;

import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Catan class.
 *
 * <p>This is the Catan class for the Catan Skewers Side
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Catan extends Side {

    /**
     * Constructor of Risk Side.
     *
     * <p>Sets the Catan Side to the appropriate default size of JUNIOR
     */
    public Catan() {
        this.setSize(Size.JUNIOR);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the price of Catan with the appropriate size and returns
     the correct value
     *
     * @return  price of Catan as double
     */
    public double getPrice() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 6.85;
            }
            if (this.getSize() == Size.WINNER) {
                return 8.65;
            }
        }
        return 4.45;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Catan with the appropriate size and returns
     the correct amount
     *
     * @return  Calories of Catan as integer
     */
    public int getCalories() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 815;
            }
            if (this.getSize() == Size.WINNER) {
                return 1045;
            }
        }
        return 530;
    }

    /*
     * Returning empty list for base.
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> empty = new LinkedList<>();
        return empty;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Catan to return a string of the description of side 
     prefixed with the appropriate size set
     *
     * @return  toString of Catan with formatting to include size provided
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " Catan Skewers";
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the Side without size.
     */
    @Override
    public String getName() {
        return "Catan Skewers";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Catan Skewers
     *
     * @param input instance of an object to see if it is an instance of Catan Skewers
     * @return  boolean value determining if it is an original instance of Catan Skewers
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Catan) {
            Catan other = (Catan) input;
            return this.getSize() == other.getSize();
        } else {
            return false;
        }
    }
}