package com.example.LibraryManagementSystem.Author;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class AuthorRepository {
    HashMap<Integer,Author> database = new HashMap<>();

    public boolean addAuthor(Author author){
        if(database.containsKey(author.getId()))
            return false;
        database.put(author.getId(),author);
        return true;
    }
    public Author getAuthor(int id){
        if(!database.containsKey(id)) return null;
        return database.get(id);
    }
    public Author getAuthor(String name){
        for(Author author:database.values())
            if(author.getName().equals(name))
                return author;
        return null;
    }
    public List<Author> getAllAuthors(){
        List<Author> ret = new ArrayList<>();
        for(Author author:database.values())
            ret.add(author);
        return  ret;
    }
    public List<List<String>> getAllRatings(){
        List<List<String>> ret = new ArrayList<>();
        for(Author author:database.values())
            ret.add(Arrays.asList(author.getName(),String.valueOf(author.getRating())));

        return ret;
    }
    public boolean updateCountOfAuthor(int id){
        if(!database.containsKey(id)) return false;
        Author author = database.get(id);
        author.setNumberOfBooks(author.getNumberOfBooks()+1);
        return true;
    }
    public boolean updateRatingOfAuthor(int id,double rating){
        if(!database.containsKey(id)) return false;
        Author author = database.get(id);
        if(author.getNumberOfBooks() == 1)
            author.setRating(rating);
        else{
            double newRating = (author.getRating()* (author.getNumberOfBooks()-1) + rating)
                    /(author.getNumberOfBooks()*1.0);
            author.setRating(newRating);
        }
        return true;
    }
}
