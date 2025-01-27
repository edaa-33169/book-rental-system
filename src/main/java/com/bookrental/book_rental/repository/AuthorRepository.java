package com.bookrental.book_rental.repository;

import com.bookrental.book_rental.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Özel sorgular gerekiyorsa burada tanımlayabilirsin
}
