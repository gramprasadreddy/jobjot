package com.ram.jobjot.jobjot.service;

import com.ram.jobjot.jobjot.entity.JobListing;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobListingService {

    private final List<JobListing> jobListings;

    public JobListingService() {
        this.jobListings = loadJobListings();
    }

    private List<JobListing> loadJobListings() {
        List<JobListing> listings = new ArrayList<>();

        listings.add(new JobListing("Lead Software Developer",
                "Are you a strategic thinker and hands-on technical expert with a passion for innovation?...",
                "https://www.adzuna.co.uk/jobs/land/ad/4930513132?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=D54FB27F23527D2EC00DE4A50D6EA3B3E7B7E7B7",
                85000));

        listings.add(new JobListing("Lead Software Developer",
                "Are you a strategic thinker and hands-on technical expert with a passion for innovation?...",
                "https://www.adzuna.co.uk/jobs/land/ad/4930513132?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=D54FB27F23527D2EC00DE4A50D6EA3B3E7B7E7B7",
                85000));

        listings.add(new JobListing("Middleweight Software Developer",
                "This is an exciting opportunity to join a dynamic and innovative team supporting the full range of the RSPB's developer work...",
                "https://www.adzuna.co.uk/jobs/land/ad/4927458763?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=2068733C83EF27EE64B7B3305832F5BB647929A1",
                40000));

        listings.add(new JobListing("Middleweight Software Developer",
                "This is an exciting opportunity to join a dynamic and innovative team supporting the full range of the RSPB's developer work...",
                "https://www.adzuna.co.uk/jobs/land/ad/4927458712?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=45AA5612614AAECEC479AEC5F03081F5C4F7EBC8",
                40000));


        listings.add(new JobListing("Software Developer",
                "Parallel is a fast-paced scale up with the backing of parent company Sewell Group...",
                "https://www.adzuna.co.uk/jobs/details/4836908348?utm_medium=api&utm_source=7fe05f60",
                40000));

        listings.add(new JobListing("Software Developer",
                "Our talented Product Development and Assurance Team is responsible for researching new and innovative technologies...",
                "https://www.adzuna.co.uk/jobs/details/4888941042?utm_medium=api&utm_source=7fe05f60",
                40777));

        listings.add(new JobListing("Software Developer",
                "LMAX is renowned for its high-performance, ultra-low latency exchange written in core Java...",
                "https://www.adzuna.co.uk/jobs/details/4726836124?utm_medium=api&utm_source=7fe05f60",
                62446));

        listings.add(new JobListing("Software Developer",
                "Build the future of e-commerce with a brand on a huge journey...",
                "https://www.adzuna.co.uk/jobs/land/ad/4928668276?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=ABB789E2E31B7C51C37FA1F0F3AAAD99DE52208D",
                46186));

        listings.add(new JobListing("Software Developer",
                "Are you a passionate technologist eager to tackle complex problems in a fast-paced environment?",
                "https://www.adzuna.co.uk/jobs/land/ad/4921137224?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=7DAFA562B561B6F0936E022DA12D5E7B93FB2D1E",
                70740));

        listings.add(new JobListing("Software Developer",
                "The successful candidate will work alongside world-class investment, research, and quantitative professionals...",
                "https://www.adzuna.co.uk/jobs/land/ad/4929397594?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=39E5412C7CD0B946D04824439B313C31415486C3",
                62551));

        listings.add(new JobListing("Software Developer",
                "At Point of Rental Software, we revolutionize the rental industry...",
                "https://www.adzuna.co.uk/jobs/land/ad/4885058506?se=Erus7Raf7xGOrF0hyYj2Ow&utm_medium=api&utm_source=7fe05f60&v=158C0D5BCFB962CCFEFF7C4C880CE6060BDA33DA",
                59936));


        return listings;
    }

    public List<JobListing> fetchJobs() {
        return jobListings;
    }
}
