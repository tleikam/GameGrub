package gamegrub.data.entrees;

import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Jenga class.
 *
 * <p>This is the Jenga class for the Jenga Nachos Entree
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Jenga extends Entree {

    private boolean spicyBeef;
    private boolean beans;

    /**
     * Jenga Contructor.
     *
     * <p>Sets default Base to CHIPS with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false. Adds default Toppings to a new Hashset which keeps
     track of all toppings on item.
     */
    public Jenga() {
        //this.base = Base.CHIPS;
        this.setBase(Base.CHIPS);
        this.spicyBeef = true;
        this.beans = true;
        // this.toppings = new HashSet<>();
        // this.toppings.add(Toppings.ONIONS);
        // this.toppings.add(Toppings.CHEESE);
        // this.toppings.add(Toppings.SOUR_CREAM);
        // this.toppings.add(Toppings.HOT_SAUCE);
        // this.toppings.add(Toppings.GUACAMOLE);
        this.addTopping(Toppings.ONIONS);
        this.addTopping(Toppings.CHEESE);
        this.addTopping(Toppings.SOUR_CREAM);
        this.addTopping(Toppings.HOT_SAUCE);
        this.addTopping(Toppings.GUACAMOLE);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the Base price of Jenga Nachos, checks to see if the 
     current base is an upcharge, calculates, and returns total
     *
     * @return  price of Jenga Nachos with provided Base as double
     */
    public double getPrice() {
        double total = 9.85;
        total += this.getBase().getValue();
        return total;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Jenga Nachos and returns total
     *
     * @return  Calories of Jenga Nachos
     */
    public int getCalories() {
        return 1470;
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
     * SpecialInstructions for Jenga Nachos.
     *
     * <p>This is the SpecialInstructions for Jenga Nachos provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a new linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = super.getSpecialInstructions();
        if (!this.spicyBeef) {
            specials.add("Hold Spicy Beef");
        }
        if (!this.beans) {
            specials.add("Hold Beans");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Jenga to return a string of Jenga Nachos 
     on the current provided Base attributes
     *
     * @return  toString of Jenga with formatting to include Base provided
     */
    @Override
    public String toString() {
        return "Jenga Nachos on " + this.getBase();
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the entree without base.
     */
    @Override
    public String getName() {
        return "Jenga Nachos";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Jenga by compairing the provided values of attributes
     *
     * @param input instance of an object to see if it is an instance of Jenga
     * @return  boolean value determining if it is an original instance of Jenga
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Jenga) {
            Jenga other = (Jenga) input;
            return this.getBase() == other.getBase()
                && this.spicyBeef == other.spicyBeef
                && this.beans == other.beans
                && this.getToppings().equals(other.getToppings());
        } else {
            return false;
        }
    }
}