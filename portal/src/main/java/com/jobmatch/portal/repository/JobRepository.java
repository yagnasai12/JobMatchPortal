package com.jobmatch.portal.repository;

import com.jobmatch.portal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}