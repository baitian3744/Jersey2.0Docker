package org.harry.rs.employeesample.jparepositories;

import org.harry.rs.employeesample.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by harry on 8/4/14.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {

}
