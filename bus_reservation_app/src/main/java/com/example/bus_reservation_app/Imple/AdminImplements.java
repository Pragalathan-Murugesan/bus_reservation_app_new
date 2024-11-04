package com.example.bus_reservation_app.Imple;

import com.example.bus_reservation_app.apirespose.ApiResponse;
import com.example.bus_reservation_app.dto.CommonDto;
import org.springframework.http.ResponseEntity;

public interface AdminImplements {
    ResponseEntity<ApiResponse> addUserProfile(CommonDto commonDto);

    ApiResponse deleteUser(Long id);

    ApiResponse adminLogin(CommonDto commonDto);

    ApiResponse updateUser(CommonDto commonDto);
}
