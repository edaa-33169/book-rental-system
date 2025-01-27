package com.bookrental.book_rental.service;

import com.bookrental.book_rental.entity.Author;
import com.bookrental.book_rental.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Yeni bir yazar ekle
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Tüm yazarları getir
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Belirli bir yazarı getir
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yazar bulunamadı!"));
    }

    // Yazarı sil
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
