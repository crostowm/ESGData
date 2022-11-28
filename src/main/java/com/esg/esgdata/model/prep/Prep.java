package com.esg.esgdata.model.prep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Prep {
    @Id @Column(length = 50)
    protected String description;
    @Column
    protected String unitType;
    @Column
    protected PrepType prepType;

    public Prep(){};
    public Prep(String description, String unitType, PrepType prepType) {
        this.description = description;
        this.unitType = unitType;
        this.prepType = prepType;
    }

    public String getDescription() {
        return description;
    }
    public String getUnitType() {
        return unitType;
    }
    public PrepType getPrepType() {
        return prepType;
    }
}
