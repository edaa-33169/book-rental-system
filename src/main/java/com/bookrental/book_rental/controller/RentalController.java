package com.bookrental.book_rental.controller;

import com.bookrental.book_rental.entity.Rental;
import com.bookrental.book_rental.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    // Tüm kiralamaları getir
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    // Yeni kiralama oluştur
    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        Rental newRental = rentalService.createRental(rental);
        return new ResponseEntity<>(newRental, HttpStatus.CREATED);
    }

    // Belirli bir kiralamayı getir
    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        Rental rental = rentalService.getRentalById(id);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    // Kiralamayı sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

