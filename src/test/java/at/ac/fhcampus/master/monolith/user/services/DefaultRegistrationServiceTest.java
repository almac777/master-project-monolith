package at.ac.fhcampus.master.monolith.user.services;

import at.ac.fhcampus.master.monolith.user.converters.UserDtoToEntityConverter;
import at.ac.fhcampus.master.monolith.user.converters.UserToDtoConverter;
import at.ac.fhcampus.master.monolith.user.repositories.UserRepository;
import at.ac.fhcampus.master.monolith.fixtures.UserFixture;
import at.ac.fhcampus.master.monolith.utils.SecurityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultRegistrationServiceTest {

    private DefaultRegistrationService defaultRegistrationService;
    private UserRepository userRepository;
    private UserToDtoConverter userToDtoConverter;
    private UserDtoToEntityConverter userDtoToEntityConverter;
    private SecurityService defaultSecurityService;

    @BeforeEach
    void setup() {
        this.userRepository = mock(UserRepository.class);
        this.userToDtoConverter = mock(UserToDtoConverter.class);
        this.defaultSecurityService = mock(SecurityService.class);
        this.userDtoToEntityConverter = mock(UserDtoToEntityConverter.class);
        this.defaultRegistrationService = new DefaultRegistrationService(
                this.defaultSecurityService,
                this.userRepository,
                this.userToDtoConverter,
                this.userDtoToEntityConverter
        );
    }

    @Test
    void whenValidUserIsRegistered_registrationShouldWork() {
        when(this.userToDtoConverter.convert(UserFixture.mockedUser()))
                .thenReturn(UserFixture.mockedUserDto());
        when(this.userDtoToEntityConverter.convert(UserFixture.mockedUserDto()))
                .thenReturn(UserFixture.mockedUser());
        when(this.userRepository.save(UserFixture.mockedUser()))
                .thenReturn(UserFixture.mockedUser());

        this.defaultRegistrationService.registerUser(UserFixture.mockedUserDto());

        verify(this.userDtoToEntityConverter, times(1)).convert(UserFixture.mockedUserDto());
        verify(this.userRepository, times(1)).save(UserFixture.mockedUser());
        verify(this.userToDtoConverter, times(1)).convert(UserFixture.mockedUser());
    }

    @Test
    void unregister() {
        when(this.userRepository.findById(1L)).thenReturn(UserFixture.optionalMockUser());
        when(this.defaultSecurityService.loggedInUser()).thenReturn(UserFixture.optionalMockUser());
        this.defaultRegistrationService.unregister(1L);
        verify(this.userRepository, times(1)).delete(UserFixture.mockedUser());
    }
}
