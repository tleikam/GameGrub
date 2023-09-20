package gamegrub.data.sides;

import gamegrub.data.Item;
import gamegrub.data.enums.Size;
import java.util.LinkedList;

/**
 * Abstract class for Sides.
 */
public abstract class Side implements Item {

    private Size size;

    /**
     * Getter for Size enum.
     *
     * @return Size value associated with side
     */
    public Size getSize() {
        return this.size;
    }

    public abstract String getName();

    /**
     * Setter for Size Enum.
     *
     * @param value Size value associated with side to set to
     */
    public void setSize(Size value) {
        this.size = value;
    }

    public abstract double getPrice();

    public abstract int getCalories();

    /**
     * Getter for special instructions.
     *
     * @return currently returns just a empty list
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        return specials;
    }
}