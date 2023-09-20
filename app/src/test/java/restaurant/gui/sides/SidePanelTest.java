package gamegrub.gui.sides;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import gamegrub.data.enums.Size;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.sides.SidePanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Test Class for SidePanel.
 *
 * @author Travis Leikam
 * @version 0.1
 */
public class SidePanelTest {

    /**
     * Test Catan Constructor.
     */
    @Test
    public void testCatanConstructor() {
        SidePanel panel = new SidePanel(new PrimaryWindow(), new Catan());
        assertThat(panel.side, is(new Catan()));
    }

    /**
     * Test Dice Constructor.
     */
    @Test
    public void testDiceConstructor() {
        SidePanel panel = new SidePanel(new PrimaryWindow(), new Dice());
        assertThat(panel.side, is(new Dice()));
    }

    /**
     * Test Risk Constructor.
     */
    @Test
    public void testRiskConstructor() {
        SidePanel panel = new SidePanel(new PrimaryWindow(), new Risk());
        assertThat(panel.side, is(new Risk()));
    }

    /**
     * Test Bad Constructor.
     */
    @Test
    public void testBadConstructionThrowsError() {
        SidePanel panel;
        assertThrows(IllegalArgumentException.class,
                () -> new SidePanel(new PrimaryWindow(), null));
    }

    /**
     * Test for Bad ActionEvent.
     *
     *<p>This test ensures that no actionevent outside of the
     ones provided work or throw an exception.
     */
    @Test
    public void testBadActionCommand() {
        SidePanel panel = new SidePanel(new PrimaryWindow(), new Catan());
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
        Catan item = new Catan();
        SidePanel panel = new SidePanel(new PrimaryWindow(), item);
        panel.size.setSelectedItem(size);
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertThat(item.getSize(), is(size));
    }

    /**
     * ParameterizedTest for Size.
     *
     *<p>This test checks to make sure the combobox in
     the gui sets all Enums of Size correctly.
     */
    @ParameterizedTest
    @EnumSource(Size.class)
    public void testBaseComboboxSetCorrect(Size size) {
        Catan item = new Catan();
        item.setSize(size);
        SidePanel panel = new SidePanel(new PrimaryWindow(), item);
        assertThat(panel.size.getSelectedItem(), is(size));
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
        Risk item = new Risk();
        SidePanel panel = new SidePanel(new PrimaryWindow(), item);
        if (item.getSize() == Size.JUNIOR) {
            panel.size.setSelectedItem(Size.WINNER);
        } else {
            panel.size.setSelectedItem(Size.JUNIOR);
        }
        panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
        Risk unchanged = new Risk();
        assertThat(item, is(unchanged));
    }
}