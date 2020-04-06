package com.app.em.controller;

import com.app.em.domain.Employee;
import com.app.em.service.EmployService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "List all Employee", response = Employee.class)
    public List<Employee> getAllEmployee() {
        return employService.getAllEmployee();
    }

}
