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
 * Class for running tests on Candy Class.
 *
 *<p>This class is full of tests to ensure
 candy works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CandyTest {

    @Test
    public void testCandyIsDrink() {
        Candy candy = new Candy();
        assertTrue(candy instanceof Drink);
    }

    @Test
    public void testCandyIsAnItem() {
        Candy candy = new Candy();
        assertTrue(candy instanceof Item);
    }

    @Test
    public void testCandyInstructionsShouldBeEmpty() {
        Candy candy = new Candy();
        assertTrue(candy.getSpecialInstructions().isEmpty());
    }

    @Test
    public void testCandyHasCorrectDefaultSize() {
        Candy candy = new Candy();
        assertTrue(candy.getSize().equals(Size.JUNIOR));
    }

    @Test
    public void testCandyIsTheCorrectPriceWithTheAppropriateSize() {
        Candy candy = new Candy();
        assertEquals(5.75, candy.getPrice());
        candy.setSize(Size.CLASSIC);
        assertEquals(7.45, candy.getPrice());
        candy.setSize(Size.WINNER);
        assertEquals(9.55, candy.getPrice());
    }

    @Test
    public void testCandyGetCaloriesReturnsCorrectAmount() {
        Candy candy = new Candy();
        assertEquals(770, candy.getCalories());
        candy.setSize(Size.CLASSIC);
        assertEquals(1215, candy.getCalories());
        candy.setSize(Size.WINNER);
        assertEquals(1465, candy.getCalories());
    }

    @Test
    public void testCandyContainsAllDefaultToppings() {
        Candy candy = new Candy();
        assertTrue(candy.getChocolate());
        assertFalse(candy.getVanilla());
        assertFalse(candy.getStrawberry());
    }

    @Test
    public void testCandyGetAndSetBothWorkAfterValuesHaveChanged() {
        Candy candy = new Candy();
        assertTrue(candy.getChocolate());
        assertFalse(candy.getVanilla());
        assertFalse(candy.getStrawberry());
        candy.setChocolate(false);
        candy.setVanilla(true);
        candy.setStrawberry(true);
        assertFalse(candy.getChocolate());
        assertTrue(candy.getVanilla());
        assertTrue(candy.getStrawberry());
    }

    @Test
    public void testCandyAddsCorrectSpecialInstructionsToAttributes() {
        Candy candy = new Candy();
        assertTrue(candy.getSpecialInstructions().isEmpty());
        candy.setChocolate(false);
        assertTrue(candy.getSpecialInstructions().contains("Hold Chocolate"));
        candy.setVanilla(true);
        assertTrue(candy.getSpecialInstructions().contains("Add Vanilla"));
        candy.setStrawberry(true);
        assertTrue(candy.getSpecialInstructions().contains("Add Strawberry"));
    }

    @Test
    public void testCandyIsEqualToAnotherInput() {
        Candy candy = new Candy();
        Candy input = new Candy();
        Cranium fail = new Cranium();
        assertFalse(candy.equals(fail));
        assertTrue(candy.equals(input));
        input.setSize(Size.WINNER);
        assertFalse(candy.equals(input));
        input.setSize(Size.JUNIOR);
        input.setChocolate(false);
        assertFalse(candy.equals(input));
        input.setChocolate(true);
        input.setVanilla(true);
        assertFalse(candy.equals(input));
        input.setVanilla(false);
        input.setStrawberry(true);
        assertFalse(candy.equals(input));
    }

    @Test
    public void testCandyToStringIsCorrectlyFormatted() {
        Candy candy = new Candy();
        assertEquals("" + candy.getSize() + " Candy Land Shake", candy.toString());
    }
}