import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ChickenEggTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class ChickenEggTest {
    private ChickenEgg chickenEgg;

    @Before
    public void setUp() {
        chickenEgg = new ChickenEgg();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 3;

        assertEquals(chickenEgg.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 10;

        assertEquals(chickenEgg.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 9;

        assertEquals(chickenEgg.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(chickenEgg.isExpire(), expected);
    }
}