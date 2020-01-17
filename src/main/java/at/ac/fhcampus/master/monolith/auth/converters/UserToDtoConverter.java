package at.ac.fhcampus.master.monolith.auth.converters;

import at.ac.fhcampus.master.monolith.auth.dtos.RoleDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.entities.Role;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    public class AuthorityToDtoConverter implements Converter<Role, RoleDto> {
        @Override
        public RoleDto convert(Role source) {
            return RoleDto.builder()
                    .id(source.getId())
                    .role(source.getRole())
                    .build();
        }
    }

    @Override
    public UserDto convert(User source) {
        return UserDto.builder()
                .id(source.getId())
                .isAccountNonExpired(source.isAccountNonExpired())
                .isAccountNonLocked(source.isAccountNonLocked())
                .isCredentialsNonExpired(source.isCredentialsNonExpired())
                .isEnabled(source.isEnabled())
                .username(source.getUsername())
                .password(source.getPassword())
                .roles(this.convert(source.getRoles()))
                .build();
    }

    List<RoleDto> convert(List<Role> authorities) {
        AuthorityToDtoConverter converter = new AuthorityToDtoConverter();
        return authorities.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
