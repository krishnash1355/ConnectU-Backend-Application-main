package com.example.ConnectU.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {
    @Email
    @NotBlank(message = "Email cannot be blank")
    private String email;
    private String password;
}
