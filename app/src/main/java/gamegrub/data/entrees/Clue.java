package gamegrub.data.entrees;

import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Clue class.
 *
 * <p>This is the Clue class for the ClueChili Entree
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Clue extends Entree {

    private boolean spicyBeef;
    private boolean chili;
    private boolean redSauce;
    private boolean beans;

    /**
     * Clue Contructor.
     *
     * <p>Sets default Base to SPAGHETTI with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false. Adds default Toppings to a new Hashset which keeps
     track of all toppings on item.
     */
    public Clue() {
        //this.base = Base.SPAGHETTI;
        this.setBase(Base.SPAGHETTI);
        this.spicyBeef = true;
        this.chili = true;
        this.redSauce = true;
        this.beans = true;
        // this.toppings = new HashSet<>();
        // this.toppings.add(Toppings.ONIONS);
        // this.toppings.add(Toppings.CHEESE);
        // this.toppings.add(Toppings.HOT_SAUCE);
        this.addTopping(Toppings.CHEESE);
        this.addTopping(Toppings.ONIONS);
        this.addTopping(Toppings.HOT_SAUCE);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the Base price of Clue Chili, checks to see if the 
     current base is an upcharge, calculates, and returns total
     *
     * @return  price of Clue Chili with provided Base as double
     */
    public double getPrice() {
        double total = 8.95;
        total += this.getBase().getValue();
        return total;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Clue Chili and returns total
     *
     * @return  Calories of Clue Chili
     */
    public int getCalories() {
        return 1165;
    }

    /**
     * Getter for spicyBeef.
     *
     * <p>Gets the boolean value of true if it has spicyBeef and false if not
     *
     * @return  boolean value of spicyBeef
     */
    public boolean getSpicyBeef() {
        return this.spicyBeef;
    }

    /**
     * Setter for spicyBeef.
     *
     * <p>Sets the value of spicyBeef to the provided boolean value
     *
     * @param value  boolean value for spicyBeef, True of include / false if exclude
     */
    public void setSpicyBeef(boolean value) {
        this.spicyBeef = value;
    }

    /**
     * Getter for Chili.
     *
     * <p>Gets the boolean value of true if it has chili and false if not
     *
     * @return  boolean value of chili
     */
    public boolean getChili() {
        return this.chili;
    }

    /**
     * Setter for Chili.
     *
     * <p>Sets the value of chili to the provided boolean value
     *
     * @param value  boolean value for chili, True of include / false if exclude
     */
    public void setChili(boolean value) {
        this.chili = value;
    }

    /**
     * Getter for redSauce.
     *
     * <p>Gets the boolean value of true if it has redSauce and false if not
     *
     * @return  boolean value of redSauce
     */
    public boolean getRedSauce() {
        return this.redSauce;
    }

    /**
     * Setter for redSauce.
     *
     * <p>Sets the value of redSauce to the provided boolean value
     *
     * @param value  boolean value for redSauce, True of include / false if exclude
     */
    public void setRedSauce(boolean value) {
        this.redSauce = value;
    }

    /**
     * Getter for Beans.
     *
     * <p>Gets the boolean value of true if it has beans and false if not
     *
     * @return  boolean value of beans
     */
    public boolean getBeans() {
        return this.beans;
    }

    /**
     * Setter for Beans.
     *
     * <p>Sets the value of beans to the provided boolean value
     *
     * @param value  boolean value for beans, True of include / false if exclude
     */
    public void setBeans(boolean value) {
        this.beans = value;
    }

    /**
     * SpecialInstructions for Clue Chili.
     *
     * <p>This is the SpecialInstructions for Clue Chili provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a new linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    public LinkedList<String> getSpecialInstructions() {
        //LinkedList<String> specials = new LinkedList<>();
        LinkedList<String> specials = super.getSpecialInstructions();
        if (!this.spicyBeef) {
            specials.add("Hold Spicy Beef");
        }
        if (!this.chili) {
            specials.add("Hold Chili");
        }
        if (!this.redSauce) {
            specials.add("Hold Red Sauce");
        }
        if (!this.beans) {
            specials.add("Hold Beans");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Clue to return a string of Clue Chili 
     on the current provided Base attributes
     *
     * @return  toString of Clue with formatting to include Base provided
     */
    @Override
    public String toString() {
        return "Clue Chili on " + this.getBase();
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the entree without base.
     */
    @Override
    public String getName() {
        return "Clue Chili";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Clue by compairing the provided values of attributes
     *
     * @param input instance of an object to see if it is an instance of Clue
     * @return  boolean value determining if it is an original instance of Clue
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Clue) {
            Clue other = (Clue) input;
            return this.getBase() == other.getBase()
                && this.spicyBeef == other.spicyBeef
                && this.chili == other.chili
                && this.redSauce == other.redSauce
                && this.beans == other.beans
                && this.getToppings().equals(other.getToppings());
        } else {
            return false;
        }
    }
}