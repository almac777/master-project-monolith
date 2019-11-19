package at.ac.fhcampus.master.monolith.auth.dtos;

import at.ac.fhcampus.master.monolith.auth.entities.Authority;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class UserDto {

    private Long id;

    private String username;
    private String password;

    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    @Singular
    private List<AuthorityDto> authorities;

}
