package com.example.arch.Model;

import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class Employee {
    private float vacationDays = 0.0f;

    public static final int MAX_WORKDAYS = 260;

    protected abstract float vacationDaysAccumulatedPerDay();

    public float getVacationDays() {
        return vacationDays;
    }

    public void work(int days) throws IllegalArgumentException {
        if (days < 0 || days > MAX_WORKDAYS) {
            throw new IllegalArgumentException("Invalid number of workdays.");
        }
        vacationDays += days * vacationDaysAccumulatedPerDay();
        if (vacationDays > MAX_WORKDAYS * vacationDaysAccumulatedPerDay()) {
            vacationDays = MAX_WORKDAYS * vacationDaysAccumulatedPerDay();
        }
    }

    public void takeVacation(float days) throws IllegalArgumentException {
        if (days < 0 || days > vacationDays) {
            throw new IllegalArgumentException("Invalid number of vacation days.");
        }
        vacationDays -= days;
    }
}
