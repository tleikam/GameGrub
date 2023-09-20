package gamegrub.data.sides;

import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Risk class.
 *
 * <p>This is the Risk class for the Risk Bites Side
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Risk extends Side {

    /**
     * Constructor of Risk Side.
     *
     * <p>Sets the Risk Side to the appropriate default size of JUNIOR
     */
    public Risk() {
        this.setSize(Size.JUNIOR);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the price of Risk with the appropriate size and returns
     the correct value
     *
     * @return  price of Risk as double
     */
    public double getPrice() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 5.15;
            }
            if (this.getSize() == Size.WINNER) {
                return 6.95;
            }
        }
        return 3.95;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Risk with the appropriate size and returns
     the correct amount
     *
     * @return  Calories of Risk as integer
     */
    public int getCalories() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 755;
            }
            if (this.getSize() == Size.WINNER) {
                return 940;
            }
        }
        return 480;
    }

    /**
     * Returning empty list for base.
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> empty = new LinkedList<>();
        return empty;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Risk to return a string of the description of side 
     prefixed with the appropriate size set
     *
     * @return  toString of Risk with formatting to include size provided
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " Risk Bites";
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the Side without size.
     */
    @Override
    public String getName() {
        return "Risk Bites";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Risk Bites
     *
     * @param input instance of an object to see if it is an instance of Risk Bites
     * @return  boolean value determining if it is an original instance of Risk Bites
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Risk) {
            Risk other = (Risk) input;
            return this.getSize() == other.getSize();
        } else {
            return false;
        }
    }
}