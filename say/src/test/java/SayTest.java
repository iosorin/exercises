import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class SayTest {

    private Say say = new Say();
    
    @Test
    public void zero() {
        assertEquals("zero", say.say(0));
    }
    
    
    @Test
    public void one() {
        assertEquals("one", say.say(1));
    }

    
    @Test
    public void fourteen() {
        assertEquals("fourteen", say.say(14));
    }

    @Test
    public void twenty() {
        assertEquals("twenty", say.say(20));
    }

    @Test
    public void twentyTwo() {
        assertEquals("twenty-two", say.say(22));
    }


    @Test
    public void twoHundred() {
        assertEquals("two hundred", say.say(200));
    }

    @Test
    public void twoHundredTwentyThree() {
        assertEquals("two hundred twenty-three", say.say(223));
    }

    @Test
    public void oneHundredFiftyTwoThousand() {
        assertEquals("one hundred fifty-two thousand", say.say(152_000));
    }

    @Test
    public void tenThousand() {
        assertEquals("ten thousand", say.say(10_000));
    }

    @Test
    public void oneThousandTwoHundredThirtyFour() {
        assertEquals("one thousand two hundred thirty-four", say.say(1_234));
    }


    @Test
    public void oneMillion() {
        assertEquals("one million", say.say(1_000_000));
    }

    @Test
    public void tenMillionTwentyThousand() {
        assertEquals("ten million twenty thousand", say.say(10_020_000));
    }


    @Test
    public void oneMillionTwentyTwoThousandThreeHundredFortyFive() {
        assertEquals("one million twenty-two thousand three hundred forty-five", say.say(1_022_345));
    }


    @Test
    public void oneBillion() {
        assertEquals("one billion", say.say(1_000_000_000));
    }


    @Test
    public void nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
        assertEquals("nine hundred eighty-seven billion six hundred fifty-four million" +
                     " three hundred twenty-one thousand one hundred twenty-three", say.say(987_654_321_123L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalNegativeNumber() {
        say.say(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalTooBigNumber() {
        say.say(1_000_000_000_000L);
    }    
}
