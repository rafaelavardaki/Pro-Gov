import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import  com.progov.CheckVariables;

public class CheckVarTest {
    @Test
    public void testChecking1() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        double result = CheckVariables.checkingV();
        assertTrue(out.toString().isEmpty());
        assertEquals(1, result);

    }

    @Test
    public void testChecking12() {
        String input = "-1\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        double result = CheckVariables.checkingV();
        assertTrue(out.toString().contains("\nΔώσε ΘΕΤΙΚΟ αριθμό!"));
        assertEquals(4, result);
    }

    @Test
    public void testChecking2() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV1();
        assertTrue(out.toString().isEmpty());
        assertEquals(4, result);
    }

    @Test
    public void testChecking22() {
        String input = "7\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV1();
        assertTrue(out.toString().contains("\nΔώσε 0,1,2,3 ή 4"));
        assertEquals(2, result);
    }

    @Test
    public void testChecking3() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV2();
        assertTrue(out.toString().isEmpty());
        assertEquals(4, result);
    }

    @Test
    public void testChecking32() {
        String input = "21\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV2();
        assertTrue(out.toString().contains("\nΔώσε αριθμό από 1 εώς 20!"));
        assertEquals(2, result);
    }

    @Test
    public void testChecking4() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV3();
        assertTrue(out.toString().isEmpty());
        assertEquals(1, result);
    }

    @Test
    public void testChecking42() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV3();
        assertTrue(out.toString().isEmpty());
        assertEquals(2, result);
    }

    @Test
    public void testChecking43() {
        String input = "3\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int result = CheckVariables.checkingV3();
        assertTrue(out.toString().contains("\nΔώσε 1 ή 2"));
        assertEquals(1, result);
    }
}
