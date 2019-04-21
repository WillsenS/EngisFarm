import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * GoatMeatTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class GoatMeatTest {
    private GoatMeat goatMeat;

    @Before
    public void setUp() {
        goatMeat = new GoatMeat();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 5;

        assertEquals(goatMeat.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 7;

        assertEquals(goatMeat.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 6;

        assertEquals(goatMeat.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(goatMeat.isExpire(), expected);
    }
}