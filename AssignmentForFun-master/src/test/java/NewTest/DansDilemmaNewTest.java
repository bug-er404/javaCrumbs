package NewTest;

import DansDilemma.DansDilemma;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DansDilemmaNewTest {

    private DansDilemma dansDilemma;

    @Before
    public void setup(){
        dansDilemma = new DansDilemma();
    }

    @Test
    public void dilemmaOfTwoDoubleTest1(){
        // Given
        Double input1 = 11d;
        Double input2 = 12d;
        // When
        Integer actual = dansDilemma.dilemmaOfTwo(input1, input2);
        // Then
        Integer expected = 6;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void dilemmaOfTwoDoubleTest2(){
        // Given
        Double input1 = 1d;
        Double input2 = 1d;
        // When
        Integer actual = dansDilemma.dilemmaOfTwo(input1, input2);
        // Then
        Integer expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfThreeDoubleTest1(){
        // Given
        Double input1 = 3d;
        Double input2 = 4d;
        Double input3 = 5d;
        // When
        Integer actual = dansDilemma.dilemmaOfThree(input1, input2, input3);
        // Then
        Integer expected = 16;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfThreeDoubleTest2(){
        // Given
        Double input1 = 0d;
        Double input2 = 0d;
        Double input3 = 0d;
        // When
        Integer actual = dansDilemma.dilemmaOfThree(input1, input2, input3);
        // Then
        Integer expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfNTest1(){
        // Given
        Double[] inputs = {5d, 6d, 7d, 8d};
        // When
        Integer actual = dansDilemma.dilemmaOfN(inputs);
        // Then
        Integer expected = 29;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfNTest2(){
        // Given
        Double[] inputs = new Double[100];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = (double) i;
        }
        // When
        Integer actual = dansDilemma.dilemmaOfN(inputs);
        // Then
        Integer expected = 8843;
        Assert.assertEquals(expected, actual);
    }


}
