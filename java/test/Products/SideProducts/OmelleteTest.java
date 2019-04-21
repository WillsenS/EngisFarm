import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * OmeletteTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class OmeletteTest {
    private Omelette omelette;

    @Before
    public void setUp() {
        omelette = new Omelette(5);
    }

    @Test
    public void testGetProductValue() {
        final int expected = 6;

        assertEquals(omellete.getProductValue(), expected);
    }

    @Test
    public void testGetPortion() {
        final int expected = 5;

        assertEquals(omellete.getPortion(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 5;

        assertEquals(omellete.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 4;

        assertEquals(omellete.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = false;

        assertEquals(omellete.isExpire(), expected);
    }
}