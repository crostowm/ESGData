package com.esg.esgdata.model.prep;

import javax.persistence.Entity;

@Entity
public class PrepTemplate extends Prep {
    private int unitDollarValue, numShiftsToPrepFor;
    private boolean includeCurrentShift, isPermanent;

    public PrepTemplate() {}
    public PrepTemplate(String description, String unitType, int unitDollarValue, PrepType prepType, int numShiftsToPrepFor, boolean includeCurrentShift, boolean isPermanent) {
        super(description, unitType, prepType);
        this.unitDollarValue = unitDollarValue;
        this.numShiftsToPrepFor = numShiftsToPrepFor;
        this.includeCurrentShift = includeCurrentShift;
        this.isPermanent = isPermanent;
    }
}

