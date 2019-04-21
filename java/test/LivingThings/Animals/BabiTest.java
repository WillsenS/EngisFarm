import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
/**
 * BabiTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class BabiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Babi babi;
    private Renderable r;

    @Before
    public void setUp() {
        r.render();
        babi = new Babi(0, 0, r);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testTalk() {
        final String expected = "Nguikk nguikk";

        babi.talk();

        assertEquals(outContent.toString(), expected);
    }

    @Test
    public void testGetChar() {
        final char expected = 'Z';

        assertEquals(babi.getChar(), expected);
    }

    @Test
    public void testGetCountProduct() {
        final int expected = 0;

        assertEquals(babi.getCountProduct(), expected);
    }

    @Test
    public void testGetProduct() {
        final int expected = 0;

        assertEquals(babi.getCountProduct(), expected);
    }

    @Test
    public void testPrint() {
        final String expected = "babi 0 Full : 5 pos : 0 0";

        babi.print();

        assertEquals(outContent.toString(), expected);
    }
}