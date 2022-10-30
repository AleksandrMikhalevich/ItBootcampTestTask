package dto;

import entities.RoleName;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 40, message = "Допускается до 40 латинских букв")
    @Pattern(regexp = "[a-zA-Z]*", message = "Допустимы только латинские буквы")
    private final String firstName;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 20, message = "Допускается до 20 латинских букв")
    @Pattern(regexp = "[a-zA-Z]*", message = "Допустимы только латинские буквы")
    private final String secondName;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 40, message = "Допускается до 40 латинских букв")
    @Pattern(regexp = "[a-zA-Z]*", message = "Допустимы только латинские буквы")
    private final String surname;

    @Email(message = "Должно соответствовать формату email")
    @Size(max = 50, message = "Допускается до 50 латинских символов")
    private final String email;

    private final Integer roleId;

    private final RoleName roleName;
}