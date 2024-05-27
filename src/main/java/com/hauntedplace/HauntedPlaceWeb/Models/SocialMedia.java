package com.hauntedplace.HauntedPlaceWeb.Models;


public class SocialMedia {
    private Long id;
    private String description;

    public SocialMedia() {}

    public SocialMedia(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    public SocialMedia(Long id) {
        this.id = id;
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