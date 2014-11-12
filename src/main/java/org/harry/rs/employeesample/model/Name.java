package org.harry.rs.employeesample.model;

/**
 * Created by hachandr on 11/12/14 .
 */
public class Name {
    private String fname;
    private String lname;
    private String mname;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Name{");
        sb.append("fname='").append(fname).append('\'');
        sb.append(", lname='").append(lname).append('\'');
        sb.append(", mname='").append(mname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
