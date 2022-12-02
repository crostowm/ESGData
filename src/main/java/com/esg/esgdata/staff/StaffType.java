package com.esg.esgdata.staff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum StaffType {
    Manager("Manager"), Inshop("Inshop"), Driver("Driver");

    private String desc;

    private StaffType(String desc) { this.desc = desc;}

    @JsonCreator
    public static StaffType decode(final String code) {
        return Stream.of(StaffType.values()).filter(targetEnum -> targetEnum.desc.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getDescription() {
        return desc;
    }
}
