package com.esg.esgdata.staff;

import javax.persistence.*;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    protected String firstName, lastName;
    protected boolean isActive;
    @Enumerated(EnumType.STRING)
    protected StaffType staffType;

    public Employee(){}

    public Employee(String firstName, String lastName, StaffType staffType)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        isActive = false;
        this.staffType = staffType;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getInitials()
    {
        return firstName.charAt(0) + "" + lastName.charAt(0);
    }

    public boolean isActive() { return isActive; }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }
}
