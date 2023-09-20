package gamegrub.data;

import java.util.LinkedList;

/**
 * Interface for items.
 */
public interface Item {

    abstract double getPrice();

    abstract int getCalories();

    abstract LinkedList<String> getSpecialInstructions();
}