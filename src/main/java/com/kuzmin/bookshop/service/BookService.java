package com.kuzmin.bookshop.service;

import com.kuzmin.bookshop.model.Book;
import com.kuzmin.bookshop.model.BookEntity;
import com.kuzmin.bookshop.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBooks() {
        List<BookEntity> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
}
