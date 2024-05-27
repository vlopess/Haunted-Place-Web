package com.hauntedplace.HauntedPlaceWeb.Models;


import com.hauntedplace.HauntedPlaceWeb.Models.Enums.TagEnum;

public class Tag {

    private Long id;
    private String description;

    public Tag() {}

    public Tag(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    public Tag(Long id) {
        this.id = id;
    }

    public Tag(TagEnum tagEnum) {
        this.id = (long) tagEnum.ordinal() + 1;
        this.description = tagEnum.name();
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
