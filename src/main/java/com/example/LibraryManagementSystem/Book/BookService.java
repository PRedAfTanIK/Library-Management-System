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
    public String updateCopiesSold(int id,int sold){
        if(bookRepository.updateCopiesSoldForBook(id,sold)) return "Updated Sold Count";
        return "Book Doesn't Exist";
    }
    public String updateCopiesSold(String name,int sold){
        Book book = getBook(name);
        if(book == null) return "Book Doesn't Exist";
        return updateCopiesSold(book.getId(),sold);
    }
    public String addLanguageToBook(Integer id,String language){
        if(getBook(id) == null) return "Book doesn't exist";
        if(bookRepository.addBaseLanguage(id,language)) return "Added Base Language";
        return "Base Language already present";
    }
    public String addLanguageToBook(String name,String language){
        if(getBook(name) == null) return "Book doesn't exist";
        return addLanguageToBook(getBook(name).getId(),language);
    }
}
