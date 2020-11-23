package CollectionsTests;

import Collections.ArrayLists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

// Please rewrite the test part as the format I gave here.

public class ArrayListsTest {
    private ArrayLists arrayLists;

    @Before
    public void setup(){
        arrayLists = new ArrayLists();
    }

    @Test
    public void addShitTest1(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        original1.add(5);
        original1.add(5);
        original1.add(5);
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        original2.add(7);
        original2.add(7);
        // When
        ArrayList<Integer> actual = arrayLists.addShit(original1, original2);
        original1.add(7);
        original1.add(7);
        // Then
        Assert.assertEquals(original1, actual);
    }

    @Test
    public void addShitTest2(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        original1.add(5);
        original1.add(5);
        original1.add(5);
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        // When
        ArrayList<Integer> actual = arrayLists.addShit(original1, original2);
        // Then
        Assert.assertEquals(original1, actual);
    }

    @Test
    public void addShitTest3(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        // When
        ArrayList<Integer> actual = arrayLists.addShit(original1, original2);
        // Then
        Assert.assertEquals(original1, actual);
    }

    @Test
    public void addShitTogetherTest1(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        original1.add(5);
        original1.add(5);
        original1.add(5);
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        original2.add(7);
        original2.add(7);
        // When
        Integer actual = arrayLists.addShitTogether(original1, original2);
        Integer expected = 29;
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addShitTogetherTest2(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        original2.add(7);
        original2.add(7);
        // when
        Integer actual = arrayLists.addShitTogether(original1, original2);
        Integer expected = 14;
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addShitTogetherTest3(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        // When
        Integer actual = arrayLists.addShitTogether(original1, original2);
        Integer expected = 0;
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAllTest1(){
        // Given
        ArrayList<Integer> original = new ArrayList<Integer>();
        original.add(5);
        original.add(5);
        original.add(5);
        original.add(7);
        original.add(7);
        // When
        Integer toRemove = 5;
        ArrayList<Integer> actual = arrayLists.removeAll(original, toRemove);
        original.remove(0);
        original.remove(0);
        original.remove(0);
        // Then
        Assert.assertEquals(original, actual);
    }

    @Test
    public void removeAllTest2(){
        // Given
        ArrayList<Integer> original = new ArrayList<Integer>();
        original.add(5);
        original.add(7);
        original.add(5);
        original.add(7);
        original.add(7);
        // When
        Integer toRemove = 5;
        ArrayList<Integer> actual = arrayLists.removeAll(original, toRemove);
        original.remove(0);
        original.remove(1);
        // Then
        Assert.assertEquals(original, actual);
    }

    @Test
    public void removeAllTest3(){
        // Given
        ArrayList<Integer> original = new ArrayList<Integer>();
        original.add(5);
        original.add(5);
        original.add(5);
        original.add(7);
        original.add(7);
        // When
        Integer toRemove = null;
        ArrayList<Integer> actual = arrayLists.removeAll(original, toRemove);
        // Then
        Assert.assertEquals(original, actual);
    }

    @Test
    public void happyListTest1(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        original.add("getexcited");
        original.add("this");
        original.add("shit");
        original.add("is");
        original.add("goingdown");
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void happyListTest2(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        original.add("yall");
        original.add("ready");
        original.add("for");
        original.add("dis");
        original.add("jawn");
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void happyListTest3(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void happyListTest4(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        original.add("We got this!");
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void happyListTest5(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        original.add("Believe");
        original.add("and");
        original.add("Achieve!");
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertFalse(actual);
    }

}
