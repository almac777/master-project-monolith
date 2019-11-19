package at.ac.fhcampus.master.monolith.auth.services;

import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;

import java.util.Optional;

public interface RegistrationService {

    UserDto registerUser(UserDto userDto);

    void unregister(Long id);

}
