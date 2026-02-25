package com.cfs.BookApi2.service;

import java.util.*;
import com.cfs.BookApi2.entity.Book;
import com.cfs.BookApi2.repo.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    //constructor injection - book repo inject hui
    public BookService (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Methods
    //1 Add book
    public Book addBook (Book book) {
        return bookRepository.save(book);
    }

    //2 Get all books
    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }

    //3 Get book by id
    public Optional<Book> getBookById (Long id) {
        return bookRepository.findById(id);
    }

    //4 Update book
    public Book updateBook (Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    //5 Delete Book
    public boolean deleteBook (Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
