package gamegrub.gui.entrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.entrees.YahtzeePanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for YahtzeePanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class YahtzeePanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), new Yahtzee());
        assertThat(panel.item, is(new Yahtzee()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), new Yahtzee());
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
        Yahtzee item = new Yahtzee();
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
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
        Yahtzee item = new Yahtzee();
        item.setBase(base);
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.base.getSelectedItem(), is(base));
    }

    /**
     * Test for TunaCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Tuna.
     */
    @Test
    public void testTunaCheckbox() {
        Yahtzee item = new Yahtzee();
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        panel.tuna.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getTuna(), is(false));
        panel.tuna.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getTuna(), is(true));
    }

    /**
     * Test for TunaCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Tuna correctly.
     */
    @Test
    public void testTunaCheckboxSetCorretly() {
        Yahtzee item = new Yahtzee();
        item.setTuna(false);
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.tuna.isSelected(), is(false));
        item.setTuna(true);
        panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.tuna.isSelected(), is(true));
    }

    /**
     * Test for VeggiesCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Veggies.
     */
    @Test
    public void testVeggiesCheckbox() {
        Yahtzee item = new Yahtzee();
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        panel.veggies.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getVeggies(), is(false));
        panel.veggies.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getVeggies(), is(true));
    }

    /**
     * Test for VeggiesCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Veggies correctly.
     */
    @Test
    public void testVeggiesCheckboxSetCorretly() {
        Yahtzee item = new Yahtzee();
        item.setVeggies(false);
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.veggies.isSelected(), is(false));
        item.setVeggies(true);
        panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.veggies.isSelected(), is(true));
    }
    
    /**
     * Test for SeaweedCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Seaweed.
     */
    @Test
    public void testSeaweedCheckbox() {
        Yahtzee item = new Yahtzee();
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        panel.seaweed.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getSeaweed(), is(false));
        panel.seaweed.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getSeaweed(), is(true));
    }

    /**
     * Test for SeaweedCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Seaweed correctly.
     */
    @Test
    public void testSeaweedCheckboxSetCorretly() {
        Yahtzee item = new Yahtzee();
        item.setSeaweed(false);
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.seaweed.isSelected(), is(false));
        item.setSeaweed(true);
        panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.seaweed.isSelected(), is(true));
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
        Yahtzee item = new Yahtzee();
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
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
        Yahtzee item = new Yahtzee();
        item.removeTopping(t);
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        assertThat(panel.toppingBox.get(t).isSelected(), is(false));
        item.addTopping(t);
        panel = new YahtzeePanel(new PrimaryWindow(), item);
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
        Yahtzee item = new Yahtzee();
        YahtzeePanel panel = new YahtzeePanel(new PrimaryWindow(), item);
        if (item.getBase() == Base.RICE) {
            panel.base.setSelectedItem(Base.CHIPS);
        } else {
            panel.base.setSelectedItem(Base.RICE);
        }
        panel.tuna.setSelected(!item.getTuna());
        panel.veggies.setSelected(!item.getVeggies());
        panel.seaweed.setSelected(!item.getSeaweed());
        for (Toppings t : Toppings.values()) {
            boolean select = !item.getToppings().contains(t);
            panel.toppingBox.get(t).setSelected(select);
        }
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Yahtzee unchanged = new Yahtzee();
        assertThat(item, is(unchanged));
    }
}