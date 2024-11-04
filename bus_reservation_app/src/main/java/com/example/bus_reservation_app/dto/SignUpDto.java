package com.example.bus_reservation_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignUpDto {
    @NotNull(message = "Name is Not Be Null")
    @NotBlank(message = "Name Field Is Missing")
    private String name;
    @NotNull(message = "EmailId is Not Be Null")
    @NotBlank(message = "EmailId Field Is Missing")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String emailID;
    @NotNull(message = "password is Not Be Null")
    @NotBlank(message = "password Field Is Missing")
    @Size(min = 8,message = "password is minimum character is 8")
    private String password;
    @NotNull(message = "role is Not Be Null")
    @NotBlank(message = "role Field Is Missing")
    private String role;
}
