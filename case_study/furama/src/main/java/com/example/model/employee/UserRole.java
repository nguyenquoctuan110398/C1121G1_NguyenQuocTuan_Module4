package com.example.model.employee;

import javax.persistence.*;

@Entity
@Table
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    private AppRole appRole;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private AppUser appUser;

    public UserRole() {
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public AppRole getRole() {
//        return appRole;
//    }
//
//    public void setRole(AppRole appRole) {
//        this.appRole = appRole;
//    }
//
//    public AppUser getUser() {
//        return appUser;
//    }
//
//    public void setUser(AppUser appUser) {
//        this.appUser = appUser;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
