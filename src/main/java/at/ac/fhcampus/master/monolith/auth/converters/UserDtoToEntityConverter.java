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
public class UserDtoToEntityConverter implements Converter<UserDto, User> {

    public class AuthorityDtoToEntityConverter implements Converter<AuthorityDto, Authority> {
        @Override
        public Authority convert(AuthorityDto source) {
            return Authority.builder()
                    .id(source.getId())
                    .authority(source.getAuthority())
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
                .authorities(this.convert(source.getAuthorities()))
                .build();
    }

    List<Authority> convert(List<AuthorityDto> authorities) {
        AuthorityDtoToEntityConverter converter = new AuthorityDtoToEntityConverter();
        return authorities.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

}
