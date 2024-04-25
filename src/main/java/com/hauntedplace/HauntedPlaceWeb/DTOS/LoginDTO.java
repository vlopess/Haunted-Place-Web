package com.hauntedplace.HauntedPlaceWeb.DTOS;


import java.util.ArrayList;
import java.util.List;

public class LoginDTO {
    private String username;
    private String email;
    private String password;



    public LoginDTO() {}
    public LoginDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public LoginBuilder builder(){
        return new LoginBuilder();
    };

    public class LoginBuilder{
        private String username;
        private String email;
        private String password;

        public LoginBuilder setUsername(String username){
            this.username = username;
            return this;
        }
        public LoginBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public LoginBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public LoginDTO build(){
            if((this.email == null && this.username == null) || this.password == null){
                throw new IllegalArgumentException("attributes can not be null");
            }
            return new LoginDTO(this.username, this.email, this.password);
        }
    }
}

