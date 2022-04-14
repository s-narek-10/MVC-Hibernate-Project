package com.nareksarkisyan.spring.mvc_hibernate_aop.service;

import com.nareksarkisyan.spring.mvc_hibernate_aop.dao.EmployeeDao;
import com.nareksarkisyan.spring.mvc_hibernate_aop.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }
}
