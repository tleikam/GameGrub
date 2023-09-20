package gamegrub.data.entrees;

import gamegrub.data.Item;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * Abstract class for Entree.
 */
public abstract class Entree implements Item {

    private Base base;
    private HashSet<Toppings> toppings;

    /**
     * Constructor for an Entree.
     *
     *<p>The constructor creates a toppings list
     */
    public Entree() {
        this.toppings = new HashSet<>();
    }

    public abstract String getName();

    /**
     * Getter for the base.
     *
     * @return Base value for entree
     */
    public Base getBase() {
        return this.base;
    }

    /**
     * Setter for the base.
     *
     * @param value sets base value for entree
     */
    public void setBase(Base value) {
        this.base = value;
    }

    /**
     * Abstract getPrice method.
     */
    public abstract double getPrice();

    /**
     * Abstract getPrice method.
     */
    public abstract int getCalories();

    /**
     * Getter for a list of toppings.
     *
     * @return Hashset with toppings
     */
    public HashSet<Toppings> getToppings() {
        return new HashSet<Toppings>(this.toppings);
    }

    /**
     * Method to add topping.
     *
     * @param value The value represents a topping
     */
    public void addTopping(Toppings value) {
        if (!this.toppings.contains(value)) {
            this.toppings.add(value);
        }
    }

    /**
     * Method to remove topping.
     *
     * @param value The value represents a topping
     */
    public void removeTopping(Toppings value) {
        this.toppings.remove(value);
    }

    /**
     * Getter for special instructions.
     *
     * @return returns special instructions for toppings
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        for (Toppings t : this.toppings) {
            specials.add(t.toString());
        }
        return specials;
    }
}