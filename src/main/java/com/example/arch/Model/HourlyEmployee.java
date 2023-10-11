package com.example.arch.Model;

public class HourlyEmployee extends Employee {

    @Override
    protected float vacationDaysAccumulatedPerDay() {
        return 10.0f / MAX_WORKDAYS;
    }
}

