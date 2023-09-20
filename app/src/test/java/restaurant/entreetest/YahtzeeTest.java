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
 * Class for running tests on Yahtzee Class.
 *
 *<p>This class is full of tests to ensure
 yahtzee works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class YahtzeeTest {

    @Test
    public void testYahtzeeIsAnEntree() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee instanceof Entree);
    }

    @Test
    public void testYahtzeeIsAnItem() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee instanceof Item);
    }

    // @Test
    // public void testYahtzeeInstructionsShouldBeEmpty() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getSpecialInstructions().isEmpty());
    // }

    @Test
    public void testYahtzeeIsTheCorrectPriceWithTheAppropriateBase() {
        Yahtzee yahtzee = new Yahtzee();
        assertEquals(15.25, yahtzee.getPrice());
        yahtzee.setBase(Base.SPAGHETTI);
        assertEquals(15.75, yahtzee.getPrice());
        yahtzee.setBase(Base.CHIPS);
        assertEquals(16.25, yahtzee.getPrice());
    }

    @Test
    public void testYahtzeeReturnsCorrectAmountOfCalories() {
        Yahtzee yahtzee = new Yahtzee();
        assertEquals(785, yahtzee.getCalories());
    }

    @Test
    public void testYahtzeeDefaultIsOnRiceBase() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee.getBase().equals(Base.RICE));
    }

    @Test
    public void testYahtzeeSetBaseChangesBase() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setBase(Base.CHIPS);
        assertFalse(yahtzee.getBase().equals(Base.RICE));
    }

    @Test
    public void testYahtzeeDefaultHasSeaweed() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee.getSeaweed());
    }

    @Test
    public void testYahtzeeSetSeaweedChangesDefault() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setSeaweed(false);
        assertFalse(yahtzee.getSeaweed());
    }

    @Test
    public void testYahtzeeDefaultHasTuna() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee.getTuna());
    }

    @Test
    public void testYahtzeeSetTunaChangesDefault() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setTuna(false);
        assertFalse(yahtzee.getTuna());
    }

    @Test
    public void testYahtzeeDefaultHasVeggies() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee.getVeggies());
    }

    @Test
    public void testYahtzeeSetVeggiesChangesDefault() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.setVeggies(false);
        assertFalse(yahtzee.getVeggies());
    }

    @Test
    public void testYahtzeeContainsAllDefaultToppings() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(yahtzee.getToppings().contains(Toppings.HOT_SAUCE));
        assertTrue(yahtzee.getToppings().contains(Toppings.CRISPY_STRIPS));
        assertTrue(yahtzee.getToppings().contains(Toppings.GUACAMOLE));
    }

    @Test
    public void testYahtzeeAddToppingInsertsToppingIntoSet() {
        Yahtzee yahtzee = new Yahtzee();
        assertFalse(yahtzee.getToppings().contains(Toppings.ONIONS));
        assertTrue(yahtzee.getToppings().size() == 4);
        yahtzee.addTopping(Toppings.ONIONS);
        assertTrue(yahtzee.getToppings().contains(Toppings.ONIONS));
        assertTrue(yahtzee.getToppings().size() == 5);
        yahtzee.addTopping(Toppings.SOY_SAUCE);
        assertTrue(yahtzee.getToppings().size() == 5);
    }

    @Test
    public void testYahtzeeRemovesToppingFromToppingSet() {
        Yahtzee yahtzee = new Yahtzee();
        assertTrue(yahtzee.getToppings().contains(Toppings.SOY_SAUCE));
        yahtzee.removeTopping(Toppings.SOY_SAUCE);
        assertFalse(yahtzee.getToppings().contains(Toppings.SOY_SAUCE));
    }

    @Test
    public void testYahtzeeIngredientSetToFalseAddsToSpecials() {
        Yahtzee yahtzee = new Yahtzee();
        //assertTrue(yahtzee.getSpecialInstructions().isEmpty());
        yahtzee.setTuna(false);
        assertTrue(yahtzee.getSpecialInstructions().contains("Hold Tuna"));
        yahtzee.setVeggies(false);
        assertTrue(yahtzee.getSpecialInstructions().contains("Hold Veggies"));
        yahtzee.setSeaweed(false);
        assertTrue(yahtzee.getSpecialInstructions().contains("Hold Seaweed"));
    }

    @Test
    public void testYahtzeeToStringFormatsCorrectly() {
        Yahtzee yahtzee = new Yahtzee();
        assertEquals("Yahtzee Poke on " + yahtzee.getBase(), yahtzee.toString());
    }

    @Test
    public void testYahtzeeObjectIsEqualToObjectInput() {
        Yahtzee yahtzee = new Yahtzee();
        Yahtzee input = new Yahtzee();
        Clue fail = new Clue();
        assertFalse(yahtzee.equals(fail));
        assertTrue(yahtzee.equals(input));
        input.setBase(Base.SPAGHETTI);
        assertFalse(yahtzee.equals(input));
        input.setBase(Base.RICE);
        input.setTuna(false);
        assertFalse(yahtzee.equals(input));
        input.setTuna(true);
        input.setVeggies(false);
        assertFalse(yahtzee.equals(input));
        input.setVeggies(true);
        input.setSeaweed(false);
        assertFalse(yahtzee.equals(input));
        input.setSeaweed(true);
        input.removeTopping(Toppings.SOY_SAUCE);
        assertFalse(yahtzee.equals(input));
    }
}