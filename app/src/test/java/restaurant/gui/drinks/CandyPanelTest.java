package gamegrub.gui.drinks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import gamegrub.data.drinks.Candy;
import gamegrub.data.enums.Size;
import gamegrub.data.enums.Toppings;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.CandyPanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for CandyPanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class CandyPanelTest {

    /**
     * Test Default Constructor.
     */
    @Test
    public void testDefaultConstructor() {
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), new Candy());
        assertThat(panel.candy, is(new Candy()));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), new Candy());
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
        Candy candy = new Candy();
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        panel.size.setSelectedItem(size);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getSize(), is(size));
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
        Candy candy = new Candy();
        candy.setSize(size);
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
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
        Candy candy = new Candy();
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        panel.chocolate.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getChocolate(), is(false));
        panel.chocolate.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getChocolate(), is(true));
    }

    /**
     * Test for ChocolateCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets chocolate correctly.
     */
    @Test
    public void testChocolateCheckboxSetCorretly() {
        Candy candy = new Candy();
        candy.setChocolate(false);
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        assertThat(panel.chocolate.isSelected(), is(false));
        candy.setChocolate(true);
        panel = new CandyPanel(new PrimaryWindow(), candy);
        assertThat(panel.chocolate.isSelected(), is(true));
    }

    /**
     * Test for VanillaCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in vanilla.
     */
    @Test
    public void testVanillaCheckbox() {
        Candy candy = new Candy();
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        panel.vanilla.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getVanilla(), is(false));
        panel.vanilla.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getVanilla(), is(true));
    }

    /**
     * Test for VanillaCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets vanilla correctly.
     */
    @Test
    public void testVanillaCheckboxSetCorretly() {
        Candy candy = new Candy();
        candy.setVanilla(false);
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        assertThat(panel.vanilla.isSelected(), is(false));
        candy.setVanilla(true);
        panel = new CandyPanel(new PrimaryWindow(), candy);
        assertThat(panel.vanilla.isSelected(), is(true));
    }
    
    /**
     * Test for StrawberryCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui works in Strawberry.
     */
    @Test
    public void testStrawberryCheckbox() {
        Candy candy = new Candy();
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        panel.strawberry.setSelected(false);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getStrawberry(), is(false));
        panel.strawberry.setSelected(true);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(candy.getStrawberry(), is(true));
    }

    /**
     * Test for StrawberryCheckbox.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets Strawberry correctly.
     */
    @Test
    public void testStrawberryCheckboxSetCorretly() {
        Candy candy = new Candy();
        candy.setStrawberry(false);
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        assertThat(panel.strawberry.isSelected(), is(false));
        candy.setStrawberry(true);
        panel = new CandyPanel(new PrimaryWindow(), candy);
        assertThat(panel.strawberry.isSelected(), is(true));
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
        Candy candy = new Candy();
        CandyPanel panel = new CandyPanel(new PrimaryWindow(), candy);
        if (candy.getSize() == Size.JUNIOR) {
            panel.size.setSelectedItem(Size.WINNER);
        } else {
            panel.size.setSelectedItem(Size.JUNIOR);
        }
        panel.chocolate.setSelected(!candy.getChocolate());
        panel.vanilla.setSelected(!candy.getVanilla());
        panel.strawberry.setSelected(!candy.getStrawberry());
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Candy unchanged = new Candy();
        assertThat(candy, is(unchanged));
    }
}