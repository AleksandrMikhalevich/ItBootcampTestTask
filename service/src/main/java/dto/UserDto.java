package dto;

import entities.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record UserDto(
        @NotBlank(message = "The field must not be empty")
        @Size(min = 1, max = 40, message = "Up to 40 latin letters allowed")
        @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters are allowed")
        String firstName,
        @NotBlank(message = "The field must not be empty")
        @Size(min = 1, max = 20, message = "Up to 20 latin letters allowed")
        @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters are allowed") String secondName,
        @NotBlank(message = "The field must not be empty")
        @Size(min = 1, max = 40, message = "Up to 40 latin letters allowed")
        @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters are allowed") String surname,
        @Email(message = "Must match email format")
        @Size(max = 50, message = "Up to 50 latin characters allowed")
        String email,
        Integer roleId,
        RoleName roleName) implements Serializable {

}