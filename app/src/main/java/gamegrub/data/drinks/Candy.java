package gamegrub.data.drinks;

import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Candy class.
 *
 * <p>This is the Candy class for the CandyLandShake Drink
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Candy extends Drink {

    private boolean chocolate;
    private boolean vanilla;
    private boolean strawberry;

    /**
     * Candy Contructor.
     *
     * <p>Sets default size to Junior with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false.
     */
    public Candy() {
        this.setSize(Size.JUNIOR);
        this.chocolate = true;
        this.vanilla = false;
        this.strawberry = false;
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the price of CandyLandShake with the appropriate size and returns
     the correct value
     *
     * @return  price of CandyLandShake as double
     */
    public double getPrice() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 7.45;
            }
            if (this.getSize() == Size.WINNER) {
                return 9.55;
            }
        }
        return 5.75;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of CandyLandShake with the appropriate size and returns
     the correct amount
     *
     * @return  Calories of CandyLandShake as integer
     */
    public int getCalories() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 1215;
            }
            if (this.getSize() == Size.WINNER) {
                return 1465;
            }
        }
        return 770;
    }

    /**
     * Getter for Chocolate.
     *
     * <p>Gets the boolean value of true if it has chocolate and false if not
     *
     * @return  boolean value of chocolate
     */
    public boolean getChocolate() {
        return this.chocolate;
    }

    /**
     * Setter for Chocolate.
     *
     * <p>Sets the value of chocolate to the provided boolean value
     *
     * @param value  boolean value for chocolate, True of include / false if exclude
     */
    public void setChocolate(boolean value) {
        this.chocolate = value;
    }

    /**
     * Getter for Vanilla.
     *
     * <p>Gets the boolean value of true if it has vanilla and false if not
     *
     * @return  boolean value of vanilla
     */
    public boolean getVanilla() {
        return this.vanilla;
    }

    /**
     * Setter for Vanilla.
     *
     * <p>Sets the value of vanilla to the provided boolean value
     *
     * @param value  boolean value for vanilla, True of include / false if exclude
     */
    public void setVanilla(boolean value) {
        this.vanilla = value;
    }

    /**
     * Getter for Strawberry.
     *
     * <p>Gets the boolean value of true if it has strawberry and false if not
     *
     * @return  boolean value of strawberry
     */
    public boolean getStrawberry() {
        return this.strawberry;
    }

    /**
     * Setter for Strawberry.
     *
     * <p>Sets the value of strawberry to the provided boolean value
     *
     * @param value  boolean value for strawberry, True of include / false if exclude
     */
    public void setStrawberry(boolean value) {
        this.strawberry = value;
    }

    /**
     * SpecialInstructions for CandyLandShake.
     *
     * <p>This is the SpecialInstructions for the CandyLandShake provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    @Override
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        if (!this.chocolate) {
            specials.add("Hold Chocolate");
        }
        if (this.vanilla) {
            specials.add("Add Vanilla");
        }
        if (this.strawberry) {
            specials.add("Add Strawberry");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Candy to return a string of the description of drink
     prefixed with the appropriate size set
     *
     * @return  toString of Candy with formatting to include size provided
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " Candy Land Shake";
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the Drink without size.
     */
    @Override
    public String getName() {
        return "Candy Land Shake";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the CandyLandShake
     *
     * @param input instance of an object to see if it is an instance of CandyLandShake
     * @return  boolean value determining if it is an original instance of CandyLandShake
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Candy) {
            Candy other = (Candy) input;
            return this.getSize() == other.getSize()
                && this.chocolate == other.chocolate
                && this.vanilla == other.vanilla
                && this.strawberry == other.strawberry;
        } else {
            return false;
        }
    }
}