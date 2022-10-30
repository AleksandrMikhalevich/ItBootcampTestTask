package dto;

import entities.RoleName;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link entities.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final String firstName;
    private final String secondName;
    private final String surname;
    private final String email;
    private final Integer roleId;
    private final RoleName roleName;
}