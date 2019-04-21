import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
/**
 * AyamTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class AyamTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Ayam ayam;
    private Renderable r;

    @Before
    public void setUp() {
        r.render();
        ayam = new Ayam(0, 0, r);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testTalk() {
        final String expected = "Petok petokkkkkk";

        ayam.talk();

        assertEquals(outContent.toString(), expected);
    }

    @Test
    public void testGetChar() {
        final char expected = 'A';

        assertEquals(ayam.getChar(), expected);
    }

    @Test
    public void testGetCountProduct() {
        final int expected = 0;

        assertEquals(ayam.getCountProduct(), expected);
    }

    @Test
    public void testGetProduct() {
        final int expected = 0;

        assertEquals(ayam.getCountProduct(), expected);
    }

    @Test
    public void testPrint() {
        final String expected = "Ayam 0 Full : 5 pos : 0 0";

        ayam.print();

        assertEquals(outContent.toString(), expected);
    }
}