package com.careerpilot.controller;

import com.careerpilot.entity.User;
import com.careerpilot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthController(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/register")
  public String register(@RequestBody User user) {

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    userRepository.save(user);

    return "User registered successfully!";
  }

  @PostMapping("/login")
  public String login(@RequestBody User user) {

    User existingUser = userRepository.findByEmail(user.getEmail())
        .orElse(null);

    if (existingUser == null) {
      return "User not found";
    }

    if (!passwordEncoder.matches(
        user.getPassword(),
        existingUser.getPassword())) {

      return "Invalid password";
    }

    return "Login successful!";
  }
}