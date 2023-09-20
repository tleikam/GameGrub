package gamegrub.gui;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gamegrub.data.Item;
import gamegrub.data.combo.Combo;
import gamegrub.data.drinks.Candy;
import gamegrub.data.drinks.Cranium;
import gamegrub.data.drinks.Drink;
import gamegrub.data.drinks.Sorry;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.entrees.Entree;
import gamegrub.data.entrees.Jenga;
import gamegrub.data.entrees.Monopoly;
import gamegrub.data.entrees.Yahtzee;
import gamegrub.data.enums.Size;
import gamegrub.data.menu.Menu;
import gamegrub.data.sides.Catan;
import gamegrub.data.sides.Dice;
import gamegrub.data.sides.Risk;
import gamegrub.data.sides.Side;
import gamegrub.gui.ItemPanel;
import gamegrub.gui.MenuPanel;
import gamegrub.gui.PrimaryWindow;
import gamegrub.gui.drinks.CandyPanel;
import gamegrub.gui.drinks.CraniumPanel;
import gamegrub.gui.drinks.DrinksPanel;
import gamegrub.gui.drinks.SorryPanel;
import gamegrub.gui.entrees.ChessPanel;
import gamegrub.gui.entrees.CluePanel;
import gamegrub.gui.entrees.EntreePanel;
import gamegrub.gui.entrees.JengaPanel;
import gamegrub.gui.entrees.MonopolyPanel;
import gamegrub.gui.entrees.YahtzeePanel;
import gamegrub.gui.sides.SidePanel;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * MockClassComboPanel Testing.
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class ComboPanelTest {

    @Mock 
    PrimaryWindow window;
    @Mock
    Combo mockCombo;

    @Test
    public void testSelectedNoneClearsEntreePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.entreeBox.getModel().setSelectedItem("No Selection");
        assertThat(panel.entreePanel, instanceOf(ItemPanel.class));
    }

    @Test
    public void testSelectedNoneClearsSidePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.sideBox.getModel().setSelectedItem("No Selection");
        assertThat(panel.sidePanel, instanceOf(ItemPanel.class));
    }

    @Test
    public void testSelectedNoneClearsDrinkPanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.drinkBox.getModel().setSelectedItem("No Selection");
        assertThat(panel.drinkPanel, instanceOf(ItemPanel.class));
    }

    // @Test
    // public void testCancelChangesNothing() {
    //     ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
    //     panel.entreeBox.getModel().setSelectedItem("No Selection");
    //     panel.sideBox.getModel().setSelectedItem("No Selection");
    //     panel.drinkBox.getModel().setSelectedItem("No Selection");
    //     panel.actionPerformed(new ActionEvent(panel, 0, "cancel"));
    //     ComboPanel unchanged = new ComboPanel(window, new Combo("Game Night"));
    //     assertThat(panel, is(unchanged));
    // }

    @Test
    public void testSelectedEntreeChangesEntreePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.entreeBox.getModel().setSelectedItem("Monopoly Bowl");
        assertThat(panel.entreePanel, instanceOf(MonopolyPanel.class));
    }

    @Test
    public void testSelectedSideChangesSidePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.sideBox.getModel().setSelectedItem("Winner Potato Dice");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
    }

    @Test
    public void testSelectedDrinkChangesDrinkPanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.drinkBox.getModel().setSelectedItem("Winner Candy Land Shake");
        assertThat(panel.drinkPanel, instanceOf(CandyPanel.class));
    }

    @Test
    public void testNullComboNoSelectedEntreePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo());
        assertThat(panel.entreePanel, instanceOf(ItemPanel.class));
    }

    @Test
    public void testNullComboNoSelectedSidePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo());
        assertThat(panel.sidePanel, instanceOf(ItemPanel.class));
    }

    @Test
    public void testNullComboNoSelectedDrinkPanel() {
        ComboPanel panel = new ComboPanel(window, new Combo());
        assertThat(panel.drinkPanel, instanceOf(ItemPanel.class));
    }

    @Test
    public void testCustomCombo() {
        ComboPanel panel = new ComboPanel(window, new Combo());
        assertThat(panel.entreePanel, instanceOf(ItemPanel.class));
        assertThat(panel.drinkPanel, instanceOf(ItemPanel.class));
        assertThat(panel.sidePanel, instanceOf(ItemPanel.class));
    }

    @Test
    public void testSaveNoSelectionMakesEntreeNull() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.entreeBox.getModel().setSelectedItem("No Selection");
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertTrue(panel.combo.getEntreeInstance() == null);
    }

    @Test
    public void testSaveNoSelectionMakesSideNull() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.sideBox.getModel().setSelectedItem("No Selection");
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertTrue(panel.combo.getSideInstance() == null);
    }

    @Test
    public void testSaveNoSelectionMakesDrinkNull() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.drinkBox.getModel().setSelectedItem("No Selection");
        panel.actionPerformed(new ActionEvent(panel, 0, "save"));
        assertTrue(panel.combo.getDrinkInstance() == null);
    }

    @Test
    public void testSelectedDrinkLoadsCorrectDrinkPanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Game Night"));
        panel.drinkBox.getModel().setSelectedItem("No Selection");
        assertThat(panel.drinkPanel, instanceOf(ItemPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Junior Candy Land Shake");
        assertThat(panel.drinkPanel, instanceOf(CandyPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Classic Candy Land Shake");
        assertThat(panel.drinkPanel, instanceOf(CandyPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Winner Candy Land Shake");
        assertThat(panel.drinkPanel, instanceOf(CandyPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Candy Land Shake");
        assertThat(panel.drinkPanel, instanceOf(CandyPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Junior Sorry Soda");
        assertThat(panel.drinkPanel, instanceOf(SorryPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Classic Sorry Soda");
        assertThat(panel.drinkPanel, instanceOf(SorryPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Winner Sorry Soda");
        assertThat(panel.drinkPanel, instanceOf(SorryPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Sorry Soda");
        assertThat(panel.drinkPanel, instanceOf(SorryPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Junior Cranium Coffee");
        assertThat(panel.drinkPanel, instanceOf(CraniumPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Classic Cranium Coffee");
        assertThat(panel.drinkPanel, instanceOf(CraniumPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Winner Cranium Coffee");
        assertThat(panel.drinkPanel, instanceOf(CraniumPanel.class));
        panel.drinkBox.getModel().setSelectedItem("Cranium Coffee");
        assertThat(panel.drinkPanel, instanceOf(CraniumPanel.class));
    }

    @Test
    public void testSelectedSideLoadsCorrectSidePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("Big Appetite"));
        panel.sideBox.getModel().setSelectedItem("No Selection");
        assertThat(panel.sidePanel, instanceOf(ItemPanel.class));
        panel.sideBox.getModel().setSelectedItem("Potato Dice");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Junior Potato Dice");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Classic Potato Dice");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Winner Potato Dice");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Catan Skewers");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Junior Catan Skewers");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Classic Catan Skewers");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Winner Catan Skewers");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Risk Bites");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Junior Risk Bites");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Classic Risk Bites");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
        panel.sideBox.getModel().setSelectedItem("Winner Risk Bites");
        assertThat(panel.sidePanel, instanceOf(SidePanel.class));
    }

    @Test
    public void testSelectedEntreeLoadsCorrectEntreePanel() {
        ComboPanel panel = new ComboPanel(window, new Combo("The Winner"));
        panel.entreeBox.getModel().setSelectedItem("No Selection");
        assertThat(panel.entreePanel, instanceOf(ItemPanel.class));
        panel.entreeBox.getModel().setSelectedItem("Chess Chicken Parmesan");
        assertThat(panel.entreePanel, instanceOf(ChessPanel.class));
        panel.entreeBox.getModel().setSelectedItem("Clue Chili");
        assertThat(panel.entreePanel, instanceOf(CluePanel.class));
        panel.entreeBox.getModel().setSelectedItem("Jenga Nachos");
        assertThat(panel.entreePanel, instanceOf(JengaPanel.class));
        panel.entreeBox.getModel().setSelectedItem("Monopoly Bowl");
        assertThat(panel.entreePanel, instanceOf(MonopolyPanel.class));
        panel.entreeBox.getModel().setSelectedItem("Yahtzee Poke");
        assertThat(panel.entreePanel, instanceOf(YahtzeePanel.class));
    }

    @Test
    public void testAddItemAddsCorrectly() {
        ComboPanel panel = new ComboPanel(window, new Combo());
        assertThat(panel.entreePanel, instanceOf(ItemPanel.class));
        assertThat(panel.drinkPanel, instanceOf(ItemPanel.class));
        assertThat(panel.sidePanel, instanceOf(ItemPanel.class));
        Entree chess = new Chess();
        panel.addItem(chess);
        Drink candy = new Candy();
        panel.addItem(candy);
        Side risk = new Risk();
        panel.addItem(risk); 
        assertTrue(panel.combo.getEntreeInstance().equals(new Chess()));
        assertTrue(panel.combo.getDrinkInstance().equals(new Candy()));
        assertTrue(panel.combo.getSideInstance().equals(new Risk()));
    }
}