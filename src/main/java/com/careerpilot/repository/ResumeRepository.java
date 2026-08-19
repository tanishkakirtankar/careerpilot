package com.careerpilot.repository;

import com.careerpilot.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}