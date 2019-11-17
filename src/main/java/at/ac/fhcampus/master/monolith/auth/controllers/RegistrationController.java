package at.ac.fhcampus.master.monolith.auth.controllers;

import at.ac.fhcampus.master.monolith.auth.dtos.UserDto;
import at.ac.fhcampus.master.monolith.auth.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(RegistrationController.BASE_URL)
public final class RegistrationController {

    static final String BASE_URL = "/api/v1/registration";
    static final String REGISTER_USER = "/register";
    static final String UNREGISTER_USER = "/delete/{userId}";

    private final RegistrationService registrationService;

    @PostMapping(REGISTER_USER)
    public UserDto register(@RequestBody UserDto userDto) {
        return this.registrationService.registerUser(userDto);
    }

    @DeleteMapping(UNREGISTER_USER)
    public void unregister(@PathVariable("userId") Long userId) {
        this.registrationService.unregister(userId);
    }

}
