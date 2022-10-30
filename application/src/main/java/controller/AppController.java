package app.controller;

import dto.UserDto;
import interfaces.UserService;
import lombok.RequiredArgsConstructor;
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

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Page<UserDto>> findAllUsers() {
        try {
            Page<UserDto> users = userService.findAll();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        try {
            UserDto user = userService.addUser(userDto);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
