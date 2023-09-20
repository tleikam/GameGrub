package restaurant.webtest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gamegrub.data.Item;
import gamegrub.data.MenuFilter;
import gamegrub.data.combo.Combo;
import gamegrub.data.drinks.Drink;
import gamegrub.data.entrees.Entree;
import gamegrub.data.sides.Side;
import java.lang.IllegalArgumentException;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * MenuFilterTest Class.
 *
 * @author Travis Leikam
 * @version 0.10
 */
@MockitoSettings(strictness = Strictness.LENIENT)
public class MenuFilterTest {

    @Mock
    Item mockItem1;
    @Mock
    Item mockItem2;
    @Mock
    Item mockItem3;
    @Mock
    Entree mockEntree;
    @Mock
    Drink mockDrink;
    @Mock
    Side mockSide;
    @Mock
    Combo mockCombo1;

    /**
     * Test MenuFilter.
     */
    @Test
    public void testMenuFilterKeyword() {
        when(mockItem1.toString()).thenReturn("Winner Candy Land Shake");
        when(mockItem2.toString()).thenReturn("Potato Dice");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe = MenuFilter.filterKeywords(filterMe, "candy");
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterKeywordComboTesterEntree() {
        when(mockCombo1.getEntreeInstance()).thenReturn(mockEntree);
        when(mockEntree.toString()).thenReturn("Chess");
        when(mockCombo1.getDrinkInstance()).thenReturn(null);
        when(mockCombo1.getSideInstance()).thenReturn(null);
        when(mockDrink.toString()).thenReturn("Candy");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockCombo1);
        filterMe.add(mockDrink);
        filterMe = MenuFilter.filterKeywords(filterMe, "Chess");
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterKeywordComboTesterDrink() {
        when(mockCombo1.getEntreeInstance()).thenReturn(null);
        when(mockCombo1.getDrinkInstance()).thenReturn(mockDrink);
        when(mockCombo1.getSideInstance()).thenReturn(null);
        when(mockDrink.toString()).thenReturn("Candy");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockCombo1);
        filterMe.add(mockItem1);
        filterMe = MenuFilter.filterKeywords(filterMe, "Candy");
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterKeywordComboTesterSide() {
        when(mockCombo1.getEntreeInstance()).thenReturn(null);
        when(mockCombo1.getDrinkInstance()).thenReturn(null);
        when(mockCombo1.getSideInstance()).thenReturn(mockSide);
        when(mockSide.toString()).thenReturn("Potato Dice");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockCombo1);
        filterMe.add(mockCombo1);
        filterMe = MenuFilter.filterKeywords(filterMe, "Dice");
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterKeywordComboButNoneMatch() {
        when(mockCombo1.getEntreeInstance()).thenReturn(mockEntree);
        when(mockCombo1.getDrinkInstance()).thenReturn(mockDrink);
        when(mockCombo1.getSideInstance()).thenReturn(mockSide);
        when(mockSide.toString()).thenReturn("Potato Dice");
        when(mockEntree.toString()).thenReturn("Chess");
        when(mockDrink.toString()).thenReturn("Candy");
        MenuFilter mf = new MenuFilter();
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockCombo1);
        filterMe.add(mockCombo1);
        filterMe = MenuFilter.filterKeywords(filterMe, "Nothing");
        assertTrue(filterMe.size() == 0);
    }

    @Test
    public void testMenuFilterKeywordComboButEverythingIsAlreadyThere() {
        when(mockCombo1.getEntreeInstance()).thenReturn(mockEntree);
        when(mockCombo1.getDrinkInstance()).thenReturn(mockDrink);
        when(mockCombo1.getSideInstance()).thenReturn(mockSide);
        when(mockSide.toString()).thenReturn("Nothing");
        when(mockEntree.toString()).thenReturn("Nothing");
        when(mockDrink.toString()).thenReturn("Nothing");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockCombo1);
        filterMe.add(mockCombo1);
        filterMe = MenuFilter.filterKeywords(filterMe, "Nothing");
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterKeywordEmptyString() {
        when(mockItem1.toString()).thenReturn("Winner Candy Land Shake");
        when(mockItem2.toString()).thenReturn("Potato Dice");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe = MenuFilter.filterKeywords(filterMe, "");
        assertTrue(filterMe.size() == 2);
    }

    @Test
    public void testMenuFilterKeywordNull() {
        when(mockItem1.toString()).thenReturn("Winner Candy Land Shake");
        when(mockItem2.toString()).thenReturn("Potato Dice");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe = MenuFilter.filterKeywords(filterMe, null);
        assertTrue(filterMe.size() == 2);
    }

    @Test
    public void testMenuFilterKeywordWithExistingItem() {
        when(mockItem1.toString()).thenReturn("Winner Candy Land Shake");
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem1);
        filterMe = MenuFilter.filterKeywords(filterMe, "Candy");
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterPrice() {

        when(mockItem1.getPrice()).thenReturn(27.75);
        when(mockItem2.getPrice()).thenReturn(10.95);
        when(mockItem3.getPrice()).thenReturn(20.95);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterPrice(filterMe, 10.00, 25.00);
        assertTrue(filterMe.size() == 2);
        filterMe = MenuFilter.filterPrice(filterMe, 15.00, 25.00);
        assertTrue(filterMe.size() == 1);
        filterMe = MenuFilter.filterPrice(filterMe, 21.00, 22.00);
        assertTrue(filterMe.size() == 0);
    }

    @Test
    public void testMenuFilterPriceMaxNegativeOne() {

        when(mockItem1.getPrice()).thenReturn(27.75);
        when(mockItem2.getPrice()).thenReturn(10.95);
        when(mockItem3.getPrice()).thenReturn(20.95);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterPrice(filterMe, 10.00, -1);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterPrice(filterMe, 15.00, -1);
        assertTrue(filterMe.size() == 2);
    }

    @Test
    public void testMenuFilterPriceMinNegativeOne() {

        when(mockItem1.getPrice()).thenReturn(27.75);
        when(mockItem2.getPrice()).thenReturn(10.95);
        when(mockItem3.getPrice()).thenReturn(20.95);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterPrice(filterMe, -1, 30.00);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterPrice(filterMe, -1, 20.00);
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterPriceMinAndMaxNegativeOne() {

        when(mockItem1.getPrice()).thenReturn(27.75);
        when(mockItem2.getPrice()).thenReturn(10.95);
        when(mockItem3.getPrice()).thenReturn(20.95);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterPrice(filterMe, -1, -1);
        assertTrue(filterMe.size() == 3);
    }

    @Test
    public void testMenuFilterCalories() {

        when(mockItem1.getCalories()).thenReturn(2775);
        when(mockItem2.getCalories()).thenReturn(1095);
        when(mockItem3.getCalories()).thenReturn(2095);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterCalories(filterMe, 1000, 2500);
        assertTrue(filterMe.size() == 2);
        filterMe = MenuFilter.filterCalories(filterMe, 1500, 2500);
        assertTrue(filterMe.size() == 1);
        filterMe = MenuFilter.filterCalories(filterMe, 2100, 2200);
        assertTrue(filterMe.size() == 0);
    }

    @Test
    public void testMenuFilterCaloriesMaxNegativeOne() {

        when(mockItem1.getCalories()).thenReturn(2775);
        when(mockItem2.getCalories()).thenReturn(1095);
        when(mockItem3.getCalories()).thenReturn(2095);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterCalories(filterMe, 1000, -1);
        assertTrue(filterMe.size() == 3);
    }

    @Test
    public void testMenuFilterCaloriesMinNegativeOne() {

        when(mockItem1.getCalories()).thenReturn(2775);
        when(mockItem2.getCalories()).thenReturn(1095);
        when(mockItem3.getCalories()).thenReturn(2095);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterCalories(filterMe, -1, 3000);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterCalories(filterMe, -1, 2000);
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterCaloriesMinAndMaxNegativeOne() {

        when(mockItem1.getCalories()).thenReturn(2775);
        when(mockItem2.getCalories()).thenReturn(1095);
        when(mockItem3.getCalories()).thenReturn(2095);
        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        assertTrue(filterMe.size() == 3);
        filterMe = MenuFilter.filterCalories(filterMe, -1, -1);
        assertTrue(filterMe.size() == 3);
    }

    @Test
    public void testMenuFilterCombos() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        filterMe.add(mockCombo1);
        assertTrue(filterMe.size() == 4);
        filterMe = MenuFilter.filterCombos(filterMe);
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterRemoveCombos() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        filterMe.add(mockCombo1);
        assertTrue(filterMe.size() == 4);
        filterMe = MenuFilter.removeCombos(filterMe);
        assertTrue(filterMe.size() == 3);
    }

    @Test
    public void testMenuFilterEntrees() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        filterMe.add(mockCombo1);
        filterMe.add(mockEntree);
        filterMe.add(mockDrink);
        filterMe.add(mockSide);
        assertTrue(filterMe.size() == 7);
        // (items, entree, side, drink, combo)
        filterMe = MenuFilter.filterType(filterMe, true, false, false, false);
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterSides() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        filterMe.add(mockCombo1);
        filterMe.add(mockEntree);
        filterMe.add(mockDrink);
        filterMe.add(mockSide);
        assertTrue(filterMe.size() == 7);
        // (items, entree, side, drink, combo)
        filterMe = MenuFilter.filterType(filterMe, false, true, false, false);
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterDrinks() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        filterMe.add(mockCombo1);
        filterMe.add(mockEntree);
        filterMe.add(mockDrink);
        filterMe.add(mockSide);
        assertTrue(filterMe.size() == 7);
        // (items, entree, side, drink, combo)
        filterMe = MenuFilter.filterType(filterMe, false, false, true, false); 
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterComboCheckBox() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockItem1);
        filterMe.add(mockItem2);
        filterMe.add(mockItem3);
        filterMe.add(mockCombo1);
        filterMe.add(mockEntree);
        filterMe.add(mockDrink);
        filterMe.add(mockSide);
        assertTrue(filterMe.size() == 7);
        // (items, entree, side, drink, combo)
        filterMe = MenuFilter.filterType(filterMe, false, false, false, true); 
        assertTrue(filterMe.size() == 1);
    }

    @Test
    public void testMenuFilterAllRemovesNone() {

        LinkedList<Item> filterMe = new LinkedList<>();
        filterMe.add(mockCombo1);
        filterMe.add(mockEntree);
        filterMe.add(mockDrink);
        filterMe.add(mockSide);
        assertTrue(filterMe.size() == 4);
        // (items, entree, side, drink, combo)
        filterMe = MenuFilter.filterType(filterMe, true, true, true, true);
        assertTrue(filterMe.size() == 4);
    }
}