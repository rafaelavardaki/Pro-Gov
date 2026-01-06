import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.progov.Trial;

public class TrialTest {

    @Test
    public void testComparison1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Trial.comparison(100, 200);
        assertTrue(out.toString().contains("Ο κρατικός προϋπολογισμός είναι ελλειμματικός."));
    }

    @Test
    public void testComparison2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Trial.comparison(200, 100);
        assertTrue(out.toString().contains("Ο κρατικός προϋπολογισμός είναι πλεονασματικός."));
    }

    @Test
    public void testComparison3() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Trial.comparison(100, 100);
        assertTrue(out.toString().contains("Ο κρατικός προϋπολογισμός είναι ισοσταθμισμένος."));
    }

    @Test
    public void testGreet() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Trial.greet();
        assertTrue(out.toString().contains("Δώσε τιμές στις παρακάτω κατηγορίες."));
    }

}
