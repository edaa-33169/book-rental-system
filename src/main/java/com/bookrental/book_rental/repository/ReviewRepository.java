package com.bookrental.book_rental.repository;

import com.bookrental.book_rental.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Belirli bir kitabın tüm yorumlarını getir
    List<Review> findByBookId(Long bookId);

    // Belirli bir kullanıcının yaptığı tüm yorumları getir
    List<Review> findByUserId(Long userId);
}
