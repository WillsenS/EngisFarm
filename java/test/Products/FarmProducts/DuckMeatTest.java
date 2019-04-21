import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * DuckMeatTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class DuckMeatTest {
    private DuckMeat duckMeat;

    
    public void setUp() {
        duckMeat = new DuckMeat();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 5;

        assertEquals(duckMeat.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 7;

        assertEquals(duckMeat.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 6;
        duckMeat.setExpireValue();
        assertEquals(duckMeat.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(duckMeat.isExpire(), expected);
    }
}