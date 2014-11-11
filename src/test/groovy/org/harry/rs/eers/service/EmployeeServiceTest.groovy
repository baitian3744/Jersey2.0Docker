package org.harry.rs.eers.service

import org.harry.rs.employeesample.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by harry on 7/31/14.
 */
@ContextConfiguration(classes=[org.harry.rs.config.AppConfig])
class EmployeeServiceTest extends Specification{


        @Autowired
        def EmployeeService employeeService;

        def "Basic Checking"(){
            when:
            def employees = employeeService.getEmployees()
            then:
            assert employees !=null

        }



        def "Employee"(){
            expect:
            def employee = employeeService.getEmployeeDetails(empId)
            nameop  == employee.name
            where:
            empId     ||nameop
            '111'     ||'Harry'
            '112'     ||'Hermione'
            '113'     ||'Ronald'

        }

}
