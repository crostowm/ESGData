package com.esg.esgdata.model.setting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SettingCategory {
    BREAD("BREAD"), BIN("BIN"), OVEN("OVEN"), MISC("MISC"), CUSTOM("CUSTOM"), TIME("TIME");

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
