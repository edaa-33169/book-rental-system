package com.bookrental.book_rental.repository;

import com.bookrental.book_rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // Özel sorgular gerekiyorsa burada ekleyebilirsin
}
