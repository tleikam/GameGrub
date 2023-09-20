package gamegrub.gui.entrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.entrees.Jenga;
import gamegrub.data.enums.Base;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.entrees.JengaPanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for JengaPanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class JengaPanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), new Jenga());
        assertThat(panel.item, is(new Jenga()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), new Jenga());
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
        Jenga item = new Jenga();
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
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
        Jenga item = new Jenga();
        item.setBase(base);
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
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
        Jenga item = new Jenga();
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
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
        Jenga item = new Jenga();
        item.setSpicyBeef(false);
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
        assertThat(panel.spicyBeef.isSelected(), is(false));
        item.setSpicyBeef(true);
        panel = new JengaPanel(new PrimaryWindow(), item);
        assertThat(panel.spicyBeef.isSelected(), is(true));
    }

    /**
     * Test for BeansCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Beans.
     */
    @Test
    public void testBeansCheckbox() {
        Jenga item = new Jenga();
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
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
        Jenga item = new Jenga();
        item.setBeans(false);
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
        assertThat(panel.beans.isSelected(), is(false));
        item.setBeans(true);
        panel = new JengaPanel(new PrimaryWindow(), item);
        assertThat(panel.beans.isSelected(), is(true));
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
        Jenga item = new Jenga();
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
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
        Jenga item = new Jenga();
        item.removeTopping(t);
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
        assertThat(panel.toppingBox.get(t).isSelected(), is(false));
        item.addTopping(t);
        panel = new JengaPanel(new PrimaryWindow(), item);
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
        Jenga item = new Jenga();
        JengaPanel panel = new JengaPanel(new PrimaryWindow(), item);
        if (item.getBase() == Base.RICE) {
            panel.base.setSelectedItem(Base.CHIPS);
        } else {
            panel.base.setSelectedItem(Base.RICE);
        }
        panel.spicyBeef.setSelected(!item.getSpicyBeef());
        panel.beans.setSelected(!item.getBeans());
        for (Toppings t : Toppings.values()) {
            boolean select = !item.getToppings().contains(t);
            panel.toppingBox.get(t).setSelected(select);
        }
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Jenga unchanged = new Jenga();
        assertThat(item, is(unchanged));
    }
}