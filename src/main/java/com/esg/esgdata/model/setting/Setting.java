package com.esg.esgdata.model.setting;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @Column(length = 50)
    private String name;
    private double value;

    public Setting(){}

    public Setting(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "key='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
