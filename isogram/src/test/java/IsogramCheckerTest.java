import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsogramCheckerTest {
    private IsogramChecker iso;
    
    @Before
    public void init() {
        iso = new IsogramChecker();
    }
    
    @Test
    public void testEmptyString() {
        assertTrue(iso.isIsogram(""));
    }

    
    @Test
    public void testLowercaseIsogram() {
        assertTrue(iso.isIsogram("isogram"));
    }

    
    @Test
    public void testNotIsogram() {
        
        assertFalse(iso.isIsogram("eleven"));
    }

    
    @Test
    public void testDuplicateEndAlphabet() {
        
        assertFalse(iso.isIsogram("zzyzx"));
    }

    
    @Test
    public void testMediumLongIsogram() {
        
        assertTrue(iso.isIsogram("subdermatoglyphic"));
    }

    
    @Test
    public void testCaseInsensitive() {
        
        assertFalse(iso.isIsogram("Alphabet"));
    }

    
    @Test
    public void testDuplicatMixedCase() {
        
        assertFalse(iso.isIsogram("alphAbet"));
    }

    
    @Test
    public void testIsogramWithHyphen() {
        
        assertTrue(iso.isIsogram("thumbscrew-japingly"));
    }

    
    @Test
    public void testIsogramWithDuplicatedCharAfterHyphen() {
        
        assertFalse(iso.isIsogram("thumbscrew-jappingly"));
    }

    
    @Test
    public void testIsogramWithDuplicatedHyphen() {
        
        assertTrue(iso.isIsogram("six-year-old"));
    }

    
    @Test
    public void testMadeUpNameThatIsAnIsogram() {
        
        assertTrue(iso.isIsogram("Emily Jung Schwartzkopf"));
    }

    
    @Test
    public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
        
        assertFalse(iso.isIsogram("accentor"));
    }

    
    @Test
    public void testSameFirstAndLast() {
        
        assertFalse(iso.isIsogram("angola"));
    }

}
