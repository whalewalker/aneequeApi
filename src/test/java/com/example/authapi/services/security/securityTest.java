package com.example.authapi.services.security;

import com.example.authapi.data.model.User;
import com.example.authapi.data.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.example.authapi.data.model.Role.USER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class securityTest {

    @Mock
    private UserRepository<User> userRepository;

    @InjectMocks
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private CustomUserDetailService customUserDetailService;
    private User mockedUser;

    @BeforeEach
    void setUp() {
        mockedUser = new User();
        mockedUser.setUsername("whale");
        mockedUser.setEmail("ohida2001@gmail.com");
        mockedUser.setPassword("pass1234");
        mockedUser.getRoles().add(USER);
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        userRepository = null;
        customUserDetailService = null;
    }

    @Test
    @DisplayName("Jwt token can be generated")
    void jwt_tokenCanBeGenerated() {
        //Given
        when(userRepository.findByName("whale"))
                .thenReturn(Optional.of(mockedUser));

        //When
        UserPrincipal fetchedUser = (UserPrincipal) customUserDetailService.loadUserByUsername("whale");
        String actualToken = jwtTokenProvider.generateToken(fetchedUser.getUsername());

        //Assert
        assertNotNull(actualToken);
        assertEquals(actualToken.getClass(), String.class);
    }

    @Test
    @DisplayName("Username can be extracted from jwt token")
    void can_extractUsernameFromJwtToken() {
        String expected = mockedUser.getUsername();
        //Given
        when(userRepository.findByName("whale"))
                .thenReturn(Optional.of(mockedUser));

        //When
        UserPrincipal fetchedUser = (UserPrincipal) customUserDetailService.loadUserByUsername("whale");
        String jwtToken = jwtTokenProvider.generateToken(fetchedUser.getUsername());
        String actual = jwtTokenProvider.extractUsername(jwtToken);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Token can be validated by checking expiration date")
    void test_thatTokenHasNotExpire() {
        //Given
        when(userRepository.findByName("whale"))
                .thenReturn(Optional.of(mockedUser));

        //When
        UserPrincipal fetchedUser = (UserPrincipal) customUserDetailService.loadUserByUsername("whale");
        String jwtToken = jwtTokenProvider.generateToken(fetchedUser.getUsername());
        boolean hasExpire = jwtTokenProvider.isTokenExpired(jwtToken);

        //Assert
        assertFalse(hasExpire);
    }

    @Test
    @DisplayName("Jwt token can be validated by username and expiration date")
    void test_jwtTokenCanBeValidated() {
        //Given
        when(userRepository.findByName("whale"))
                .thenReturn(Optional.of(mockedUser));

        //When
        UserPrincipal fetchedUser = (UserPrincipal) customUserDetailService.loadUserByUsername("whale");
        String jwtToken = jwtTokenProvider.generateToken(fetchedUser.getUsername());
        boolean isValid = jwtTokenProvider.validateToken(jwtToken, fetchedUser);

        //Assert
        assertTrue(isValid);
    }

}