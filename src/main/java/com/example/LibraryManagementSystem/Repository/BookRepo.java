package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
    boolean existsByName(String name);

    Book findByName(String name);

    List<Book> findAllByGenre(String genre);
}
