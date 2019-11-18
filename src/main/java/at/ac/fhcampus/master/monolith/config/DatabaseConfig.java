package at.ac.fhcampus.master.monolith.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "at.ac.fhcampus.master.monolith")
@EnableJpaRepositories(basePackages = "at.ac.fhcampus.master.monolith")
public class DatabaseConfig {
}
