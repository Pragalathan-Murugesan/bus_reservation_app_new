package com.example.bus_reservation_app.controller;

import com.example.bus_reservation_app.apirespose.ApiResponse;
import com.example.bus_reservation_app.dto.CommonDto;
import com.example.bus_reservation_app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping(value = "/adduserprofile")
    public ApiResponse addUserProfile(@RequestBody CommonDto commonDto){
        return adminService.addUserProfile(commonDto);
    }
    @PostMapping(value = "/adminlogin")
    public ApiResponse adminLogin(@RequestBody CommonDto commonDto){
        return adminService.adminLogin(commonDto);
    }
    @DeleteMapping(value = "/delete/user/{id}")
    public ApiResponse deleteUser(@PathVariable Long id){
        return adminService.deleteUser(id);
    }
    @PutMapping(value = "/update/user")
    public ApiResponse updateUser(@RequestBody CommonDto commonDto){
        return adminService.updateUser(commonDto);
    }

}
