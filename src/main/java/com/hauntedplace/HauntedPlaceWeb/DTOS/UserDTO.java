package com.hauntedplace.HauntedPlaceWeb.DTOS;


import java.util.ArrayList;
import java.util.List;


import com.hauntedplace.HauntedPlaceWeb.Models.Enums.TagEnum;
import com.hauntedplace.HauntedPlaceWeb.Models.Post;
import com.hauntedplace.HauntedPlaceWeb.Models.Tag;
import com.hauntedplace.HauntedPlaceWeb.Models.UserSocialMedia;


public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profilePictureUrl;
    private MultipartFile profilePicture;
    private String bio;
    private String localization;
    private List<Tag> tags = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<UserSocialMedia> socialMedias = new ArrayList<>();



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public List<Tag> getTags() {
        return this.tags;
    }


    public void setTags(List<TagEnum> tagsEnum) {
        this.tags = tagsEnum.stream().map(Tag::new).toList();
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

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
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
    public List<UserSocialMedia> getSocialMedias() {
        return socialMedias;
    }
    public void setSocialMedias(List<UserSocialMedia> socialMedias) {
        this.socialMedias = socialMedias;
    }
}
