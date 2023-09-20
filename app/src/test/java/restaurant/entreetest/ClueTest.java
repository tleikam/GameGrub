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
 * Class for running tests on Clue Class.
 *
 *<p>This class is full of tests to ensure
 clue works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class ClueTest {

    @Test
    public void testClueIsAnEntree() {
        Clue clue = new Clue();
        assertTrue(clue instanceof Entree);
    }

    @Test
    public void testClueIsAnItem() {
        Clue clue = new Clue();
        assertTrue(clue instanceof Item);
    }

    // @Test
    // public void testClueInstructionsShouldBeEmpty() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getSpecialInstructions().isEmpty());
    // }

    @Test
    public void testClueIsTheCorrectPriceWithTheAppropriateBase() {
        Clue clue = new Clue();
        assertEquals(10.45, clue.getPrice());
        clue.setBase(Base.RICE);
        assertEquals(9.95, clue.getPrice());
        clue.setBase(Base.CHIPS);
        assertEquals(10.95, clue.getPrice());
    }

    @Test
    public void testClueContainsAllDefaultToppings() {
        Clue clue = new Clue();
        assertTrue(clue.getToppings().contains(Toppings.ONIONS));
        assertTrue(clue.getToppings().contains(Toppings.CHEESE));
        assertTrue(clue.getToppings().contains(Toppings.HOT_SAUCE));
    }

    @Test
    public void testClueAddToppingInsertsToppingIntoSet() {
        Clue clue = new Clue();
        assertFalse(clue.getToppings().contains(Toppings.SOY_SAUCE));
        clue.addTopping(Toppings.SOY_SAUCE);
        assertTrue(clue.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(clue.getToppings().size() == 4);
        clue.addTopping(Toppings.SOY_SAUCE);
        assertTrue(clue.getToppings().size() == 4);
    }

    @Test
    public void testClueRemovesToppingFromToppingSet() {
        Clue clue = new Clue();
        assertTrue(clue.getToppings().contains(Toppings.CHEESE));
        clue.removeTopping(Toppings.CHEESE);
        assertFalse(clue.getToppings().contains(Toppings.CHEESE));
    }

    @Test
    public void testClueBaseIsSpaghetti() {
        Clue clue = new Clue();
        assertEquals(Base.SPAGHETTI, clue.getBase());
    }

    @Test
    public void testClueSetBaseActuallyChangesBase() {
        Clue clue = new Clue();
        clue.setBase(Base.CHIPS);
        assertFalse(clue.getBase().equals(Base.SPAGHETTI));
    }

    @Test
    public void testClueCaloriesIsCorrect() {
        Clue clue = new Clue();
        assertEquals(1165, clue.getCalories());
    }

    @Test
    public void testClueHasSpicyBeef() {
        Clue clue = new Clue();
        assertTrue(clue.getSpicyBeef());
    }

    @Test
    public void testClueSetSpicyBeefToFalse() {
        Clue clue = new Clue();
        clue.setSpicyBeef(false);
        assertFalse(clue.getSpicyBeef());
    }

    @Test
    public void testClueHasChili() {
        Clue clue = new Clue();
        assertTrue(clue.getChili());
    }

    @Test
    public void testClueSetChiliToFalse() {
        Clue clue = new Clue();
        clue.setChili(false);
        assertFalse(clue.getChili());
    }

    @Test
    public void testClueHasRedSauce() {
        Clue clue = new Clue();
        assertTrue(clue.getRedSauce());
    }

    @Test
    public void testClueSetRedSauceToFalse() {
        Clue clue = new Clue();
        clue.setRedSauce(false);
        assertFalse(clue.getRedSauce());
    }

    @Test
    public void testClueHasBeans() {
        Clue clue = new Clue();
        assertTrue(clue.getBeans());
    }

    @Test
    public void testClueSetBeansToFalse() {
        Clue clue = new Clue();
        clue.setBeans(false);
        assertFalse(clue.getBeans());
    }

    @Test
    public void testClueIngredientSetToFalseAddsToSpecials() {
        Clue clue = new Clue();
        //assertTrue(clue.getSpecialInstructions().isEmpty());
        clue.setSpicyBeef(false);
        assertTrue(clue.getSpecialInstructions().contains("Hold Spicy Beef"));
        clue.setChili(false);
        assertTrue(clue.getSpecialInstructions().contains("Hold Chili"));
        clue.setBeans(false);
        assertTrue(clue.getSpecialInstructions().contains("Hold Beans"));
        clue.setRedSauce(false);
        assertTrue(clue.getSpecialInstructions().contains("Hold Red Sauce"));
    }

    @Test
    public void testClueToString() {
        Clue clue = new Clue();
        assertEquals("Clue Chili on " + clue.getBase(), clue.toString());
    }

    @Test
    public void testClueObjectIsEqualToObjectInput() {
        Clue clue = new Clue();
        Clue input = new Clue();
        Chess fail = new Chess();
        assertFalse(clue.equals(fail));
        assertTrue(clue.equals(input));
        input.setBase(Base.CHIPS);
        assertFalse(clue.equals(input));
        input.setBase(Base.SPAGHETTI);
        input.setSpicyBeef(false);
        assertFalse(clue.equals(input));
        input.setSpicyBeef(true);
        input.setChili(false);
        assertFalse(clue.equals(input));
        input.setChili(true);
        input.setBeans(false);
        assertFalse(clue.equals(input));
        input.setBeans(true);
        input.setRedSauce(false);
        assertFalse(clue.equals(input));
        input.setRedSauce(true);
        input.removeTopping(Toppings.CHEESE);
        assertFalse(clue.equals(input));
    }
}