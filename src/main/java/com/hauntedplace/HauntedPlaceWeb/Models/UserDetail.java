package com.hauntedplace.HauntedPlaceWeb.Models;

import com.hauntedplace.HauntedPlaceWeb.DTOS.PostDTO;
import com.hauntedplace.HauntedPlaceWeb.DTOS.UserSocialMediaDTO;
import com.hauntedplace.HauntedPlaceWeb.Models.Enums.TagEnum;

import java.util.ArrayList;
import java.util.List;

public class UserDetail {
    private String id;
    private String username;
    private String email;
    private String profilePictureUrl;
    private String bio;
    private String localization;
    private Boolean isFollowed;
    private List<TagEnum> tags = new ArrayList<TagEnum>();
    private List<PostDTO> posts = new ArrayList<>();
    private List<UserOverView> followers = new ArrayList<>();
    private List<UserOverView> following = new ArrayList<>();
    private List<UserSocialMediaDTO> socialMedias = new ArrayList<>();



    public UserDetail(){}


    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<TagEnum> getTags() {
        return this.tags;
    }

    public void setTags(List<TagEnum> tags) {
        this.tags = tags;
    }

    public void addTag(TagEnum tag) {
        this.tags.add(tag);
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getLocalization() {
        return localization;
    }
    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }
    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public List<UserOverView> getFollowers(){
        return this.followers;
    }
    public List<UserOverView> getFollowing(){
        return this.following;
    }
    public List<UserSocialMediaDTO> getSocialMedias(){
        return this.socialMedias;
    }
    public void setSocialMedias(List<UserSocialMediaDTO> socialMedias) {
        this.socialMedias = socialMedias;
    }
}


