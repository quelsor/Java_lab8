package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SumTaskTest {
    @Test
    public void testComputeSmallArray() {
        int[] array = {1, 2, 3, 4, 5};
        SumTask task = new SumTask(array, 0, array.length);

        long result = task.compute();

        // 1+2+3+4+5 = 15
        assertEquals(15, result);
    }

    @Test
    public void testComputeLargeArray() {
        int[] array = new int[50];
        Arrays.fill(array, 1);
        SumTask task = new SumTask(array, 0, array.length);

        long result = task.compute();

        // 50 * 1 = 50
        assertEquals(50, result);
    }

    @Test
    public void testComputeEmptyArray() {
        int[] array = {};
        SumTask task = new SumTask(array, 0, array.length);

        long result = task.compute();

        assertEquals(0, result);
    }

    @Test
    public void testComputeArrayWithSingleElement() {
        int[] array = {10};
        SumTask task = new SumTask(array, 0, array.length);
        long result = task.compute();

        assertEquals(10, result);
    }

    @Test
    public void testComputeNegativeNumbers() {
        int[] array = {-1, -2, -3, -4, -5};
        SumTask task = new SumTask(array, 0, array.length);

        long result = task.compute();

        // (-1) + (-2) + (-3) + (-4) + (-5) = -15
        assertEquals(-15, result);
    }

    @Test
    public void testComputeMixedPositiveAndNegative() {
        int[] array = {1, -1, 2, -2, 3, -3};
        SumTask task = new SumTask(array, 0, array.length);

        long result = task.compute();

        // 1 + (-1) + 2 + (-2) + 3 + (-3) = 0
        assertEquals(0, result);
    }
}