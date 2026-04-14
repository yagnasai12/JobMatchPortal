package com.jobmatch.portal.controller;

import com.jobmatch.portal.model.Resume;
import com.jobmatch.portal.repository.ResumeRepository;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeRepository resumeRepository;

    @PostMapping("/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file) {
        try {

            // create folder
            String uploadDir = "uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // save file
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(uploadDir + fileName);
            Files.write(path, file.getBytes());

            // extract text using Tika
            Tika tika = new Tika();
            String extractedText = tika.parseToString(file.getInputStream());

            // save to DB
            Resume resume = new Resume();
            resume.setFilePath(path.toString());
            resume.setExtractedText(extractedText);

            resumeRepository.save(resume);

            return "Resume uploaded successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error uploading file: " + e.getMessage();
        }
    }
}