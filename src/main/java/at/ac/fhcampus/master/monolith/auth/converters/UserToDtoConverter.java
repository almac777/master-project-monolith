package at.ac.fhcampus.master.monolith.auth.converters;

import at.ac.fhcampus.master.monolith.auth.dtos.AuthorityDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.entities.Authority;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    public class AuthorityToDtoConverter implements Converter<Authority, AuthorityDto> {
        @Override
        public AuthorityDto convert(Authority source) {
            return AuthorityDto.builder()
                    .id(source.getId())
                    .authority(source.getAuthority())
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
                .authorities(this.convert(source.getAuthorities()))
                .build();
    }

    List<AuthorityDto> convert(List<Authority> authorities) {
        AuthorityToDtoConverter converter = new AuthorityToDtoConverter();
        return authorities.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
