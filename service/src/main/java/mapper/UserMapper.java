package mapper;


import dto.UserDto;
import entities.User;
import org.mapstruct.*;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-28 14:21
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "roleName", target = "role.name")
    User userDtoToUser(UserDto userDto);

    @InheritInverseConfiguration(name = "userDtoToUser")
    UserDto userToUserDto(User user);

}
