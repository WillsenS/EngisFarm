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
        chickenEgg.setExpireValue();
        assertEquals(chickenEgg.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(chickenEgg.isExpire(), expected);
    }
}