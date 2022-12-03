package com.esg.esgdata.model.prep;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@IdClass(PrepId.class)
public class PrepItem extends Prep implements Serializable {
    @Id @JsonDeserialize(as = LocalDate.class)
    LocalDate date;

    @Column
    private float numToPrep, calcToPrep;
    @Column
    private int unitDollarValue;
    @Column
    private boolean isComplete;

    public PrepItem(){};

    public PrepItem(String description, String unitType, PrepType prepType, LocalDate date, float calcToPrep, int unitDollarValue)
    {
        super(description, unitType, prepType);
        this.date = date;
        this.calcToPrep = calcToPrep;
        this.numToPrep = calcToPrep;
        this.unitDollarValue = unitDollarValue;
        isComplete = false;
    }

    public PrepItem(String description, String unitType, PrepType prepType, float calcToPrep)
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
        ret += getDesc() + " " + getNumToPrep() + "/" + getCalcToPrep() + " $" + getUnitDollarValue() + "/" + getUnitType() + " : " + (isComplete? "complete":"incomplete");
        return ret;
    }

    public LocalDate getDate() {
        return date;
    }
}

