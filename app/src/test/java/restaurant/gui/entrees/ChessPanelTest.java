package gamegrub.gui.entrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.entrees.Chess;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.entrees.ChessPanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for ChessPanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class ChessPanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), new Chess());
        assertThat(panel.item, is(new Chess()));
    }

    /**
     * Test for Bad ActionEvent.
     */
    @Test
    public void testBadActionCommand() {
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), new Chess());
        assertDoesNotThrow(() -> panel.actionPerformed(new ActionEvent(panel, 0, "bad")));
    }

    /**
     * ParameterizedTest for Base.
     *
     *<p>This test checks to make sure the combobox in
     the gui works with all Enums of Base.
     */
    @ParameterizedTest
    @EnumSource(Base.class)
    public void testBaseCombobox(Base base) {
        Chess item = new Chess();
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        panel.base.setSelectedItem(base);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getBase(), is(base));
    }

    /**
     * ParameterizedTest for BaseSet.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets all Enums of Base correctly.
     */
    @ParameterizedTest
    @EnumSource(Base.class)
    public void testBaseComboboxSetCorrect(Base base) {
        Chess item = new Chess();
        item.setBase(base);
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.base.getSelectedItem(), is(base));
    }

    /**
     * Test for crispyChickenCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in crispyChicken.
     */
    @Test
    public void testCrispyCickenCheckbox() {
        Chess item = new Chess();
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        panel.crispyChicken.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getCrispyChicken(), is(false));
        panel.crispyChicken.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getCrispyChicken(), is(true));
    }

    /**
     * Test for crispyChickenCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets crispyChicken correctly.
     */
    @Test
    public void testCrispyChickenCheckboxSetCorretly() {
        Chess item = new Chess();
        item.setCrispyChicken(false);
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.crispyChicken.isSelected(), is(false));
        item.setCrispyChicken(true);
        panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.crispyChicken.isSelected(), is(true));
    }

    /**
     * Test for RedSauceCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in RedSauce.
     */
    @Test
    public void testRedSauceCheckbox() {
        Chess item = new Chess();
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        panel.redSauce.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getRedSauce(), is(false));
        panel.redSauce.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getRedSauce(), is(true));
    }

    /**
     * Test for redsauceCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets redSauce correctly.
     */
    @Test
    public void testRedSauceCheckboxSetCorretly() {
        Chess item = new Chess();
        item.setRedSauce(false);
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.redSauce.isSelected(), is(false));
        item.setRedSauce(true);
        panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.redSauce.isSelected(), is(true));
    }

    /**
     * ParameterizedTest for ToppingCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works for all toppings in Chess.
     */
    @ParameterizedTest
    @EnumSource(Toppings.class)
    public void testToppingCheckbox(Toppings t) {
        Chess item = new Chess();
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        panel.toppingBox.get(t).setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getToppings().contains(t), is(false));
        panel.toppingBox.get(t).setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getToppings().contains(t), is(true));
    }

    /**
     * ParameterizedTest for Toppings.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets all Toppings of Chess correctly.
     */
    @ParameterizedTest
    @EnumSource(Toppings.class)
    public void testToppingCheckboxSetCorrectly(Toppings t) {
        Chess item = new Chess();
        item.removeTopping(t);
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.toppingBox.get(t).isSelected(), is(false));
        item.addTopping(t);
        panel = new ChessPanel(new PrimaryWindow(), item);
        assertThat(panel.toppingBox.get(t).isSelected(), is(true));
    }

    /**
     * Test for CancelButtonActionEvent.
     *
     *<p>This test checks to make sure actionEvent cancel 
     works correctly and keeps the value of the item 
     unchanged.
     */
    @Test
    public void testCancelButton() {
        Chess item = new Chess();
        ChessPanel panel = new ChessPanel(new PrimaryWindow(), item);
        if (item.getBase() == Base.RICE) {
            panel.base.setSelectedItem(Base.CHIPS);
        } else {
            panel.base.setSelectedItem(Base.RICE);
        }
        panel.redSauce.setSelected(!item.getRedSauce());
        panel.crispyChicken.setSelected(!item.getCrispyChicken());
        for (Toppings t : Toppings.values()) {
            boolean select = !item.getToppings().contains(t);
            panel.toppingBox.get(t).setSelected(select);
        }
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Chess unchanged = new Chess();
        assertThat(item, is(unchanged));
    }
}