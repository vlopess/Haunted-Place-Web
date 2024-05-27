package com.hauntedplace.HauntedPlaceWeb.Models.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum TagEnum {
    @JsonProperty("MOVIES")
    MOVIES("MOVIES"),
    @JsonProperty("MUSIC")
    MUSIC("MUSIC"),
    @JsonProperty("STYLE")
    STYLE("STYLE"),
    @JsonProperty("LITERATURE")
    LITERATURE("LITERATURE");

    private String value;

    TagEnum(String value) {
       this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @JsonCreator
    public static TagEnum fromString(String value) {
        return TagEnum.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}
