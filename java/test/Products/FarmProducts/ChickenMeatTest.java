import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ChickenMeatTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class ChickenMeatTest {
    private ChickenMeat chickenMeat;

    
    public void setUp() {
        chickenMeat = new ChickenMeat();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 4;

        assertEquals(chickenMeat.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 6;

        assertEquals(chickenMeat.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 5;
        chickenMeat.setExpireValue();
        assertEquals(chickenMeat.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(chickenMeat.isExpire(), expected);
    }
}