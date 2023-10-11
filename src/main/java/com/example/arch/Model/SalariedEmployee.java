package com.example.arch.Model;

public class SalariedEmployee extends Employee {

    @Override
    protected float vacationDaysAccumulatedPerDay() {
        return 15.0f / MAX_WORKDAYS;
    }
}

