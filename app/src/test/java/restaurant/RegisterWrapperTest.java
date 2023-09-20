package gamegrub.gui;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.ksu.cs.cc410.register.CashDenomination;
import edu.ksu.cs.cc410.register.CashDrawer;
import java.lang.Math;
import java.util.HashMap;
import javax.swing.JSpinner;
import org.junit.jupiter.api.Test;

/**
 * Test Wrapper for the Register.
 */
public class RegisterWrapperTest {

    // @Test
    // public void testRegisterUpdatesCorrectly() {
    //     HashMap<CashDenomination, Integer> receiving = new HashMap<>();
    //     receiving.put(CashDenomination.HUNDRED_DOLLAR_BILL, 1);
    //     PrimaryWindow pw = new PrimaryWindow();
    //     OrderPanel op = new OrderPanel(pw);
    //     RegisterWrapper rw = new RegisterWrapper(receiving, op,
    //                                              100.0, 90.0, 10.0);
    //     assertThat(op.cashDrawer.getCount(CashDenomination.HUNDRED_DOLLAR_BILL), is(11));
    // }
}