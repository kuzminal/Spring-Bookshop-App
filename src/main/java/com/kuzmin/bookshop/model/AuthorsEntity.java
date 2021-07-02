package com.kuzmin.bookshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class AuthorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BookEntity> books = null;

    public AuthorsEntity id(Long id) {
        this.id = id;
        return this;
    }

}
