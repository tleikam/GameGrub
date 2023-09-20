package gamegrub.data.drinks;

import gamegrub.data.Item;
import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Abstract class for Drinks.
 */
public abstract class Drink implements Item {

    private Size size;

    /**
     * Getter for Size enum.
     *
     * @return Size value associated with drink
     */
    public Size getSize() {
        return this.size;
    }
    
    public abstract String getName();

    /**
     * Setter for Size Enum.
     *
     * @param value Size value associated with drink to set to
     */
    public void setSize(Size value) {
        this.size = value;
    }

    /**
     * Abstract getter for price.
     */
    public abstract double getPrice();

    /**
     * Abstract getter for calories.
     */
    public abstract int getCalories();

    /**
     * Abstract getter for special instructions.
     */
    public abstract LinkedList<String> getSpecialInstructions();
    
}