package com.prgrms.board.controller;

import com.prgrms.board.dto.user.UserCreateRequest;
import com.prgrms.board.dto.user.UserFindRequest;
import com.prgrms.board.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Long> addUser(final @Valid @RequestBody UserCreateRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<UserFindRequest> getUser(final @RequestParam Long userId) {
        return ResponseEntity.ok(userService.findUser(userId));
    }

    @PutMapping
    public ResponseEntity<Long> modifyUser(final @RequestParam Long userId, final @Valid @RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(userService.modifyUser(userId, userCreateRequest));
    }

    @DeleteMapping
    public ResponseEntity<Long> removeUser(final @RequestParam Long userId) {
        return ResponseEntity.ok(userService.removeUser(userId));
    }

}
