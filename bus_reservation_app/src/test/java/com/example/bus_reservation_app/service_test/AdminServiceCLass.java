//package com.example.bus_reservation_app.service_test;
//
//import com.example.bus_reservation_app.dto.SignUpDto;
//import com.example.bus_reservation_app.entity.User;
//import com.example.bus_reservation_app.jwt_tokens.TokenGeneration;
//import com.example.bus_reservation_app.repo.UserProfileRepo;
//import com.example.bus_reservation_app.repo.UserRepo;
//import com.example.bus_reservation_app.service.UserService;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//
//import static org.mockito.Mockito.when;
//
////@MockitoSettings(strictness = Strictness.LENIENT)
////@ExtendWith(MockitoExtension.class)
////@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
//public class AdminServiceCLass {
//    @Mock
//    UserRepo userRepo;
//    @Mock
//    TokenGeneration tokenGeneration;
//    @Mock
//    UserProfileRepo userProfileRepo;
//    @InjectMocks
//    UserService userService1;
//    ;
//    //    = mock(UserService.class);
//    @InjectMocks
//    UserService userService;
//    @Mock
//    EntityManager entityManager;
//    //    @Mock
////    ApiResponse apiResponse1;
//    @Mock
//    private User user;
//    @Mock
//    TypedQuery<User> query;
//
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    @Order(1)
//    public void addAdminTest() {
//        SignUpDto signUpDto = new SignUpDto();
//        signUpDto.setName("John Doe");
//        signUpDto.setEmailID("john@example.com");
//        signUpDto.setPassword("password123");
//        signUpDto.setRole("admin");
//
//        User user = new User();
//        user.setName("John Doe");
//        user.setEmailID("john@example.com");
//        user.setPassword("password123");
//        user.setRole("admin");
//
////        ApiResponse expectedResponse = new ApiResponse();
////        expectedResponse.setMessage("hhfhhf");
////        expectedResponse.setData(null);
////        expectedResponse.setStatus(HttpStatus.OK.value());
//
//        when(userRepo.save(user)).thenReturn(user);
//        userService.signUp(signUpDto);
//
//        Assertions.assertEquals(HttpStatus.OK, userService.signUp(signUpDto).getStatusCode());
//
////        Mockito.verify(userService, times(1)).signUp(signUpDto);
//    }
//}
////    @Test
////    @Order(2)
////    public void testLogin_Successful() {
////        LoginDto loginDto = new LoginDto();
////        loginDto.setRole("admin");
////        loginDto.setEmailID("admin@example.com");
////
////        User user = new User();
////        user.setId(1L);
////        user.setRole("admin");
////        user.setEmailID("admin@example.com");
////
////        ApiResponse apiResponse = new ApiResponse();
////        apiResponse.setStatus(HttpStatus.OK.value());
////        apiResponse.setMessage("success");
////        apiResponse.setData(null);
////
////        apiResponse1.setStatus(HttpStatus.NOT_FOUND.value());
////        apiResponse1.setMessage("Failed");
////        apiResponse1.setData(null);
////
////        String loginQuery = "SELECT e FROM User e WHERE e.role = :role AND e.emailID = :emailID";
////        entityManager.createQuery(loginQuery, (User.class));
////        when(query.setParameter(eq("role"), eq(loginDto.getRole()))).thenReturn(query);
////        when(query.setParameter(eq("emailID"), eq(loginDto.getEmailID()))).thenReturn(query);
////        when(query.getSingleResult()).thenReturn(user);
////        assertEquals(user.getRole(), loginDto.getRole());
////        assertEquals(user.getEmailID(), loginDto.getEmailID());
////        assertEquals(apiResponse.getStatus(), userService.login(loginDto).getStatus());
//////        assertThrows(, (Executable) userService.login(loginDto).getStatus());
////    }
////
////    @Test
////    @Order(3)
////    public void testLogin() {
////        LoginDto loginDto = new LoginDto();
////        loginDto.setRole("admin");
////        loginDto.setEmailID("admin@example.com");
//////       UserProfile userProfile=new UserProfile(1L,"gender",11L,132456L,4L,321L,2000-09-09);
////        UserProfile userProfile = new UserProfile();
////        User use = new User(1L, "name", "emailid", "password", "role", 2443L, 12L, 123L, userProfile, 123L);
////        String token = "token string";
////        when(userRepo.save(use)).thenReturn(use);
////        Assertions.assertEquals(HttpStatus.OK,userService.login(loginDto).getStatus());
////    }
//
