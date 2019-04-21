import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * CowMeatTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class CowMeatTest {
    private CowMeat cowMeat;

    @Before
    public void setUp() {
        cowMeat = new CowMeat();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 6;

        assertEquals(cowMeat.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 3;

        assertEquals(cowMeat.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 2;

        assertEquals(cowMeat.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(cowMeat.isExpire(), expected);
    }
}