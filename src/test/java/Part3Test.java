import org.junit.Assert;
import org.junit.Test;

public class Part3Test {

    @Test
    public void testTwoOccurrencesTrue() {

        String b = "samplestringmp";
        System.out.println("The longer string is " + b);
        boolean result = Part3.twoOccurrences("mp", b);
        Assert.assertTrue(result);
    }

    @Test
    public void testTwoOccurrencesFalse() {

        String b = "sampleline";
        System.out.println("The longer string is " + b);
        boolean result = Part3.twoOccurrences("le", b);
        Assert.assertFalse(result);
    }

    @Test
    public void testLastPartIncludesString() {

        String b = "sampleline";
        String result = Part3.lastPart("le", b);
        Assert.assertTrue(result.equals("line"));
    }

    @Test
    public void testLastPartDoesNotIncludeString() {

        String b = "sampleline";
        String result = Part3.lastPart("word", b);
        Assert.assertTrue(result.equals("sampleline"));
    }
}
