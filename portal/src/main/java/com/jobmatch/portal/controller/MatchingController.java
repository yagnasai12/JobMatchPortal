package com.jobmatch.portal.controller;

import com.jobmatch.portal.dto.JobMatchResponse;
import com.jobmatch.portal.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchingController {

    @Autowired
    private MatchingService matchingService;

    @GetMapping("/{resumeId}")
    public List<JobMatchResponse> match(@PathVariable Long resumeId) {
        return matchingService.matchJobs(resumeId);
    }
}