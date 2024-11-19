package com.example.springBootWithMongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "jobPost")
public class JobPost {
    @Id
    private Integer id;
    @Field("description")
    private String description;
    private String experience;
    private String profile;
    private List<String> technologies;
}
