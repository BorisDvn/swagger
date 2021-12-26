package com.example.swagger.controller;

import com.example.swagger.model.Employee;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile/v1/employee")
public class EmployeeProfilController {

    List<Employee> employees = Arrays.asList(
            new Employee(12345L, "bob", "Computer", 7896541258L),
            new Employee(85967L, "Alice", "Electric", 7896541258L),
            new Employee(98765L, "John", "E-Commerce", 7896541258L),
            new Employee(74125L, "Tom", "Trading", 7896541258L)
    );

    @GetMapping(value = "fetch/all")
    public List<Employee> fetchAllEmployee() {
        return employees;
    }

    @GetMapping(value = "fetch/{departement}")
    public Employee fetchEmployeeByName(@ApiParam(value = "Dapartement Name", required = true) @PathVariable String departement) {
        return employees.stream().filter(x -> x.getDepartment().equalsIgnoreCase(departement)).findFirst().get();
    }

    @PostMapping(value = "")
    public Employee insertEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @PutMapping(value = "")
    public Employee updateEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }


    @PatchMapping
    public Object patchEmployee(@ApiParam(value = "Employee") @RequestBody Map<String, Object> partialUpdate) {
        return partialUpdate;
    }

}