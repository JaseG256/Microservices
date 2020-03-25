package com.Msa.contentmanagementsystem.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String title;

    private String content;

    @ManyToOne
    private User author;

    @OneToMany
    private Set<User> mandatoryReviewers = new HashSet<>();

    @ElementCollection
    private Set<Review> reviewers = new HashSet<>();

    @ManyToOne
    private  Set<Category> categories = new HashSet<>();

    @ElementCollection
    private Set<Tag> tags = new HashSet<>();

    public Review review(String userId, String status) {
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }

    public Boolean revised() {
        return this.mandatoryReviewers.stream().allMatch(
                reviewer -> this.reviewers.stream().anyMatch(
                        review -> reviewer.id.equals(review.userId) && "approved".equals(review.status)
                )
        );
    }

}
