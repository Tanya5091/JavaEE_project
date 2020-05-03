package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty(message = "Login can`t be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message ="Only latin characters and digits are allowed")
    private String login;


    @NotEmpty(message = "Password can`t be empty")
    @Size(min = 8, max = 20, message = "Password should contain 8 to 20 characters")
    private String password;
}
