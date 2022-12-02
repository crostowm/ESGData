package com.esg.esgdata.staff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum StaffGroups {
    ALL_STAFF("All Staff"), ALL_EMPLOYEES("All Employees"), ALL_MANAGERS("All Managers"), ACTIVE_STAFF("Active Staff"), ACTIVE_EMPLOYEES("Active Employees"), ACTIVE_MANAGERS("Active Managers"), INACTIVE_STAFF("Inactive Staff"),
    INACTIVE_EMPLOYEES("Inactive Employees"), INACTIVE_MANAGERS("Inactive Managers"), ACTIVE_DRIVERS("Active Drivers");

    private String desc;

    private StaffGroups(String desc) { this.desc = desc;}

    @JsonCreator
    public static StaffGroups decode(final String code) {
        return Stream.of(StaffGroups.values()).filter(targetEnum -> targetEnum.desc.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getDescription() {
        return desc;
    }
}
