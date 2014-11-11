package org.harry.rs.employeesample.entity;

import javax.persistence.*;

/**
 * Created by harry on 8/4/14.
 */
@Entity
@Table(name = "employee")
public class EmployeeEntity {



    private Integer empId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private Integer pin;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "emp_id", unique = true, nullable = false)
    public Integer getEmpId() {

        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
