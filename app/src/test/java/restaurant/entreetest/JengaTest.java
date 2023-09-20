package restaurant.entreetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gamegrub.data.Item;
import gamegrub.data.drinks.Drink;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Entree;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class for running tests on Jenga Class.
 *
 *<p>This class is full of tests to ensure
 jenga works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class JengaTest {

    @Test
    public void testJengaIsAnEntree() {
        Jenga jenga = new Jenga();
        assertTrue(jenga instanceof Entree);
    }

    @Test
    public void testJengaIsAnItem() {
        Jenga jenga = new Jenga();
        assertTrue(jenga instanceof Item);
    }

    // @Test
    // public void testJengaInstructionsShouldBeEmpty() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getSpecialInstructions().isEmpty());
    // }

    @Test
    public void testJengaIsTheCorrectPriceWithTheAppropriateBase() {
        Jenga jenga = new Jenga();
        assertEquals(11.85, jenga.getPrice());
        jenga.setBase(Base.SPAGHETTI);
        assertEquals(11.35, jenga.getPrice());
        jenga.setBase(Base.RICE);
        assertEquals(10.85, jenga.getPrice());
    }

    @Test
    public void testJengaReturnsCorrectAmountOfCalories() {
        Jenga jenga = new Jenga();
        assertEquals(1470, jenga.getCalories());
    }

    @Test
    public void testJengaDefaultIsOnChipBase() {
        Jenga jenga = new Jenga();
        assertTrue(jenga.getBase().equals(Base.CHIPS));
    }

    @Test
    public void testJengaSetBaseChangesBase() {
        Jenga jenga = new Jenga();
        jenga.setBase(Base.RICE);
        assertFalse(jenga.getBase().equals(Base.CHIPS));
    }

    @Test
    public void testJengaHasSpicyBeefDefault() {
        Jenga jenga = new Jenga();
        assertTrue(jenga.getSpicyBeef());
    }

    @Test
    public void testJengaSetSpicyBeefChangesDefault() {
        Jenga jenga = new Jenga();
        jenga.setSpicyBeef(false);
        assertFalse(jenga.getSpicyBeef());
    }

    @Test
    public void testJengaHasBeansDefault() {
        Jenga jenga = new Jenga();
        assertTrue(jenga.getBeans());
    }

    @Test
    public void testJengaSetBeansChangesDefault() {
        Jenga jenga = new Jenga();
        jenga.setBeans(false);
        assertFalse(jenga.getBeans());
    }

    @Test
    public void testJengaContainsAllDefaultToppings() {
        Jenga jenga = new Jenga();
        assertTrue(jenga.getToppings().contains(Toppings.ONIONS));
        assertTrue(jenga.getToppings().contains(Toppings.CHEESE));
        assertTrue(jenga.getToppings().contains(Toppings.HOT_SAUCE));
        assertTrue(jenga.getToppings().contains(Toppings.SOUR_CREAM));
        assertTrue(jenga.getToppings().contains(Toppings.GUACAMOLE));
    }

    @Test
    public void testJengaAddToppingInsertsToppingIntoSet() {
        Jenga jenga = new Jenga();
        assertFalse(jenga.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(jenga.getToppings().size() == 5);
        jenga.addTopping(Toppings.SOY_SAUCE);
        assertTrue(jenga.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(jenga.getToppings().size() == 6);
        jenga.addTopping(Toppings.SOY_SAUCE);
        assertTrue(jenga.getToppings().size() == 6);
    }

    @Test
    public void testJengaRemovesToppingFromToppingSet() {
        Jenga jenga = new Jenga();
        assertTrue(jenga.getToppings().contains(Toppings.CHEESE));
        jenga.removeTopping(Toppings.CHEESE);
        assertFalse(jenga.getToppings().contains(Toppings.CHEESE));
    }

    @Test
    public void testJengaIngredientSetToFalseAddsToSpecials() {
        Jenga jenga = new Jenga();
        //assertTrue(jenga.getSpecialInstructions().isEmpty());
        jenga.setSpicyBeef(false);
        assertTrue(jenga.getSpecialInstructions().contains("Hold Spicy Beef"));
        jenga.setBeans(false);
        assertTrue(jenga.getSpecialInstructions().contains("Hold Beans"));
    }

    @Test
    public void testJengaToStringFormatsCorrectly() {
        Jenga jenga = new Jenga();
        assertEquals("Jenga Nachos on " + jenga.getBase(), jenga.toString());
    }

    @Test
    public void testJengaObjectIsEqualToObjectInput() {
        Jenga jenga = new Jenga();
        Jenga input = new Jenga();
        Clue fail = new Clue();
        assertFalse(jenga.equals(fail));
        assertTrue(jenga.equals(input));
        input.setBase(Base.SPAGHETTI);
        assertFalse(jenga.equals(input));
        input.setBase(Base.CHIPS);
        input.setSpicyBeef(false);
        assertFalse(jenga.equals(input));
        input.setSpicyBeef(true);
        input.setBeans(false);
        assertFalse(jenga.equals(input));
        input.setBeans(true);
        input.removeTopping(Toppings.CHEESE);
        assertFalse(jenga.equals(input));
    }
}