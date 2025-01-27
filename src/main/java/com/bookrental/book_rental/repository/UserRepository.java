package com.bookrental.book_rental.repository;

import com.bookrental.book_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Özel sorgular için burada metotlar tanımlayabiliriz
}
