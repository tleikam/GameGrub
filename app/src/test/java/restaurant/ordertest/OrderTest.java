package restaurant.ordertest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gamegrub.data.Item;
import gamegrub.data.entrees.Chess;
import gamegrub.data.entrees.Clue;
import gamegrub.data.order.Order;
import gamegrub.data.order.OrderNumberSingleton;
import java.lang.IllegalArgumentException;
import java.lang.Iterable;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * Order Test Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class OrderTest {

    @Mock
    Clue mockClue1;
    @Mock
    Chess mockChess1;
    @Mock
    OrderNumberSingleton mockSingleton;

    /**
     * Order Test Method.
     */
    @Test
    public void testOrderCreatesValueProperly() {
        Order order = new Order();
        assertThat(order.size(), is(0));
        assertThat(order.getSubTotal(), is(0.0));
        assertThat(order.getTotalTax(), is(0.0));
        assertThat(order.getTotalCalories(), is(0));
    }

    @Test
    public void testOrderTaxCannotBeAbove1() {
        Order order = new Order();
        assertThrows(IllegalArgumentException.class, () -> order.setTaxRate(1.01));
    }

    @Test
    public void testOrderTaxCannotBeBelow0() {
        Order order = new Order();
        assertThrows(IllegalArgumentException.class, () -> order.setTaxRate(-0.1));
    }

    @Test
    public void testOrderTaxIsGlobal() {
        Order order = new Order();
        Order order2 = new Order();
        assertEquals(0.115, order.getTaxRate());
        assertEquals(0.115, order2.getTaxRate());
        order.setTaxRate(0.092);
        assertEquals(0.092, order.getTaxRate());
        assertEquals(0.092, order2.getTaxRate());
        order.setTaxRate(0.115);
    }

    @Test
    public void testOrderUsesOrderNumberSingletonCorrectly() {

        //when(mockSingleton.getNextOrderNumber()).thenReturn(36);
        // try (MockedStatic<OrderNumberSingleton> mockSingletonStatic =
        //         Mockito.mockStatic(OrderNumberSingleton.class)) {
        //     mockSingletonStatic.when(
        //        () -> OrderNumberSingleton.getInstance()).thenReturn(mockSingleton);
        //     Order order = new Order();
        //     order.getOrderNumber();
        // assertEquals(order.getOrderNumber(), is(36));
        //}
        OrderNumberSingleton ons = OrderNumberSingleton.getInstance();
        assertThat(ons.getOrderNumber(), is(1));
    }

    @Test
    public void testAddingItemAndRemoveItemOrderSize() {
        Order order = new Order();
        assertThat(order.size(), is(0));
        order.addItem(mockClue1);
        assertThat(order.size(), is(1));
        order.removeItem(mockClue1);
        assertThat(order.size(), is(0));
    }

    @Test
    public void testOrderContainsItem() {
        Order order = new Order();
        order.addItem(mockClue1);
        assertTrue(order.containsItem(mockClue1));
    }

    @Test
    public void testOrderDoesNotContainsItem() {
        Order order = new Order();
        order.addItem(mockClue1);
        assertFalse(order.containsItem(mockChess1));
    }

    @Test
    public void testOrderGetReturnsCorrectItem() {
        Order order = new Order();
        order.addItem(mockClue1);
        assertThat(order.get(0), is(mockClue1));
        order.addItem(mockChess1);
        assertThat(order.get(1), is(mockChess1));
    }

    @Test
    public void testOrderSubTotalReturnsCorrectly() {
        when(mockClue1.getPrice()).thenReturn(1.25);
        when(mockChess1.getPrice()).thenReturn(1.26);
        Order order = new Order();
        assertTrue(order.getSubTotal() == 0.0);
        order.addItem(mockClue1);
        assertThat(order.getSubTotal(), is(1.25));
        order.addItem(mockChess1);
        assertThat(order.getSubTotal(), is(2.51));
        order.removeItem(mockClue1);
        assertThat(order.getSubTotal(), is(1.26));
    }

    @Test
    public void testOrderCaloriesReturnsCorrectly() {
        when(mockClue1.getCalories()).thenReturn(100);
        when(mockChess1.getCalories()).thenReturn(1000);
        Order order = new Order();
        assertTrue(order.getTotalCalories() == 0);
        order.addItem(mockClue1);
        order.addItem(mockChess1);
        assertThat(mockClue1.getCalories(), is(100));
        assertThat(mockChess1.getCalories(), is(1000));
        assertThat(order.getTotalCalories(), is(1100));
    }

    @Test
    public void testOrderTotalReturnsCorrectly() {
        when(mockClue1.getPrice()).thenReturn(1.00);
        when(mockChess1.getPrice()).thenReturn(1.00);
        Order order = new Order();
        order.addItem(mockClue1);
        order.addItem(mockChess1);
        assertThat(mockClue1.getPrice(), is(1.00));
        assertThat(mockChess1.getPrice(), is(1.00));
        assertThat(order.getTaxRate(), is(0.115));
        assertThat(order.getTotalCost(), is(2.23));
    }

    @Test
    public void testOrderIteratorReturnsCorrectly() {
        Order order = new Order();
        Iterator<Item> its = order.iterator();
        assertTrue(its instanceof Iterator);
    }
}