package restaurant.sidestest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
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
 * Class for running tests on Catan Class.
 *
 *<p>This class is full of tests to ensure
 catan works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CatanTest {

    @Test
    public void testCatanIsSide() {
        Catan catan = new Catan();
        assertTrue(catan instanceof Side);
    }

    @Test
    public void testCatanIsAnItem() {
        Catan catan = new Catan();
        assertTrue(catan instanceof Item);
    }

    @Test
    public void testCatanInstructionsShouldBeEmpty() {
        Catan catan = new Catan();
        assertTrue(catan.getSpecialInstructions().isEmpty());
    }

    @Test
    public void testCatanHasCorrectDefaultSize() {
        Catan catan = new Catan();
        assertTrue(catan.getSize().equals(Size.JUNIOR));
    }

    @Test
    public void testCatanReturnsCorrectCaloriesWithSize() {
        Catan catan = new Catan();
        assertEquals(530, catan.getCalories());
        catan.setSize(Size.CLASSIC);
        assertEquals(815, catan.getCalories());
        catan.setSize(Size.WINNER);
        assertEquals(1045, catan.getCalories());
    }

    @Test
    public void testCatanReturnsCorrectPriceWithSize() {
        Catan catan = new Catan();
        assertEquals(4.45, catan.getPrice());
        catan.setSize(Size.CLASSIC);
        assertEquals(6.85, catan.getPrice());
        catan.setSize(Size.WINNER);
        assertEquals(8.65, catan.getPrice());
    }

    @Test
    public void testCatanSetSizeAppropriatelyChangesAttribute() {
        Catan catan = new Catan();
        assertFalse(catan.getSize().equals(Size.WINNER));
        catan.setSize(Size.WINNER);
        assertTrue(catan.getSize().equals(Size.WINNER));
    }

    @Test
    public void testCatanToStringIsCorrectlyFormatted() {
        Catan catan = new Catan();
        assertEquals("" + catan.getSize() + " Catan Skewers", catan.toString());
    }

    @Test
    public void testCatanIsEqualToAnotherInput() {
        Catan catan = new Catan();
        Catan input = new Catan();
        Dice fail = new Dice();
        assertFalse(catan.equals(fail));
        assertTrue(catan.equals(input));
        input.setSize(Size.WINNER);
        assertFalse(catan.equals(input));
    }

    @Test
    public void testSidesReturnsEmptyList() {
        Side catan = new Catan();
        assertThat(catan.getSpecialInstructions().size(), is(0));
    }
}