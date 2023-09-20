package gamegrub.data.drinks;

import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Cranium class.
 *
 * <p>This is the Cranium class for the Cranium Coffee Drink
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Cranium extends Drink {

    private boolean milk;
    private boolean caramel;
    private boolean chocolate;
    private boolean mint;

    /**
     * Cranium Contructor.
     *
     * <p>Sets default size to Junior with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false.
     */
    public Cranium() {
        this.setSize(Size.JUNIOR);
        this.milk = true;
        this.caramel = false;
        this.chocolate = false;
        this.mint = false;
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the price of CraniumCoffee with the appropriate size and returns
     the correct value
     *
     * @return  price of CraniumCoffee as double
     */
    public double getPrice() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 5.25;
            }
            if (this.getSize() == Size.WINNER) {
                return 6.00;
            }
        }
        return 4.35;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of CraniumCoffee with the appropriate size and returns
     the correct amount
     *
     * @return  Calories of CraniumCoffee as integer
     */
    public int getCalories() {
        if (this.getSize() != Size.JUNIOR) {
            if (this.getSize() == Size.CLASSIC) {
                return 495;
            }
            if (this.getSize() == Size.WINNER) {
                return 585;
            }
        }
        return 380;
    }

    /**
     * Getter for Milk.
     *
     * <p>Gets the boolean value of true if it has milk and false if not
     *
     * @return  boolean value of milk
     */
    public boolean getMilk() {
        return this.milk;
    }

    /**
     * Setter for Milk.
     *
     * <p>Sets the value of milk to the provided boolean value
     *
     * @param value  boolean value for milk, True of include / false if exclude
     */
    public void setMilk(boolean value) {
        this.milk = value;
    }

    /**
     * Getter for Caramel.
     *
     * <p>Gets the boolean value of true if it has caramel and false if not
     *
     * @return  boolean value of caramel
     */
    public boolean getCaramel() {
        return this.caramel;
    }

    /**
     * Setter for Caramel.
     *
     * <p>Sets the value of caramel to the provided boolean value
     *
     * @param value  boolean value for caramel, True of include / false if exclude
     */
    public void setCaramel(boolean value) {
        this.caramel = value;
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
     * Getter for Mint.
     *
     * <p>Gets the boolean value of true if it has mint and false if not
     *
     * @return  boolean value of mint
     */
    public boolean getMint() {
        return this.mint;
    }

    /**
     * Setter for Mint.
     *
     * <p>Sets the value of mint to the provided boolean value
     *
     * @param value  boolean value for mint, True of include / false if exclude
     */
    public void setMint(boolean value) {
        this.mint = value;
    }

    /**
     * SpecialInstructions for CraniumCoffee.
     *
     * <p>This is the SpecialInstructions for the CraniumCoffee provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    @Override
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        if (!this.milk) {
            specials.add("Hold Milk");
        }
        if (this.caramel) {
            specials.add("Add Caramel");
        }
        if (this.chocolate) {
            specials.add("Add Chocolate");
        }
        if (this.mint) {
            specials.add("Add Mint");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Cranium to return a string of the description of drink
     prefixed with the appropriate size set
     *
     * @return  toString of Cranium with formatting to include size provided
     */
    @Override
    public String toString() {
        return "" + this.getSize() + " Cranium Coffee";
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the Drink without size.
     */
    @Override
    public String getName() {
        return "Cranium Coffee";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the CraniumCoffee
     *
     * @param input instance of an object to see if it is an instance of CraniumCoffee
     * @return  boolean value determining if it is an original instance of CraniumCoffee
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Cranium) {
            Cranium other = (Cranium) input;
            return this.getSize() == other.getSize()
                && this.milk == other.milk
                && this.caramel == other.caramel
                && this.chocolate == other.chocolate
                && this.mint == other.mint;
        } else {
            return false;
        }
    }
}