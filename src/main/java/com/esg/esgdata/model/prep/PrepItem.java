package com.esg.esgdata.model.prep;

import javax.persistence.Entity;

@Entity
public class PrepItem extends Prep {
    private float numToPrep, calcToPrep;
    private int unitDollarValue;
    private boolean isComplete;

    public PrepItem(){};

    public PrepItem(String description, String unitType, float calcToPrep, int unitDollarValue, PrepType prepType)
    {
        super(description, unitType, prepType);
        this.calcToPrep = calcToPrep;
        this.numToPrep = calcToPrep;
        this.unitDollarValue = unitDollarValue;
        isComplete = false;
    }

    public PrepItem(String description, String unitType, float calcToPrep, PrepType prepType)
    {
        super(description, unitType, prepType);
        this.calcToPrep = calcToPrep;
        this.numToPrep = calcToPrep;
        this.unitDollarValue = -1;
        isComplete = false;
    }

    public float getNumToPrep() {
        return numToPrep;
    }

    public int getUnitDollarValue() {
        return unitDollarValue;
    }

    public void setNumToPrep(float value)
    {
        numToPrep = value;
    }

    public float getCalcToPrep() {
        return calcToPrep;
    }

    public void calculatePrep(double projections) { setCalcPrep((float)(projections/unitDollarValue)); }

    public void setCalcPrep(float calcToPrep)
    {
        this.calcToPrep = calcToPrep;
        numToPrep = calcToPrep;
    }

    public void setComplete(boolean isComplete)
    {
        this.isComplete = isComplete;
    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public String toString()
    {
        String ret = "";
        ret += getDescription() + " " + getNumToPrep() + "/" + getCalcToPrep() + " $" + getUnitDollarValue() + "/" + getUnitType() + " : " + (isComplete? "complete":"incomplete");
        return ret;
    }
}

