package com.app.em.service;

import com.app.em.domain.Employee;
import com.app.em.dto.EmployeeDTO;
import com.app.em.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {

    private EmployRepository employRepository;

    @Autowired
    public void setEmployRepository(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public List<Employee> getAllEmployee() { return employRepository.findAll(); }

    public Employee findEmployeeByEmployeeId(int employeeId) {
        return employRepository.findEmployeeByEmployeeId(employeeId).orElse(null);
    }

    // TODO: need to be implemented
    public boolean updateEmployeeByEmployeeId(int employeeId, EmployeeDTO employeeDTO) {
        return true;
    }
}
