package com.cfs.BookApi2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;       //validation - glt data ko system me jane se rokta h

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    public Book () {    //no argument / default constructor h - spring ko object banane k liye chahiye
    }

    public Book(Long id, String title, String author, Double price) {       // all- args constructor (manual object creation k liye) - jab object bnate waqt sari values sari values ek sath deni ho
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}



