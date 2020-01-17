package at.ac.fhcampus.master.monolith.auth.converters;

import at.ac.fhcampus.master.monolith.auth.dtos.RoleDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.entities.Role;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDtoToEntityConverter implements Converter<UserDto, User> {

    public class AuthorityDtoToEntityConverter implements Converter<RoleDto, Role> {
        @Override
        public Role convert(RoleDto source) {
            return Role.builder()
                    .id(source.getId())
                    .role(source.getRole())
                    .build();
        }
    }

    @Override
    public User convert(UserDto source) {
        return User.builder()
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

    List<Role> convert(List<RoleDto> authorities) {
        AuthorityDtoToEntityConverter converter = new AuthorityDtoToEntityConverter();
        return Optional.ofNullable(authorities)
                .orElse(new LinkedList<>())
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
