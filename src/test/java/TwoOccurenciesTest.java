import org.junit.Assert;
import org.junit.Test;

public class TwoOccurenciesTest {

    @Test
    public void testTwoOccurrencesTrue() {

        String b = "samplestringmp";
        System.out.println("The longer string is " + b);
        boolean result = Part3.twoOccurrences("mp", b);
        Assert.assertTrue(result);
    }

    @Test
    public void testTwoOccurrencesFalse() {

        String b = "samplestring";
        System.out.println("The longer string is " + b);
        boolean result = Part3.twoOccurrences("le", b);
        Assert.assertFalse(result);
    }
}
