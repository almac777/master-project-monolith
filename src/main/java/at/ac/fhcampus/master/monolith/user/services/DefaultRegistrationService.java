package at.ac.fhcampus.master.monolith.user.services;

import at.ac.fhcampus.master.monolith.user.converters.UserDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.user.converters.UserToDtoConverter;
import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import at.ac.fhcampus.master.monolith.user.entities.User;
import at.ac.fhcampus.master.monolith.user.repositories.UserRepository;
import at.ac.fhcampus.master.monolith.utils.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DefaultRegistrationService implements RegistrationService {

    private final SecurityService securityService;

    private final UserRepository userRepository;
    private final UserToDtoConverter userToDtoConverter;
    private final UserDtoToEntityConverter userDtoToEntityConverter;

    @Override
    public UserDto registerUser(UserDto userDto) {
        return Optional.of(userDto)
                .map(this::peekUserDto)
                .map(userDtoToEntityConverter::convert)
                .map(this::peekUser)
                .map(userRepository::save)
                .map(userToDtoConverter::convert)
                .orElseThrow(() -> {
                    throw new RuntimeException("User registration has failed");
                });
    }

    private User peekUser(User user) {
        log.info("Trying to store the following user: {}", user);
        return user;
    }

    private UserDto peekUserDto(UserDto userDto) {
        log.info("Received the following user dto: {}", userDto);
        return userDto;
    }


    @Override
    public void unregister(Long id) {
        var user = this.securityService.loggedInUser().orElse(null);
        if (user == null || !user.getId().equals(id)) {
            throw new RuntimeException("Invalid request");
        }

        this.userRepository.findById(id)
                .ifPresentOrElse(this::removeUser, () -> {
                    throw new RuntimeException("User not found");
                });
    }

    private void removeUser(User user) {
        log.info("Removing user {}", user);
        this.userRepository.delete(user);
    }
}
