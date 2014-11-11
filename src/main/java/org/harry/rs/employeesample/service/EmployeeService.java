package org.harry.rs.employeesample.service;

import org.harry.rs.employeesample.model.Employee;
import org.harry.rs.employeesample.model.Employees;

import java.util.List;

/**
 * Created by harry on 7/31/14.
 */
public interface  EmployeeService {

    public abstract Employees getEmployees();
    public abstract Employees saveEmployees(Employees employee);

    public abstract Employee getEmployeeDetails(String employeeId);
    public abstract Employee saveEmployee(Employee employee);
    public abstract void deleteEmployee(Employee employee);

}
