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
 * Class for running tests on Monopoly Class.
 *
 *<p>This class is full of tests to ensure
 monopoly works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class MonopolyTest {

    @Test
    public void testMonopolyIsAnEntree() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly instanceof Entree);
    }

    @Test
    public void testMonopolyIsAnItem() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly instanceof Item);
    }

    // @Test
    // public void testMonopolyInstructionsShouldBeEmpty() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getSpecialInstructions().isEmpty());
    // }

    @Test
    public void testMonopolyIsTheCorrectPriceWithTheAppropriateBase() {
        Monopoly monopoly = new Monopoly();
        assertEquals(18.65, monopoly.getPrice());
        monopoly.setBase(Base.SPAGHETTI);
        assertEquals(19.15, monopoly.getPrice());
        monopoly.setBase(Base.CHIPS);
        assertEquals(19.65, monopoly.getPrice());
    }

    @Test
    public void testMonopolyBaseIsSpaghetti() {
        Monopoly monopoly = new Monopoly();
        assertEquals(Base.RICE, monopoly.getBase());
    }

    @Test
    public void testMonopolySetBaseToChipsChangesBase() {
        Monopoly monopoly = new Monopoly();
        monopoly.setBase(Base.SPAGHETTI);
        assertFalse(monopoly.getBase().equals(Base.RICE));
    }

    @Test
    public void testMonopolyGetCaloriesReturnsCorrectAmount() {
        Monopoly monopoly = new Monopoly();
        assertEquals(1685, monopoly.getCalories());
    }

    @Test
    public void testMonopolyHasVeggies() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly.getVeggies());
    }

    @Test
    public void testMonopolySetVeggiesChangesValue() {
        Monopoly monopoly = new Monopoly();
        monopoly.setVeggies(false);
        assertFalse(monopoly.getVeggies());
    }

    @Test
    public void testMonopolyHasBeans() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly.getBeans());
    }

    @Test
    public void testMonopolySetBeansChangesValue() {
        Monopoly monopoly = new Monopoly();
        monopoly.setBeans(false);
        assertFalse(monopoly.getBeans());
    }

    @Test
    public void testMonopolyHasCrispyChicken() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly.getCrispyChicken());
    }

    @Test
    public void testMonopolySetCrispyChickenChangesValue() {
        Monopoly monopoly = new Monopoly();
        monopoly.setCrispyChicken(false);
        assertFalse(monopoly.getCrispyChicken());
    }

    @Test
    public void testMonopolyHasSpicyBeef() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly.getSpicyBeef());
    }

    @Test
    public void testMonopolySetSpicyBeefChangesValue() {
        Monopoly monopoly = new Monopoly();
        monopoly.setSpicyBeef(false);
        assertFalse(monopoly.getSpicyBeef());
    }

    @Test
    public void testMonopolyContainsAllDefaultToppings() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly.getToppings().contains(Toppings.ONIONS));
        assertTrue(monopoly.getToppings().contains(Toppings.CHEESE));
        assertTrue(monopoly.getToppings().contains(Toppings.HOT_SAUCE));
        assertTrue(monopoly.getToppings().contains(Toppings.SOUR_CREAM));
        assertTrue(monopoly.getToppings().contains(Toppings.GUACAMOLE));
        assertTrue(monopoly.getToppings().contains(Toppings.CRISPY_STRIPS));
    }

    @Test
    public void testMonopolyAddToppingInsertsToppingIntoSet() {
        Monopoly monopoly = new Monopoly();
        assertFalse(monopoly.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(monopoly.getToppings().size() == 6);
        monopoly.addTopping(Toppings.SOY_SAUCE);
        assertTrue(monopoly.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(monopoly.getToppings().size() == 7);
        monopoly.addTopping(Toppings.SOY_SAUCE);
        assertTrue(monopoly.getToppings().size() == 7);
    }

    @Test
    public void testMonopolyRemovesToppingFromToppingSet() {
        Monopoly monopoly = new Monopoly();
        assertTrue(monopoly.getToppings().contains(Toppings.CHEESE));
        monopoly.removeTopping(Toppings.CHEESE);
        assertFalse(monopoly.getToppings().contains(Toppings.CHEESE));
    }

    @Test
    public void testMonopolyIngredientSetToFalseAddsToSpecials() {
        Monopoly monopoly = new Monopoly();
        //assertTrue(monopoly.getSpecialInstructions().isEmpty());
        monopoly.setCrispyChicken(false);
        assertTrue(monopoly.getSpecialInstructions().contains("Hold Crispy Chicken"));
        monopoly.setSpicyBeef(false);
        assertTrue(monopoly.getSpecialInstructions().contains("Hold Spicy Beef"));
        monopoly.setBeans(false);
        assertTrue(monopoly.getSpecialInstructions().contains("Hold Beans"));
        monopoly.setVeggies(false);
        assertTrue(monopoly.getSpecialInstructions().contains("Hold Veggies"));
    }

    @Test
    public void testMonopolyToStringFormatsCorrectly() {
        Monopoly monopoly = new Monopoly();
        assertEquals("Monopoly Bowl on " + monopoly.getBase(), monopoly.toString());
    }

    @Test
    public void testMonopolyObjectIsEqualToObjectInput() {
        Monopoly monopoly = new Monopoly();
        Monopoly input = new Monopoly();
        Clue fail = new Clue();
        assertFalse(monopoly.equals(fail));
        assertTrue(monopoly.equals(input));
        input.setBase(Base.SPAGHETTI);
        assertFalse(monopoly.equals(input));
        input.setBase(Base.RICE);
        input.setSpicyBeef(false);
        assertFalse(monopoly.equals(input));
        input.setSpicyBeef(true);
        input.setCrispyChicken(false);
        assertFalse(monopoly.equals(input));
        input.setCrispyChicken(true);
        input.setBeans(false);
        assertFalse(monopoly.equals(input));
        input.setBeans(true);
        input.setVeggies(false);
        assertFalse(monopoly.equals(input));
        input.setVeggies(true);
        input.removeTopping(Toppings.CHEESE);
        assertFalse(monopoly.equals(input));
    }

}