package gamegrub.data.entrees;

import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Yahtzee class.
 *
 * <p>This is the Yahtzee class for the Yahtzee Poke Entree
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Yahtzee extends Entree {

    private boolean tuna;
    private boolean veggies;
    private boolean seaweed;

    /**
     * Yahtzee Contructor.
     *
     * <p>Sets default Base to Rice with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false. Adds default Toppings to a new Hashset which keeps
     track of all toppings on item.
     */
    public Yahtzee() {
        //this.base = Base.RICE;
        this.setBase(Base.RICE);
        this.tuna = true;
        this.veggies = true;
        this.seaweed = true;
        // this.toppings = new HashSet<>();
        // this.toppings.add(Toppings.GUACAMOLE);
        // this.toppings.add(Toppings.SOY_SAUCE);
        // this.toppings.add(Toppings.HOT_SAUCE);
        // this.toppings.add(Toppings.CRISPY_STRIPS);
        this.addTopping(Toppings.GUACAMOLE);
        this.addTopping(Toppings.SOY_SAUCE);
        this.addTopping(Toppings.HOT_SAUCE);
        this.addTopping(Toppings.CRISPY_STRIPS);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the Base price of Yahtzee Poke, checks to see if the 
     current base is an upcharge, calculates, and returns total
     *
     * @return  price of Yahtzee Poke with provided Base as double
     */
    public double getPrice() {
        double total = 14.25;
        total += this.getBase().getValue();
        return total;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Yahtzee Poke and returns total
     *
     * @return  Calories of Yahtzee Poke
     */
    public int getCalories() {
        return 785;
    }

    /**
     * Getter for Tuna.
     *
     * <p>Gets the boolean value of true if it has tuna and false if not
     *
     * @return  boolean value of tuna
     */
    public boolean getTuna() {
        return this.tuna;
    }

    /**
     * Setter for Tuna.
     *
     * <p>Sets the value of tuna to the provided boolean value
     *
     * @param value  boolean value for tuna, True of include / false if exclude
     */
    public void setTuna(boolean value) {
        this.tuna = value;
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
     * Getter for Seaweed.
     *
     * <p>Gets the boolean value of true if it has seaweed and false if not
     *
     * @return  boolean value of seaweed
     */
    public boolean getSeaweed() {
        return this.seaweed;
    }

    /**
     * Setter for Seaweed.
     *
     * <p>Sets the value of seaweed to the provided boolean value
     *
     * @param value  boolean value for seaweed, True of include / false if exclude
     */
    public void setSeaweed(boolean value) {
        this.seaweed = value;
    }

    /**
     * SpecialInstructions for Yahtzee Poke.
     *
     * <p>This is the SpecialInstructions for Yahtzee Poke provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a new linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = super.getSpecialInstructions();
        if (!this.tuna) {
            specials.add("Hold Tuna");
        }
        if (!this.veggies) {
            specials.add("Hold Veggies");
        }
        if (!this.seaweed) {
            specials.add("Hold Seaweed");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Yahtzee to return a string of Yahtzee Poke
     on the current provided Base attributes
     *
     * @return  toString of Yahtzee with formatting to include Base provided
     */
    @Override
    public String toString() {
        return "Yahtzee Poke on " + this.getBase();
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the entree without base.
     */
    @Override
    public String getName() {
        return "Yahtzee Poke";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Yahtzee by compairing the provided values of attributes
     *
     * @param input instance of an object to see if it is an instance of Yahtzee
     * @return  boolean value determining if it is an original instance of Yahtzee
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Yahtzee) {
            Yahtzee other = (Yahtzee) input;
            return this.getBase() == other.getBase()
                && this.tuna == other.tuna
                && this.veggies == other.veggies
                && this.seaweed == other.seaweed
                && this.getToppings().equals(other.getToppings());
        } else {
            return false;
        }
    }
}