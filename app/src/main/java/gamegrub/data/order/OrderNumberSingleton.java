package gamegrub.data.order;

/**
 * Class to follow singleton pattern.
 */
public class OrderNumberSingleton {

    private int nextOrderNumber = 1;
    private static OrderNumberSingleton instance = null;

    /**
     * Contructor for the singleton.
     */
    private OrderNumberSingleton() {
        //do nothing
    }

    /**
     * Getter for instance of OrderNumberSingleton.
     *
     * @return the single instance of OrderNumberSingleton
     */
    public static OrderNumberSingleton getInstance() {
        if (OrderNumberSingleton.instance == null) {
            OrderNumberSingleton.instance = new OrderNumberSingleton();
        }
        return OrderNumberSingleton.instance;
    }

    /**
     * Getter for Order Number.
     *
     * @return nextOrderNumber attribute
     */
    public int getOrderNumber() {
        return this.nextOrderNumber;
    }

    /**
     * Getter for the next number singleton.
     *
     * @return integer for the value of current order number
     */
    public static int getNextOrderNumber() {
        OrderNumberSingleton instance = getInstance();
        int temp = instance.getOrderNumber();
        instance.nextOrderNumber = instance.nextOrderNumber + 1;
        return temp;
    }
}