package org.harry.rs.employeesample.service;

import jersey.repackaged.com.google.common.base.Function;
import jersey.repackaged.com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.harry.rs.employeesample.dao.EmployeeDAO;
import org.harry.rs.employeesample.entity.EmployeeEntity;
import org.harry.rs.employeesample.model.Employee;
import org.harry.rs.employeesample.model.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by harry on 7/31/14.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    @Qualifier("dozerBeanMapper")
    DozerBeanMapper mapper;

    @Override
    public Employees getEmployees() {
        LOGGER.debug("Getting all employees");
        return mapToModel(employeeDAO.getAllEmployees());
    }

    @Override
    public Employee getEmployeeDetails(String employeeId) {
        LOGGER.debug("Getting the details for {} Empl", employeeId);
        Assert.notNull("EmployeeId should not be null", employeeId);
        return mapper.map(employeeDAO.getEmployeeDetails(Long.parseLong(employeeId)), Employee.class);

    }

    @Override
    public Employee saveEmployee(Employee employee) {
        LOGGER.debug("Saving the Empl{}", employee);
        return mapper.map((employeeDAO.saveEmployee(mapper.map(employee, EmployeeEntity.class))), Employee.class);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        LOGGER.debug("Deleting the Empl{}", employee);
        employeeDAO.delete(employee.getId());
    }

    @Override
    public Employees saveEmployees(Employees employee) {
        LOGGER.debug("Saving the employee {}", employee);
        List<EmployeeEntity> employeeEntities = mapToEntity(employee);
        return mapToModel(employeeDAO.saveEmployees(employeeEntities));
    }


    private List<EmployeeEntity> mapToEntity(Employees employees) {
        List<EmployeeEntity> entities = Lists.transform(employees.getEmployees(), new Function<Employee, EmployeeEntity>() {
            @Override
            public EmployeeEntity apply(Employee employee) {
                LOGGER.debug("mapper {} , employee {}",mapper,employee);
                return mapper.map(employee,EmployeeEntity.class,"emp_entity_model");
            }
        });
        return entities;

    }

    private Employees mapToModel(List<EmployeeEntity> employees) {
        List<Employee> employeeList = Lists.transform(employees, new Function<EmployeeEntity, Employee>() {
            @Override
            public Employee apply(EmployeeEntity employeeEntity) {
                return mapper.map(employeeEntity, Employee.class,"emp_entity_model");
            }
        });
        Employees employees1 = new Employees();
        employees1.setEmployees(employeeList);
        return employees1;
    }


}
