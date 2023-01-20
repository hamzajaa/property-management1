package com.example.propertymanagment1.modelOrDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // if a value of an attribute is null => will be not returned
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String userName;
    @NotNull(message = "UserEmail  can't be null") // if this not validate => springboot automatically throw an exception
    @NotEmpty(message = "UserEmail can't be empty")
    @Size(min = 1, max = 50, message = "User Email should be between 1 to 50 characters in length")
    private String userEmail;

    @NotNull(message = "Password can't be null")
    @NotEmpty(message = "Password can't be empty")
    @Size(min = 8, max = 50, message = "Password should be between 8 to 50 characters in length")
    private String password;
    private String phone;
}
