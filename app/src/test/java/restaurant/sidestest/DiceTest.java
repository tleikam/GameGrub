package restaurant.sidestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gamegrub.data.Item;
import gamegrub.data.enums.Size;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class for running tests on Dice Class.
 *
 *<p>This class is full of tests to ensure
 dice works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class DiceTest {

    @Test
    public void testDiceIsSide() {
        Dice dice = new Dice();
        assertTrue(dice instanceof Side);
    }

    @Test
    public void testDiceIsAnItem() {
        Dice dice = new Dice();
        assertTrue(dice instanceof Item);
    }

    @Test
    public void testDiceInstructionsShouldBeEmpty() {
        Dice dice = new Dice();
        assertTrue(dice.getSpecialInstructions().isEmpty());
    }
    
    @Test
    public void testDiceHasCorrectDefaultSize() {
        Dice dice = new Dice();
        assertTrue(dice.getSize().equals(Size.JUNIOR));
    }

    @Test
    public void testDiceReturnsCorrectCaloriesWithSize() {
        Dice dice = new Dice();
        assertEquals(350, dice.getCalories());
        dice.setSize(Size.CLASSIC);
        assertEquals(475, dice.getCalories());
        dice.setSize(Size.WINNER);
        assertEquals(795, dice.getCalories());
    }

    @Test
    public void testDiceReturnsCorrectPriceWithSize() {
        Dice dice = new Dice();
        assertEquals(2.75, dice.getPrice());
        dice.setSize(Size.CLASSIC);
        assertEquals(3.85, dice.getPrice());
        dice.setSize(Size.WINNER);
        assertEquals(5.35, dice.getPrice());
    }

    @Test
    public void testDiceSetSizeAppropriatelyChangesAttribute() {
        Dice dice = new Dice();
        assertFalse(dice.getSize().equals(Size.WINNER));
        dice.setSize(Size.WINNER);
        assertTrue(dice.getSize().equals(Size.WINNER));
    }

    @Test
    public void testDiceToStringIsCorrectlyFormatted() {
        Dice dice = new Dice();
        assertEquals("" + dice.getSize() + " Potato Dice", dice.toString());
    }

    @Test
    public void testDiceIsEqualToAnotherInput() {
        Dice dice = new Dice();
        Dice input = new Dice();
        Risk fail = new Risk();
        assertFalse(dice.equals(fail));
        assertTrue(dice.equals(input));
        input.setSize(Size.WINNER);
        assertFalse(dice.equals(input));
    }
}