package gamegrub.gui.entrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.entrees.Monopoly;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.entrees.MonopolyPanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for MonopolyPanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class MonopolyPanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), new Monopoly());
        assertThat(panel.item, is(new Monopoly()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), new Monopoly());
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
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        item.setBase(base);
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        item.setSpicyBeef(false);
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.spicyBeef.isSelected(), is(false));
        item.setSpicyBeef(true);
        panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.spicyBeef.isSelected(), is(true));
    }

    /**
     * Test for crispyChickenCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in crispyChicken.
     */
    @Test
    public void testCripsyChickenCheckbox() {
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        item.setCrispyChicken(false);
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.crispyChicken.isSelected(), is(false));
        item.setCrispyChicken(true);
        panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.crispyChicken.isSelected(), is(true));
    }
    
    /**
     * Test for BeansCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Beans.
     */
    @Test
    public void testBeansCheckbox() {
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        panel.beans.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getBeans(), is(false));
        panel.beans.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getBeans(), is(true));
    }

    /**
     * Test for BeansCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Beans correctly.
     */
    @Test
    public void testBeansCheckboxSetCorretly() {
        Monopoly item = new Monopoly();
        item.setBeans(false);
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.beans.isSelected(), is(false));
        item.setBeans(true);
        panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.beans.isSelected(), is(true));
    }

    /**
     * Test for VeggiesCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Veggies.
     */
    @Test
    public void testVeggiesCheckbox() {
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        item.setVeggies(false);
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.veggies.isSelected(), is(false));
        item.setVeggies(true);
        panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.veggies.isSelected(), is(true));
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
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        item.removeTopping(t);
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        assertThat(panel.toppingBox.get(t).isSelected(), is(false));
        item.addTopping(t);
        panel = new MonopolyPanel(new PrimaryWindow(), item);
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
        Monopoly item = new Monopoly();
        MonopolyPanel panel = new MonopolyPanel(new PrimaryWindow(), item);
        if (item.getBase() == Base.RICE) {
            panel.base.setSelectedItem(Base.CHIPS);
        } else {
            panel.base.setSelectedItem(Base.RICE);
        }
        panel.spicyBeef.setSelected(!item.getSpicyBeef());
        panel.crispyChicken.setSelected(!item.getCrispyChicken());
        panel.beans.setSelected(!item.getBeans());
        panel.veggies.setSelected(!item.getVeggies());
        for (Toppings t : Toppings.values()) {
            boolean select = !item.getToppings().contains(t);
            panel.toppingBox.get(t).setSelected(select);
        }
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Monopoly unchanged = new Monopoly();
        assertThat(item, is(unchanged));
    }
}