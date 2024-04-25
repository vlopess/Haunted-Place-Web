package com.hauntedplace.HauntedPlaceWeb.DTOS;

import com.hauntedplace.HauntedPlaceWeb.Models.EncryptedId;
import com.hauntedplace.HauntedPlaceWeb.Models.Enums.TagEnum;
import com.hauntedplace.HauntedPlaceWeb.Models.UserOverView;


import java.util.Date;

public class PostDTO {
    private String encryptedId;
    private String title;
    private String urlImage;
    private UserOverView user;
    private TagEnum tag;
    private String content;
    private Date createdAt;

    public PostDTO() {}

    public PostDTO(String encryptedId, String title, String urlImage, UserOverView user, TagEnum tag, String content, Date createdAt) {
        this.encryptedId = encryptedId;
        this.title = title;
        this.urlImage = urlImage;
        this.user = user;
        this.tag = tag;
        this.content = content;
        this.createdAt = createdAt;
    }


    public String getEncryptedId() {
        return encryptedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    public UserOverView getUser() {
        return user;
    }

    public void setUser(UserOverView user) {
        this.user = user;
    }
    public TagEnum getTag() {
        return tag;
    }

    public void setTag(TagEnum tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
