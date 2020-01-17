package at.ac.fhcampus.master.monolith.auth.services;

import at.ac.fhcampus.master.monolith.auth.converters.UserDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.auth.converters.UserToDtoConverter;
import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.entities.User;
import at.ac.fhcampus.master.monolith.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public final class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;
    private final UserToDtoConverter userToDtoConverter;
    private final UserDtoToEntityConverter userDtoToEntityConverter;

    @Override
    public UserDto registerUser(UserDto userDto) {
        return Optional.of(userDto)
                .map(userDtoToEntityConverter::convert)
                .map(userRepository::save)
                .map(userToDtoConverter::convert)
                .orElseThrow(() -> {
                    throw new RuntimeException("User registration has failed");
                });
    }

    @Override
    public void unregister(Long id) {
        this.userRepository.findById(id)
                .ifPresentOrElse(
                    this::removeUser,
                    () -> { throw new RuntimeException("User not found"); }
                );
    }

    private void removeUser(User user) {
        this.userRepository.delete(user);
    }

}
