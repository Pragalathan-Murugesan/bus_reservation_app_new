package com.example.bus_reservation_app.service_test;

import com.example.bus_reservation_app.dto.CommonDto;
import com.example.bus_reservation_app.entity.User;
import com.example.bus_reservation_app.jwt_tokens.TokenGeneration;
import com.example.bus_reservation_app.repo.AdminRepo;
import com.example.bus_reservation_app.repo.UserProfileRepo;
import com.example.bus_reservation_app.repo.UserRepo;
import com.example.bus_reservation_app.service.AdminService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AdminServiceClassTest {

    @Mock
    UserRepo userRepo;

    @Mock
    TokenGeneration tokenGeneration;

    @Mock
    UserProfileRepo userProfileRepo;

    @InjectMocks
    AdminService adminService;

    @Mock
    AdminRepo adminRepo;

    @Mock
    EntityManager entityManager;

    @Mock
    User user;

    @Mock
    TypedQuery<User> query;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    public void addAdminTest() {
        // Arrange
        CommonDto signUpDto = new CommonDto("John Doe", "john@example.com", "password123", "admin", 34567890L);

        // Act
        adminService.addUserProfile(signUpDto);
    }

    // Add more tests for other functionalities as needed.
}
