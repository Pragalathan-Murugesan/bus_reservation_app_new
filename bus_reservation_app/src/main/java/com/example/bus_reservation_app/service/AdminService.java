package com.example.bus_reservation_app.service;

import com.example.bus_reservation_app.Imple.AdminImplements;
import com.example.bus_reservation_app.apirespose.ApiResponse;
import com.example.bus_reservation_app.dto.CommonDto;
import com.example.bus_reservation_app.dto.LoginDto;
import com.example.bus_reservation_app.entity.Admin;
import com.example.bus_reservation_app.entity.User;
import com.example.bus_reservation_app.entity.UserProfile;
import com.example.bus_reservation_app.global_exception.CustomizeException;
import com.example.bus_reservation_app.jwt_tokens.TokenGeneration;
import com.example.bus_reservation_app.repo.AdminRepo;
import com.example.bus_reservation_app.repo.UserProfileRepo;
import com.example.bus_reservation_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService implements AdminImplements {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    ApiResponse apiResponse;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private TokenGeneration tokenGeneration;

    @Override
    public ApiResponse addUserProfile(CommonDto commonDto) {
try {
    Admin admin = new Admin();
    admin.setName(commonDto.getName());
    admin.setEmailID(commonDto.getEmailID());
    admin.setPassword(commonDto.getPassword());
    admin.setRole(commonDto.getRole());
    Long createAt = Instant.now().getEpochSecond();
    admin.setCreateAt(createAt);
    adminRepo.save(admin);
    apiResponse.setStatus(HttpStatus.OK.value());
    apiResponse.setMessage("admin Added Successfully");
    apiResponse.setData(null);
}catch (NullPointerException e){
    throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
}
        return apiResponse;
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            apiResponse.setData(null);
            apiResponse.setMessage("User Deleted Successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return apiResponse;
    }

    @Override
    public ApiResponse adminLogin(CommonDto commonDto) {
        try {
            String loginQuery = "SELECT q FROM Admin q WHERE q.role = :role AND q.emailID = :emailID";
            TypedQuery<Admin> query = entityManager.createQuery(loginQuery, Admin.class);
            query.setParameter("role",commonDto.getRole());
            query.setParameter("emailID",commonDto.getEmailID());
            query.getSingleResult();
            Admin admin =  query.getSingleResult();
            if (admin==null){
                apiResponse.setData(null);
                apiResponse.setMessage("Login Failed");
                apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
            }
            String token = tokenGeneration.generateTokens(new LoginDto());
            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            apiResponse.setData(data);
            apiResponse.setMessage("Login Successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return apiResponse;
    }

    @Override
    public ApiResponse updateUser(CommonDto commonDto) {
        try {
            String loginQuery = "SELECT q FROM User q WHERE q.name = :name";
            TypedQuery<User> query = entityManager.createQuery(loginQuery, User.class);
            query.setParameter("name",commonDto.getName());
            query.getSingleResult();
            User user = query.getSingleResult();
            user.setPassword(commonDto.getPassword());
            Long updateAt = Instant.now().getEpochSecond();
            user.setUpdateAt(updateAt);
            userRepo.save(user);
            apiResponse.setData(null);
            apiResponse.setMessage("User Updated Successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return apiResponse;
    }


}

