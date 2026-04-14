package com.jobmatch.portal.dto;

import com.jobmatch.portal.model.Job;

public class JobMatchResponse {

    private Job job;
    private int matchScore;

    public JobMatchResponse(Job job, int matchScore) {
        this.job = job;
        this.matchScore = matchScore;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }
}