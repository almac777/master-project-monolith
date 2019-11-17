package at.ac.fhcampus.master.monolith.auth.services;

import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;

public interface RegistrationService {

    UserDto registerUser(UserDto userDto);

    void unregister(Long id);

}
