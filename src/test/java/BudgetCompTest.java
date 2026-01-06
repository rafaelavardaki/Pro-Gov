import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import  com.progov.BudgetComparator;

public class BudgetCompTest {
    @Test
    public void testCompare() {
        String[] cat1 = {"Α","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
        double[] val1now = {100.0,200.0,300.0,400.0,500.0,600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0,1400.0,1500.0,1600.0,1700.0,1800.0,1900.0,2000.0};
        String[] cat2 = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G"};
        double[] val2now = {600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0,1400.0,1500.0,1600.0,1700.0,1800.0,1900.0,2000.0,2100.0,2200.0,2300.0,2400.0,2500.0};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BudgetComparator.compare(cat1, val1now, cat2, val2now);
        assertTrue(out.toString().contains("Διαφορά: -65950.0"));
        assertTrue(out.toString().contains("Διαφορά: -102300.0"));
        assertTrue(out.toString().contains("Πέρσι είχαμε ΕΛΛΕΙΜΜΑ"));
        assertTrue(out.toString().contains("Φέτος έχουμε ΕΛΛΕΙΜΜΑ"));
    }

    @Test
    public void testCompare2() {
        String[] cat1 = {"Α","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
        double[] val1now = {100.0,200.0,300.0,400.0,500.0,600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0,1400.0,1500.0,1600.0,1700.0,1800.0,1900.0,2000.0};
        String[] cat2 = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G"};
        double[] val2now = {100.0,200.0,300.0,400.0,500.0,600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0,1400.0,1500.0,1600.0,1700.0,1800.0,1900.0,2000.0};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BudgetComparator.compare(cat1, val1now, cat2, val2now);
        assertTrue(out.toString().contains("Διαφορά: -65950.0"));
        assertTrue(out.toString().contains("Διαφορά: -112300.0"));
        assertTrue(out.toString().contains("Πέρσι είχαμε ΕΛΛΕΙΜΜΑ"));
        assertTrue(out.toString().contains("Φέτος έχουμε ΙΣΟΖΥΓΙΟ"));
    }

    @Test
    public void testCompare3() {
        String[] cat2 = {"Α","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
        double[] val2now = {100.0,200.0,300.0,400.0,500.0,600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0,1400.0,1500.0,1600.0,1700.0,1800.0,1900.0,2000.0};
        String[] cat1 = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G"};
        double[] val1now = {600.0,700.0,800.0,900.0,1000.0,1100.0,1200.0,1300.0,1400.0,1500.0,1600.0,1700.0,1800.0,1900.0,2000.0,2100.0,2200.0,2300.0,2400.0,2500.0};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BudgetComparator.compare(cat1, val1now, cat2, val2now);
        assertTrue(out.toString().contains("Διαφορά: -55950.0"));
        assertTrue(out.toString().contains("Διαφορά: -112300.0"));
        assertTrue(out.toString().contains("Πέρσι είχαμε ΕΛΛΕΙΜΜΑ"));
        assertTrue(out.toString().contains("Φέτος έχουμε ΠΛΕΟΝΑΣΜΑ"));
    }
} 