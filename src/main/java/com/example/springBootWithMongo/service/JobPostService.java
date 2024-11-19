package com.example.springBootWithMongo.service;

import com.example.springBootWithMongo.model.JobPost;
import com.example.springBootWithMongo.repo.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {

    private JobPostRepo jobPostRepo;

    @Autowired
      public JobPostService(JobPostRepo jobPostRepo) {
        this.jobPostRepo = jobPostRepo;
    }

    public List<JobPost> getAllJobPost(){
        return jobPostRepo.findAll();
    }

    public Optional<JobPost> getJobPostById(int id){
        return jobPostRepo.findById(id);
    }

    public List<JobPost>getJobsByExperince(String experience){
        return jobPostRepo.findByExperienceContainingIgnoreCase(experience,Sort.by(Sort.Order.asc("experience")));
    }

    public List<JobPost>getJobsByTechnologies(String technologies){
        return jobPostRepo.findByTechnologiesContainingIgnoreCase(technologies);
    }
    public List<JobPost>getJobsByProfile(String profile){
        return jobPostRepo.findByProfileContainingIgnoreCase(profile, Sort.by(Sort.Order.asc("profile")));
    }

    public List<JobPost> getJobsByDescription(String description){
        return jobPostRepo.findByDescriptionContainingIgnoreCase(description);
    }

    public List<JobPost> findJobsWithProfileMatch(String profile) {
        return jobPostRepo.findByProfileRegex(profile);
    }

}
