package com.comport.cp.user.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterDto {

    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "First name must contain at least 3 characters")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "Last name must contain at least 3 characters")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", message = "Invalid email")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must contain at least 8 characters, one letter and one number")
    private String password;
}
