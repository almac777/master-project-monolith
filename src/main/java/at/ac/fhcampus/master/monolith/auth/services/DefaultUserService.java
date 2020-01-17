package at.ac.fhcampus.master.monolith.auth.services;

import at.ac.fhcampus.master.monolith.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DefaultUserService implements UserDetailsService {

    private static final String ERROR_USERNAME_NOT_FOUND = "Couldn't find user %s";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(ERROR_USERNAME_NOT_FOUND, username)));
    }
}
