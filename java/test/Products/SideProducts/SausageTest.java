import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * SausageTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class SausageTest {
    private Sausage sausage;

    @Before
    public void setUp() {
        sausage = new Sausage(5);
    }

    @Test
    public void testGetProductValue() {
        final int expected = 7;

        assertEquals(sausage.getProductValue(), expected);
    }

    @Test
    public void testGetPortion() {
        final int expected = 5;

        assertEquals(sausage.getPortion(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 5;

        assertEquals(sausage.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 4;

        assertEquals(sausage.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(sausage.isExpire(), expected);
    }
}