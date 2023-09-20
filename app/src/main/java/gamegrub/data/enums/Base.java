package gamegrub.data.enums;

/**
 * Base Enum class.
 *
 * <p>This is the Base Enum class providing available bases for entrees
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum Base {
    RICE("Rice", 1.0),
    SPAGHETTI("Spaghetti", 1.5),
    CHIPS("Chips", 2.0);

    private final String description;

    private final double value;

    /**
     * Contructor for Base.
     *
     * <p>This method sets the String description equal to that of base
     and value to the appropriate upcharge value
     *
     */
    private Base(String description, double value) {
        this.description = description;
        this.value = value;
    }

    /**
     * Accessor method for values of Base.
     *
     * @return returns cost of base
     */
    public double getValue() {
        return this.value;
    }

    /**
     * toString modifier.
     *
     * <p>This method overrides toString method to return the description
     *
     * @return returns description of Base;
     */
    @Override
    public String toString() {
        return this.description;
    }
}