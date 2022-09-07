package com.example.java17il2022;

import com.example.java17il2022.week6.Calculation;
import com.example.java17il2022.week6.CalculationImpl;
import com.example.java17il2022.week6.SumStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyCusotmizedTest {
    private Calculation calculation;

    @BeforeEach
    private void init() {
        SumStrategy sumStrategy = Mockito.mock(SumStrategy.class);
        Mockito.when(sumStrategy.sum(new int[]{2, 3})).thenReturn(5);
        calculation = new CalculationImpl(sumStrategy);
    }

    @Test
    void testWrongResult() {
        Assertions.assertFalse(calculation.sum(1, 1) == 3);
    }

    @Test
    void testCorrectResult() {
        Assertions.assertTrue(calculation.sum(2, 3) == 5);
    }
}
