package com.esg.esgdata.model.prep;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PrepTemplate extends Prep {
    @Column
    private int unitDollarValue, numShiftsToPrepFor;
    @Column
    private boolean includeCurrentShift, isPermanent;

    public PrepTemplate() {}
    public PrepTemplate(String description, String unitType, int unitDollarValue, PrepType prepType, int numShiftsToPrepFor, boolean includeCurrentShift, boolean isPermanent) {
        super(description, unitType, prepType);
        this.unitDollarValue = unitDollarValue;
        this.numShiftsToPrepFor = numShiftsToPrepFor;
        this.includeCurrentShift = includeCurrentShift;
        this.isPermanent = isPermanent;
    }

    public int getUnitDollarValue() {
        return unitDollarValue;
    }

    public void setUnitDollarValue(int unitDollarValue) {
        this.unitDollarValue = unitDollarValue;
    }

    public int getNumShiftsToPrepFor() {
        return numShiftsToPrepFor;
    }

    public void setNumShiftsToPrepFor(int numShiftsToPrepFor) {
        this.numShiftsToPrepFor = numShiftsToPrepFor;
    }

    public boolean isIncludeCurrentShift() {
        return includeCurrentShift;
    }

    public void setIncludeCurrentShift(boolean includeCurrentShift) {
        this.includeCurrentShift = includeCurrentShift;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    @Override
    public String toString() {
        return "PrepTemplate{" +
                "unitDollarValue=" + unitDollarValue +
                ", numShiftsToPrepFor=" + numShiftsToPrepFor +
                ", includeCurrentShift=" + includeCurrentShift +
                ", isPermanent=" + isPermanent +
                ", desc='" + desc + '\'' +
                ", unitType='" + unitType + '\'' +
                ", prepType=" + prepType +
                '}';
    }
}

