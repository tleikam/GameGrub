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
 * Class for running tests on Sorry Class.
 *
 *<p>This class is full of tests to ensure
 sorry works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class SorryTest {
    
    @Test
    public void testSorryIsDrink() {
        Sorry sorry = new Sorry();
        assertTrue(sorry instanceof Drink);
    }

    @Test
    public void testSorryIsAnItem() {
        Sorry sorry = new Sorry();
        assertTrue(sorry instanceof Item);
    }

    @Test
    public void testSorryInstructionsShouldBeEmpty() {
        Sorry sorry = new Sorry();
        assertTrue(sorry.getSpecialInstructions().isEmpty());
    }

    @Test
    public void testSorryHasCorrectDefaultSize() {
        Sorry sorry = new Sorry();
        assertTrue(sorry.getSize().equals(Size.JUNIOR));
    }

    @Test
    public void testSorryIsTheCorrectPriceWithTheAppropriateSize() {
        Sorry sorry = new Sorry();
        assertEquals(2.55, sorry.getPrice());
        sorry.setSize(Size.CLASSIC);
        assertEquals(3.85, sorry.getPrice());
        sorry.setSize(Size.WINNER);
        assertEquals(5.35, sorry.getPrice());
    }

    @Test
    public void testSorryGetCaloriesReturnsCorrectAmount() {
        Sorry sorry = new Sorry();
        assertEquals(370, sorry.getCalories());
        sorry.setSize(Size.CLASSIC);
        assertEquals(535, sorry.getCalories());
        sorry.setSize(Size.WINNER);
        assertEquals(765, sorry.getCalories());
    }

    @Test
    public void testSorryContainsAllDefaultToppings() {
        Sorry sorry = new Sorry();
        assertTrue(sorry.getCola());
        assertFalse(sorry.getCherry());
        assertFalse(sorry.getGrape());
        assertFalse(sorry.getOrange());
    }

    @Test
    public void testSorryGetAndSetBothWorkAfterValuesHaveChanged() {
        Sorry sorry = new Sorry();
        assertTrue(sorry.getCola());
        assertFalse(sorry.getCherry());
        assertFalse(sorry.getGrape());
        assertFalse(sorry.getOrange());
        sorry.setCola(false);
        sorry.setCherry(true);
        sorry.setGrape(true);
        sorry.setOrange(true);
        assertFalse(sorry.getCola());
        assertTrue(sorry.getCherry());
        assertTrue(sorry.getGrape());
        assertTrue(sorry.getOrange());
    }

    @Test
    public void testSorryAddsCorrectSpecialInstructionsToAttributes() {
        Sorry sorry = new Sorry();
        assertTrue(sorry.getSpecialInstructions().isEmpty());
        sorry.setCola(false);
        assertTrue(sorry.getSpecialInstructions().contains("Hold Cola"));
        sorry.setCherry(true);
        assertTrue(sorry.getSpecialInstructions().contains("Add Cherry"));
        sorry.setGrape(true);
        assertTrue(sorry.getSpecialInstructions().contains("Add Grape"));
        sorry.setOrange(true);
        assertTrue(sorry.getSpecialInstructions().contains("Add Orange"));
    }

    @Test
    public void testSorryIsEqualToAnotherInput() {
        Sorry sorry = new Sorry();
        Sorry input = new Sorry();
        Cranium fail = new Cranium();
        assertFalse(sorry.equals(fail));
        assertTrue(sorry.equals(input));
        input.setSize(Size.WINNER);
        assertFalse(sorry.equals(input));
        input.setSize(Size.JUNIOR);
        sorry.setCola(false);
        assertFalse(sorry.equals(input));
        input.setCola(true);
        sorry.setCherry(true);
        assertFalse(sorry.equals(input));
        input.setCherry(false);
        sorry.setGrape(true);
        assertFalse(sorry.equals(input));
        input.setGrape(false);
        sorry.setOrange(true);
        assertFalse(sorry.equals(input));
    }

    @Test
    public void testSorryToStringIsCorrectlyFormatted() {
        Sorry sorry = new Sorry();
        assertEquals("" + sorry.getSize() + " Sorry Soda", sorry.toString());
    }
}