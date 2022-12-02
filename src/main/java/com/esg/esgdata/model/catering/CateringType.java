package com.esg.esgdata.model.catering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum CateringType {
    Party_30("30 Piece Party Pack"), Party_18("18 Piece Party Pack"), Box_Lunch("Box Lunch"), Mini_12("Mini-Jimmy 12 Pack"), Sandwiches("Sandwich");

    private String desc;

    private CateringType(String desc)
    {
        this.desc = desc;
    }

    @JsonCreator
    public static CateringType decode(final String code) {
        return Stream.of(CateringType.values()).filter(targetEnum -> targetEnum.desc.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getDescription() {
        return desc;
    }
}
