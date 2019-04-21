import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * PorkTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class PorkTest {
    private Pork pork;

    @Before
    public void setUp() {
        porkMeat = new Pork();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 5;

        assertEquals(pork.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 7;

        assertEquals(pork.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 6;

        assertEquals(pork.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(pork.isExpire(), expected);
    }
}