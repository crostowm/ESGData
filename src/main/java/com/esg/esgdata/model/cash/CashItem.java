package com.esg.esgdata.model.cash;

import com.esg.esgdata.staff.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class CashItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate date;
    private double r1, r2, safe;
    private int hr, min;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "counted_by_id")
    private Employee countedBy;

    public void setCountedBy(Employee countedBy) {
        this.countedBy = countedBy;
    }

    public CashItem(){}

    public CashItem(LocalDate date, double r1, double r2, double safe, Employee countedBy) {
        this.date = date;
        this.r1 = r1;
        this.r2 = r2;
        this.safe = safe;
        this.countedBy = countedBy;
        Calendar c = Calendar.getInstance();
        hr = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);
    }

    public double getR1() {
        return r1;
    }

    public double getR2() {
        return r2;
    }

    public double getSafe() {
        return safe;
    }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public Employee getCountedBy() {
        return countedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public void setSafe(double safe) {
        this.safe = safe;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "CashItem{" +
                "id=" + id +
                ", date=" + date +
                ", r1=" + r1 +
                ", r2=" + r2 +
                ", safe=" + safe +
                ", hr=" + hr +
                ", min=" + min +
                ", countedBy=" + countedBy +
                '}';
    }
}
