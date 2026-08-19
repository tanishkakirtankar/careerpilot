package com.careerpilot.controller;

import com.careerpilot.entity.Job;
import com.careerpilot.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

  private final JobRepository jobRepository;

  public JobController(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @PostMapping
  public Job createJob(@RequestBody Job job) {
    return jobRepository.save(job);
  }

  @GetMapping
  public List<Job> getAllJobs() {
    return jobRepository.findAll();
  }

  @GetMapping("/{id}")
  public Job getJob(@PathVariable Long id) {
    return jobRepository.findById(id)
        .orElse(null);
  }
}