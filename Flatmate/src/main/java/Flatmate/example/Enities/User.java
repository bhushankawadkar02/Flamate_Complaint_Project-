package Flatmate.example.Enities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "Users")
@Setter
@Getter
@Data
public class User implements UserDetails {


    @Id

    private String id;  // Change the type from String to Long or Integer

    private String username;
    private String password;
    private String email;
    private int karmaPoints = 0;


    @ManyToOne
    @JoinColumn(name = "flat_id", referencedColumnName = "id")
    private Flat flat;  // Reference to the Flat entity
    public User( String id,String username, String password, String email, int karmaPoints,Flat flat) {
    this.id=id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.karmaPoints = karmaPoints;
      this.flat = flat;
    }




    public int getKarmaPoints() {
        return karmaPoints;
    }

    public void setKarmaPoints(int karmaPoints) {
        this.karmaPoints = karmaPoints;
    }

//    public Flat getFlat() {
//        return flat;
//    }
//
//    public void setFlat(Flat flat) {
//        this.flat = flat;
//    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

}
