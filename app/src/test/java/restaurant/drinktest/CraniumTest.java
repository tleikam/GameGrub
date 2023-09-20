package restaurant.drinktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gamegrub.data.Item;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.enums.Size;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class for running tests on Cranium Class.
 *
 *<p>This class is full of tests to ensure
 cranium works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CraniumTest {
    
    @Test
    public void testCraniumIsDrink() {
        Cranium craunium = new Cranium();
        assertTrue(craunium instanceof Drink);
    }

    @Test
    public void testCraniumIsAnItem() {
        Cranium craunium = new Cranium();
        assertTrue(craunium instanceof Item);
    }

    @Test
    public void testCraniumInstructionsShouldBeEmpty() {
        Cranium craunium = new Cranium();
        assertTrue(craunium.getSpecialInstructions().isEmpty());
    }

    @Test
    public void testCraniumHasCorrectDefaultSize() {
        Cranium craunium = new Cranium();
        assertTrue(craunium.getSize().equals(Size.JUNIOR));
    }

    @Test
    public void testCraniumIsTheCorrectPriceWithTheAppropriateSize() {
        Cranium craunium = new Cranium();
        assertEquals(4.35, craunium.getPrice());
        craunium.setSize(Size.CLASSIC);
        assertEquals(5.25, craunium.getPrice());
        craunium.setSize(Size.WINNER);
        assertEquals(6.00, craunium.getPrice());
    }

    @Test
    public void testCraniumGetCaloriesReturnsCorrectAmount() {
        Cranium craunium = new Cranium();
        assertEquals(380, craunium.getCalories());
        craunium.setSize(Size.CLASSIC);
        assertEquals(495, craunium.getCalories());
        craunium.setSize(Size.WINNER);
        assertEquals(585, craunium.getCalories());
    }

    @Test
    public void testCraniumContainsAllDefaultToppings() {
        Cranium craunium = new Cranium();
        assertTrue(craunium.getMilk());
        assertFalse(craunium.getCaramel());
        assertFalse(craunium.getChocolate());
        assertFalse(craunium.getMint());
    }

    @Test
    public void testCraniumGetAndSetBothWorkAfterValuesHaveChanged() {
        Cranium craunium = new Cranium();
        assertTrue(craunium.getMilk());
        assertFalse(craunium.getCaramel());
        assertFalse(craunium.getChocolate());
        assertFalse(craunium.getMint());
        craunium.setMilk(false);
        craunium.setChocolate(true);
        craunium.setCaramel(true);
        craunium.setMint(true);
        assertFalse(craunium.getMilk());
        assertTrue(craunium.getCaramel());
        assertTrue(craunium.getChocolate());
        assertTrue(craunium.getMint());
    }

    @Test
    public void testCraniumAddsCorrectSpecialInstructionsToAttributes() {
        Cranium craunium = new Cranium();
        assertTrue(craunium.getSpecialInstructions().isEmpty());
        craunium.setMilk(false);
        assertTrue(craunium.getSpecialInstructions().contains("Hold Milk"));
        craunium.setCaramel(true);
        assertTrue(craunium.getSpecialInstructions().contains("Add Caramel"));
        craunium.setChocolate(true);
        assertTrue(craunium.getSpecialInstructions().contains("Add Chocolate"));
        craunium.setMint(true);
        assertTrue(craunium.getSpecialInstructions().contains("Add Mint"));
    }

    @Test
    public void testCraniumIsEqualToAnotherInput() {
        Cranium craunium = new Cranium();
        Cranium input = new Cranium();
        Sorry fail = new Sorry();
        assertFalse(craunium.equals(fail));
        assertTrue(craunium.equals(input));
        input.setSize(Size.WINNER);
        assertFalse(craunium.equals(input));
        input.setSize(Size.JUNIOR);
        input.setMilk(false);
        assertFalse(craunium.equals(input));
        input.setMilk(true);
        input.setCaramel(true);
        assertFalse(craunium.equals(input));
        input.setCaramel(false);
        input.setChocolate(true);
        assertFalse(craunium.equals(input));
        input.setChocolate(false);
        input.setMint(true);
        assertFalse(craunium.equals(input));
    }

    @Test
    public void testCraniumToStringIsCorrectlyFormatted() {
        Cranium craunium = new Cranium();
        assertEquals("" + craunium.getSize() + " Cranium Coffee", craunium.toString());
    }
}