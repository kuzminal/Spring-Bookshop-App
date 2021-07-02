package com.kuzmin.bookshop.controller;

import com.kuzmin.bookshop.ApiApi;
import com.kuzmin.bookshop.model.Book;
import com.kuzmin.bookshop.model.BookEntity;
import com.kuzmin.bookshop.model.Genre;
import com.kuzmin.bookshop.model.GenreEntity;
import com.kuzmin.bookshop.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class ApiController implements ApiApi {
    private final BookService bookService;

    public ApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        List<BookEntity> books = bookService.getAllBooks();
        return books.stream()
                .map(this::convertBookToDTO)
                .collect(Collectors.toList());
    }

    private Book convertBookToDTO(BookEntity bookEntity) {
        Book book = new Book();
        if (!Objects.isNull(bookEntity)) {
            book.setId(bookEntity.getId());
            book.setAnnotation(bookEntity.getAnnotation());
            book.setCount(bookEntity.getCount());
            book.setImageCover(bookEntity.getImageCover());
            book.setIsbn(bookEntity.getIsbn());
            book.setPrice(bookEntity.getPrice());
            book.setTitle(bookEntity.getTitle());
            book.setGenre(convertGenreToDTO(bookEntity.getGenre()));
        }
        return book;
    }

    private Genre convertGenreToDTO(GenreEntity genreEntity) {
        Genre genre = new Genre();
        if (!Objects.isNull(genreEntity)) {
            genre.setId(genreEntity.getId());
            genre.setName(genreEntity.getName());
        }
        return genre;
    }
}
