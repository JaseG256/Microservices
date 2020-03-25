package com.Msa.contentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Review {

    String userId;
    String status;

    public Review() { }

    public Review(String userId, String status) {
        this.userId = userId;
        this.status = status;
    }

}