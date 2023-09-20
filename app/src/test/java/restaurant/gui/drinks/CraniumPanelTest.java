package gamegrub.gui.drinks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.drinks.Cranium;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.CraniumPanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for CraniumPanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CraniumPanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), new Cranium());
        assertThat(panel.drink, is(new Cranium()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), new Cranium());
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
        Cranium cranium = new Cranium();
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        panel.size.setSelectedItem(size);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getSize(), is(size));
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
        Cranium cranium = new Cranium();
        cranium.setSize(size);
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.size.getSelectedItem(), is(size));
    }

    /**
     * Test for ChocolateCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in chocolate.
     */
    @Test
    public void testChocolateCheckbox() {
        Cranium cranium = new Cranium();
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        panel.chocolate.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getChocolate(), is(false));
        panel.chocolate.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getChocolate(), is(true));
    }

    /**
     * Test for ChocolateCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets chocolate correctly.
     */
    @Test
    public void testChocolateCheckboxSetCorretly() {
        Cranium cranium = new Cranium();
        cranium.setChocolate(false);
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.chocolate.isSelected(), is(false));
        cranium.setChocolate(true);
        panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.chocolate.isSelected(), is(true));
    }

    /**
     * Test for MilkCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Milk.
     */
    @Test
    public void testMilkCheckbox() {
        Cranium cranium = new Cranium();
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        panel.milk.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getMilk(), is(false));
        panel.milk.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getMilk(), is(true));
    }

    /**
     * Test for MilkCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Milk correctly.
     */
    @Test
    public void testMilkCheckboxSetCorretly() {
        Cranium cranium = new Cranium();
        cranium.setMilk(false);
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.milk.isSelected(), is(false));
        cranium.setMilk(true);
        panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.milk.isSelected(), is(true));
    }
    
    /**
     * Test for CaramelCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Caramel.
     */
    @Test
    public void testCaramelCheckbox() {
        Cranium cranium = new Cranium();
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        panel.caramel.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getCaramel(), is(false));
        panel.caramel.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getCaramel(), is(true));
    }

    /**
     * Test for CaramelCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Caramel correctly.
     */
    @Test
    public void testCaramelCheckboxSetCorretly() {
        Cranium cranium = new Cranium();
        cranium.setCaramel(false);
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.caramel.isSelected(), is(false));
        cranium.setCaramel(true);
        panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.caramel.isSelected(), is(true));
    }

    /**
     * Test for MintCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Mint.
     */
    @Test
    public void testMintCheckbox() {
        Cranium cranium = new Cranium();
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        panel.mint.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getMint(), is(false));
        panel.mint.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(cranium.getMint(), is(true));
    }

    /**
     * Test for MintCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Mint correctly.
     */
    @Test
    public void testMintCheckboxSetCorretly() {
        Cranium cranium = new Cranium();
        cranium.setMint(false);
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.mint.isSelected(), is(false));
        cranium.setMint(true);
        panel = new CraniumPanel(new PrimaryWindow(), cranium);
        assertThat(panel.mint.isSelected(), is(true));
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
        Cranium cranium = new Cranium();
        CraniumPanel panel = new CraniumPanel(new PrimaryWindow(), cranium);
        if (cranium.getSize() == Size.JUNIOR) {
            panel.size.setSelectedItem(Size.WINNER);
        } else {
            panel.size.setSelectedItem(Size.JUNIOR);
        }
        panel.chocolate.setSelected(!cranium.getChocolate());
        panel.milk.setSelected(!cranium.getMilk());
        panel.caramel.setSelected(!cranium.getCaramel());
        panel.mint.setSelected(!cranium.getMint());
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Cranium unchanged = new Cranium();
        assertThat(cranium, is(unchanged));
    }
}