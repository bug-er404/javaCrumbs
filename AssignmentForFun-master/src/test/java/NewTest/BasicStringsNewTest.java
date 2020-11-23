package NewTest;

import Strings.BasicStrings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicStringsNewTest {
    private BasicStrings basicStrings;

    @Before
    public void setup(){
        basicStrings = new BasicStrings();
    }

    @Test
    public void flipConcatTest1(){
        // Given
        String string1 = "Bob";
        String string2 = "Marley";
        String expected = "MarleyBob";
        // When
        String actual = basicStrings.flipConcat(string1, string2);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void flipConcatTest2(){
        // Given
        String string1 = " so heavy";
        String string2 = "She's";
        String expected = "She's so heavy";
        // When
        String actual = basicStrings.flipConcat(string1, string2);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCharTest1(){
        // Given
        String string1 = "I love c programming";
        char expected = 'I';
        // When
        char actual = basicStrings.getChar(string1, 0);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCharTest2(){
        // Given
        String string1 = "Jump when you this!";
        char expected = '!';
        // When
        char actual = basicStrings.getChar(string1, 18);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iCantSeeTest1(){
        // Given
        String string1 = "Lovers";
        String expected = "      ";
        // When
        String actual = basicStrings.iCantSee(string1);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iCantSeeTest2(){
        // Given
        String string1 = "I";
        String expected = " ";
        // When
        String actual = basicStrings.iCantSee(string1);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iCantSeeTest3(){
        // Given
        String string1 = "";
        String expected = "";
        // When
        String actual = basicStrings.iCantSee(string1);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void loudAndClearTest1(){
        // Given
        String string = "";
        String expected = "";
        // When
        String actual = basicStrings.loudAndClear(string);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void loudAndClearTest2(){
        // Given
        String string = "wE wIlL RoCk YoU";
        String expected = "WE WILL ROCK YOU";
        // When
        String actual = basicStrings.loudAndClear(string);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseCaseTest1(){
        // Given
        String string = "We Will Rock You";
        String expected = "wE wILL rOCK yOU";
        // When
        String actual = basicStrings.reverseCase(string);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseCaseTest2(){
        // Given
        String string = "hAppY BiRtHDay!";
        String expected = "HaPPy bIrThdAY!";
        // When
        String actual = basicStrings.reverseCase(string);
        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void oneAtATimeTest(){
        // Given
        String string1 = "";
        String string2 = "";
        String expected = "";
        // When
        String actual = basicStrings.oneAtATime(string1, string2);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void oneAtATimeTest2(){
        // Given
        String string1 = "jhn asai";
        String string2 = "onyw kd";
        String expected = "johnny wa skadi";
        // When
        String actual = basicStrings.oneAtATime(string1, string2);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void oneAtATimeTest3(){
        // Given
        String string1 = "Chr 1.3";
        String string2 = "oot";
        String expected = "Cohort 1.3";
        // When
        String actual = basicStrings.oneAtATime(string1, string2);
        // Then
        Assert.assertEquals(expected, actual);
    }



}
