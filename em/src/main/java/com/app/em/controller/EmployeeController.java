package com.app.em.controller;

import com.app.em.domain.Employee;
import com.app.em.dto.EmployeeDTO;
import com.app.em.service.EmployService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"EM - core service"})
public class EmployeeController {

    private EmployService employService;

    @Autowired
    public void setEmployService(EmployService employService) {
        this.employService = employService;
    }

    @GetMapping("all")
    @ApiOperation(value = "List all Employee - testing purpose", response = Employee.class)
    public List<Employee> getAllEmployee() {
        return employService.getAllEmployee();
    }

    @GetMapping("fetch-employee")
    @ApiOperation(value = "Get the employee information for the current employee", response = Employee.class)
    public ResponseEntity<Employee> getEmployeeInfo(@RequestHeader("employeeId") Integer employeeId) {

        if(employeeId == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Employee employee = employService.findEmployeeByEmployeeId(employeeId);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("update-employee")
    @ApiOperation(value = "update information for the current employee to db")
    public ResponseEntity<String> updateEmployeeInfo(
            @RequestHeader("employeeId") Integer employeeId,
            @RequestBody EmployeeDTO employeeDTO
        ) {

        if(employeeId == null || employeeDTO == null) {
            return new ResponseEntity<>("Missing data.", HttpStatus.BAD_REQUEST);
        }

        boolean res = employService.updateEmployeeByEmployeeId(employeeId, employeeDTO);

        if(!res) {
            return new ResponseEntity<>("Fail to update employee information.", HttpStatus.OK);
        }

        return new ResponseEntity<>("Update successfully.", HttpStatus.OK);
    }
}
