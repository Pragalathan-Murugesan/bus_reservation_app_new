package com.example.bus_reservation_app.Imple;

import com.example.bus_reservation_app.apirespose.ApiResponse;
import com.example.bus_reservation_app.dto.CommonDto;
import com.example.bus_reservation_app.dto.LoginDto;
import com.example.bus_reservation_app.dto.SignUpDto;
import org.springframework.http.ResponseEntity;

public interface UserImple {
    ResponseEntity<ApiResponse> signUp(SignUpDto signUpDto);

    ApiResponse login(LoginDto  loginDto);

    ApiResponse bookTicket(CommonDto commonDto) throws Exception;

    ApiResponse getAvailability();

    ApiResponse deleteOneTicket(CommonDto commonDto);

    ApiResponse changePassword(CommonDto commonDto);

    ApiResponse forgotPassword(CommonDto commonDto);

    ApiResponse resetPassword(CommonDto commonDto);
}
