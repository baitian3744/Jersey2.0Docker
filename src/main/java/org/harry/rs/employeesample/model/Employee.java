package org.harry.rs.employeesample.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by harry on 7/31/14.
 */
@XmlRootElement
public class Employee {
    private Name name;
    private String age;
    private Address mailingAddress;

    private Integer id;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name=").append(name);
        sb.append(", age='").append(age).append('\'');
        sb.append(", mailingAddress=").append(mailingAddress);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
