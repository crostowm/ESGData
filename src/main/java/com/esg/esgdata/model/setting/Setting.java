package com.esg.esgdata.model.setting;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @Column(length = 75)
    private String name;
    private double value;

    @Enumerated(EnumType.STRING)
    private SettingCategory settingCategory;

    public Setting(){}

    public Setting(String name, double value, SettingCategory settingCategory) {
        this.name = name;
        this.value = value;
        this.settingCategory = settingCategory;
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

    public SettingCategory getSettingCategory() {
        return settingCategory;
    }

    public void setSettingCategory(SettingCategory settingCategory) {
        this.settingCategory = settingCategory;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "key='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
