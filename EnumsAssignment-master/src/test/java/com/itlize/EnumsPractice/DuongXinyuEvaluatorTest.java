package com.itlize.EnumsPractice;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yang on 02/03/20.
 */
public class DuongXinyuEvaluatorTest {
    @Test
    public void testyang() {
        // Given
        String input = "yang";
        DuongXinyuEvaluator abc = new DuongXinyuEvaluator(input);

        // When
        boolean isDuong = abc.isDuong();
        boolean isXinyu = abc.isXinyu();

        // Then
        Assert.assertFalse(isDuong);
        Assert.assertFalse(isXinyu);
    }

    @Test
    public void testWilhem() {
        // Given
        String input = "Tariq";
        DuongXinyuEvaluator abc = new DuongXinyuEvaluator(input);

        // When
        boolean isDuong = abc.isDuong();
        boolean isXinyu = abc.isXinyu();

        // Then
        Assert.assertFalse(isDuong);
        Assert.assertFalse(isXinyu);
    }

    @Test
    public void testxinyu() {
        // Given
        String input = "Xinyu";
        DuongXinyuEvaluator abc = new DuongXinyuEvaluator(input);

        // When
        boolean isDuong = abc.isDuong();
        boolean isXinyu = abc.isXinyu();

        // Then
        Assert.assertFalse(isDuong);
        Assert.assertTrue(isXinyu);
    }


    @Test
    public void testDuong() {
        // Given
        String input = "Duong";
        DuongXinyuEvaluator abc = new DuongXinyuEvaluator(input);

        // When
        boolean isDuong = abc.isDuong();
        boolean isXinyu = abc.isXinyu();

        // Then
        Assert.assertTrue(isDuong);
        Assert.assertFalse(isXinyu);
    }
}
