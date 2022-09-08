package com.example.java17il2022;

import com.example.java17il2022.week6.test.fizzbuzz.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class FizzbuzzTest {
    private static Solution solution;

    @BeforeAll
    public static void init() {
        solution = new Solution();
    }

    @Test
    public void testHelperException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> solution.fizzbuzz(100, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solution.fizzbuzz(-1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solution.fizzbuzz(-5, -1));
    }

    @Test
    public void testHelper() {
        Assertions.assertTrue(solution.fizzbuzzHelper(5).equals("buzz"));
        Assertions.assertTrue(solution.fizzbuzzHelper(3).equals("fizz"));
        Assertions.assertTrue(solution.fizzbuzzHelper(15).equals("fizzbuzz"));
        Assertions.assertTrue(solution.fizzbuzzHelper(98).equals("98"));
    }

    @Test
    public void testFizzbuzzRangeInput() {
        Solution mockObj = spy(solution);
        mockObj.fizzbuzz(1, 100);
        verify(mockObj, times(1)).fizzbuzz(1, 100);
    }

    @Test
    public void testFizzbuzzHelperTimesTest() {
        Solution mockObj = spy(solution);
        when(mockObj.fizzbuzzHelper(1)).thenReturn("this is the first input");
        mockObj.fizzbuzz(1, 100);
        for(int number = 1; number <= 100; number++) {
            verify(mockObj, times(1)).fizzbuzzHelper(number);
        }
    }
}
