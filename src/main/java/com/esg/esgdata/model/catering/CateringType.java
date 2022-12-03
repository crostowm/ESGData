package com.esg.esgdata.model.catering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum CateringType {
    Party_30("Party_30"), Party_18("Party_18"), Box_Lunch("Box_Lunch"), Mini_12("Mini_12"), Sandwiches("Sandwiches");

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
