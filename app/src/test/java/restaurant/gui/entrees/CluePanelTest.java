package gamegrub.gui.entrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.entrees.Clue;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.entrees.CluePanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for CluePanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CluePanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        CluePanel panel = new CluePanel(new PrimaryWindow(), new Clue());
        assertThat(panel.item, is(new Clue()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        CluePanel panel = new CluePanel(new PrimaryWindow(), new Clue());
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
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
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
        Clue item = new Clue();
        item.setBase(base);
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.base.getSelectedItem(), is(base));
    }

    /**
     * Test for SpicyBeefCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in SpicyBeef.
     */
    @Test
    public void testSpicyBeefCheckbox() {
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        panel.spicyBeef.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getSpicyBeef(), is(false));
        panel.spicyBeef.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getSpicyBeef(), is(true));
    }

    /**
     * Test for SpicyBeefCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets SpicyBeef correctly.
     */
    @Test
    public void testSpicyBeefCheckboxSetCorretly() {
        Clue item = new Clue();
        item.setSpicyBeef(false);
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.spicyBeef.isSelected(), is(false));
        item.setSpicyBeef(true);
        panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.spicyBeef.isSelected(), is(true));
    }

    /**
     * Test for ChiliCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Chili.
     */
    @Test
    public void testChiliCheckbox() {
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        panel.chili.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getChili(), is(false));
        panel.chili.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getChili(), is(true));
    }

    /**
     * Test for ChiliCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Chili correctly.
     */
    @Test
    public void testChiliCheckboxSetCorretly() {
        Clue item = new Clue();
        item.setChili(false);
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.chili.isSelected(), is(false));
        item.setChili(true);
        panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.chili.isSelected(), is(true));
    }
    
    /**
     * Test for RedSauceCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in RedSauce.
     */
    @Test
    public void testRedSauceCheckbox() {
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        panel.redSauce.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getRedSauce(), is(false));
        panel.redSauce.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getRedSauce(), is(true));
    }

    /**
     * Test for BeansCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Beans.
     */
    @Test
    public void testBeansCheckboxSetCorretly() {
        Clue item = new Clue();
        item.setBeans(false);
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.beans.isSelected(), is(false));
        item.setBeans(true);
        panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.beans.isSelected(), is(true));
    }

    /**
     * Test for BeansCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Beans correctly.
     */
    @Test
    public void testBeansCheckbox() {
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        panel.beans.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getBeans(), is(false));
        panel.beans.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getBeans(), is(true));
    }

    /**
     * Test for redsauceCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets redSauce correctly.
     */
    @Test
    public void testRedSauceCheckboxSetCorretly() {
        Clue item = new Clue();
        item.setRedSauce(false);
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.redSauce.isSelected(), is(false));
        item.setRedSauce(true);
        panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.redSauce.isSelected(), is(true));
    }

    /**
     * ParameterizedTest for ToppingCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works for all toppings in Clue.
     */
    @ParameterizedTest
    @EnumSource(Toppings.class)
    public void testToppingCheckbox(Toppings t) {
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
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
        Clue item = new Clue();
        item.removeTopping(t);
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        assertThat(panel.toppingBox.get(t).isSelected(), is(false));
        item.addTopping(t);
        panel = new CluePanel(new PrimaryWindow(), item);
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
        Clue item = new Clue();
        CluePanel panel = new CluePanel(new PrimaryWindow(), item);
        if (item.getBase() == Base.RICE) {
            panel.base.setSelectedItem(Base.CHIPS);
        } else {
            panel.base.setSelectedItem(Base.RICE);
        }
        panel.spicyBeef.setSelected(!item.getSpicyBeef());
        panel.chili.setSelected(!item.getChili());
        panel.redSauce.setSelected(!item.getRedSauce());
        panel.beans.setSelected(!item.getBeans());
        for (Toppings t : Toppings.values()) {
            boolean select = !item.getToppings().contains(t);
            panel.toppingBox.get(t).setSelected(select);
        }
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Clue unchanged = new Clue();
        assertThat(item, is(unchanged));
    }
}