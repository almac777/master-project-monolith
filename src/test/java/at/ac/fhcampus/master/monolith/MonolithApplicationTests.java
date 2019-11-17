package at.ac.fhcampus.master.monolith;

import at.ac.fhcampus.master.monolith.auth.controllers.RegistrationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MonolithApplicationTests {

    @Autowired
    private RegistrationController registrationController;

    @Test
    void contextLoads() {
        assertThat(registrationController).isNotNull();
    }
}
