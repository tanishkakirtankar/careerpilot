package com.careerpilot.controller;

import com.careerpilot.entity.Application;
import com.careerpilot.repository.ApplicationRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

  private final ApplicationRepository applicationRepository;

  public ApplicationController(ApplicationRepository applicationRepository) {
    this.applicationRepository = applicationRepository;
  }

  @PostMapping
  public Application apply(@RequestBody Application application) {

    application.setStatus("APPLIED");
    application.setAppliedAt(LocalDateTime.now());

    return applicationRepository.save(application);
  }

  @GetMapping("/user/{userId}")
  public List<Application> getUserApplications(
      @PathVariable Long userId) {

    return applicationRepository.findByUserId(userId);
  }
}