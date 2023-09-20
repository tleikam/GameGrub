package restaurant.ordertest;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gamegrub.data.order.Order;
import gamegrub.data.order.OrderNumberSingleton;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * OrderNumberSingleton Test Class.
 *
 * @author Travis Leikam
 * @version 0.1
 */
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class OrderNumberSingletonTest {

    @Mock
    OrderNumberSingleton mockSingleton;
    @Mock
    Order mockOrder1;
    @Mock
    Order mockOrder2;

    /**
     * OrderNumberSingleton Test Method.
     */
    @Test
    public void testOrderNumberSingleton() {
        try (MockedStatic<OrderNumberSingleton> mockSingletonStatic =
                Mockito.mockStatic(OrderNumberSingleton.class)) {
            mockSingletonStatic.when(
                    () -> OrderNumberSingleton.getInstance()).thenReturn(mockSingleton);
            //OrderNumberSingleton ons = OrderNumberSingleton.getInstance();
            //assertThat(ons.getOrderNumber(), is(1));
        }
        // OrderNumberSingleton ons = OrderNumberSingleton.getInstance();
        // assertThat(ons.getOrderNumber(), is(1));
        // ons.getNextOrderNumber();
        // assertThat(ons.getOrderNumber(), is(2));
        // ons.getNextOrderNumber();
        // assertThat(ons.getOrderNumber(), is(3));
        // ons.getNextOrderNumber();
        // assertThat(ons.getOrderNumber(), is(4));
        // ons.getNextOrderNumber();
        // assertThat(ons.getOrderNumber(), is(5));
        // ons.getNextOrderNumber();
        // assertThat(ons.getOrderNumber(), is(6));
        // ons.getNextOrderNumber();
        // assertThat(ons.getOrderNumber(), is(7));
    }

}