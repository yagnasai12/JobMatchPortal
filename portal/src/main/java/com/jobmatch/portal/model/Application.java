package com.jobmatch.portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long jobId;

    private String status;
}