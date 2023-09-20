package gamegrub.data.entrees;

import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Clue class.
 *
 * <p>This is the Chess class for the Chess Chicken Parmesan Entree
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Chess extends Entree {

    private boolean crispyChicken;
    private boolean redSauce;

    /**
     * Chess Contructor.
     *
     * <p>Sets default Base to SPAGHETTI with boolean values on default 
     ingredients to true, while possible but not default ingredients
     to false. Adds default Toppings to a new Hashset which keeps
     track of all toppings on item.
     */
    public Chess() {
        //this.base = Base.SPAGHETTI;
        this.setBase(Base.SPAGHETTI);
        this.crispyChicken = true;
        this.redSauce = true;
        //this.toppings = new HashSet<>();
        //this.toppings.add(Toppings.CHEESE);
        this.addTopping(Toppings.CHEESE);
        //this.toppings.add(Toppings.FRESH_HERBS);
        this.addTopping(Toppings.FRESH_HERBS);
    }

    /**
     * Getter for Price.
     *
     * <p>Gets the Base price of Chess Chicken Parmesan, checks to see if the 
     current base is an upcharge, calculates, and returns total
     *
     * @return  price of Chess Chicken Parm with provided Base as double
     */
    public double getPrice() {
        double total = 12.15;
        total += this.getBase().getValue();
        return total;
    }

    /**
     * Getter for Calories.
     *
     * <p>Gets the Calories of Chess Chicken Parmesan and returns total
     *
     * @return  Calories of Chess Chicken Parm 
     */
    public int getCalories() {
        return 1555;
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
     * SpecialInstructions for Chess Chicken Parmesan.
     *
     * <p>This is the SpecialInstructions for Chess Chicken Parmesan provided by
     the values of the attributes. It goes through each ingredient and adds
     special instructions as strings to a new linked list based on the value.
     *
     * @return  returns a linkedlist of strings added by the method
     */
    public LinkedList<String> getSpecialInstructions() {
        //LinkedList<String> specials = new LinkedList<>();
        LinkedList<String> specials = super.getSpecialInstructions();
        if (!this.crispyChicken) {
            specials.add("Hold Crispy Chicken");
        }
        if (!this.redSauce) {
            specials.add("Hold Red Sauce");
        }
        return specials;
    }

    /**
     * ToString Override.
     *
     * <p>Overrides the toString of Chess to return a string of Chess Chicken 
     Parmesan on the current provided Base attributes
     *
     * @return  toString of Chess with formatting to include Base provided
     */
    @Override
    public String toString() {
        return "Chess Chicken Parmesan on " + this.getBase();
    }

    /**
     * Get Name method.
     *
     * @return returns the name of the entree without base.
     */
    @Override
    public String getName() {
        return "Chess Chicken Parmesan";
    }

    /**
     * Equals Override.
     *
     * <p>Overrides the Equals to determine whether an input is an original instance of
     the Chess by compairing the provided values of attributes
     *
     * @param input instance of an object to see if it is an instance of Chess
     * @return  boolean value determining if it is an original instance of Chess
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Chess) {
            Chess other = (Chess) input;
            return this.getBase() == other.getBase()
                && this.crispyChicken == other.crispyChicken
                && this.redSauce == other.redSauce
                && this.getToppings().equals(other.getToppings());
        } else {
            return false;
        }
    }
}