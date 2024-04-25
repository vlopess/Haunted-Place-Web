package com.hauntedplace.HauntedPlaceWeb.Models;

import com.hauntedplace.HauntedPlaceWeb.DTOS.LoginDTO;

public record AuthData(String email, String password) {
    public AuthData(LoginDTO loginDTO) {
        this(loginDTO.getEmail(), loginDTO.getPassword());
    }
}
