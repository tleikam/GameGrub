package gamegrub.gui.drinks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.drinks.Sorry;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.SorryPanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for SorryPanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class SorryPanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), new Sorry());
        assertThat(panel.drink, is(new Sorry()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), new Sorry());
        assertDoesNotThrow(() -> panel.actionPerformed(new ActionEvent(panel, 0, "bad")));
    }

    /**
     * ParameterizedTest for Size.
     *
     *<p>This test checks to make sure the combobox in
     the gui works with all Enums of Size.
     */
    @ParameterizedTest
    @EnumSource(Size.class)
    public void testSizeCombobox(Size size) {
        Sorry sorry = new Sorry();
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        panel.size.setSelectedItem(size);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getSize(), is(size));
    }

    /**
     * ParameterizedTest for Size.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets all Enums of Size correctly.
     */
    @ParameterizedTest
    @EnumSource(Size.class)
    public void testSizeComboboxSetCorrect(Size size) {
        Sorry sorry = new Sorry();
        sorry.setSize(size);
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.size.getSelectedItem(), is(size));
    }

    /**
     * Test for ColaCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Cola.
     */
    @Test
    public void testColaCheckbox() {
        Sorry sorry = new Sorry();
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        panel.cola.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getCola(), is(false));
        panel.cola.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getCola(), is(true));
    }

    /**
     * Test for ColaCheckBox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Cola correctly.
     */
    @Test
    public void testColaCheckboxSetCorretly() {
        Sorry sorry = new Sorry();
        sorry.setCola(false);
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.cola.isSelected(), is(false));
        sorry.setCola(true);
        panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.cola.isSelected(), is(true));
    }

    /**
     * Test for CherryCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Cherry.
     */
    @Test
    public void testCherryCheckbox() {
        Sorry sorry = new Sorry();
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        panel.cherry.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getCherry(), is(false));
        panel.cherry.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getCherry(), is(true));
    }

    /**
     * Test for CherryCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Cherry correctly.
     */
    @Test
    public void testCherryCheckboxSetCorretly() {
        Sorry sorry = new Sorry();
        sorry.setCherry(false);
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.cherry.isSelected(), is(false));
        sorry.setCherry(true);
        panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.cherry.isSelected(), is(true));
    }
    
    /**
     * Test for GrapeCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Grape.
     */
    @Test
    public void testGrapeCheckbox() {
        Sorry sorry = new Sorry();
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        panel.grape.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getGrape(), is(false));
        panel.grape.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getGrape(), is(true));
    }

    /**
     * Test for GrapeCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Grape correctly.
     */
    @Test
    public void testGrapeCheckboxSetCorretly() {
        Sorry sorry = new Sorry();
        sorry.setGrape(false);
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.grape.isSelected(), is(false));
        sorry.setGrape(true);
        panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.grape.isSelected(), is(true));
    }

    /**
     * Test for OrangeCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Orange.
     */
    @Test
    public void testOrangeCheckbox() {
        Sorry sorry = new Sorry();
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        panel.orange.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getOrange(), is(false));
        panel.orange.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(sorry.getOrange(), is(true));
    }

    /**
     * Test for OrangeCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Orange correctly.
     */
    @Test
    public void testOrangeCheckboxSetCorretly() {
        Sorry sorry = new Sorry();
        sorry.setOrange(false);
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.orange.isSelected(), is(false));
        sorry.setOrange(true);
        panel = new SorryPanel(new PrimaryWindow(), sorry);
        assertThat(panel.orange.isSelected(), is(true));
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
        Sorry sorry = new Sorry();
        SorryPanel panel = new SorryPanel(new PrimaryWindow(), sorry);
        if (sorry.getSize() == Size.JUNIOR) {
            panel.size.setSelectedItem(Size.WINNER);
        } else {
            panel.size.setSelectedItem(Size.JUNIOR);
        }
        panel.cola.setSelected(!sorry.getCola());
        panel.cherry.setSelected(!sorry.getCherry());
        panel.grape.setSelected(!sorry.getGrape());
        panel.orange.setSelected(!sorry.getOrange());
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Sorry unchanged = new Sorry();
        assertThat(sorry, is(unchanged));
    }
}