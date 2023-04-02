package com.example.LibraryManagementSystem.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository = new BookRepository();
    @Autowired
    BookRepo bookRepo;
    public String addBook(Book book){
//        if(bookRepository.addBook(book)) return "Book Added Successfully";
//        return "Book Already Exists";
        bookRepo.save(book);
        return "Book Added Successfully";
    }
    public List<Book> getAllBooks(){
//        return bookRepository.getAllBooks();
        return bookRepo.findAll();
    }
    public Book getBook(int id){
        return bookRepo.findById(id).orElse(null);
    }
    public Book getBook(String name){
        return bookRepository.getBook(name);
    }
    public List<Book> getBooksByGenre(String genre){
        return bookRepository.getBooksByGenre(genre);
    }
    public String updateCopiesSold(int id,int sold){
        Book book = bookRepo.findById(id).orElse(null);
        if(book.equals(null)) return "Book Doesn't Exist";
        book.setCopiesSold(book.getCopiesSold()+sold);
        bookRepo.save(book);
        return "Updated Sold Count";
    }
    public String updateCopiesSold(String name,int sold){
        Book book = getBook(name);
        if(book == null) return "Book Doesn't Exist";
        return updateCopiesSold(book.getId(),sold);
    }
    public String addLanguageToBook(Integer id,String language){
//        if(getBook(id) == null) return "Book doesn't exist";
//        if(bookRepository.addBaseLanguage(id,language)) return "Added Base Language";
//        return "Base Language already present";
        Book book = bookRepo.findById(id).orElse(null);
        if(book.equals(null)) return "Book Doesn't Exist";
        if(book.getBaseLanguage().length()!=0) return "Base Language Present";
        book.setBaseLanguage(language);
        bookRepo.save(book);
        return "Book Base Language Changed";
    }
    public String addLanguageToBook(String name,String language){
        if(getBook(name) == null) return "Book doesn't exist";
        return addLanguageToBook(getBook(name).getId(),language);
    }
}
