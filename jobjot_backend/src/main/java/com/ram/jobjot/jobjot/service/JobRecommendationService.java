package com.ram.jobjot.jobjot.service;
import com.ram.jobjot.jobjot.entity.JobListing;
import com.ram.jobjot.jobjot.entity.JobRecommendation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobRecommendationService {

    private final JobListingService jobListingService;

    @Autowired
    public JobRecommendationService(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    public List<JobRecommendation> getRecommendations(MultipartFile file) throws IOException {
        String resumeText = extractTextFromPDF(file);

        Set<String> resumeKeywords = extractKeywords(resumeText);

        List<JobListing> jobListings = jobListingService.fetchJobs();

        return findTopMatchingJobs(resumeKeywords, jobListings);
    }

    private String extractTextFromPDF(MultipartFile file) throws IOException {
        PDDocument document = PDDocument.load(file.getInputStream());
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();
        return text;
    }

    private Set<String> extractKeywords(String text) {
        Set<String> keywords = new HashSet<>(Arrays.asList(text.toLowerCase().split("\\W+")));
        keywords.removeAll(List.of("and", "the", "to", "a", "in", "for", "with", "on", "of"));
        return keywords;
    }

    private List<JobRecommendation> findTopMatchingJobs(Set<String> resumeKeywords, List<JobListing> jobListings) {
        List<JobRecommendation> recommendations = new ArrayList<>();

        for (JobListing job : jobListings) {
            double score = calculateRelevanceScore(resumeKeywords, job);
            recommendations.add(new JobRecommendation(job.getTitle(), job.getDescription(), job.getRedirectUrl(), score));
        }

        return recommendations.stream()
                .sorted(Comparator.comparing(JobRecommendation::getRelevanceScore).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    private double calculateRelevanceScore(Set<String> resumeKeywords, JobListing job) {
        Set<String> jobKeywords = new HashSet<>(Arrays.asList(job.getDescription().toLowerCase().split("\\W+")));
        jobKeywords.addAll(Arrays.asList(job.getTitle().toLowerCase().split("\\W+")));

        jobKeywords.retainAll(resumeKeywords);
        return (double) jobKeywords.size() / resumeKeywords.size();
    }
}
