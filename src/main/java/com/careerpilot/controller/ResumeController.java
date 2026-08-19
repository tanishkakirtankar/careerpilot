package com.careerpilot.controller;

import com.careerpilot.entity.Resume;
import com.careerpilot.repository.ResumeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

  private final ResumeRepository resumeRepository;

  public ResumeController(ResumeRepository resumeRepository) {
    this.resumeRepository = resumeRepository;
  }

  @PostMapping
  public Resume createResume(@RequestBody Resume resume) {

    return resumeRepository.save(resume);
  }

  @GetMapping("/{id}")
  public Resume getResume(@PathVariable Long id) {

    return resumeRepository.findById(id)
        .orElse(null);
  }
}