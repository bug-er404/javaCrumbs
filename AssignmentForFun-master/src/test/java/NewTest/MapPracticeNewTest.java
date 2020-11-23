package NewTest;

import Collections.MapPractice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class MapPracticeNewTest
{
    private MapPractice mapPractice;
    private Map map1;

    @Before
    public void setup(){
        mapPractice = new MapPractice();
        map1 = new TreeMap<String, String>();
        map1.put("Kathmandu", "Nepal");
        map1.put("Afghanistan", "Kabul");
        map1.put("Angola", "Luanda");
    }

    @Test
    public void findValueOfTest1(){
        // Given
        String key = "Kathmandu";
        // When
        String expected = "Nepal";
        String actual = (String) mapPractice.findValueOf(map1, key);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findValueOfTest2(){
        // Given
        String key = "Dreamland";
        // When
        String expected = null;
        String actual = (String) mapPractice.findValueOf(map1, key);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findKeysOfTest1(){
        // Given
        String value = "Nepal";
        // When
        Object[] expected = {"Kathmandu"};
        Object[] actual = mapPractice.findKeysOf(map1, value);
        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findKeysOfTest2(){
        // Given
        String value = "Halo";
        // When
        Object[] expected = {};
        Object[] actual = mapPractice.findKeysOf(map1, value);
        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void fibonacciTreeTest1(){
        // Given
        Integer upTo = 7;
        // When
        Map<Integer, Integer> expected = new TreeMap<Integer, Integer>();
        expected.put(1, 1);
        expected.put(2, 1);
        expected.put(3, 2);
        expected.put(4, 3);
        expected.put(5, 5);
        expected.put(6, 8);
        expected.put(7, 13);
        Map<Integer, Integer> actual = mapPractice.fibonacciTree(upTo);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fibonacciTreeTest2(){
        // Given
        Integer upTo = 3;
        // When
        Map<Integer, Integer> expected = new TreeMap<Integer, Integer>();
        expected.put(1, 1);
        expected.put(2, 1);
        expected.put(3, 2);
        Map<Integer, Integer> actual = mapPractice.fibonacciTree(upTo);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fibonacciTreeTest3(){
        // Given
        Integer upTo = 0;
        // When
        Map<Integer, Integer> expected = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> actual = mapPractice.fibonacciTree(upTo);
        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void crazySpiralTest1(){
        // Given
        Integer upTo = 7;
        Integer first = 2;
        Integer second = 2;
        // When
        Map<Integer, Integer> expected = new TreeMap<Integer, Integer>();
        expected.put(1, 2);
        expected.put(2, 2);
        expected.put(3, 4);
        expected.put(4, 6);
        expected.put(5, 10);
        expected.put(6, 16);
        expected.put(7, 26);

        Map<Integer, Integer> actual = mapPractice.crazySpiral(first, second, upTo);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void crazySpiralTest2(){
        // Given
        Integer upTo = 3;
        Integer first = 5;
        Integer second = 2;
        // When
        Map<Integer, Integer> expected = new TreeMap<Integer, Integer>();
        expected.put(1, 5);
        expected.put(2, 2);
        expected.put(3, 7);
        Map<Integer, Integer> actual = mapPractice.crazySpiral(first, second, upTo);
        // Then
        Assert.assertEquals(expected, actual);
    }

}
