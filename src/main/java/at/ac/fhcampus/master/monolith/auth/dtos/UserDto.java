package at.ac.fhcampus.master.monolith.auth.dtos;

import at.ac.fhcampus.master.monolith.auth.entities.Authority;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String username;
    private String password;

    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    private List<Authority> authorities;

}
