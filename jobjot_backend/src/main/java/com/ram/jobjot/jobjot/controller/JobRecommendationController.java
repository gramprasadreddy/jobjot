package com.ram.jobjot.jobjot.controller;
import com.ram.jobjot.jobjot.entity.JobRecommendation;
import com.ram.jobjot.jobjot.service.JobRecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobRecommendationController {
    private static final Logger logger = LoggerFactory.getLogger(JobRecommendationController.class);
    private final JobRecommendationService jobRecommendationService;

    @Autowired
    public JobRecommendationController(JobRecommendationService jobRecommendationService) {
        this.jobRecommendationService = jobRecommendationService;
    }


    @PostMapping("/upload-resume")
    public ResponseEntity<?> uploadResume(@RequestParam(value = "resume", required = false) MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                logger.warn("File part is null or empty.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("File part 'file' is missing or empty in the request.");
            }
            logger.info("File received: {}", file.getOriginalFilename());
            List<JobRecommendation> recommendations = jobRecommendationService.getRecommendations(file);
            return ResponseEntity.ok(recommendations);
        } catch (IOException e) {
            logger.error("Error processing file upload", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during file upload.");
        }
    }
}
