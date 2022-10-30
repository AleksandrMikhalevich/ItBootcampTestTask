package impl;


import dto.UserDto;
import interfaces.UserService;
import lombok.RequiredArgsConstructor;
import mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repo.UserRepository;


/**
 * @author Alex Mikhalevich
 * @created 2022-10-28 14:12
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto addUser(UserDto user) {
        userRepository.save(userMapper.userDtoToUser(user));
        return user;
    }

    @Override
    public Page<UserDto> findAll() {
        Pageable paged = PageRequest.of(0, 10, Sort.by("email"));
        return userRepository.findAll(paged).map(userMapper::userToUserDto);
    }
}
