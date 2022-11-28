package com.esg.esgdata.model.setting;

import javax.persistence.*;

@Entity
public class Setting {
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
