package com.esg.esgdata.model.setting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum SettingCategory {
    BREAD("Bread"), BIN("Bin"), OVEN("Oven"), MISC("Misc"), CUSTOM("Custom");

    private String desc;

    private SettingCategory(String desc) { this.desc = desc;}

    @JsonCreator
    public static SettingCategory decode(final String code) {
        return Stream.of(SettingCategory.values()).filter(targetEnum -> targetEnum.desc.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getDescription() {
        return desc;
    }
}
