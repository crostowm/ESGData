package com.esg.esgdata.model.prep;

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
    private boolean complete;

    public PrepItem(){};

    public PrepItem(String description, String unitType, PrepType prepType, LocalDate date, float calcToPrep, int unitDollarValue)
    {
        super(description, unitType, prepType);
        this.date = date;
        this.calcToPrep = calcToPrep;
        this.numToPrep = calcToPrep;
        this.unitDollarValue = unitDollarValue;
        complete = false;
    }

    public PrepItem(String description, String unitType, PrepType prepType, float calcToPrep)
    {
        super(description, unitType, prepType);
        this.calcToPrep = calcToPrep;
        this.numToPrep = calcToPrep;
        this.unitDollarValue = -1;
        complete = false;
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

    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    @Override
    public String toString()
    {
        String ret = "";
        ret += getDesc() + " " + getNumToPrep() + "/" + getCalcToPrep() + " $" + getUnitDollarValue() + "/" + getUnitType() + " : " + (complete ? "complete":"incomplete");
        return ret;
    }

    public LocalDate getDate() {
        return date;
    }


}

