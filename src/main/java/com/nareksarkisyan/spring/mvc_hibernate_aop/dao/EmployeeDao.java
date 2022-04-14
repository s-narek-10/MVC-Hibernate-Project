package com.nareksarkisyan.spring.mvc_hibernate_aop.dao;

import com.nareksarkisyan.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(Employee employee);
}
