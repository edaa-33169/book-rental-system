package com.bookrental.book_rental.service;

import com.bookrental.book_rental.entity.Review;
import com.bookrental.book_rental.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Yeni bir yorum oluştur
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Tüm yorumları getir
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Belirli bir kitabın yorumlarını getir
    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    // Belirli bir kullanıcının yorumlarını getir
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    // Yorum sil
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
