package com.cfs.BookApi2.repo;

import com.cfs.BookApi2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {
}
