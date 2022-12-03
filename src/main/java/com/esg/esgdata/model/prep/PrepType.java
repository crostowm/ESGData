package com.esg.esgdata.model.prep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum PrepType {
    VEG("VEG"), MISC("MISC"), LTO("LTO"), SLICING("SLICING");

    private String desc;

    private PrepType(String desc)
    {
        this.desc = desc;
    }

    @JsonCreator
    public static PrepType decode(final String code) {
        return Stream.of(PrepType.values()).filter(targetEnum -> targetEnum.desc.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getDescription() {
        return desc;
    }
}
