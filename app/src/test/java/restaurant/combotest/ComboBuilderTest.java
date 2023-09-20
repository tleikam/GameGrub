package restaurant.combotest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
import gamegrub.data.combo.ComboBuilder;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Entree;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.data.menu.Menu;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * ComboBuilder Test Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class ComboBuilderTest {

    /**
     * ComboBuilder Test Method.
     */
    @Test
    public void testComboBuilderMethod() {

    }

    /**
     * GameNightCombo Test.
     *
     *<p>This test ensures that the combobuilder makes 
     correct instances of items in the combo.
     */
    @Test
    public void testGameNightCombo() {
        ComboBuilder cb = new ComboBuilder();
        Combo gameNight = cb.comboBuilder("Game Night");
        Entree entree = gameNight.getEntreeInstance();
        assertTrue(entree instanceof Jenga);
        Side side = gameNight.getSideInstance();
        assertTrue(side instanceof Catan);
        Drink drink = gameNight.getDrinkInstance();
        assertTrue(drink instanceof Sorry);
        assertEquals(gameNight.getName(), "Game Night");
    }

    /**
     * RollTheDiceCombo Test.
     *
     *<p>This test ensures that the combobuilder makes 
     correct instances of items in the combo.
     */
    @Test
    public void testRollTheDiceCombo() {
        ComboBuilder cb = new ComboBuilder();
        Combo rollTheDice = cb.comboBuilder("Roll the Dice");
        Entree entree = rollTheDice.getEntreeInstance();
        assertTrue(entree instanceof Yahtzee);
        Side side = rollTheDice.getSideInstance();
        assertTrue(side instanceof Dice);
        Drink drink = rollTheDice.getDrinkInstance();
        assertTrue(drink instanceof Candy);
        assertEquals(rollTheDice.getName(), "Roll the Dice");
    }

    /**
     * BigAppetiteCombo Test.
     *
     *<p>This test ensures that the combobuilder makes 
     correct instances of items in the combo.
     */
    @Test
    public void testBigAppetiteCombo() {
        ComboBuilder cb = new ComboBuilder();
        Combo bigAppetite = cb.comboBuilder("Big Appetite");
        Entree entree = bigAppetite.getEntreeInstance();
        assertTrue(entree instanceof Chess);
        Side side = bigAppetite.getSideInstance();
        assertTrue(side instanceof Risk);
        Drink drink = bigAppetite.getDrinkInstance();
        assertTrue(drink instanceof Cranium);
        assertEquals(bigAppetite.getName(), "Big Appetite");
    }

    /**
     * TheWinnerCombo Test.
     *
     *<p>This test ensures that the combobuilder makes 
     correct instances of items in the combo.
     */
    @Test
    public void testTheWinnerCombo() {
        ComboBuilder cb = new ComboBuilder();
        Combo theWinner = cb.comboBuilder("The Winner");
        Entree entree = theWinner.getEntreeInstance();
        assertTrue(entree instanceof Monopoly);
        Side side = theWinner.getSideInstance();
        assertTrue(side instanceof Dice);
        Drink drink = theWinner.getDrinkInstance();
        assertTrue(drink instanceof Sorry);
        assertEquals(theWinner.getName(), "The Winner");
    }

    /**
     * Incorrect Name ComboBuilder Test.
     *
     *<p>This test ensures that the combobuilder doesn't
     make a combo if the name is incorrect.
     */
    @Test
    public void testIncorrectComboNameThrowsException() {
        ComboBuilder cb = new ComboBuilder();
        assertThrows(IllegalArgumentException.class, () -> cb.comboBuilder("BlahBlahBlah"));
        
    }
}