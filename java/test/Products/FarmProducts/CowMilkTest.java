import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * CowMilkTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class CowMilkTest {
    private CowMilk cowMilk;

    @Before
    public void setUp() {
        cowMilk = new CowMilk();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 4;

        assertEquals(cowMilk.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 5;

        assertEquals(cowMilk.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 4;

        assertEquals(cowMilk.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(cowMilk.isExpire(), expected);
    }
}