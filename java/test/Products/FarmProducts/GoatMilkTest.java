import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * GoatMilkTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class GoatMilkTest {
    private GoatMilk goatMilk;

    
    public void setUp() {
        goatMilk = new GoatMilk();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 3;

        assertEquals(goatMilk.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 5;

        assertEquals(goatMilk.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 4;
        goatMilk.setExpireValue();
        assertEquals(goatMilk.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(goatMilk.isExpire(), expected);
    }
}