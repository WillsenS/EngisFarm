import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * BarbequeTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class BarbequeTest {
    private Barbeque barbeque;

    
    public void setUp() {
        barbeque = new Barbeque(5);
    }

    @Test
    public void testGetProductValue() {
        final int expected = 10;

        assertEquals(barbeque.getProductValue(), expected);
    }

    @Test
    public void testGetPortion() {
        final int expected = 5;

        assertEquals(barbeque.getPortion(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 5;

        assertEquals(barbeque.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 4;
        barbeque.setExpireValue();
        assertEquals(barbeque.getExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(barbeque.isExpire(), expected);
    }
}