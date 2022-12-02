package com.esg.esgdata.model.catering;

import javax.persistence.*;

@Entity
public class CateringItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private CateringType cateringType;
    private int numItems;

    public CateringItem(){}
    public CateringItem(CateringType cateringType, int numItems) {
        this.cateringType = cateringType;
        this.numItems = numItems;
    }

    public CateringType getCateringType() {
        return cateringType;
    }

    public int getNumItems() {
        return numItems;
    }

    public void addItems(int numItems)
    {
        this.numItems += numItems;
    }

    public String getCateringTypeToString()
    {
        switch (cateringType)
        {
            case Mini_12:
                return numItems > 1? "12 Pack Mini Jimmys":"12 Pack Mini Jimmy";
            case Party_18:
                return numItems > 1? "18 Piece Party Packs":"18 Piece Party Pack";
            case Party_30:
                return numItems > 1? "30 Piece Party Packs":"30 Piece Party Pack";
            case Box_Lunch:
                return numItems > 1? "Box Lunches":"Box Lunch";
            case Sandwiches:
                return numItems > 1? "Sandwiches":"Sandwich";
            default:
                return "Error Catering Type";
        }
    }
}
