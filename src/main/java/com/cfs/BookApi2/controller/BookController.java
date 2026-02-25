package com.cfs.BookApi2.controller;

import java.util.*;
import com.cfs.BookApi2.entity.Book;
import com.cfs.BookApi2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//controller ka kaam hai http request lena, service call krna , response return krna
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    //now add endpoints
    //1 add boook
    @PostMapping
    public ResponseEntity<Book> addBook (@RequestBody Book book) {
        Book saved = bookService.addBook(book);
        return ResponseEntity.status(201).body(saved);
    }

    //2 get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks () {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    //3 get book by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById (@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();
    }

    //4 update book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updated = bookService.updateBook(id, book);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //5 delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoook (@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
