package at.ac.fhcampus.master.monolith.user.converters;

import at.ac.fhcampus.master.monolith.user.dtos.RoleDto;
import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import at.ac.fhcampus.master.monolith.user.entities.Role;
import at.ac.fhcampus.master.monolith.user.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    public static class RoleToDtoConverter implements Converter<Role, RoleDto> {
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
                .accountNonExpired(source.isAccountNonExpired())
                .accountNonLocked(source.isAccountNonLocked())
                .credentialsNonExpired(source.isCredentialsNonExpired())
                .enabled(source.isEnabled())
                .username(source.getUsername())
                .password(source.getPassword())
                .roles(this.convert(source.getRoles()))
                .build();
    }

    List<RoleDto> convert(List<Role> authorities) {
        RoleToDtoConverter converter = new RoleToDtoConverter();
        return authorities.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
