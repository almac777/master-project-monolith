package at.ac.fhcampus.master.monolith.user.converters;

import at.ac.fhcampus.master.monolith.user.dtos.RoleDto;
import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import at.ac.fhcampus.master.monolith.user.entities.Role;
import at.ac.fhcampus.master.monolith.user.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDtoToEntityConverter implements Converter<UserDto, User> {

    public static class RoleDtoToEntityConverter implements Converter<RoleDto, Role> {
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
                .accountNonExpired(source.isAccountNonExpired())
                .accountNonLocked(source.isAccountNonLocked())
                .credentialsNonExpired(source.isCredentialsNonExpired())
                .enabled(source.isEnabled())
                .username(source.getUsername())
                .password(source.getPassword())
                .roles(this.convert(source.getRoles()))
                .build();
    }

    List<Role> convert(List<RoleDto> authorities) {
        RoleDtoToEntityConverter converter = new RoleDtoToEntityConverter();
        return Optional.ofNullable(authorities)
                .orElse(new LinkedList<>())
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
