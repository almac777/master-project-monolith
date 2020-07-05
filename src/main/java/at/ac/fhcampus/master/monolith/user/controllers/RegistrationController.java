package at.ac.fhcampus.master.monolith.user.controllers;

import at.ac.fhcampus.master.monolith.user.dtos.UserDto;
import at.ac.fhcampus.master.monolith.user.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(RegistrationController.BASE_URL)
public final class RegistrationController {

    static final String BASE_URL = "/api/v1/users";
    static final String REGISTER_USER = "/registration";
    static final String UNREGISTER_USER = "/remove/{userId}";

    private final RegistrationService registrationService;

    @PostMapping(REGISTER_USER)
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(this.registrationService.registerUser(userDto));
    }

    @DeleteMapping(UNREGISTER_USER)
    public ResponseEntity<Void> unregister(@PathVariable("userId") Long userId) {
        this.registrationService.unregister(userId);
        return ResponseEntity.<Void>status(HttpStatus.OK)
                .body(null);
    }
}
