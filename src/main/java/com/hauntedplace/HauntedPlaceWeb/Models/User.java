package com.hauntedplace.HauntedPlaceWeb.Models;

import java.util.ArrayList;
import java.util.List;

public class User  {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profilePictureUrl;
    private String bio;
    private String localization;
    private List<Tag> tags = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<User> following = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private List<UserSocialMedia> socialMedias = new ArrayList<>();

    public User(){}


    public User(UserOverView userDTO) {
        this.id = new EncryptedId(userDTO.encryptedId()).getDecrypted();
        this.username = userDTO.username();
        this.email = userDTO.username();
        this.bio = userDTO.bio();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public List<User> getFollowers(){
        return this.followers;
    }

    public List<User> getFollowing(){
        return this.following;
    }
    public List<UserSocialMedia> getSocialMedias(){
        return this.socialMedias;
    }
    public void setSocialMedias(List<UserSocialMedia> socialMedias) {
        this.socialMedias = socialMedias;
    }
    public void addSocialMedias(List<UserSocialMedia> socialMedias) {
        this.socialMedias.addAll(socialMedias);
    }
}