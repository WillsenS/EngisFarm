import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * DuckEggTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class DuckEggTest {
    private DuckEgg duckEgg;

    
    public void setUp() {
        duckEgg = new DuckEgg();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 4;

        assertEquals(duckEgg.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 10;

        assertEquals(duckEgg.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 9;
        duckEgg.setExpireValue();
        assertEquals(duckEgg.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(duckEgg.isExpire(), expected);
    }
}