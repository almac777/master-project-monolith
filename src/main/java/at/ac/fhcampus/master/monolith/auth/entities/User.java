package at.ac.fhcampus.master.monolith.auth.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
public class User implements UserDetails {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;

    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    @Singular
    @ManyToMany
    private List<Authority> authorities;

}
