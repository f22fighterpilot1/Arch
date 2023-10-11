package com.example.arch.controller;

import com.example.arch.Model.Employee;
import com.example.arch.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeIndex}/employee")
    public Employee getEmployee(@PathVariable int employeeIndex) {
        return employeeService.getEmployee(employeeIndex);
    }


    @PostMapping("/{employeeIndex}/work")
    public void work(@PathVariable int employeeIndex, @RequestParam int days) {
        employeeService.workForEmployee(employeeIndex, days);
    }

    @PostMapping("/{employeeIndex}/vacation")
    public void takeVacation(@PathVariable int employeeIndex, @RequestParam float days) {
        employeeService.takeVacationForEmployee(employeeIndex, days);
    }

    // Endpoint to check vacation days for an employee
    @GetMapping("/{employeeIndex}/vacationDays")
    public float checkVacationDays(@PathVariable int employeeIndex) {
        return employeeService.getEmployee(employeeIndex).getVacationDays();
    }
}