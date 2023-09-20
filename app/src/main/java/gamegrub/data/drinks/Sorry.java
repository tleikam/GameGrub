package gamegrub.data.drinks;

import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Sorry class.
 *
 * <p>This is the Sorry class for the Sorry Soda Drink
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Sorry extends Drink {

    private boolean cola;
    private boolean cherry;
    private boolean grape;
    private boolean orange;

    /**
     * Sorry Contructor.
     *
     * <p>Sets default size to Junior with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false.
     */
    public Sorry() {
        this.setSize(Size.JUNIOR);
        this.cola = true;
        this.cherry = false;
        this.grape = false;
        this.orange = false;
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the price of SorrySoda with the appropriate size and returns
     the correct value
     *
     * @return  price of SorrySoda as double
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
        return 2.55;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of SorrySoda with the appropriate size and returns
     the correct amount
     *
     * @return  Calories of SorrySoda as integer
     */
    public int getCalories() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 535;
            }
            if (this.getSize() == Size.WINNER) {
                return 765;
            }
        }
        return 370;
    }

    /**
     * Getter for Cola.
     *
     * <p>Gets the boolean value of true if it has cola and false if not
     *
     * @return  boolean value of cola
     */
    public boolean getCola() {
        return this.cola;
    }

    /**
     * Setter for Cola.
     *
     * <p>Sets the value of cola to the provided boolean value
     *
     * @param value  boolean value for cola, True of include / false if exclude
     */
    public void setCola(boolean value) {
        this.cola = value;
    }

    /**
     * Getter for Cherry.
     *
     * <p>Gets the boolean value of true if it has cherry and false if not
     *
     * @return  boolean value of cherry
     */
    public boolean getCherry() {
        return this.cherry;
    }

    /**
     * Setter for Cherry.
     *
     * <p>Sets the value of cherry to the provided boolean value
     *
     * @param value  boolean value for cherry, True of include / false if exclude
     */
    public void setCherry(boolean value) {
        this.cherry = value;
    }

    /**
     * Getter for Grape.
     *
     * <p>Gets the boolean value of true if it has grape and false if not
     *
     * @return  boolean value of grape
     */
    public boolean getGrape() {
        return this.grape;
    }

    /**
     * Setter for Grape.
     *
     * <p>Sets the value of grape to the provided boolean value
     *
     * @param value  boolean value for grape, True of include / false if exclude
     */
    public void setGrape(boolean value) {
        this.grape = value;
    }

    /**
     * Getter for Orange.
     *
     * <p>Gets the boolean value of true if it has orange and false if not
     *
     * @return  boolean value of orange
     */
    public boolean getOrange() {
        return this.orange;
    }

    /**
     * Setter for Orange.
     *
     * <p>Sets the value of orange to the provided boolean value
     *
     * @param value  boolean value for orange, True of include / false if exclude
     */
    public void setOrange(boolean value) {
        this.orange = value;
    }

    /**
     * SpecialInstructions for SorrySoda.
     *
     * <p>This is the SpecialInstructions for the SorrySoda provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    @Override
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        if (!this.cola) {
            specials.add("Hold Cola");
        }
        if (this.cherry) {
            specials.add("Add Cherry");
        }
        if (this.grape) {
            specials.add("Add Grape");
        }
        if (this.orange) {
            specials.add("Add Orange");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Sorry to return a string of the description of drink
     prefixed with the appropriate size set
     *
     * @return  toString of Sorry with formatting to include size provided
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " Sorry Soda";
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the Drink without size.
     */
    @Override
    public String getName() {
        return "Sorry Soda";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the SorrySoda
     *
     * @param input instance of an object to see if it is an instance of SorrySoda
     * @return  boolean value determining if it is an original instance of SorrySoda
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Sorry) {
            Sorry other = (Sorry) input;
            return this.getSize() == other.getSize()
                && this.cola == other.cola
                && this.cherry == other.cherry
                && this.grape == other.grape
                && this.orange == other.orange;
        } else {
            return false;
        }
    }
}