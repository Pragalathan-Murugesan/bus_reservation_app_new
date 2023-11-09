package com.example.bus_reservation_app.controller;

import com.example.bus_reservation_app.apirespose.ApiResponse;
import com.example.bus_reservation_app.dto.CommonDto;
import com.example.bus_reservation_app.dto.LoginDto;
import com.example.bus_reservation_app.dto.SignUpDto;
import com.example.bus_reservation_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/api")
public class UserControlle {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }
    @PostMapping(value = "/login")
    public ApiResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @GetMapping(value = "/get/availability")
    public ApiResponse getAvailability(){
        return userService.getAvailability();
    }
    @PostMapping(value = "/book/ticket")
    public ApiResponse bookTicket(@RequestBody CommonDto commonDto) throws Exception {
        return userService.bookTicket(commonDto);
    }

    @PutMapping(value = "/delete/oneticket")
    public ApiResponse deleteOneTicket(@RequestBody CommonDto commonDto){
        return userService.deleteOneTicket(commonDto);
    }
    @PutMapping(value = "/change/password")
    public ApiResponse changePassword(@RequestBody CommonDto commonDto){
        return userService.changePassword(commonDto);
    }
    @PostMapping(value = "/forgot/password")
    public ApiResponse forgotPassword(@RequestBody CommonDto commonDto){
    return userService.forgotPassword(commonDto);
    }
    @PutMapping(value = "/reset/password")
    public ApiResponse resetPassword(@RequestBody CommonDto commonDto){
        return userService.resetPassword(commonDto);
    }
}
