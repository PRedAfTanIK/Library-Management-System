package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
    Author findByName(String name);

    boolean existsByName(String name);

    Author findById(int authorId);
}
