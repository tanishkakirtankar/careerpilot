package com.careerpilot.controller;

import com.careerpilot.dto.UserResponse;
import com.careerpilot.entity.User;
import com.careerpilot.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElse(null);

        if (user == null) {
            return null;
        }

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole());
    }
}