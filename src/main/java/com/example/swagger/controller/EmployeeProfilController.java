package com.example.swagger.controller;

import com.example.swagger.model.Employee;
import com.example.swagger.model.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ApiOperation(value = "/profile/v1/employee", tags = "Employee Profile Controller")
@RestController
@RequestMapping("/profile/v1/employee")
public class EmployeeProfilController {

    List<Employee> employees = Arrays.asList(
            new Employee(12345L, "bob", "Computer", 7896541258L,"email@person.com" ),
            new Employee(85967L, "Alice", "Electric", 7896541258L,"email@person.com"),
            new Employee(98765L, "John", "E-Commerce", 7896541258L,"email@person.com"),
            new Employee(74125L, "Tom", "Trading", 7896541258L,"email@person.com")
    );

    @ApiOperation(value = "Fetch all Employee", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)
    })
    @GetMapping(value = "fetch/all")
    public List<Employee> fetchAllEmployee() {
        return employees;
    }

    @ApiOperation(value = "Fetch Employee by Department", response = Iterable.class)
    @GetMapping(value = "fetch/{department}")
    public Employee fetchEmployeeByDepartent(@ApiParam(value = "Dapartment Name", required = true) @PathVariable String departement) {
        return employees.stream().filter(x -> x.getDepartment().equalsIgnoreCase(departement)).findFirst().get();
    }

    @ApiOperation(value = "Insert Employee", response = Iterable.class)
    @PostMapping(value = "")
    public Employee insertEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @ApiOperation(value = "Update Employee", response = Iterable.class)
    @PutMapping(value = "")
    public Employee updateEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @ApiOperation(value = "Detele Employee", response = Iterable.class)
    @DeleteMapping
    public ResponseEntity<?> deleteEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @ApiOperation(value = "Patch Employee", response = Iterable.class)
    @PatchMapping
    public Object patchEmployee(@ApiParam(value = "Employee") @RequestBody Map<String, Object> partialUpdate) {
        return partialUpdate;
    }

}