package com.kuzmin.bookshop.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String isbn;

    @NotBlank
    private String annotation;

    private byte[] imageCover;

    @ManyToOne
    private GenreEntity genre;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<AuthorsEntity> authors = null;

    private Double price;

    private Integer count;

    public BookEntity id(String id) {
        this.id = id;
        return this;
    }
}
