package restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * GameGrubTest class.
 *
 * <p>This is the test class for the GameGrub program
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class GameGrubTest {

    @Test void appHasGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    // @Test
    // public void testClueInstructionsShouldBeEmpty() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testClueIsTheCorrectPriceWithTheAppropriateBase() {
    //     Clue clue = new Clue();
    //     assertEquals(10.45, clue.getPrice());
    //     clue.setBase(Base.RICE);
    //     assertEquals(9.95, clue.getPrice());
    //     clue.setBase(Base.CHIPS);
    //     assertEquals(10.95, clue.getPrice());
    // }

    // @Test
    // public void testClueContainsAllDefaultToppings() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getToppings().contains(Toppings.ONIONS));
    //     assertTrue(clue.getToppings().contains(Toppings.CHEESE));
    //     assertTrue(clue.getToppings().contains(Toppings.HOT_SAUCE));
    // }

    // @Test
    // public void testClueAddToppingInsertsToppingIntoSet() {
    //     Clue clue = new Clue();
    //     assertFalse(clue.getToppings().contains(Toppings.SOY_SAUCE));
    //     clue.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(clue.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(clue.getToppings().size() == 4);
    //     clue.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(clue.getToppings().size() == 4);
    // }

    // @Test
    // public void testClueRemovesToppingFromToppingSet() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getToppings().contains(Toppings.CHEESE));
    //     clue.removeTopping(Toppings.CHEESE);
    //     assertFalse(clue.getToppings().contains(Toppings.CHEESE));
    // }

    // @Test
    // public void testClueBaseIsSpaghetti() {
    //     Clue clue = new Clue();
    //     assertEquals(Base.SPAGHETTI, clue.getBase());
    // }

    // @Test
    // public void testClueSetBaseActuallyChangesBase() {
    //     Clue clue = new Clue();
    //     clue.setBase(Base.CHIPS);
    //     assertFalse(clue.getBase().equals(Base.SPAGHETTI));
    // }

    // @Test
    // public void testClueCaloriesIsCorrect() {
    //     Clue clue = new Clue();
    //     assertEquals(1165, clue.getCalories());
    // }

    // @Test
    // public void testClueHasSpicyBeef() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getSpicyBeef());
    // }

    // @Test
    // public void testClueSetSpicyBeefToFalse() {
    //     Clue clue = new Clue();
    //     clue.setSpicyBeef(false);
    //     assertFalse(clue.getSpicyBeef());
    // }

    // @Test
    // public void testClueHasChili() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getChili());
    // }

    // @Test
    // public void testClueSetChiliToFalse() {
    //     Clue clue = new Clue();
    //     clue.setChili(false);
    //     assertFalse(clue.getChili());
    // }

    // @Test
    // public void testClueHasRedSauce() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getRedSauce());
    // }

    // @Test
    // public void testClueSetRedSauceToFalse() {
    //     Clue clue = new Clue();
    //     clue.setRedSauce(false);
    //     assertFalse(clue.getRedSauce());
    // }

    // @Test
    // public void testClueHasBeans() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getBeans());
    // }

    // @Test
    // public void testClueSetBeansToFalse() {
    //     Clue clue = new Clue();
    //     clue.setBeans(false);
    //     assertFalse(clue.getBeans());
    // }

    // @Test
    // public void testClueIngredientSetToFalseAddsToSpecials() {
    //     Clue clue = new Clue();
    //     assertTrue(clue.getSpecialInstructions().isEmpty());
    //     clue.setSpicyBeef(false);
    //     assertTrue(clue.getSpecialInstructions().contains("Hold Spicy Beef"));
    //     clue.setChili(false);
    //     assertTrue(clue.getSpecialInstructions().contains("Hold Chili"));
    //     clue.setBeans(false);
    //     assertTrue(clue.getSpecialInstructions().contains("Hold Beans"));
    //     clue.setRedSauce(false);
    //     assertTrue(clue.getSpecialInstructions().contains("Hold Red Sauce"));
    // }

    // @Test
    // public void testClueToString() {
    //     Clue clue = new Clue();
    //     assertEquals("Clue Chili on " + clue.getBase(), clue.toString());
    // }

    // @Test
    // public void testClueObjectIsEqualToObjectInput() {
    //     Clue clue = new Clue();
    //     Clue input = new Clue();
    //     Chess fail = new Chess();
    //     assertFalse(clue.equals(fail));
    //     assertTrue(clue.equals(input));
    //     input.setBase(Base.CHIPS);
    //     assertFalse(clue.equals(input));
    //     input.setBase(Base.SPAGHETTI);
    //     input.setSpicyBeef(false);
    //     assertFalse(clue.equals(input));
    //     input.setSpicyBeef(true);
    //     input.setChili(false);
    //     assertFalse(clue.equals(input));
    //     input.setChili(true);
    //     input.setBeans(false);
    //     assertFalse(clue.equals(input));
    //     input.setBeans(true);
    //     input.setRedSauce(false);
    //     assertFalse(clue.equals(input));
    //     input.setRedSauce(true);
    //     input.removeTopping(Toppings.CHEESE);
    //     assertFalse(clue.equals(input));
    // }

    // @Test
    // public void testChessInstructionsShouldBeEmpty() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testChessIsTheCorrectPriceWithTheAppropriateBase() {
    //     Chess chess = new Chess();
    //     assertEquals(13.65, chess.getPrice());
    //     chess.setBase(Base.RICE);
    //     assertEquals(13.15, chess.getPrice());
    //     chess.setBase(Base.CHIPS);
    //     assertEquals(14.15, chess.getPrice());
    // }

    // @Test
    // public void testChessGetCaloriesReturnsCorrectAmount() {
    //     Chess chess = new Chess();
    //     assertEquals(1555, chess.getCalories());
    // }

    // @Test
    // public void testChessContainsAllDefaultToppings() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getToppings().contains(Toppings.FRESH_HERBS));
    //     assertTrue(chess.getToppings().contains(Toppings.CHEESE));
    // }

    // @Test
    // public void testChessAddToppingInsertsToppingIntoSet() {
    //     Chess chess = new Chess();
    //     assertFalse(chess.getToppings().contains(Toppings.SOY_SAUCE));
    //     chess.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(chess.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(chess.getToppings().size() == 3);
    //     chess.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(chess.getToppings().size() == 3);
    // }

    // @Test
    // public void testChessRemovesToppingFromToppingSet() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getToppings().contains(Toppings.CHEESE));
    //     chess.removeTopping(Toppings.CHEESE);
    //     assertFalse(chess.getToppings().contains(Toppings.CHEESE));
    // }

    // @Test
    // public void testChessToStringFormatsCorrectly() {
    //     Chess chess = new Chess();
    //     assertEquals("Chess Chicken Parmesan on " + chess.getBase(), chess.toString());
    // }

    // @Test
    // public void testChessBaseIsSpaghetti() {
    //     Chess chess = new Chess();
    //     assertEquals(Base.SPAGHETTI, chess.getBase());
    // }

    // @Test
    // public void testChessSetBaseToChipsChangesBase() {
    //     Chess chess = new Chess();
    //     chess.setBase(Base.CHIPS);
    //     assertFalse(chess.getBase().equals(Base.SPAGHETTI));
    // }

    // @Test
    // public void testChessHasCrispyChicken() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getCrispyChicken());
    // }

    // @Test
    // public void testChessSetCrispyChickenToFalse() {
    //     Chess chess = new Chess();
    //     chess.setCrispyChicken(false);
    //     assertFalse(chess.getCrispyChicken());
    // }

    // @Test
    // public void testChessHasRedSauce() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getRedSauce());
    // }

    // @Test
    // public void testChessSetRedSauceToFalse() {
    //     Chess chess = new Chess();
    //     chess.setRedSauce(false);
    //     assertFalse(chess.getRedSauce());
    // }

    // @Test
    // public void testChessIngredientSetToFalseAddsToSpecials() {
    //     Chess chess = new Chess();
    //     assertTrue(chess.getSpecialInstructions().isEmpty());
    //     chess.setCrispyChicken(false);
    //     assertTrue(chess.getSpecialInstructions().contains("Hold Crispy Chicken"));
    //     chess.setRedSauce(false);
    //     assertTrue(chess.getSpecialInstructions().contains("Hold Red Sauce"));
    // }

    // @Test
    // public void testChessObjectIsEqualToObjectInput() {
    //     Chess chess = new Chess();
    //     Chess input = new Chess();
    //     Clue fail = new Clue();
    //     assertFalse(chess.equals(fail));
    //     assertTrue(chess.equals(input));
    //     input.setBase(Base.CHIPS);
    //     assertFalse(chess.equals(input));
    //     input.setBase(Base.SPAGHETTI);
    //     input.setCrispyChicken(false);
    //     assertFalse(chess.equals(input));
    //     input.setCrispyChicken(true);
    //     input.setRedSauce(false);
    //     assertFalse(chess.equals(input));
    //     input.setRedSauce(true);
    //     input.removeTopping(Toppings.CHEESE);
    //     assertFalse(chess.equals(input));
    // }

    // @Test
    // public void testMonopolyInstructionsShouldBeEmpty() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testMonopolyIsTheCorrectPriceWithTheAppropriateBase() {
    //     Monopoly monopoly = new Monopoly();
    //     assertEquals(18.65, monopoly.getPrice());
    //     monopoly.setBase(Base.SPAGHETTI);
    //     assertEquals(19.15, monopoly.getPrice());
    //     monopoly.setBase(Base.CHIPS);
    //     assertEquals(19.65, monopoly.getPrice());
    // }

    // @Test
    // public void testMonopolyBaseIsSpaghetti() {
    //     Monopoly monopoly = new Monopoly();
    //     assertEquals(Base.RICE, monopoly.getBase());
    // }

    // @Test
    // public void testMonopolySetBaseToChipsChangesBase() {
    //     Monopoly monopoly = new Monopoly();
    //     monopoly.setBase(Base.SPAGHETTI);
    //     assertFalse(monopoly.getBase().equals(Base.RICE));
    // }

    // @Test
    // public void testMonopolyGetCaloriesReturnsCorrectAmount() {
    //     Monopoly monopoly = new Monopoly();
    //     assertEquals(1685, monopoly.getCalories());
    // }

    // @Test
    // public void testMonopolyHasVeggies() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getVeggies());
    // }

    // @Test
    // public void testMonopolySetVeggiesChangesValue() {
    //     Monopoly monopoly = new Monopoly();
    //     monopoly.setVeggies(false);
    //     assertFalse(monopoly.getVeggies());
    // }

    // @Test
    // public void testMonopolyHasBeans() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getBeans());
    // }

    // @Test
    // public void testMonopolySetBeansChangesValue() {
    //     Monopoly monopoly = new Monopoly();
    //     monopoly.setBeans(false);
    //     assertFalse(monopoly.getBeans());
    // }

    // @Test
    // public void testMonopolyHasCrispyChicken() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getCrispyChicken());
    // }

    // @Test
    // public void testMonopolySetCrispyChickenChangesValue() {
    //     Monopoly monopoly = new Monopoly();
    //     monopoly.setCrispyChicken(false);
    //     assertFalse(monopoly.getCrispyChicken());
    // }

    // @Test
    // public void testMonopolyHasSpicyBeef() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getSpicyBeef());
    // }

    // @Test
    // public void testMonopolySetSpicyBeefChangesValue() {
    //     Monopoly monopoly = new Monopoly();
    //     monopoly.setSpicyBeef(false);
    //     assertFalse(monopoly.getSpicyBeef());
    // }

    // @Test
    // public void testMonopolyContainsAllDefaultToppings() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getToppings().contains(Toppings.ONIONS));
    //     assertTrue(monopoly.getToppings().contains(Toppings.CHEESE));
    //     assertTrue(monopoly.getToppings().contains(Toppings.HOT_SAUCE));
    //     assertTrue(monopoly.getToppings().contains(Toppings.SOUR_CREAM));
    //     assertTrue(monopoly.getToppings().contains(Toppings.GUACAMOLE));
    //     assertTrue(monopoly.getToppings().contains(Toppings.CRISPY_STRIPS));
    // }

    // @Test
    // public void testMonopolyAddToppingInsertsToppingIntoSet() {
    //     Monopoly monopoly = new Monopoly();
    //     assertFalse(monopoly.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(monopoly.getToppings().size() == 6);
    //     monopoly.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(monopoly.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(monopoly.getToppings().size() == 7);
    //     monopoly.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(monopoly.getToppings().size() == 7);
    // }

    // @Test
    // public void testMonopolyRemovesToppingFromToppingSet() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getToppings().contains(Toppings.CHEESE));
    //     monopoly.removeTopping(Toppings.CHEESE);
    //     assertFalse(monopoly.getToppings().contains(Toppings.CHEESE));
    // }

    // @Test
    // public void testMonopolyIngredientSetToFalseAddsToSpecials() {
    //     Monopoly monopoly = new Monopoly();
    //     assertTrue(monopoly.getSpecialInstructions().isEmpty());
    //     monopoly.setCrispyChicken(false);
    //     assertTrue(monopoly.getSpecialInstructions().contains("Hold Crispy Chicken"));
    //     monopoly.setSpicyBeef(false);
    //     assertTrue(monopoly.getSpecialInstructions().contains("Hold Spicy Beef"));
    //     monopoly.setBeans(false);
    //     assertTrue(monopoly.getSpecialInstructions().contains("Hold Beans"));
    //     monopoly.setVeggies(false);
    //     assertTrue(monopoly.getSpecialInstructions().contains("Hold Veggies"));
    // }

    // @Test
    // public void testMonopolyToStringFormatsCorrectly() {
    //     Monopoly monopoly = new Monopoly();
    //     assertEquals("Monopoly Bowl on " + monopoly.getBase(), monopoly.toString());
    // }

    // @Test
    // public void testMonopolyObjectIsEqualToObjectInput() {
    //     Monopoly monopoly = new Monopoly();
    //     Monopoly input = new Monopoly();
    //     Clue fail = new Clue();
    //     assertFalse(monopoly.equals(fail));
    //     assertTrue(monopoly.equals(input));
    //     input.setBase(Base.SPAGHETTI);
    //     assertFalse(monopoly.equals(input));
    //     input.setBase(Base.RICE);
    //     input.setSpicyBeef(false);
    //     assertFalse(monopoly.equals(input));
    //     input.setSpicyBeef(true);
    //     input.setCrispyChicken(false);
    //     assertFalse(monopoly.equals(input));
    //     input.setCrispyChicken(true);
    //     input.setBeans(false);
    //     assertFalse(monopoly.equals(input));
    //     input.setBeans(true);
    //     input.setVeggies(false);
    //     assertFalse(monopoly.equals(input));
    //     input.setVeggies(true);
    //     input.removeTopping(Toppings.CHEESE);
    //     assertFalse(monopoly.equals(input));
    // }

    // @Test
    // public void testJengaInstructionsShouldBeEmpty() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testJengaIsTheCorrectPriceWithTheAppropriateBase() {
    //     Jenga jenga = new Jenga();
    //     assertEquals(11.85, jenga.getPrice());
    //     jenga.setBase(Base.SPAGHETTI);
    //     assertEquals(11.35, jenga.getPrice());
    //     jenga.setBase(Base.RICE);
    //     assertEquals(10.85, jenga.getPrice());
    // }

    // @Test
    // public void testJengaReturnsCorrectAmountOfCalories() {
    //     Jenga jenga = new Jenga();
    //     assertEquals(1470, jenga.getCalories());
    // }

    // @Test
    // public void testJengaDefaultIsOnChipBase(){
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getBase().equals(Base.CHIPS));
    // }

    // @Test
    // public void testJengaSetBaseChangesBase() {
    //     Jenga jenga = new Jenga();
    //     jenga.setBase(Base.RICE);
    //     assertFalse(jenga.getBase().equals(Base.CHIPS));
    // }

    // @Test
    // public void testJengaHasSpicyBeefDefault() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getSpicyBeef());
    // }

    // @Test
    // public void testJengaSetSpicyBeefChangesDefault() {
    //     Jenga jenga = new Jenga();
    //     jenga.setSpicyBeef(false);
    //     assertFalse(jenga.getSpicyBeef());
    // }

    // @Test
    // public void testJengaHasBeansDefault() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getBeans());
    // }

    // @Test
    // public void testJengaSetBeansChangesDefault() {
    //     Jenga jenga = new Jenga();
    //     jenga.setBeans(false);
    //     assertFalse(jenga.getBeans());
    // }

    // @Test
    // public void testJengaContainsAllDefaultToppings() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getToppings().contains(Toppings.ONIONS));
    //     assertTrue(jenga.getToppings().contains(Toppings.CHEESE));
    //     assertTrue(jenga.getToppings().contains(Toppings.HOT_SAUCE));
    //     assertTrue(jenga.getToppings().contains(Toppings.SOUR_CREAM));
    //     assertTrue(jenga.getToppings().contains(Toppings.GUACAMOLE));
    // }

    // @Test
    // public void testJengaAddToppingInsertsToppingIntoSet() {
    //     Jenga jenga = new Jenga();
    //     assertFalse(jenga.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(jenga.getToppings().size() == 5);
    //     jenga.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(jenga.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(jenga.getToppings().size() == 6);
    //     jenga.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(jenga.getToppings().size() == 6);
    // }

    // @Test
    // public void testJengaRemovesToppingFromToppingSet() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getToppings().contains(Toppings.CHEESE));
    //     jenga.removeTopping(Toppings.CHEESE);
    //     assertFalse(jenga.getToppings().contains(Toppings.CHEESE));
    // }

    // @Test
    // public void testJengaIngredientSetToFalseAddsToSpecials() {
    //     Jenga jenga = new Jenga();
    //     assertTrue(jenga.getSpecialInstructions().isEmpty());
    //     jenga.setSpicyBeef(false);
    //     assertTrue(jenga.getSpecialInstructions().contains("Hold Spicy Beef"));
    //     jenga.setBeans(false);
    //     assertTrue(jenga.getSpecialInstructions().contains("Hold Beans"));
    // }

    // @Test
    // public void testJengaToStringFormatsCorrectly() {
    //     Jenga jenga = new Jenga();
    //     assertEquals("Jenga Nachos on " + jenga.getBase(), jenga.toString());
    // }

    // @Test
    // public void testJengaObjectIsEqualToObjectInput() {
    //     Jenga jenga = new Jenga();
    //     Jenga input = new Jenga();
    //     Clue fail = new Clue();
    //     assertFalse(jenga.equals(fail));
    //     assertTrue(jenga.equals(input));
    //     input.setBase(Base.SPAGHETTI);
    //     assertFalse(jenga.equals(input));
    //     input.setBase(Base.CHIPS);
    //     input.setSpicyBeef(false);
    //     assertFalse(jenga.equals(input));
    //     input.setSpicyBeef(true);
    //     input.setBeans(false);
    //     assertFalse(jenga.equals(input));
    //     input.setBeans(true);
    //     input.removeTopping(Toppings.CHEESE);
    //     assertFalse(jenga.equals(input));
    // }

    // @Test
    // public void testYahtzeeInstructionsShouldBeEmpty() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testYahtzeeIsTheCorrectPriceWithTheAppropriateBase() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertEquals(15.25, yahtzee.getPrice());
    //     yahtzee.setBase(Base.SPAGHETTI);
    //     assertEquals(15.75, yahtzee.getPrice());
    //     yahtzee.setBase(Base.CHIPS);
    //     assertEquals(16.25, yahtzee.getPrice());
    // }

    // @Test
    // public void testYahtzeeReturnsCorrectAmountOfCalories() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertEquals(785, yahtzee.getCalories());
    // }

    // @Test
    // public void testYahtzeeDefaultIsOnRiceBase(){
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getBase().equals(Base.RICE));
    // }

    // @Test
    // public void testYahtzeeSetBaseChangesBase() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     yahtzee.setBase(Base.CHIPS);
    //     assertFalse(yahtzee.getBase().equals(Base.RICE));
    // }

    // @Test
    // public void testYahtzeeDefaultHasSeaweed(){
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getSeaweed());
    // }

    // @Test
    // public void testYahtzeeSetSeaweedChangesDefault() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     yahtzee.setSeaweed(false);
    //     assertFalse(yahtzee.getSeaweed());
    // }

    // @Test
    // public void testYahtzeeDefaultHasTuna(){
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getTuna());
    // }

    // @Test
    // public void testYahtzeeSetTunaChangesDefault() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     yahtzee.setTuna(false);
    //     assertFalse(yahtzee.getTuna());
    // }

    // @Test
    // public void testYahtzeeDefaultHasVeggies(){
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getVeggies());
    // }

    // @Test
    // public void testYahtzeeSetVeggiesChangesDefault() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     yahtzee.setVeggies(false);
    //     assertFalse(yahtzee.getVeggies());
    // }

    // @Test
    // public void testYahtzeeContainsAllDefaultToppings() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getToppings().contains(Toppings.SOY_SAUCE));
    //     assertTrue(yahtzee.getToppings().contains(Toppings.HOT_SAUCE));
    //     assertTrue(yahtzee.getToppings().contains(Toppings.CRISPY_STRIPS));
    //     assertTrue(yahtzee.getToppings().contains(Toppings.GUACAMOLE));
    // }

    // @Test
    // public void testYahtzeeAddToppingInsertsToppingIntoSet() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertFalse(yahtzee.getToppings().contains(Toppings.ONIONS));
    //     assertTrue(yahtzee.getToppings().size() == 4);
    //     yahtzee.addTopping(Toppings.ONIONS);
    //     assertTrue(yahtzee.getToppings().contains(Toppings.ONIONS));
    //     assertTrue(yahtzee.getToppings().size() == 5);
    //     yahtzee.addTopping(Toppings.SOY_SAUCE);
    //     assertTrue(yahtzee.getToppings().size() == 5);
    // }

    // @Test
    // public void testYahtzeeRemovesToppingFromToppingSet() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getToppings().contains(Toppings.SOY_SAUCE));
    //     yahtzee.removeTopping(Toppings.SOY_SAUCE);
    //     assertFalse(yahtzee.getToppings().contains(Toppings.SOY_SAUCE));
    // }

    // @Test
    // public void testYahtzeeIngredientSetToFalseAddsToSpecials() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertTrue(yahtzee.getSpecialInstructions().isEmpty());
    //     yahtzee.setTuna(false);
    //     assertTrue(yahtzee.getSpecialInstructions().contains("Hold Tuna"));
    //     yahtzee.setVeggies(false);
    //     assertTrue(yahtzee.getSpecialInstructions().contains("Hold Veggies"));
    //     yahtzee.setSeaweed(false);
    //     assertTrue(yahtzee.getSpecialInstructions().contains("Hold Seaweed"));
    // }

    // @Test
    // public void testYahtzeeToStringFormatsCorrectly() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     assertEquals("Yahtzee Poke on " + yahtzee.getBase(), yahtzee.toString());
    // }

    // @Test
    // public void testYahtzeeObjectIsEqualToObjectInput() {
    //     Yahtzee yahtzee = new Yahtzee();
    //     Yahtzee input = new Yahtzee();
    //     Clue fail = new Clue();
    //     assertFalse(yahtzee.equals(fail));
    //     assertTrue(yahtzee.equals(input));
    //     input.setBase(Base.SPAGHETTI);
    //     assertFalse(yahtzee.equals(input));
    //     input.setBase(Base.RICE);
    //     input.setTuna(false);
    //     assertFalse(yahtzee.equals(input));
    //     input.setTuna(true);
    //     input.setVeggies(false);
    //     assertFalse(yahtzee.equals(input));
    //     input.setVeggies(true);
    //     input.setSeaweed(false);
    //     assertFalse(yahtzee.equals(input));
    //     input.setSeaweed(true);
    //     input.removeTopping(Toppings.SOY_SAUCE);
    //     assertFalse(yahtzee.equals(input));
    // }



    // @Test
    // public void testCatanHasCorrectDefaultSize() {
    //     Catan catan = new Catan();
    //     assertTrue(catan.getSize().equals(Size.JUNIOR));
    // }

    // @Test
    // public void testCatanReturnsCorrectCaloriesWithSize() {
    //     Catan catan = new Catan();
    //     assertEquals(530, catan.getCalories());
    //     catan.setSize(Size.CLASSIC);
    //     assertEquals(815, catan.getCalories());
    //     catan.setSize(Size.WINNER);
    //     assertEquals(1045, catan.getCalories());
    // }

    // @Test
    // public void testCatanReturnsCorrectPriceWithSize() {
    //     Catan catan = new Catan();
    //     assertEquals(4.45, catan.getPrice());
    //     catan.setSize(Size.CLASSIC);
    //     assertEquals(6.85, catan.getPrice());
    //     catan.setSize(Size.WINNER);
    //     assertEquals(8.65, catan.getPrice());
    // }

    // @Test
    // public void testCatanSetSizeAppropriatelyChangesAttribute() {
    //     Catan catan = new Catan();
    //     assertFalse(catan.getSize().equals(Size.WINNER));
    //     catan.setSize(Size.WINNER);
    //     assertTrue(catan.getSize().equals(Size.WINNER));
    // }

    // @Test
    // public void testCatanToStringIsCorrectlyFormatted() {
    //     Catan catan = new Catan();
    //     assertEquals("" + catan.getSize() + " Catan Skewers", catan.toString());
    // }

    // @Test
    // public void testCatanIsEqualToAnotherInput() {
    //     Catan catan = new Catan();
    //     Catan input = new Catan();
    //     Dice fail = new Dice();
    //     assertFalse(catan.equals(fail));
    //     assertTrue(catan.equals(input));
    //     input.setSize(Size.WINNER);
    //     assertFalse(catan.equals(input));
    // }



    // @Test
    // public void testDiceHasCorrectDefaultSize() {
    //     Dice dice = new Dice();
    //     assertTrue(dice.getSize().equals(Size.JUNIOR));
    // }

    // @Test
    // public void testDiceReturnsCorrectCaloriesWithSize() {
    //     Dice dice = new Dice();
    //     assertEquals(350, dice.getCalories());
    //     dice.setSize(Size.CLASSIC);
    //     assertEquals(475, dice.getCalories());
    //     dice.setSize(Size.WINNER);
    //     assertEquals(795, dice.getCalories());
    // }

    // @Test
    // public void testDiceReturnsCorrectPriceWithSize() {
    //     Dice dice = new Dice();
    //     assertEquals(2.75, dice.getPrice());
    //     dice.setSize(Size.CLASSIC);
    //     assertEquals(3.85, dice.getPrice());
    //     dice.setSize(Size.WINNER);
    //     assertEquals(5.35, dice.getPrice());
    // }

    // @Test
    // public void testDiceSetSizeAppropriatelyChangesAttribute() {
    //     Dice dice = new Dice();
    //     assertFalse(dice.getSize().equals(Size.WINNER));
    //     dice.setSize(Size.WINNER);
    //     assertTrue(dice.getSize().equals(Size.WINNER));
    // }

    // @Test
    // public void testDiceToStringIsCorrectlyFormatted() {
    //     Dice dice = new Dice();
    //     assertEquals("" + dice.getSize() + " Potato Dice", dice.toString());
    // }

    // @Test
    // public void testDiceIsEqualToAnotherInput() {
    //     Dice dice = new Dice();
    //     Dice input = new Dice();
    //     Risk fail = new Risk();
    //     assertFalse(dice.equals(fail));
    //     assertTrue(dice.equals(input));
    //     input.setSize(Size.WINNER);
    //     assertFalse(dice.equals(input));
    // }


    // @Test
    // public void testRiskHasCorrectDefaultSize() {
    //     Risk risk = new Risk();
    //     assertTrue(risk.getSize().equals(Size.JUNIOR));
    // }

    // @Test
    // public void testRiskReturnsCorrectCaloriesWithSize() {
    //     Risk risk = new Risk();
    //     assertEquals(480, risk.getCalories());
    //     risk.setSize(Size.CLASSIC);
    //     assertEquals(755, risk.getCalories());
    //     risk.setSize(Size.WINNER);
    //     assertEquals(940, risk.getCalories());
    // }

    // @Test
    // public void testRiskReturnsCorrectPriceWithSize() {
    //     Risk risk = new Risk();
    //     assertEquals(3.95, risk.getPrice());
    //     risk.setSize(Size.CLASSIC);
    //     assertEquals(5.15, risk.getPrice());
    //     risk.setSize(Size.WINNER);
    //     assertEquals(6.95, risk.getPrice());
    // }

    // @Test
    // public void testRiskSetSizeAppropriatelyChangesAttribute() {
    //     Risk risk = new Risk();
    //     assertFalse(risk.getSize().equals(Size.WINNER));
    //     risk.setSize(Size.WINNER);
    //     assertTrue(risk.getSize().equals(Size.WINNER));
    // }

    // @Test
    // public void testRiskToStringIsCorrectlyFormatted() {
    //     Risk risk = new Risk();
    //     assertEquals("" + risk.getSize() + " Risk Bites", risk.toString());
    // }

    // @Test
    // public void testRiskIsEqualToAnotherInput() {
    //     Risk risk = new Risk();
    //     Risk input = new Risk();
    //     Dice fail = new Dice();
    //     assertFalse(risk.equals(fail));
    //     assertTrue(risk.equals(input));
    //     input.setSize(Size.WINNER);
    //     assertFalse(risk.equals(input));
    // }







    // @Test
    // public void testCandyInstructionsShouldBeEmpty() {
    //     Candy candy = new Candy();
    //     assertTrue(candy.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testCandyHasCorrectDefaultSize() {
    //     Candy candy = new Candy();
    //     assertTrue(candy.getSize().equals(Size.JUNIOR));
    // }

    // @Test
    // public void testCandyIsTheCorrectPriceWithTheAppropriateSize() {
    //     Candy candy = new Candy();
    //     assertEquals(5.75, candy.getPrice());
    //     candy.setSize(Size.CLASSIC);
    //     assertEquals(7.45, candy.getPrice());
    //     candy.setSize(Size.WINNER);
    //     assertEquals(9.55, candy.getPrice());
    // }

    // @Test
    // public void testCandyGetCaloriesReturnsCorrectAmount() {
    //     Candy candy = new Candy();
    //     assertEquals(770, candy.getCalories());
    //     candy.setSize(Size.CLASSIC);
    //     assertEquals(1215, candy.getCalories());
    //     candy.setSize(Size.WINNER);
    //     assertEquals(1465, candy.getCalories());
    // }

    // @Test
    // public void testCandyContainsAllDefaultToppings() {
    //     Candy candy = new Candy();
    //     assertTrue(candy.getChocolate());
    //     assertFalse(candy.getVanilla());
    //     assertFalse(candy.getStrawberry());
    // }

    // @Test
    // public void testCandyGetAndSetBothWorkAfterValuesHaveChanged() {
    //     Candy candy = new Candy();
    //     assertTrue(candy.getChocolate());
    //     assertFalse(candy.getVanilla());
    //     assertFalse(candy.getStrawberry());
    //     candy.setChocolate(false);
    //     candy.setVanilla(true);
    //     candy.setStrawberry(true);
    //     assertFalse(candy.getChocolate());
    //     assertTrue(candy.getVanilla());
    //     assertTrue(candy.getStrawberry());
    // }

    // @Test
    // public void testCandyAddsCorrectSpecialInstructionsToAttributes() {
    //     Candy candy = new Candy();
    //     assertTrue(candy.getSpecialInstructions().isEmpty());
    //     candy.setChocolate(false);
    //     assertTrue(candy.getSpecialInstructions().contains("Hold Chocolate"));
    //     candy.setVanilla(true);
    //     assertTrue(candy.getSpecialInstructions().contains("Add Vanilla"));
    //     candy.setStrawberry(true);
    //     assertTrue(candy.getSpecialInstructions().contains("Add Strawberry"));
    // }

    // @Test
    // public void testCandyIsEqualToAnotherInput() {
    //     Candy candy = new Candy();
    //     Candy input = new Candy();
    //     Dice fail = new Dice();
    //     assertFalse(candy.equals(fail));
    //     assertTrue(candy.equals(input));
    //     input.setSize(Size.WINNER);
    //     assertFalse(candy.equals(input));
    //     input.setSize(Size.JUNIOR);
    //     input.setChocolate(false);
    //     assertFalse(candy.equals(input));
    //     input.setChocolate(true);
    //     input.setVanilla(true);
    //     assertFalse(candy.equals(input));
    //     input.setVanilla(false);
    //     input.setStrawberry(true);
    //     assertFalse(candy.equals(input));
    // }

    // @Test
    // public void testCandyToStringIsCorrectlyFormatted() {
    //     Candy candy = new Candy();
    //     assertEquals("" + candy.getSize() + " Candy Land Shake", candy.toString());
    // }




    // @Test
    // public void testCraniumInstructionsShouldBeEmpty() {
    //     Cranium craunium = new Cranium();
    //     assertTrue(craunium.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testCraniumHasCorrectDefaultSize() {
    //     Cranium craunium = new Cranium();
    //     assertTrue(craunium.getSize().equals(Size.JUNIOR));
    // }

    // @Test
    // public void testCraniumIsTheCorrectPriceWithTheAppropriateSize() {
    //     Cranium craunium = new Cranium();
    //     assertEquals(4.35, craunium.getPrice());
    //     craunium.setSize(Size.CLASSIC);
    //     assertEquals(5.25, craunium.getPrice());
    //     craunium.setSize(Size.WINNER);
    //     assertEquals(6.00, craunium.getPrice());
    // }

    // @Test
    // public void testCraniumGetCaloriesReturnsCorrectAmount() {
    //     Cranium craunium = new Cranium();
    //     assertEquals(380, craunium.getCalories());
    //     craunium.setSize(Size.CLASSIC);
    //     assertEquals(495, craunium.getCalories());
    //     craunium.setSize(Size.WINNER);
    //     assertEquals(585, craunium.getCalories());
    // }

    // @Test
    // public void testCraniumContainsAllDefaultToppings() {
    //     Cranium craunium = new Cranium();
    //     assertTrue(craunium.getMilk());
    //     assertFalse(craunium.getCaramel());
    //     assertFalse(craunium.getChocolate());
    //     assertFalse(craunium.getMint());
    // }

    // @Test
    // public void testCraniumGetAndSetBothWorkAfterValuesHaveChanged() {
    //     Cranium craunium = new Cranium();
    //     assertTrue(craunium.getMilk());
    //     assertFalse(craunium.getCaramel());
    //     assertFalse(craunium.getChocolate());
    //     assertFalse(craunium.getMint());
    //     craunium.setMilk(false);
    //     craunium.setChocolate(true);
    //     craunium.setCaramel(true);
    //     craunium.setMint(true);
    //     assertFalse(craunium.getMilk());
    //     assertTrue(craunium.getCaramel());
    //     assertTrue(craunium.getChocolate());
    //     assertTrue(craunium.getMint());
    // }

    // @Test
    // public void testCraniumAddsCorrectSpecialInstructionsToAttributes() {
    //     Cranium craunium = new Cranium();
    //     assertTrue(craunium.getSpecialInstructions().isEmpty());
    //     craunium.setMilk(false);
    //     assertTrue(craunium.getSpecialInstructions().contains("Hold Milk"));
    //     craunium.setCaramel(true);
    //     assertTrue(craunium.getSpecialInstructions().contains("Add Caramel"));
    //     craunium.setChocolate(true);
    //     assertTrue(craunium.getSpecialInstructions().contains("Add Chocolate"));
    //     craunium.setMint(true);
    //     assertTrue(craunium.getSpecialInstructions().contains("Add Mint"));
    // }

    // @Test
    // public void testCraniumIsEqualToAnotherInput() {
    //     Cranium craunium = new Cranium();
    //     Cranium input = new Cranium();
    //     Dice fail = new Dice();
    //     assertFalse(craunium.equals(fail));
    //     assertTrue(craunium.equals(input));
    //     input.setSize(Size.WINNER);
    //     assertFalse(craunium.equals(input));
    //     input.setSize(Size.JUNIOR);
    //     input.setMilk(false);
    //     assertFalse(craunium.equals(input));
    //     input.setMilk(true);
    //     input.setCaramel(true);
    //     assertFalse(craunium.equals(input));
    //     input.setCaramel(false);
    //     input.setChocolate(true);
    //     assertFalse(craunium.equals(input));
    //     input.setChocolate(false);
    //     input.setMint(true);
    //     assertFalse(craunium.equals(input));
    // }

    // @Test
    // public void testCraniumToStringIsCorrectlyFormatted() {
    //     Cranium craunium = new Cranium();
    //     assertEquals("" + craunium.getSize() + " Cranium Coffee", craunium.toString());
    // }

    



    // @Test
    // public void testSorryInstructionsShouldBeEmpty() {
    //     Sorry sorry = new Sorry();
    //     assertTrue(sorry.getSpecialInstructions().isEmpty());
    // }

    // @Test
    // public void testSorryHasCorrectDefaultSize() {
    //     Sorry sorry = new Sorry();
    //     assertTrue(sorry.getSize().equals(Size.JUNIOR));
    // }

    // @Test
    // public void testSorryIsTheCorrectPriceWithTheAppropriateSize() {
    //     Sorry sorry = new Sorry();
    //     assertEquals(2.55, sorry.getPrice());
    //     sorry.setSize(Size.CLASSIC);
    //     assertEquals(3.85, sorry.getPrice());
    //     sorry.setSize(Size.WINNER);
    //     assertEquals(5.35, sorry.getPrice());
    // }

    // @Test
    // public void testSorryGetCaloriesReturnsCorrectAmount() {
    //     Sorry sorry = new Sorry();
    //     assertEquals(370, sorry.getCalories());
    //     sorry.setSize(Size.CLASSIC);
    //     assertEquals(535, sorry.getCalories());
    //     sorry.setSize(Size.WINNER);
    //     assertEquals(765, sorry.getCalories());
    // }

    // @Test
    // public void testSorryContainsAllDefaultToppings() {
    //     Sorry sorry = new Sorry();
    //     assertTrue(sorry.getCola());
    //     assertFalse(sorry.getCherry());
    //     assertFalse(sorry.getGrape());
    //     assertFalse(sorry.getOrange());
    // }

    // @Test
    // public void testSorryGetAndSetBothWorkAfterValuesHaveChanged() {
    //     Sorry sorry = new Sorry();
    //     assertTrue(sorry.getCola());
    //     assertFalse(sorry.getCherry());
    //     assertFalse(sorry.getGrape());
    //     assertFalse(sorry.getOrange());
    //     sorry.setCola(false);
    //     sorry.setCherry(true);
    //     sorry.setGrape(true);
    //     sorry.setOrange(true);
    //     assertFalse(sorry.getCola());
    //     assertTrue(sorry.getCherry());
    //     assertTrue(sorry.getGrape());
    //     assertTrue(sorry.getOrange());
    // }

    // @Test
    // public void testSorryAddsCorrectSpecialInstructionsToAttributes() {
    //     Sorry sorry = new Sorry();
    //     assertTrue(sorry.getSpecialInstructions().isEmpty());
    //     sorry.setCola(false);
    //     assertTrue(sorry.getSpecialInstructions().contains("Hold Cola"));
    //     sorry.setCherry(true);
    //     assertTrue(sorry.getSpecialInstructions().contains("Add Cherry"));
    //     sorry.setGrape(true);
    //     assertTrue(sorry.getSpecialInstructions().contains("Add Grape"));
    //     sorry.setOrange(true);
    //     assertTrue(sorry.getSpecialInstructions().contains("Add Orange"));
    // }

    // @Test
    // public void testSorryIsEqualToAnotherInput() {
    //     Sorry sorry = new Sorry();
    //     Sorry input = new Sorry();
    //     Dice fail = new Dice();
    //     assertFalse(sorry.equals(fail));
    //     assertTrue(sorry.equals(input));
    //     input.setSize(Size.WINNER);
    //     assertFalse(sorry.equals(input));
    //     input.setSize(Size.JUNIOR);
    //     sorry.setCola(false);
    //     assertFalse(sorry.equals(input));
    //     input.setCola(true);
    //     sorry.setCherry(true);
    //     assertFalse(sorry.equals(input));
    //     input.setCherry(false);
    //     sorry.setGrape(true);
    //     assertFalse(sorry.equals(input));
    //     input.setGrape(false);
    //     sorry.setOrange(true);
    //     assertFalse(sorry.equals(input));
    // }

    // @Test
    // public void testSorryToStringIsCorrectlyFormatted() {
    //     Sorry sorry = new Sorry();
    //     assertEquals("" + sorry.getSize() + " Sorry Soda", sorry.toString());
    // }
}
