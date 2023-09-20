package gamegrub.data.enums;

/**
 * Size Enum class.
 *
 * <p>This is the Size Enum class providing available Sizes for Sides and Drinks
 *
 * @author Travis Leikam
 * @version 0.1
 */
public enum Size {
    JUNIOR("Junior"),
    CLASSIC("Classic"),
    WINNER("Winner");

    private final String description;

    /**
     * Contructor for size.
     *
     * @param value descriptor of enum value
     */
    private Size(String value) {
        this.description = value;
    }

    /**
     * toString modifier.
     *
     * <p>This method overrides toString method to return the description
     *
     * @return returns description of Size;
     */
    @Override
    public String toString() {
        return this.description;
    }
}