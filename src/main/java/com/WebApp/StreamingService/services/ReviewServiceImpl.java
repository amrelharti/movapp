package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Review;
import com.WebApp.StreamingService.repositories.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepo reviewRepo;
    @Override
    public Review saveReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public void deleteAllReviews() {
        reviewRepo.deleteAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }
}
