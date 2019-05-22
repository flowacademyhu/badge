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

    public Boolean isUserContainsUser(Badge badge) {
        return this.badgesUser.contains(badge);
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (fullname != null ? !fullname.equals(user.fullname) : user.fullname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (badges != null ? !badges.equals(user.badges) : user.badges != null) return false;
        return badgesUser != null ? badgesUser.equals(user.badgesUser) : user.badgesUser == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (badges != null ? badges.hashCode() : 0);
        result = 31 * result + (badgesUser != null ? badgesUser.hashCode() : 0);
        return result;
    }
}
