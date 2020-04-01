package com.Msa.contentmanagementsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "news")
public class News {

    @Id
    private String id;

    private String title;

    private String content;

    private User author;

    private Set<User> mandatoryReviewers = new HashSet<>();

    private Set<Review> reviewers = new HashSet<>();

    private  Set<Category> categories = new HashSet<>();

    private Set<Tag> tags = new HashSet<>();

    public Review review(String userId, String status) {
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }

    public Boolean revised() {
        return this.mandatoryReviewers.stream().allMatch(
                reviewer -> this.reviewers.stream().anyMatch(
                        review -> reviewer.getIdentity().equals(review.userId) && "approved".equals(review.status)
                )
        );
    }

}
