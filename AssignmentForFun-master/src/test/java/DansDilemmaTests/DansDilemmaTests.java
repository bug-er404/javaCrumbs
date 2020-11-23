package DansDilemmaTests;

import DansDilemma.DansDilemma;
import Strings.BasicStrings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Please rewrite the test part as the format I gave here.
public class DansDilemmaTests {

    private DansDilemma dansDilemma;

    @Before
    public void setup(){
        dansDilemma = new DansDilemma();
    }

    @Test
    public void dilemmaOfTwoDoubleTest1(){
        // Given
        Double input1 = 4d;
        Double input2 = 5d;
        // When
        Integer actual = dansDilemma.dilemmaOfTwo(input1, input2);
        // Then
        Integer expected = 6;
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void dilemmaOfTwoDoubleTest2(){
        // Given
        Double input1 = 5d;
        Double input2 = 5d;
        // When
        Integer actual = dansDilemma.dilemmaOfTwo(input1, input2);
        // Then
        Integer expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfTwoDoubleTest3(){
        // Given
        Double input1 = 43141351915321531d;
        Double input2 = 143115.3914319413;
        // When
        Integer actual = dansDilemma.dilemmaOfTwo(input1, input2);
        // Then
        Integer expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfTwoDoubleTest4(){
        // Given
        Double input1 = 0d;
        Double input2 = 0d;
        // When
        Integer actual = dansDilemma.dilemmaOfTwo(input1, input2);
        // Then
        Integer expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfThreeDoubleTest1(){
        // Given
        Double input1 = 1d;
        Double input2 = 2d;
        Double input3 = 3d;
        // When
        Integer actual = dansDilemma.dilemmaOfThree(input1, input2, input3);
        // Then
        Integer expected = 12;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfThreeDoubleTest2(){
        // Given
        Double input1 = 3d;
        Double input2 = 2d;
        Double input3 = 3d;
        // When
        Integer actual = dansDilemma.dilemmaOfThree(input1, input2, input3);
        // Then
        Integer expected = 8;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfThreeDoubleTest3(){
        // Given
        Double input1 = 4.5;
        Double input2 = 90d;
        Double input3 = 3d;
        // When
        Integer actual = dansDilemma.dilemmaOfThree(input1, input2, input3);
        // Then
        Integer expected = 17;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfThreeDoubleTest4(){
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
        Double[] inputs = {4d, 6d, 8d, 12d};
        // When
        Integer actual = dansDilemma.dilemmaOfN(inputs);
        // Then
        Integer expected = 26;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfNTest2(){
        // Given
        Double[] inputs = {4d, 64d};
        // When
        Integer actual = dansDilemma.dilemmaOfN(inputs);
        // Then
        Integer expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfNTest3(){
        // Given
        Double[] inputs = {1d, 2d, 4d, 8d, 16d, 32d, 64d};
        // When
        Integer actual = dansDilemma.dilemmaOfN(inputs);
        // Then
        Integer expected = 70;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dilemmaOfNTest4(){
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

    @Test
    public void dilemmaOfNTest5(){
        // Given
        Double[] inputs = new Double[4314];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = (double) i;
        }
        // When
        Integer actual = dansDilemma.dilemmaOfN(inputs);
        // Then
        Integer expected = 15632976;
        Assert.assertEquals(expected, actual);
    }

}
