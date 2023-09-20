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
 * Class for running tests on Risk Class.
 *
 *<p>This class is full of tests to ensure
 risk works as intended.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class RiskTest {

    @Test
    public void testRiskIsSide() {
        Risk risk = new Risk();
        assertTrue(risk instanceof Side);
    }

    @Test
    public void testRiskIsAnItem() {
        Risk risk = new Risk();
        assertTrue(risk instanceof Item);
    }

    @Test
    public void testRiskInstructionsShouldBeEmpty() {
        Risk risk = new Risk();
        assertTrue(risk.getSpecialInstructions().isEmpty());
    }
    
    @Test
    public void testRiskHasCorrectDefaultSize() {
        Risk risk = new Risk();
        assertTrue(risk.getSize().equals(Size.JUNIOR));
    }

    @Test
    public void testRiskReturnsCorrectCaloriesWithSize() {
        Risk risk = new Risk();
        assertEquals(480, risk.getCalories());
        risk.setSize(Size.CLASSIC);
        assertEquals(755, risk.getCalories());
        risk.setSize(Size.WINNER);
        assertEquals(940, risk.getCalories());
    }

    @Test
    public void testRiskReturnsCorrectPriceWithSize() {
        Risk risk = new Risk();
        assertEquals(3.95, risk.getPrice());
        risk.setSize(Size.CLASSIC);
        assertEquals(5.15, risk.getPrice());
        risk.setSize(Size.WINNER);
        assertEquals(6.95, risk.getPrice());
    }

    @Test
    public void testRiskSetSizeAppropriatelyChangesAttribute() {
        Risk risk = new Risk();
        assertFalse(risk.getSize().equals(Size.WINNER));
        risk.setSize(Size.WINNER);
        assertTrue(risk.getSize().equals(Size.WINNER));
    }

    @Test
    public void testRiskToStringIsCorrectlyFormatted() {
        Risk risk = new Risk();
        assertEquals("" + risk.getSize() + " Risk Bites", risk.toString());
    }

    @Test
    public void testRiskIsEqualToAnotherInput() {
        Risk risk = new Risk();
        Risk input = new Risk();
        Dice fail = new Dice();
        assertFalse(risk.equals(fail));
        assertTrue(risk.equals(input));
        input.setSize(Size.WINNER);
        assertFalse(risk.equals(input));
    }
}