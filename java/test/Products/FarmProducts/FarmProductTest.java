import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * FarmProductTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class FarmProductTest {
    private FarmProduct farmProduct;

    @Before
    public void setUp() {
        farmProduct = new FarmProduct();
    }

    @Test
    public void testGetProductValue() {
        final int expected = 0;

        assertEquals(farmProduct.getProductValue(), expected);
    }

    @Test
    public void testGetExpireValue() {
        final int expected = 0;

        assertEquals(farmProduct.getExpireValue(), expected);
    }

    @Test
    public void testSetExpireValue() {
        final int expected = 0;

        assertEquals(farmProduct.setExpireValue(), expected);
    }

    @Test
    public void testIsExpire() {
        final boolean expected = true;

        assertEquals(farmProduct.isExpire(), expected);
    }
}