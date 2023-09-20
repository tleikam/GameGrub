package gamegrub.data;

import gamegrub.data.combo.Combo;
import gamegrub.data.drinks.Drink;
import gamegrub.data.entrees.Entree;
import gamegrub.data.sides.Side;
import java.util.LinkedList;

/**
 * Menu Filter Class.
 *
 *<p>This class provides filtering for a 
 search method contained in the html.
 */
public class MenuFilter {

    /**
     * KeyWord filter.
     *
     *<p>This method filters through the list by a entered keyword
     *
     * @param items list of items to filter through
     * @param keywords keywords provided by search
     * @return A new linked list of filtered items
     */
    public static LinkedList<Item> filterKeywords(LinkedList<Item> items, String keywords) {
        if (keywords == null || keywords.length() == 0) {
            return items;
        }
        LinkedList<Item> output = new LinkedList<>();
        for (String keyword : keywords.split(" ")) {
            keyword = keyword.toLowerCase();
            for (Item item : items) {
                if (item instanceof Combo) {
                    Combo combo = (Combo) item;
                    if (combo.getEntreeInstance() != null) {
                        Item entree = combo.getEntreeInstance();
                        if (!output.contains(item) 
                                && entree.toString().toLowerCase().contains(keyword)) {
                            output.add(item);
                        }
                    }
                    if (combo.getDrinkInstance() != null) {
                        Item drink = combo.getDrinkInstance();
                        if (!output.contains(item) 
                                && drink.toString().toLowerCase().contains(keyword)) {
                            output.add(item);
                        }
                    }
                    if (combo.getSideInstance() != null) {
                        Item side = combo.getSideInstance();
                        if (!output.contains(item)
                                && side.toString().toLowerCase().contains(keyword)) {
                            output.add(item);
                        }
                    }
                }
                if (item.toString().toLowerCase().contains(keyword)) {
                    if (!output.contains(item)) {
                        output.add(item);
                    }
                }
            }
        }
        return output;
    }

    /**
     * Type filter.
     *
     *<p>This method filters through the types of food
    by a provided checkbox
     *
     * @param items list of items to filter through
     * @param entree boolean determining if entrees should be included
     * @param side boolean determining if sides should be included
     * @param drink boolean determining if drinks should be included
     * @param combo boolean determining if combos should be included
     * @return A new linked list of filtered items
     */
    public static LinkedList<Item> filterType(
            LinkedList<Item> items, boolean entree, boolean side, boolean drink, boolean combo) {
        LinkedList<Item> output = new LinkedList<>();
        for (Item item : items) {
            if (entree && item instanceof Entree) {
                output.add(item);
            }
            if (side && item instanceof Side) {
                output.add(item);
            }
            if (drink && item instanceof Drink) {
                output.add(item);
            }
            if (combo && item instanceof Combo) {
                output.add(item);
            }
        }
        return output;
    }

    /**
     * Price filter.
     *
     *<p>This method filters through the list by a range of price
     *
     * @param items list of items to filter through
     * @param pricemin minimum price for filtering
     * @param pricemax maximum price for filtering
     * @return A new linked list of filtered items
     */
    public static LinkedList<Item> filterPrice(
            LinkedList<Item> items, double pricemin, double pricemax) {
        if (pricemin < 0 && pricemax < 0) {
            return items;
        }
        if (pricemax < 0) {
            pricemax = Double.MAX_VALUE;
        }
        LinkedList<Item> output = new LinkedList<>();
        for (Item item : items) {
            if (item.getPrice() >= pricemin && item.getPrice() <= pricemax) {
                output.add(item);
            }
        }
        return output;
    }

    /**
     * Calorie filter.
     *
     *<p>This method filters through the list by a range of calories
     *
     * @param items list of items to filter through
     * @param calmin minimum calories for filtering
     * @param calmax maximum calories for filtering
     * @return A new linked list of filtered items
     */
    public static LinkedList<Item> filterCalories(
            LinkedList<Item> items, int calmin, int calmax) {
        if (calmin < 0 && calmax < 0) {
            return items;
        }
        if (calmax < 0) {
            calmax = Integer.MAX_VALUE;
        }
        LinkedList<Item> output = new LinkedList<>();
        for (Item item : items) {
            if (item.getCalories() >= calmin && item.getCalories() <= calmax) {
                output.add(item);
            }
        }
        return output;
    }

    /**
     * Combo filter.
     *
     *<p>This method filters through the list and seperates
     combos and items
     *
     * @param items list of items to filter through
     * @return A new linked list of filtered combos
     */
    public static LinkedList<Item> filterCombos(
            LinkedList<Item> items) {
        LinkedList<Item> combos = new LinkedList<>();
        for (Item item : items) {
            if (item instanceof Combo) {
                combos.add(item);
            }
        }
        return combos;
    }

    /**
     * Combo Remover filter.
     *
     *<p>This method filters through the list and removes combos
     *
     * @param items list of items to filter through
     * @return A new linked list of filtered items without combos
     */
    public static LinkedList<Item> removeCombos(
            LinkedList<Item> items) {
        LinkedList<Item> fixed = new LinkedList<>();
        for (Item item : items) {
            if (!(item instanceof Combo)) {
                fixed.add(item);
            }
        }
        return fixed;
    } 
}