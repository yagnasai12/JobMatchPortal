package com.jobmatch.portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String description;

    private String skills;
}