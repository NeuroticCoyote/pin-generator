import static org.junit.Assert.*;
import org.junit.Test;

public class pinGeneratorTest {
    
    @Test
    public void testPinGenerator() {
        String name = "Joe G";
        int sortCode = 711313; // example sort code/account number here
        int accountNumber = 13561342;
        String pin = pinGenerator.generatePin(name, sortCode, accountNumber);
        System.out.println(pin);
        assertNotNull(pin); 

    }

}
