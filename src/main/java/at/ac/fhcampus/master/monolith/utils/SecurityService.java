package at.ac.fhcampus.master.monolith.utils;

import at.ac.fhcampus.master.monolith.user.entities.User;

import java.util.Optional;

public interface SecurityService {

    Optional<User> loggedInUser();
}
