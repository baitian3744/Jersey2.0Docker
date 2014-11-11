package org.harry.rs.employeesample.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by harry on 7/31/14.
 */
@XmlRootElement
public class Employees {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}
