package com.esg.esgdata.model.execution;

import com.esg.esgdata.staff.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@IdClass(ExecutionId.class)
public class ExecutionChart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private LocalDate date;
    @Id @Column(length = 6)
    private String lunchOrDinner;
    @ManyToOne()
    @JoinColumn(name = "reg1_employee_id")
    private Employee reg1;
    @ManyToOne()
    @JoinColumn(name = "reg2_employee_id")
    private Employee reg2;
    @ManyToOne()
    @JoinColumn(name = "bs1_employee_id")
    private Employee bs1;
    @ManyToOne()
    @JoinColumn(name = "bs2_employee_id")
    private Employee bs2;
    @ManyToOne()
    @JoinColumn(name = "mp1_employee_id")
    private Employee mp1;
    @ManyToOne()
    @JoinColumn(name = "mp2_employee_id")
    private Employee mp2;
    @ManyToOne()
    @JoinColumn(name = "con1_employee_id")
    private Employee con1;
    @ManyToOne()
    @JoinColumn(name = "con2_employee_id")
    private Employee con2;

    public ExecutionChart(){}
    public ExecutionChart(LocalDate date, String lunchOrDinner) {
        this.date = date;
        this.lunchOrDinner = lunchOrDinner;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLunchOrDinner() {
        return lunchOrDinner;
    }

    public void setLunchOrDinner(String lunchOrDinner) {
        this.lunchOrDinner = lunchOrDinner;
    }

    public Employee getReg1() {
        return reg1;
    }

    public void setReg1(Employee reg1) {
        this.reg1 = reg1;
    }

    public Employee getReg2() {
        return reg2;
    }

    public void setReg2(Employee reg2) {
        this.reg2 = reg2;
    }

    public Employee getBs1() {
        return bs1;
    }

    public void setBs1(Employee bs1) {
        this.bs1 = bs1;
    }

    public Employee getBs2() {
        return bs2;
    }

    public void setBs2(Employee bs2) {
        this.bs2 = bs2;
    }

    public Employee getMp1() {
        return mp1;
    }

    public void setMp1(Employee mp1) {
        this.mp1 = mp1;
    }

    public Employee getMp2() {
        return mp2;
    }

    public void setMp2(Employee mp2) {
        this.mp2 = mp2;
    }

    public Employee getCon1() {
        return con1;
    }

    public void setCon1(Employee con1) {
        this.con1 = con1;
    }

    public Employee getCon2() {
        return con2;
    }

    public void setCon2(Employee con2) {
        this.con2 = con2;
    }
}

