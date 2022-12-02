package com.esg.esgdata.model.catering;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CateringOrder  implements Comparable<CateringOrder> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int dueHour, dueMin;
    private double dollarValue;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<CateringItem> items = new ArrayList<>();

    public CateringOrder(){}

    public CateringOrder(int dueHour, int dueMin, double dollarValue) {
        this.dueHour = dueHour;
        this.dueMin = dueMin;
        this.dollarValue = dollarValue;
    }

    public void addCateringItem(CateringItem cateringItem)
    {
        items.add(cateringItem);
    }

    public int getDueHour() {
        return dueHour;
    }

    public int getDueMin() {
        return dueMin;
    }

    public double getDollarValue() { return dollarValue;}

    public List<CateringItem> getItems() {
        return items;
    }

    @Override
    public int compareTo(CateringOrder cateringOrder) {
        return dueHour != cateringOrder.dueHour? dueHour - cateringOrder.dueHour: dueMin - cateringOrder.dueMin;
    }

    public void setCateringItems(ArrayList<CateringItem> items)
    {
        this.items = items;
    }
}

