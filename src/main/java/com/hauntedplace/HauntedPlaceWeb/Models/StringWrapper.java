package com.hauntedplace.HauntedPlaceWeb.Models;

public class StringWrapper {
    private String value;

    public StringWrapper(){

    }
    public StringWrapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

