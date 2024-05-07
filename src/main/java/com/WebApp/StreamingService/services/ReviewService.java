package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    Review saveReview(Review review);
    Review updateReview(Review review);
    void deleteReviewById(Long id);
    void deleteAllReviews();
    Review getReviewById(Long id);
    List<Review> getAllReviews();
}
