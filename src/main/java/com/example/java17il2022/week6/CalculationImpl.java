package com.example.java17il2022.week6;

import java.util.Arrays;

public class CalculationImpl implements Calculation{
    private final SumStrategy sumHelper;

    public CalculationImpl(SumStrategy sumHelper) {
        this.sumHelper = sumHelper;
    }

    @Override
    public int sum(int a, int b) {
        //logic
        return sumHelper.sum(new int[]{a, b});
    }

}
