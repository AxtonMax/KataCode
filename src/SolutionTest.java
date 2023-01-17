
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class SolutionTest {
    
    @Test
    public void fixedTests() {
        assertEquals(1 , parseInt("one"));
        assertEquals(20 , parseInt("twenty"));
        assertEquals(246 , parseInt("two hundred forty-six"));
    }
    
    public static int parseInt(String numStr) {
        // Your code here!
        return -1;
    }
}