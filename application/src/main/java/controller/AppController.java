package controller;

import dto.UserDto;
import interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-28 14:56
 */
@RestController
@RequiredArgsConstructor
public class AppController {

    private static final Logger logger = LogManager.getLogger(AppController.class);

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Page<UserDto>> findAllUsers() {
        Page<UserDto> users = userService.findAll();
        if (users.isEmpty()) {
            logger.warn("Пользователи отсутствуют");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.info("Получение всех пользователей...");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        logger.info("Новый пользователь создан.");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
