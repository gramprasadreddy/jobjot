
package com.ram.jobjot.jobjot.controller;

import com.ram.jobjot.jobjot.entity.Job;
import com.ram.jobjot.jobjot.service.JobScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobScraperService jobScraperService;

    @GetMapping("/api/jobs")
    public List<Job> getJobs(@RequestParam String url) throws IOException {
        return jobScraperService.scrapeJobs(url);
    }
}
