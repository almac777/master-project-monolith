package at.ac.fhcampus.master.monolith.user.services;

import at.ac.fhcampus.master.monolith.user.dtos.UserDto;

public interface RegistrationService {

    UserDto registerUser(UserDto userDto);

    void unregister(Long id);
}
