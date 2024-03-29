package xyz.n490808114.shopWeb.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class User implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Null
    private String id;
    private String name;
    @Size(min = 8,max = 255)
    private String username;
    @Size(min = 8,max = 255)
    private String password;
    private String email;
    @JsonIgnore
    private Role[] roles;
    private String avatar;

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {list.add(new SimpleGrantedAuthority(role.getName()));}
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @param roles the roles to set
     */
    public void setRoles(Role[] roles) {
        this.roles = roles;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the roles
     */
    public Role[] getRoles() {
        return roles;
    }

}