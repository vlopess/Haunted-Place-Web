package com.hauntedplace.HauntedPlaceWeb.Models.Enums;

public enum TagEnum {
    MOVIES("MOVIES"),
    MUSIC("MUSIC"),
    STYLE("STYLE"),
    LITERATURE("LITERATURE");

    private String value;

    TagEnum(String value) {
       this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
