package com.example.LibraryManagementSystem.Author;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepository authorRepository = new AuthorRepository();

    public String addAuthor(Author author){
        if(author.getId()<0) return "Please enter a valid author Id";
        if(authorRepository.addAuthor(author)) return "Author Added Successfully";
        return "Author Already Exists!!";
    }

    public Author getAuthor(int id){
        return authorRepository.getAuthor(id);
    }
    public Author getAuthor(String name){
        return authorRepository.getAuthor(name);
    }
    public List<Author> getAllAuthors(){
        return authorRepository.getAllAuthors();
    }
    public List<List<String>> getAllRatings(){
        return authorRepository.getAllRatings();
    }
    public boolean updateBookCountForAuthor(int id){
        if(authorRepository.updateCountOfAuthor(id)) return true;
        return false;
    }
    public boolean updateRatingOfAuthor(int id,double newRating){
        if(authorRepository.updateRatingOfAuthor(id,newRating)) return true;
        return false;
    }
}
