package com.example.arch.services;

import com.example.arch.Model.Employee;
import com.example.arch.Model.HourlyEmployee;
import com.example.arch.Model.Manager;
import com.example.arch.Model.SalariedEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees = Stream.of(
                        Stream.generate(HourlyEmployee::new).limit(10),
                        Stream.generate(SalariedEmployee::new).limit(10),
                        Stream.generate(Manager::new).limit(10))
                .flatMap(stream -> stream) // Flatten the streams into one stream
                .collect(Collectors.toList()); // Collect the results into a list
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int index) throws IllegalArgumentException {
        if (index >= 0 && index < employees.size()) {
            return employees.get(index);
        }
        throw new IllegalArgumentException("Employee not found for the following index: " + index + ".");
    }

    public void workForEmployee(int index, int days) {
        Employee emp = getEmployee(index);
        if (emp != null) {
            emp.work(days);
        }
    }

    public void takeVacationForEmployee(int index, float days) {
        Employee emp = getEmployee(index);
        if (emp != null) {
            emp.takeVacation(days);
        }
    }
}
