package interfaces;


import dto.UserDto;
import org.springframework.data.domain.Page;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-28 14:11
 */
public interface UserService {

    UserDto addUser(UserDto user);

    Page<UserDto> findAll();

}
