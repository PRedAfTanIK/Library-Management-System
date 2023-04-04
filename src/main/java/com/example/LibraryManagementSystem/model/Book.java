package com.example.LibraryManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;
    @Column(name = "author id")
    private int authorId;
    @Column(name = "copies sold")
    private int copiesSold;
    @Column(name = "rating")
    private double rating;
    @Column(name = "base language")
    private String baseLanguage;

}
