package com.bookrental.book_rental.repository;

import com.bookrental.book_rental.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Ek sorgular gerekiyorsa burada tanımlanabilir.
}
