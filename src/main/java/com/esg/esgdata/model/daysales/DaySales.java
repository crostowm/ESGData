package com.esg.esgdata.model.daysales;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class DaySales implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private LocalDate date;
    private double amSales, amCatering, amSampling, pmSales, pmCatering, pmSampling;

    public DaySales(){
        this.amSales = 0;
        this.amCatering = 0;
        this.amSampling = 0;
        this.pmSales = 0;
        this.pmCatering = 0;
        this.pmSampling = 0;
    }

    public DaySales(LocalDate date)
    {
        this.date = date;
        this.amSales = 0;
        this.amCatering = 0;
        this.amSampling = 0;
        this.pmSales = 0;
        this.pmCatering = 0;
        this.pmSampling = 0;
    }
    public DaySales(LocalDate date, double amSales, double amCatering, double amSampling, double pmSales, double pmCatering, double pmSampling) {
        this.date = date;
        this.amSales = amSales;
        this.amCatering = amCatering;
        this.amSampling = amSampling;
        this.pmSales = pmSales;
        this.pmCatering = pmCatering;
        this.pmSampling = pmSampling;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmSales() {
        return amSales;
    }

    public void setAmSales(double amSales) {
        this.amSales = amSales;
    }

    public double getAmCatering() {
        return amCatering;
    }

    public void setAmCatering(double amCatering) {
        this.amCatering = amCatering;
    }

    public double getAmSampling() {
        return amSampling;
    }

    public void setAmSampling(double amSampling) {
        this.amSampling = amSampling;
    }

    public double getPmSales() {
        return pmSales;
    }

    public void setPmSales(double pmSales) {
        this.pmSales = pmSales;
    }

    public double getPmCatering() {
        return pmCatering;
    }

    public void setPmCatering(double pmCatering) {
        this.pmCatering = pmCatering;
    }

    public double getPmSampling() {
        return pmSampling;
    }

    public void setPmSampling(double pmSampling) {
        this.pmSampling = pmSampling;
    }

    public void addSales(boolean isAM, double amount) {
        if(isAM)
            amSales += amount;
        else
            pmSales += amount;
    }

    public void addCatering(boolean isAM, double amount) {
        if(isAM)
            amCatering += amount;
        else
            pmCatering += amount;
    }

    public void addSampling(boolean isAM, double amount) {
        if(isAM)
            amSampling += amount;
        else
            pmSampling += amount;
    }

    public double getSales(boolean isAM)
    {
        return isAM? amSales:pmSales;
    }

    public double getCatering(boolean isAM) {
        return isAM? amCatering:pmCatering;
    }

    public double getSampling(boolean isAM) {
        return isAM? amSampling:pmSampling;
    }

    @Override
    public String toString() {
        return "DaySales{" +
                "date=" + date +
                ", amSales=" + amSales +
                ", amCatering=" + amCatering +
                ", amSampling=" + amSampling +
                ", pmSales=" + pmSales +
                ", pmCatering=" + pmCatering +
                ", pmSampling=" + pmSampling +
                '}';
    }
}