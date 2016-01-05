package com.dawidkotarba.playground.integration.dto;


import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */
public class UserInDto implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String password;

    private boolean enabled;

    @NotNull
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
