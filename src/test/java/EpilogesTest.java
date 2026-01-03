import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import  com.progov.Epiloges;

public class EpilogesTest {

    @Test
    public void testGetBudget() {
        String[] categor1 = {"A", "B", "C"};
        double[] kostos1 = {100.0, 200.0, 300.0};
        String[] categor2 = {"A2", "B2", "C2"};
        double[] kostos2 = {100.0, 200.0, 300.0};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Epiloges.getBudget(categor1, kostos1, categor2, kostos2);
        assertTrue(out.toString().contains("A : 100.0"));
        assertTrue(out.toString().contains("B : 200.0"));
        assertTrue(out.toString().contains("C : 300.0"));
        assertTrue(out.toString().contains("A2 : 100.0"));
        assertTrue(out.toString().contains("B2 : 200.0"));
        assertTrue(out.toString().contains("C2 : 300.0"));
        
    }
}
