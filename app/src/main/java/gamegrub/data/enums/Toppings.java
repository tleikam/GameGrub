package gamegrub.data.enums;

/**
 * Toppings Enum class.
 *
 * <p>This is the Toppings Enum class providing available Toppings for entrees
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum Toppings {
    ONIONS("Onions"),
    CHEESE("Cheese"),
    HOT_SAUCE("Hot Sauce"),
    SOUR_CREAM("Sour Cream"),
    GUACAMOLE("Guacamole"),
    SOY_SAUCE("Soy Sauce"),
    CRISPY_STRIPS("Crispy Strips"),
    FRESH_HERBS("Fresh Herbs");

    private final String description;

    /**
     * Contructor for toppings.
     *
     * @param value value "String" of topping
     */
    private Toppings(String value) {
        this.description = value;
    }

    /**
     * toString modifier.
     *
     * <p>This method overrides toString method to return the description
     *
     * @return returns description of topping;
     */
    @Override
    public String toString() {
        return this.description;
    }
}