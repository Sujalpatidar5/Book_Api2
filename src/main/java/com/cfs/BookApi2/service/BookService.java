package com.cfs.BookApi2.service;

import java.util.*;
import com.cfs.BookApi2.entity.Book;
import com.cfs.BookApi2.exception.BookNotFoundException;
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
    public Book getBookById (Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Book Not Found with id : " + id));
    }

    //4 Update book
    public Book updateBook (Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Book not found with id : " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());

        return bookRepository.save(existingBook);
    }

    //5 Delete Book
    public void deleteBook (Long id) {
       Book book = bookRepository.findById(id).orElseThrow(() ->
               new BookNotFoundException("Book not found with id : " + id));

       bookRepository.delete(book);
    }
}
