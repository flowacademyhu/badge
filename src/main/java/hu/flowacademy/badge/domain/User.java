package hu.flowacademy.badge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    @Column
    private String fullname;

    @Column
    private String password;

    @Column
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Badge> badges;

    @ManyToMany(mappedBy = "users")
    Set<Badge> badgesUser = new HashSet<>();


    public User() {
    }




    public User(String username, String fullname, String password, String role) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }

    public void addBadgeToUser(Badge badge) {
        badgesUser.add(badge);
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
