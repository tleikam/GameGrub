package restaurant.combotest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import java.lang.IllegalArgumentException;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * Combo Test Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class ComboTest {

    @Mock
    Sorry mockSorry;
    @Mock
    Dice mockDice;
    @Mock
    Monopoly mockPoly;
    @Mock
    Monopoly mockPoly2;
    @Mock
    Chess mockChess;
    @Mock
    Candy mockCandy;
    @Mock
    Candy mockCandy2;
    @Mock
    Catan mockCatan;
    @Mock
    Catan mockCatan2;
    @Mock
    Cranium mockCranium;

    /**
     * Combo Test Method.
     */
    @Test
    public void testComboMethod() {

    }

    @Test
    public void testGetAndSetDiscountWorksAsIntented() {
        Combo combo = new Combo();
        assertTrue(combo.getDiscount() == 0.80);
        combo.setDiscount(1.20);
        assertTrue(combo.getDiscount() == 1.20);
        combo.setDiscount(0.80);
        assertTrue(combo.getDiscount() == 0.80);
    }

    @Test
    public void testGetComboItemsReturnsItemsInLinkedList() {
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        combo.setDrinkInstance(mockCandy);
        combo.setSideInstance(mockCatan);
        LinkedList<Item> items = combo.getComboItems();
        assertThat(items.size(), is(3));
        combo.setSideInstance(null);
        items = combo.getComboItems();
        assertThat(items.size(), is(2));
    }

    @Test
    public void testGetComboItemsReturnsNothingIfNull() {
        Combo combo = new Combo();
        LinkedList<Item> items = combo.getComboItems();
        assertThat(items.size(), is(0));
    }

    @Test
    public void testComboClearNullifiesAllInstances() {
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        combo.setDrinkInstance(mockCandy);
        combo.setSideInstance(mockCatan);
        assertFalse(combo.getEntreeInstance() == null);
        assertFalse(combo.getDrinkInstance() == null);
        assertFalse(combo.getSideInstance() == null);
        combo.clear();
        assertTrue(combo.getEntreeInstance() == null);
        assertTrue(combo.getDrinkInstance() == null);
        assertTrue(combo.getSideInstance() == null);
    }

    @Test
    public void testComboGetCaloriesReturnsTheCorrectAmount() {
        when(mockPoly.getCalories()).thenReturn(1000);
        when(mockCandy.getCalories()).thenReturn(7000);
        when(mockCatan.getCalories()).thenReturn(1500);
        Combo combo = new Combo();
        assertTrue(combo.getCalories() == 0);
        combo.setEntreeInstance(mockPoly);
        assertTrue(combo.getCalories() == 1000);
        combo.setDrinkInstance(mockCandy);
        assertTrue(combo.getCalories() == 8000);
        combo.setSideInstance(mockCatan);
        assertTrue(combo.getCalories() == 9500);
    }

    @Test
    public void testComboDoesNotApplyDiscountForEmptyCombo() {
        Combo combo = new Combo();
        assertTrue(combo.getPrice() == 0.0);
    }

    @Test
    public void testComboDoesNotApplyDiscountFor1ItemCombo() {
        when(mockPoly.getPrice()).thenReturn(8.95);
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        assertTrue(combo.getPrice() == 8.95);
    }

    @Test
    public void testComboDoesNotApplyDiscountFor2ItemCombo() {
        when(mockPoly.getPrice()).thenReturn(9.0);
        when(mockCandy.getPrice()).thenReturn(9.0);
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        combo.setDrinkInstance(mockCandy);
        assertTrue(combo.getPrice() == 18.0);
    }

    @Test
    public void testComboDoesApplyDiscountFor3ItemCombo() {
        when(mockPoly.getPrice()).thenReturn(9.0);
        when(mockCandy.getPrice()).thenReturn(9.0);
        when(mockCatan.getPrice()).thenReturn(9.0);
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        combo.setDrinkInstance(mockCandy);
        combo.setSideInstance(mockCatan);
        assertFalse(combo.getPrice() == 27.0);
    }

    @Test
    public void testComboDoesNotApplyDiscountForDrinkSideCombo() {
        when(mockCandy.getPrice()).thenReturn(9.0);
        when(mockCatan.getPrice()).thenReturn(9.0);
        Combo combo = new Combo();
        combo.setDrinkInstance(mockCandy);
        combo.setSideInstance(mockCatan);
        assertTrue(combo.getPrice() == 18.0);
    }

    @Test
    public void testComboDoesNotApplyDiscountForNullCombo() {
        Combo combo = new Combo();
        combo.clear();
        assertTrue(combo.getPrice() == 0.0);
    }

    @Test
    public void testComboDiscountIsGlobal() {
        when(mockPoly.getPrice()).thenReturn(9.0);
        when(mockCandy.getPrice()).thenReturn(9.0);
        when(mockCatan.getPrice()).thenReturn(9.0);
        when(mockPoly2.getPrice()).thenReturn(10.0);
        when(mockCandy2.getPrice()).thenReturn(10.0);
        when(mockCatan2.getPrice()).thenReturn(10.0);
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        combo.setSideInstance(mockCatan);
        combo.setDrinkInstance(mockCandy);
        Combo combo2 = new Combo();
        combo2.setEntreeInstance(mockPoly2);
        combo2.setDrinkInstance(mockCandy2);
        combo2.setSideInstance(mockCatan2);
        assertTrue(combo.getPrice() == 26.20);
        assertTrue(combo2.getPrice() == 29.20);
        combo.setDiscount(0.20);
        assertTrue(combo.getPrice() == 26.80);
        assertTrue(combo2.getPrice() == 29.80);
        combo.setDiscount(0.80);
    }

    @Test
    public void testComboDiscountCanBeSetToZero() {
        when(mockPoly.getPrice()).thenReturn(9.0);
        when(mockCandy.getPrice()).thenReturn(9.0);
        when(mockCatan.getPrice()).thenReturn(9.0);
        Combo combo = new Combo();
        combo.setEntreeInstance(mockPoly);
        combo.setSideInstance(mockCatan);
        combo.setDrinkInstance(mockCandy);
        assertTrue(combo.getPrice() == 26.20);
        combo.setDiscount(0.0);
        assertTrue(combo.getPrice() == 27.0);
        combo.setDiscount(0.80);
    }

    /*
     * I'm having a bit of trouble throwing exceptions in tests.
     */
    // @Test
    // public void testComboDiscountCannotBeLessThanZero() {
    //     Combo combo = new Combo();
    //     assertThrows(IllegalArgumentException.class, (combo.setDiscount(-0.1)));
    // }

    @Test
    public void testComboConstructorWithStringWorks() {
        Combo combo = new Combo("The Winner");
        assertTrue(combo.getEntreeInstance() != null);
    }

    @Test
    public void testComboConstructorWithEmptyStringWorks() {
        Combo combo = new Combo("");
        assertTrue(combo.getEntreeInstance() == null);
    }

    @Test
    public void testGetSpecialInstructionsWithNoNameAddCustom() {
        Combo combo = new Combo();
        LinkedList<String> specials = combo.getSpecialInstructions();
        assertTrue(specials.contains("Custom Combo"));
    }

    @Test
    public void testGetSpecialInstructionsWithNameAddDiscount() {
        Combo combo = new Combo("The Winner");
        LinkedList<String> specials = combo.getSpecialInstructions();
        assertTrue(specials.contains("The Winner"));
        assertTrue(specials.contains("$" + combo.getDiscount() + " Discount Applied"));
    }

    @Test
    public void testComboCompareToItemReturnsFalse() {
        Combo combo = new Combo();
        assertFalse(combo.equals(mockPoly));
    }

    @Test
    public void testComboNullCompareToOtherComboWithEntree() {
        Combo combo = new Combo();
        Combo withEntree = new Combo();
        withEntree.setEntreeInstance(mockPoly);
        assertFalse(combo.equals(withEntree));
    }

    @Test
    public void testComboNullCompareToOtherComboWithSide() {
        Combo combo = new Combo();
        Combo withSide = new Combo();
        withSide.setSideInstance(mockCatan);
        assertFalse(combo.equals(withSide));
    }

    @Test
    public void testComboNullCompareToOtherComboWithDrink() {
        Combo combo = new Combo();
        Combo withDrink = new Combo();
        withDrink.setDrinkInstance(mockCandy);
        assertFalse(combo.equals(withDrink));
    }

    @Test
    public void testCombosEqualIfTheyAreTheSame() {
        Combo combo = new Combo("The Winner");
        Combo other = new Combo("The Winner");
        assertTrue(combo.equals(other));
    }

    @Test
    public void testCombosDoNotEqualIfDrinksAreDifferent() {
        Combo combo = new Combo("The Winner");
        Combo other = new Combo("The Winner");
        other.setDrinkInstance(mockCranium);
        assertFalse(combo.equals(other));
    }

    @Test
    public void testCombosDoNotEqualIfSidesAreDifferent() {
        Combo combo = new Combo("The Winner");
        Combo other = new Combo("The Winner");
        other.setSideInstance(mockCatan);
        assertFalse(combo.equals(other));
    }

    @Test
    public void testCombosDoNotEqualIfEntreesAreDifferent() {
        Combo combo = new Combo("The Winner");
        Combo other = new Combo("The Winner");
        other.setEntreeInstance(mockChess);
        assertFalse(combo.equals(other));
    }

    @Test
    public void testCombosDoNotEqualIfNamesAreDifferent() {
        Combo other = new Combo();
        other.setEntreeInstance(mockPoly);
        other.setSideInstance(mockDice);
        other.setDrinkInstance(mockSorry);
        Combo combo = new Combo("The Winner");
        assertFalse(combo.equals(other));
    }

    // @Test
    // public void testComboEntreeCannotBeDrink() {
    //     Combo combo = new Combo();
    //     try {
    //         combo.setEntreeInstance(mockCandy);
    //     } catch (IllegalArgumentException e) {
    //         assertThrows(IllegalArgumentException.class, e);
    //     }
        
    // }

    // @Test
    // public void testComboEntreeCannotBeSide() {
    //     Combo combo = new Combo();
    //     assertThrows(IllegalArgumentException.class, combo.setEntreeInstance(mockCatan));
    // }

    // @Test
    // public void testComboDrinkCannotBeEntree() {
    //     Combo combo = new Combo();
    //     assertThrows(IllegalArgumentException.class, combo.setDrinkInstance(mockPoly));
    // }

    // @Test
    // public void testComboDrinkCannotBeSide() {
    //     Combo combo = new Combo();
    //     assertThrows(IllegalArgumentException.class, combo.setDrinkInstance(mockCatan));
    // }

    // @Test
    // public void testComboSideCannotBeEntree() {
    //     Combo combo = new Combo();
    //     assertThrows(IllegalArgumentException.class, combo.setSideInstance(mockPoly));
    // }

    // @Test
    // public void testComboSideCannotBeDrink() {
    //     Combo combo = new Combo();
    //     assertThrows(IllegalArgumentException.class, combo.setSideInstance(mockCandy));
    // }
}