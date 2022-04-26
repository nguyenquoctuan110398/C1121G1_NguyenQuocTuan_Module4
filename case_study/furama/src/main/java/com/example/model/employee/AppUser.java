package com.example.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class AppUser {
    @Id
    private String username;
    private String password;

    @OneToOne(mappedBy = "appUser")
    private Employee employee;

    @OneToMany(mappedBy = "appUser")
    private Set<UserRole> userRoles;


    public AppUser() {
    }

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
