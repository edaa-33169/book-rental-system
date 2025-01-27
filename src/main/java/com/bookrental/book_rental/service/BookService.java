package com.bookrental.book_rental.service;

import com.bookrental.book_rental.entity.Book;
import com.bookrental.book_rental.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Yeni bir kitap ekle
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // ID'ye göre kitap getir
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Kitap bulunamadı!"));
    }

    // Kitap sil
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
