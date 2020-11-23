package NewTest;

import Collections.ArrayLists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayListsNewTest {

    private ArrayLists arrayLists;

    @Before
    public void setup(){
        arrayLists = new ArrayLists();
    }

    @Test
    public void addShitTest1(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        original1.add(2);
        original1.add(3);
        original1.add(4);
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        original2.add(5);
        original2.add(6);
        // When
        ArrayList<Integer> actual = arrayLists.addShit(original1, original2);
        original1.add(5);
        original1.add(6);
        // Then
        Assert.assertEquals(original1, actual);
    }

    @Test
    public void addShitTest2(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        original1.add(3);
        original1.add(3);
        original1.add(3);
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
        original1.add(1);
        original1.add(1);
        original1.add(1);
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        original2.add(1);
        original2.add(1);
        // When
        Integer actual = arrayLists.addShitTogether(original1, original2);
        Integer expected = 5;
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addShitTogetherTest2(){
        // Given
        ArrayList<Integer> original1 = new ArrayList<Integer>();
        ArrayList<Integer> original2 = new ArrayList<Integer>();
        original2.add(100);
        original2.add(100);
        // when
        Integer actual = arrayLists.addShitTogether(original1, original2);
        Integer expected = 200;
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAllTest1(){
        // Given
        ArrayList<Integer> original = new ArrayList<Integer>();
        original.add(2);
        original.add(2);
        original.add(7);
        original.add(7);
        // When
        Integer toRemove = 2;
        ArrayList<Integer> actual = arrayLists.removeAll(original, toRemove);
        original.remove(0);
        original.remove(1);
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
        Integer toRemove = 9;
        ArrayList<Integer> actual = arrayLists.removeAll(original, toRemove);
        // Then
        Assert.assertEquals(original, actual);
    }


    @Test
    public void happyListTest1(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void happyListTest2(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        original.add("Just");
        original.add("do");
        original.add("it!");
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void happyListTest3(){
        // Given
        ArrayList<String> original = new ArrayList<String>();
        original.add("hold");
        original.add("on");
        original.add("new");
        original.add("we");
        original.add("are");
        // When
        boolean actual = arrayLists.happyList(original);
        // Then
        Assert.assertTrue(actual);
    }

}