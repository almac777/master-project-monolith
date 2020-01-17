package at.ac.fhcampus.master.monolith.fixtures;

import at.ac.fhcampus.master.monolith.auth.dtos.RoleDto;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.entities.Role;
import at.ac.fhcampus.master.monolith.auth.entities.User;

import java.util.Optional;

public class UserFixture {

    public static Optional<User> optionalMockUser() {
        return Optional.of(mockedUser());
    }

    public static User mockedUser() {
        return User.builder()
                .id(1L)
                .username("username")
                .password("password")
                .role(Role.builder().id(1L).role("mockauthority").build())
                .build();
    }

    public static UserDto mockedUserDto() {
        return UserDto.builder()
                .id(1L)
                .username("username")
                .password("password")
                .role(RoleDto.builder().id(1L).role("mockauthority").build())
                .build();
    }
}
