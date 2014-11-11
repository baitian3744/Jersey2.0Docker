package org.harry.rs.employeesample.dao;

import org.harry.rs.employeesample.entity.EmployeeEntity;
import org.harry.rs.employeesample.jparepositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by harry on 8/4/14.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        LOGGER.debug("Finding all employee");
        List<EmployeeEntity> lst = new ArrayList<>();
        for (EmployeeEntity emp : employeeRepository.findAll()) {
            lst.add(emp);
        }
        return lst;
    }

    @Override
    public EmployeeEntity getEmployeeDetails(Long employeeID) {
        LOGGER.debug("Finding The  {} employee",employeeID);
        return employeeRepository.findOne(employeeID);
    }

    @Override
    public List<EmployeeEntity> saveEmployees(List<EmployeeEntity> ems) {
        LOGGER.debug("Saving  all  {} employeessssss",ems);
        employeeRepository.save(ems);
        List<EmployeeEntity> lst = new ArrayList<>();
        for (EmployeeEntity emp : employeeRepository.findAll()){
            lst.add(emp);
        }
        LOGGER.debug("Getting  all  {} employeessssss",lst);
        return lst;
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity em) {
        LOGGER.debug("Saving  The  {} employeessssss",em);
        return employeeRepository.save(em);
    }

    @Override
    public void delete(Integer id) {
        LOGGER.debug("Deleting  The  {} employee",id);
        employeeRepository.delete(employeeRepository.findOne(Long.valueOf(id)));
    }


}
