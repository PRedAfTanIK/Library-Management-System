package com.example.LibraryManagementSystem.Book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository = new BookRepository();
    public String addBook(Book book){
        if(bookRepository.addBook(book)) return "Book Added Successfully";
        return "Book Already Exists";
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
    public Book getBook(int id){
        return bookRepository.getBook(id);
    }
    public Book getBook(String name){
        return bookRepository.getBook(name);
    }

    public List<Book> getBooksByGenre(String genre){
        return bookRepository.getBooksByGenre(genre);
    }
}
