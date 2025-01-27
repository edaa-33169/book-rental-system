package com.bookrental.book_rental.service;

import com.bookrental.book_rental.entity.Book;
import com.bookrental.book_rental.entity.Rental;
import com.bookrental.book_rental.repository.RentalRepository;
import com.bookrental.book_rental.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;

    public RentalService(RentalRepository rentalRepository, BookRepository bookRepository) {
        this.rentalRepository = rentalRepository;
        this.bookRepository = bookRepository;
    }

    // Tüm kiralamaları getir
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    // Yeni kiralama oluştur
    public Rental createRental(Rental rental) {
        // Kitabın uygun olup olmadığını kontrol et
        Book book = rental.getBook();
        if (!book.isAvailable()) {
            throw new RuntimeException("Bu kitap şu anda kiralanamaz!");
        }

        // Kitabın durumunu 'kiralanmış' olarak güncelle
        book.setAvailable(false);
        bookRepository.save(book);

        return rentalRepository.save(rental);
    }

    // Kiralamayı ID'ye göre getir
    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kiralama bulunamadı!"));
    }

    // Kiralamayı sil ve kitabı tekrar kullanılabilir yap
    public void deleteRental(Long id) {
        Rental rental = getRentalById(id);
        Book book = rental.getBook();

        // Kitabı tekrar 'uygun' olarak işaretle
        book.setAvailable(true);
        bookRepository.save(book);

        rentalRepository.deleteById(id);
    }
}
