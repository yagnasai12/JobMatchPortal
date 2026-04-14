package com.jobmatch.portal.service;

import com.jobmatch.portal.dto.JobMatchResponse;
import com.jobmatch.portal.model.Job;
import com.jobmatch.portal.model.Resume;
import com.jobmatch.portal.repository.JobRepository;
import com.jobmatch.portal.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchingService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    public List<JobMatchResponse> matchJobs(Long resumeId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        String resumeText = resume.getExtractedText().toLowerCase();

        List<Job> jobs = jobRepository.findAll();
        List<JobMatchResponse> result = new ArrayList<>();

        for (Job job : jobs) {

            String[] skills = job.getSkills().toLowerCase().split(",");

            int matchCount = 0;

            for (String skill : skills) {
                skill = skill.trim();

                if (resumeText.contains(skill)) {
                    matchCount++;
                }
            }

            int score = (int) (((double) matchCount / skills.length) * 100);

            result.add(new JobMatchResponse(job, score));
        }

        return result;
    }
}