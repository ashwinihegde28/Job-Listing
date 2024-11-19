package com.example.springBootWithMongo.repo;

import com.example.springBootWithMongo.model.JobPost;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobPostRepo extends MongoRepository<JobPost,Integer> {
    List<JobPost> findByExperienceContainingIgnoreCase(String experience, Sort sort);
    List<JobPost> findByProfileContainingIgnoreCase(String profile, Sort sort);
    List<JobPost> findByTechnologiesContainingIgnoreCase(String technologies);
    List<JobPost> findByDescriptionContainingIgnoreCase(String description);
    //custom queries
    @Query("{ 'profile' : { $regex: ?0, $options: 'i' } }")
    List<JobPost> findByProfileRegex(String profile);



}
