package Flatmate.example.Enities;



import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "flats")
@Data
@Builder
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for Flat entity

    @Column( nullable = false)
    private int flatCode;  // Flat code to uniquely identify the flat

    // Relationship with User (One-to-Many)
    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;  // List of users associated with this flat

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlatCode() {
        return flatCode;
    }

    public void setFlatCode(int flatCode) {
        this.flatCode = flatCode;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Flat() {
    }

    public Flat(Long id, int flatCode, Set<User> users) {
        this.id = id;
        this.flatCode = flatCode;
        this.users = users;
    }
}
