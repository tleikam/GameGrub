package gamegrub.data.combo;

import gamegrub.data.Item;
import gamegrub.data.drinks.Drink;
import gamegrub.data.entrees.Entree;
import gamegrub.data.sides.Side;
import java.util.LinkedList;

/**
 * Class used for creating a combo.
 *
 *<p>This class takes 3 items: entree, side, and drink
 and checks to see if the given items are an available 
 combo provided
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class Combo implements Item {

    private String name;
    private Entree entreeInstance;
    private Side sideInstance;
    private Drink drinkInstance;
    private static double discount = .80;

    /**
     * Constructor for combo if name is provided.
     *
     * @param name name of the combo
     */
    public Combo(String name) {
        if (name.length() != 0) {
            ComboBuilder build = new ComboBuilder();
            Combo combo = build.comboBuilder(name);
            // this.name = combo.getName();
            this.name = name;
            this.entreeInstance = combo.getEntreeInstance();
            this.sideInstance = combo.getSideInstance();
            this.drinkInstance = combo.getDrinkInstance();
        } else {
            this.name = "Custom Combo";
            this.entreeInstance = null;
            this.sideInstance = null;
            this.drinkInstance = null;
        }
    }

    /**
     * Constructor for combo if name isn't provided.
     */
    public Combo() {
        this.name = "Custom Combo";
        this.entreeInstance = null;
        this.sideInstance = null;
        this.drinkInstance = null;
    }

    /**
     * Getter for combo items.
     *
     * @return LinkedList containing all signature combos
     */
    public LinkedList<Item> getComboItems() {
        LinkedList<Item> comboItems = new LinkedList<>();
        if (this.entreeInstance != null) {
            comboItems.add(this.getEntreeInstance());
        }
        if (this.sideInstance != null) {
            comboItems.add(this.getSideInstance());
        }
        if (this.drinkInstance != null) {
            comboItems.add(this.getDrinkInstance());
        }
        return comboItems;
    }

    /** 
     * Getter for name of the combo.
     *
     * @return  Name for combo
     */
    public String getName() {
        return this.name;
    }

    /** 
     * Setter for name of the combo.
     *
     * @param name Name to set for combo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for EntreeInstance.
     *
     * <p>Gets the Current entreeInstance and returns it
     *
     * @return  current entreeInstance
     */
    public Entree getEntreeInstance() {
        return this.entreeInstance;
    }

    /**
     * Setter for EntreeInstance.
     *
     * <p>Sets the entreeInstance to the provided parameter
     *
     * @param entree Value to set the EntreeInstance to
     */
    public void setEntreeInstance(Entree entree) {
        this.entreeInstance = entree;
    }

    /**
     * Getter for side instance.
     *
     * <p>Gets the Current side instance and returns it
     *
     * @return  current sideInstance
     */
    public Side getSideInstance() {
        return this.sideInstance;
    }

    /**
     * Setter for SideInstance.
     *
     * <p>Sets the SideInstance to the provided parameter
     *
     * @param side Value to set the SideInstance to
     */
    public void setSideInstance(Side side) {
        this.sideInstance = side;
    }

    /**
     * Getter for drink instance.
     *
     * <p>Gets the Current drink instance and returns it
     *
     * @return  current drinkInstance
     */
    public Drink getDrinkInstance() {
        return this.drinkInstance;
    }

    /**
     * Setter for drinkInstance.
     *
     * <p>Sets the drinkInstance to the provided parameter
     *
     * @param drink Value to set the drinkInstance to
     */
    public void setDrinkInstance(Drink drink) {
        this.drinkInstance = drink;
    }

    /**
     * Getter for discount.
     *
     * <p>Gets the Current double value for the discount value
     *
     * @return  current discount value
     */
    public static double getDiscount() {
        return discount;
    } 

    /**
     * Setter for discount.
     *
     * <p>Sets the discount value to the provided parameter
     *
     * @param amount Value to set the discount to
     */
    public static void setDiscount(double amount) {
        if (amount < 0.0) {
            throw new IllegalArgumentException();
        }
        discount = amount;
    }

    /**
     * Getter for the Price of a combo.
     *
     *<p>This method calculates the price of all instances
     in the combo, and no value provided is null, applies 
     a discount to the total prices.
     *
     * @return The price of the combo
     */
    public double getPrice() {
        double total = 0.0;
        if (this.entreeInstance != null) {
            total += entreeInstance.getPrice();
        }
        if (this.sideInstance != null) {
            total += sideInstance.getPrice();
        }
        if (this.drinkInstance != null) {
            total += drinkInstance.getPrice();
        }
        if (this.entreeInstance != null
                && this.sideInstance != null
                && this.drinkInstance != null) {
            total = total - getDiscount();
        }
        return total;
    }

    /**
     * Getter for Calories.
     *
     * @return total integer value of calories of items
     */
    public int getCalories() {
        int total = 0;
        if (this.entreeInstance != null) {
            total += entreeInstance.getCalories();
        }
        if (this.sideInstance != null) {
            total += sideInstance.getCalories();
        }
        if (this.drinkInstance != null) {
            total += drinkInstance.getCalories();
        }
        return total;
    }

    /**
     * Getter for Special instructions.
     *
     * @return List of instructions based on combo name and discount
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        if (this.name != null) {
            specials.add(this.name);
        } else {
            specials.add("Custom Combo");
        }
        if (this.entreeInstance != null
                && this.sideInstance != null
                && this.drinkInstance != null) {
            specials.add("$" + discount + " Discount Applied");
        }
        return specials;
    }

    /**
     * Override method for toString.
     */
    public String toString() {
        return name;
    }

    /**
     * Method to determine Equality in combos.
     *
     * @return boolean value determining Equality
     */
    @Override
    public boolean equals(Object input) {
        if (input instanceof Combo) {
            Combo other = (Combo) input;
            if (this.entreeInstance == null) {
                if (other.getEntreeInstance() != null) {
                    return false;
                }
            }
            if (this.sideInstance == null) {
                if (other.getSideInstance() != null) {
                    return false;
                }
            }
            if (this.drinkInstance == null) {
                if (other.getDrinkInstance() != null) {
                    return false;
                }
            }
            if (this.entreeInstance.equals(other.getEntreeInstance())
                    && this.sideInstance.equals(other.getSideInstance())
                    && this.drinkInstance.equals(other.getDrinkInstance())
                    && this.name.equals(other.getName())) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * Method to reset instances.
     *
     *<p>Resets all the current instances back to the null value.
     *
     */
    public void clear() {
        this.entreeInstance = null;
        this.sideInstance = null;
        this.drinkInstance = null;
    }
}