package com.jobmatch.portal.controller;

import com.jobmatch.portal.model.Job;
import com.jobmatch.portal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/add")
    public Job addJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}