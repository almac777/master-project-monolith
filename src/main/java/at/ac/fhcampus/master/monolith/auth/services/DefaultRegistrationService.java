package at.ac.fhcampus.master.monolith.auth.services;

import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public UserDto registerUser(UserDto userDto) {
        throw new RuntimeException("registerUser / Not yet implemented.");
    }

    @Override
    public void unregister(Long id) {
        throw new RuntimeException("unregister / Not yet implemented.");
    }
}
