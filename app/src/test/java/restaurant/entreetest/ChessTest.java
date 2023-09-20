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
 * Class for running tests on Chess Class.
 *
 *<p>This class is full of tests to ensure
 chess works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class ChessTest {

    @Test
    public void testChessIsAnEntree() {
        Chess chess = new Chess();
        assertTrue(chess instanceof Entree);
    }

    @Test
    public void testChessIsAnItem() {
        Chess chess = new Chess();
        assertTrue(chess instanceof Item);
    }

    // @Test
    // public void testChessInstructionsShouldBeEmpty() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getSpecialInstructions().isEmpty());
    // }

    @Test
    public void testChessIsTheCorrectPriceWithTheAppropriateBase() {
        Chess chess = new Chess();
        assertEquals(13.65, chess.getPrice());
        chess.setBase(Base.RICE);
        assertEquals(13.15, chess.getPrice());
        chess.setBase(Base.CHIPS);
        assertEquals(14.15, chess.getPrice());
    }

    @Test
    public void testChessGetCaloriesReturnsCorrectAmount() {
        Chess chess = new Chess();
        assertEquals(1555, chess.getCalories());
    }

    @Test
    public void testChessContainsAllDefaultToppings() {
        Chess chess = new Chess();
        assertTrue(chess.getToppings().contains(Toppings.FRESH_HERBS));
        assertTrue(chess.getToppings().contains(Toppings.CHEESE));
    }

    @Test
    public void testChessAddToppingInsertsToppingIntoSet() {
        Chess chess = new Chess();
        assertFalse(chess.getToppings().contains(Toppings.SOY_SAUCE));
        chess.addTopping(Toppings.SOY_SAUCE);
        assertTrue(chess.getToppings().contains(Toppings.SOY_SAUCE));
        assertTrue(chess.getToppings().size() == 3);
        chess.addTopping(Toppings.SOY_SAUCE);
        assertTrue(chess.getToppings().size() == 3);
    }

    @Test
    public void testChessRemovesToppingFromToppingSet() {
        Chess chess = new Chess();
        assertTrue(chess.getToppings().contains(Toppings.CHEESE));
        chess.removeTopping(Toppings.CHEESE);
        assertFalse(chess.getToppings().contains(Toppings.CHEESE));
    }

    @Test
    public void testChessToStringFormatsCorrectly() {
        Chess chess = new Chess();
        assertEquals("Chess Chicken Parmesan on " + chess.getBase(), chess.toString());
    }

    @Test
    public void testChessBaseIsSpaghetti() {
        Chess chess = new Chess();
        assertEquals(Base.SPAGHETTI, chess.getBase());
    }

    @Test
    public void testChessSetBaseToChipsChangesBase() {
        Chess chess = new Chess();
        chess.setBase(Base.CHIPS);
        assertFalse(chess.getBase().equals(Base.SPAGHETTI));
    }

    @Test
    public void testChessHasCrispyChicken() {
        Chess chess = new Chess();
        assertTrue(chess.getCrispyChicken());
    }

    @Test
    public void testChessSetCrispyChickenToFalse() {
        Chess chess = new Chess();
        chess.setCrispyChicken(false);
        assertFalse(chess.getCrispyChicken());
    }

    @Test
    public void testChessHasRedSauce() {
        Chess chess = new Chess();
        assertTrue(chess.getRedSauce());
    }

    @Test
    public void testChessSetRedSauceToFalse() {
        Chess chess = new Chess();
        chess.setRedSauce(false);
        assertFalse(chess.getRedSauce());
    }

    @Test
    public void testChessIngredientSetToFalseAddsToSpecials() {
        Chess chess = new Chess();
        //assertTrue(chess.getSpecialInstructions().isEmpty());
        chess.setCrispyChicken(false);
        assertTrue(chess.getSpecialInstructions().contains("Hold Crispy Chicken"));
        chess.setRedSauce(false);
        assertTrue(chess.getSpecialInstructions().contains("Hold Red Sauce"));
    }

    @Test
    public void testChessObjectIsEqualToObjectInput() {
        Chess chess = new Chess();
        Chess input = new Chess();
        Clue fail = new Clue();
        assertFalse(chess.equals(fail));
        assertTrue(chess.equals(input));
        input.setBase(Base.CHIPS);
        assertFalse(chess.equals(input));
        input.setBase(Base.SPAGHETTI);
        input.setCrispyChicken(false);
        assertFalse(chess.equals(input));
        input.setCrispyChicken(true);
        input.setRedSauce(false);
        assertFalse(chess.equals(input));
        input.setRedSauce(true);
        input.removeTopping(Toppings.CHEESE);
        assertFalse(chess.equals(input));
    }
}