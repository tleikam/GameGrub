package gamegrub.data.custom;

import gamegrub.data.Item;
import java.math.BigDecimal;
import java.util.LinkedList;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Custom Item Class.
 *
 *<p>This class is used in the web application to create
 custom items in the menu.
 *
 * @author Travis Leikam
 * @version v0.12
 */
public class CustomItem implements Item {

    @NotNull
    @Size(min = 4)
    public String name;

    @NotNull
    @DecimalMin("1.50")
    @Digits(integer = 2, fraction = 2)
    public BigDecimal priceBig;

    @NotNull
    @Min(250)
    public int calories;

    /**
     * Constructor for a Custom Item.
     */
    public CustomItem(String name, BigDecimal price, int calories) {
        this.name = name;
        this.priceBig = price;
        this.calories = calories;
    }

    /**
     * Default contructor for json.
     */
    public CustomItem() {

    }

    /**
     * Setter for the name of Custom Item.
     *
     * @param name Name for the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the name of the item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the price of Custom Item.
     *
     * @param price Price for the item
     */
    public void setPrice(double price) {
        this.priceBig = new BigDecimal(price);
    }

    /**
     * Getter for the Price of the custom item.
     *
     * @return Price of the item
     */
    public double getPrice() {
        return this.priceBig.doubleValue();
    }

    /**
     * Setter for the price of Custom Item.
     *
     * @param price Price for the item
     */
    public void setPriceBig(BigDecimal price) {
        this.priceBig = price;
    }

    /**
     * Getter for the Price of the custom item.
     *
     * @return Price of the item
     */
    public BigDecimal getPriceBig() {
        return this.priceBig;
    }

    /**
     * Setter for the calories of Custom Item.
     *
     * @param calories Calories for the item
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Getter for the calories of the custom item.
     *
     * @return Calories of the item
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * Getter for the Special instructions of the custom item.
     *
     * @return LinkedList containing Special instructions of the item
     */
    public LinkedList<String> getSpecialInstructions() {
        LinkedList<String> specials = new LinkedList<>();
        return specials;
    }

    /**
     * ToString method for custom item.
     */
    public String toString() {
        return this.getName() + ": $" + this.getPrice() + " - Calories: " + this.getCalories();
    }
}