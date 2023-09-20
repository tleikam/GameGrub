package gamegrub.data.sides;

import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Dice class.
 *
 * <p>This is the Dice class for the Potato Dice Side
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Dice extends Side {

    /**
     * Constructor of Risk Side.
     *
     * <p>Sets the Dice Side to the appropriate default size of JUNIOR
     */
    public Dice() {
        this.setSize(Size.JUNIOR);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the price of Dice with the appropriate size and returns
     the correct value
     *
     * @return  price of Dice as double
     */
    public double getPrice() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 3.85;
            }
            if (this.getSize() == Size.WINNER) {
                return 5.35;
            }
        }
        return 2.75;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Dice with the appropriate size and returns
     the correct amount
     *
     * @return  Calories of Dice as integer
     */
    public int getCalories() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 475;
            }
            if (this.getSize() == Size.WINNER) {
                return 795;
            }
        }
        return 350;
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
     * <p>Overrides the toString of Dice to return a string of the description of side 
     prefixed with the appropriate size set
     *
     * @return  toString of Dice with formatting to include size provided
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " Potato Dice";
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the Side without size.
     */
    @Override
    public String getName() {
        return "Potato Dice";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Potato Dice
     *
     * @param input instance of an object to see if it is an instance of Potato Dice
     * @return  boolean value determining if it is an original instance of Potato Dice
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Dice) {
            Dice other = (Dice) input;
            return this.getSize() == other.getSize();
        } else {
            return false;
        }
    }
}