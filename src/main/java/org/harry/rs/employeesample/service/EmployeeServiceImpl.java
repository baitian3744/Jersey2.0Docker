package org.harry.rs.employeesample.service;

import org.harry.rs.employeesample.dao.EmployeeDAO;
import org.harry.rs.employeesample.entity.EmployeeEntity;
import org.harry.rs.employeesample.model.Employee;
import org.harry.rs.employeesample.model.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry on 7/31/14.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public Employees getEmployees() {
        LOGGER.debug("Getting all employees");
       return mapToModel(employeeDAO.getAllEmployees());
    }

    @Override
    public Employee getEmployeeDetails(String employeeId) {
        LOGGER.debug("Getting the details for {} Empl",employeeId);
        Assert.notNull("EmployeeId should not be null",employeeId);
       return mapToSingleModel( employeeDAO.getEmployeeDetails(Long.parseLong(employeeId)));

    }

    @Override
    public Employee saveEmployee(Employee employee) {
        LOGGER.debug("Saving the Empl{}",employee);
        return mapToSingleModel((employeeDAO.saveEmployee(mapToSingleEntity(employee))));
    }

    @Override
    public void deleteEmployee(Employee employee) {
        LOGGER.debug("Deleting the Empl{}",employee);
         employeeDAO.delete(employee.getId());
    }

    @Override
    public Employees saveEmployees(Employees employee) {
        LOGGER.debug("Saving the employee {}",employee);
        List<EmployeeEntity> employeeEntities = mapToEntity(employee);
        return mapToModel(employeeDAO.saveEmployees(employeeEntities));
    }


    private List<EmployeeEntity> mapToEntity(Employees employees) {
        List<EmployeeEntity> entities = new ArrayList<>();
        for (Employee emp :employees.getEmployees()){
            entities.add(mapToSingleEntity(emp));
        }
        return entities;
    }

    private EmployeeEntity mapToSingleEntity(Employee emp) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(emp.getName());
        return employeeEntity;
    }

    private Employees mapToModel(List<EmployeeEntity> employees) {
        Employees employees1 = new Employees();
        List<Employee> lst = new ArrayList<>();
        for (EmployeeEntity emp: employees){
            lst.add(mapToSingleModel(emp));
        }
        return employees1;
    }

    private Employee mapToSingleModel(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        employee.setId(employeeEntity.getEmpId());
        employee.setName(employeeEntity.getFirstName());
        return employee;
    }
}
