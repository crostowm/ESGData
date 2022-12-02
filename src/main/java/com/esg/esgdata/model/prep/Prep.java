package com.esg.esgdata.model.prep;

import javax.persistence.*;

@MappedSuperclass
public abstract class Prep {
    @Id @Column(length = 50)
    protected String desc;

    protected String unitType;
    @Enumerated(EnumType.STRING)
    protected PrepType prepType;

    public Prep(){};
    public Prep(String description, String unitType, PrepType prepType) {
        this.desc = description;
        this.unitType = unitType;
        this.prepType = prepType;
    }

    public String getDesc() {
        return desc;
    }
    public String getUnitType() {
        return unitType;
    }
    public PrepType getPrepType() {
        return prepType;
    }

}
