package com.esg.esgdata.model.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TaskCategory {
    Open("Open"), ALCU("ALCU"), ADCU("ADCU"), Close("Close"), DBL("DBL"), MDBL("MDBL");

    private String desc;

    private TaskCategory(String desc) { this.desc = desc;}

    @JsonCreator
    public static TaskCategory decode(final String code) {
        return Stream.of(TaskCategory.values()).filter(targetEnum -> targetEnum.desc.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getDescription() {
        return desc;
    }
}
