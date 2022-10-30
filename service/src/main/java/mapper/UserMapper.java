package by.itbootcamp.testtaskwithoutmodules.service.mapper;

import by.itbootcamp.testtaskwithoutmodules.repository.User;
import by.itbootcamp.testtaskwithoutmodules.service.dto.UserDto;
import org.mapstruct.*;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-28 14:21
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
