package gamegrub.data.entrees;

import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Monopoly class.
 *
 * <p>This is the Monopoly class for the Monopoly Bowl Entree
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Monopoly extends Entree {

    private boolean spicyBeef;
    private boolean crispyChicken;
    private boolean beans;
    private boolean veggies;

    /**
     * Monopoly Contructor.
     *
     * <p>Sets default Base to Rice with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false. Adds default Toppings to a new Hashset which keeps
     track of all toppings on item.
     */
    public Monopoly() {
        //this.base = Base.RICE;
        this.setBase(Base.RICE);
        this.spicyBeef = true;
        this.crispyChicken = true;
        this.beans = true;
        this.veggies = true;
        // this.toppings = new HashSet<>();
        // this.toppings.add(Toppings.ONIONS);
        // this.toppings.add(Toppings.CHEESE);
        // this.toppings.add(Toppings.HOT_SAUCE);
        // this.toppings.add(Toppings.SOUR_CREAM);
        // this.toppings.add(Toppings.GUACAMOLE);
        // this.toppings.add(Toppings.CRISPY_STRIPS);
        this.addTopping(Toppings.ONIONS);
        this.addTopping(Toppings.CHEESE);
        this.addTopping(Toppings.HOT_SAUCE);
        this.addTopping(Toppings.SOUR_CREAM);
        this.addTopping(Toppings.GUACAMOLE);
        this.addTopping(Toppings.CRISPY_STRIPS);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the Base price of Monopoly Bowl, checks to see if the 
     current base is an upcharge, calculates, and returns total
     *
     * @return  price of Monopoly Bowl with provided Base as double
     */
    public double getPrice() {
        double total = 17.65;
        total += this.getBase().getValue();
        return total;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Monopoly Bowl and returns total
     *
     * @return  Calories of Monopoly Bowl
     */
    public int getCalories() {
        return 1685;
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
     * Getter for crispyChicken.
     *
     * <p>Gets the boolean value of true if it has crispyChicken and false if not
     *
     * @return  boolean value of crispyChicken
     */
    public boolean getCrispyChicken() {
        return this.crispyChicken;
    }

    /**
     * Setter for crispyChicken.
     *
     * <p>Sets the value of crispyChicken to the provided boolean value
     *
     * @param value  boolean value for crispyChicken, True of include / false if exclude
     */
    public void setCrispyChicken(boolean value) {
        this.crispyChicken = value;
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
     * Getter for Veggies.
     *
     * <p>Gets the boolean value of true if it has veggies and false if not
     *
     * @return  boolean value of veggies
     */
    public boolean getVeggies() {
        return this.veggies;
    }

    /**
     * Setter for Veggies.
     *
     * <p>Sets the value of veggies to the provided boolean value
     *
     * @param value  boolean value for veggies, True of include / false if exclude
     */
    public void setVeggies(boolean value) {
        this.veggies = value;
    }

    /**
     * SpecialInstructions for Monopoly Bowl.
     *
     * <p>This is the SpecialInstructions for Monopoly Bowl provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a new linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = super.getSpecialInstructions();
        if (!this.crispyChicken) {
            specials.add("Hold Crispy Chicken");
        }
        if (!this.spicyBeef) {
            specials.add("Hold Spicy Beef");
        }
        if (!this.beans) {
            specials.add("Hold Beans");
        }
        if (!this.veggies) {
            specials.add("Hold Veggies");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Monopoly to return a string of Monopoly Bowl 
     on the current provided Base attributes
     *
     * @return  toString of Monopoly with formatting to include Base provided
     */
    @Override
    public String toString() {
        return "Monopoly Bowl on " + this.getBase();
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the entree without base.
     */
    @Override
    public String getName() {
        return "Monopoly Bowl";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Monopoly by compairing the provided values of attributes
     *
     * @param input instance of an object to see if it is an instance of Monopoly
     * @return  boolean value determining if it is an original instance of Monopoly
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Monopoly) {
            Monopoly other = (Monopoly) input;
            return this.getBase() == other.getBase()
                && this.spicyBeef == other.spicyBeef
                && this.crispyChicken == other.crispyChicken
                && this.beans == other.beans
                && this.veggies == other.veggies
                && this.getToppings().equals(other.getToppings());
        } else {
            return false;
        }
    }
}