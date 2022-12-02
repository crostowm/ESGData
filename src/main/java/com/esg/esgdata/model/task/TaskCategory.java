package com.esg.esgdata.model.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum TaskCategory {
    Open("Opening Procedure"), ALCU("After Lunch Cleanup"), ADCU("After Dinner Clean Up"), Close("Closing Procedure"), DBL("Daily Beautification List"), MDBL("Manager Daily Beautification List");

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
