package com.ram.jobjot.jobjot.service;

import com.ram.jobjot.jobjot.entity.Job;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobScraperService {

    public List<Job> scrapeJobs(String url) {
        List<Job> jobList = new ArrayList<>();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get(url);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            int jobsFetched = 0;
            int maxJobs = 30;

            while (jobsFetched < maxJobs) {
                // Wait until job elements are visible
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job_seen_beacon")));
                List<WebElement> jobElements = driver.findElements(By.cssSelector(".job_seen_beacon"));

                for (int i = 0; i < jobElements.size() && jobsFetched < maxJobs; i++) {
                    WebElement jobElement = jobElements.get(i);
                    Job job = new Job();

                    // Extract job title and link
                    WebElement titleElement = jobElement.findElement(By.cssSelector(".jcs-JobTitle"));
                    job.setTitle(titleElement.getText());
                    job.setJobLink(titleElement.getAttribute("href"));

                    // Click to view job details
                    titleElement.click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".jobsearch-JobComponent-description")));

                    // Extract job description
                    job.setDescription(driver.findElement(By.cssSelector(".jobsearch-JobComponent-description")).getText());

                    // Extract company name and location
                    try {
                        WebElement companyElement = driver.findElement(By.cssSelector("[data-testid='company-name']"));
                        job.setCompany(companyElement.getText());
                    } catch (Exception e) {
                        job.setCompany("N/A");
                    }

                    try {
                        WebElement locationElement = driver.findElement(By.cssSelector("[data-testid='job-location']"));
                        job.setLocation(locationElement.getText());
                    } catch (Exception e) {
                        job.setLocation("N/A");
                    }

                    jobList.add(job);
                    jobsFetched++;

                    // Navigate back to the job list page
                    driver.navigate().back();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job_seen_beacon")));

                    // Refresh job elements after returning
                    jobElements = driver.findElements(By.cssSelector(".job_seen_beacon"));
                }

                // Check for "Next Page" link, wait until clickable, and click if available
                try {
                    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-testid='pagination-page-next']")));
                    Thread.sleep(2000); // Small delay to stabilize navigation
                    nextButton.click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job_seen_beacon")));
                } catch (Exception e) {
                    System.out.println("No more pages available.");
                    break; // Exit loop if no "Next Page" button is found
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

        return jobList;
    }
}
