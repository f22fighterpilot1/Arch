package com.example.arch.Model;

public class Manager extends SalariedEmployee {

    @Override
    protected float vacationDaysAccumulatedPerDay() {
        return 30.0f / MAX_WORKDAYS;
    }
}

