package com.example.LibraryManagementSystem.Book;

import com.example.LibraryManagementSystem.Author.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {
    HashMap<Integer,Book> database = new HashMap<>();

    public boolean addBook(Book book){
        if(database.containsKey(book.getId())) return false;
        database.put(book.getId(), book);
        return true;
    }
    public List<Book> getAllBooks(){
        List<Book> ret = new ArrayList<>();
        for(Book book:database.values())
            ret.add(book);
        return ret;
    }
    public Book getBook(int id){
        if(!database.containsKey(id)) return null;
        return database.get(id);
    }
    public Book getBook(String name){
        for(Book book:database.values())
            if(book.getName().equals(name))
                return book;
        return null;
    }
    public List<Book> getBooksByGenre(String genre){
        List<Book> ret = new ArrayList<>();
        for(Book book: database.values())
            if(book.getGenre().equals(genre))
                ret.add(book);
        return ret;
    }
}
