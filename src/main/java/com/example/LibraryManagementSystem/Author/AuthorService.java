package com.example.LibraryManagementSystem.Author;

import com.example.LibraryManagementSystem.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {
    AuthorRepository authorRepository = new AuthorRepository();
    @Autowired
    AuthorRepo authorRepo;

    public String addAuthor(Author author){
        if(author.getId()<0) return "Please enter a valid author Id";
//        if(authorRepository.addAuthor(author)) return "Author Added Successfully";
        authorRepo.save(author);
        return "Author Already Exists!!";
    }

    public Author getAuthor(int id){
        //return authorRepository.getAuthor(id);
        return authorRepo.findById(id).orElse(null);
    }
    public Author getAuthor(String name){
        return authorRepository.getAuthor(name);
    }
    public List<Author> getAllAuthors(){
        //return authorRepository.getAllAuthors();
        return authorRepo.findAll();
    }
    public List<List<String>> getAllRatings(){
        //return authorRepository.getAllRatings();
        List<Author> list = getAllAuthors();
        List<List<String>> ret = new ArrayList<>();
        for(Author author:list)
            ret.add(Arrays.asList(author.getName(),String.valueOf(author.getRating())));

        return ret;
    }
    public boolean updateBookCountForAuthor(int id){
//        if(authorRepository.updateCountOfAuthor(id)) return true;
//        return false;
        Author author = authorRepo.findById(id).orElse(null);
        if(author.equals(null)) return false;
        author.setNumberOfBooks(author.getNumberOfBooks()+1);
        return true;
    }
    public boolean updateRatingOfAuthor(int id,double newRating){
        if(authorRepository.updateRatingOfAuthor(id,newRating)) return true;
        return false;
    }
}
