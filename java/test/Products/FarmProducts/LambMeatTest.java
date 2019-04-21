import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * LambMeatTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class LambMeatTest {
    private LambMeat lambMeat;

    
    public void setUp() {
        lambMeat = new LambMeat();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 5;

        assertEquals(lambMeat.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 7;

        assertEquals(lambMeat.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 6;
        lambMeat.setExpireValue();
        assertEquals(lambMeat.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(lambMeat.isExpire(), expected);
    }
}