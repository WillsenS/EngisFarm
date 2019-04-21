import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
/**
 * DombaTest Class.
 *
 * @author Ghazwan S. M.
 * @since 2019.04.19
 */
public class DombaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Domba domba;
    private Renderable r;

    
    public void setUp() {
        r.render();
        domba = new Domba(0, 0, r);
        System.setOut(new PrintStream(outContent));
    }

    
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testTalk() {
        final String expected = "Mbekkkk~~~";

        domba.talk();

        assertEquals(outContent.toString(), expected);
    }

    @Test
    public void testGetChar() {
        final char expected = 'D';

        assertEquals(domba.getChar(), expected);
    }

    @Test
    public void testGetCountProduct() {
        final int expected = 0;

        assertEquals((int) domba.getCountProduct(), expected);
    }

    @Test
    public void testGetProduct() {
        final int expected = 0;

        assertEquals((int) domba.getCountProduct(), expected);
    }

    @Test
    public void testPrint() {
        final String expected = "domba 0 Full : 5 pos : 0 0";

        domba.print();

        assertEquals(outContent.toString(), expected);
    }
}