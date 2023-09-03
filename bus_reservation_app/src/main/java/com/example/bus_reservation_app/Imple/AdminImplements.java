package com.example.bus_reservation_app.Imple;

import com.example.bus_reservation_app.apirespose.ApiResponse;
import com.example.bus_reservation_app.dto.CommonDto;

public interface AdminImplements {
    ApiResponse addUserProfile(CommonDto commonDto);

    ApiResponse deleteUser(Long id);

    ApiResponse adminLogin(CommonDto commonDto);

    ApiResponse updateUser(CommonDto commonDto);
}
