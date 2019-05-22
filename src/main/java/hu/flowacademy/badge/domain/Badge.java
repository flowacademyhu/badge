package hu.flowacademy.badge.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "badge_seq")
    @SequenceGenerator(name = "badge_seq", initialValue = 1, sequenceName = "badge_seq")
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "user_badges",
            joinColumns = @JoinColumn(name = "badge_id"),
            inverseJoinColumns = @JoinColumn(name = "user_username"))
    Set<User> users = new HashSet<>();

    public void setUserToBadge(User user) {
        users.add(user);
    }
    public Boolean isBadgeContainsUser(User user) {
        return this.users.contains(user);
    }

    public Badge(Long id, String name, byte[] content, User owner) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.owner = owner;
    }
    public Badge() {

    }

    public Badge(String name, byte[] content, User owner) {
        this.name = name;
        this.content = content;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
