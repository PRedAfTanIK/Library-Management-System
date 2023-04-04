package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Repository.AuthorRepo;
import com.example.LibraryManagementSystem.Repository.BookRepo;
import com.example.LibraryManagementSystem.model.Author;
import com.example.LibraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired

    private BookRepo bookRepo;
//    @Autowired
//    public void setAuthorRepo(AuthorRepo authorRepo){
//        this.authorRepo = authorRepo;
//    }
//    @Autowired
//    public void setBookRepo(BookRepo bookRepo){
//        this.bookRepo = bookRepo;
//    }

    /*Author related functions*/

    public String addAuthor(Author author){
        if(authorRepo.existsById(author.getId())) return DataClass.ReturnMessages.ITEM_EXISTS;
        authorRepo.save(author);
        return DataClass.Fields.AUTHOR+DataClass.ReturnMessages.ADD_SUCCESS;
    }

    public Author getAuthor(int id){
        return authorRepo.findById(id);
    }
    public Author getAuthor(String name){
        if(!authorRepo.existsByName(name)) return null;
        return authorRepo.findByName(name);
    }
    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }
    public List<List<String>> getAllRatings(){
        List<Author> authorList = getAllAuthors();
        List<List<String>> returnList = new ArrayList<>();
        for(Author author:authorList)
            returnList.add(Arrays.asList(author.getName(),author.getRating()+""));

        return returnList;
    }
    public String updateBookCountForAuthor(int id,int newBooksAdded){
        if(!authorRepo.existsById(id)) return DataClass.ReturnMessages.ITEM_DOESNT_EXIST;
        Author author = authorRepo.findById(id);
        author.setNumberOfBooks(author.getNumberOfBooks()+newBooksAdded);
        authorRepo.save(author);
        return DataClass.Fields.BOOK_COUNT+DataClass.ReturnMessages.UPDATE_SUCCESS;
    }
    public String updateRatingOfAuthor(int id,double newRating){
        if(!authorRepo.existsById(id)) return DataClass.ReturnMessages.ITEM_DOESNT_EXIST;
        Author author = authorRepo.findById(id);
        author.setRating(newRating);
        authorRepo.save(author);
        return DataClass.Fields.RATING+DataClass.ReturnMessages.UPDATE_SUCCESS;
    }

    /*Books related functions */
    public String addBook(Book book){
        if(bookRepo.existsById(book.getId())) return DataClass.ReturnMessages.ITEM_EXISTS;
        bookRepo.save(book);
        return DataClass.Fields.BOOK+DataClass.ReturnMessages.ADD_SUCCESS;
    }
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    public Book getBook(int id){
        return bookRepo.findById(id).orElse(null);
    }
    public Book getBook(String name){
        if(!bookRepo.existsByName(name)) return null;
        return bookRepo.findByName(name);
    }
    public Author getAuthorOfBook(int id){
        if(!bookRepo.existsById(id)) return null;
        return getAuthor(bookRepo.getReferenceById(id).getAuthorId());
    }
    public String updateCopiesSold(int id,int newSold){
        if(!bookRepo.existsById(id)) return DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST;
        Book book = bookRepo.findById(id).orElse(null);
        book.setCopiesSold(book.getCopiesSold()+newSold);
        bookRepo.save(book);
        return DataClass.Fields.SOLD_COUNT+DataClass.ReturnMessages.UPDATE_SUCCESS;
    }
    public String updateCopiesSold(String name,int newSold){
        if(!bookRepo.existsByName(name)) return DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST;
        Book book = bookRepo.findByName(name);
        book.setCopiesSold(book.getCopiesSold()+newSold);
        bookRepo.save(book);
        return DataClass.Fields.SOLD_COUNT+DataClass.ReturnMessages.UPDATE_SUCCESS;
    }
    public String addLanguageToBook(Integer id,String language){
        if(!bookRepo.existsById(id)) return DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST;
        Book book = bookRepo.findById(id).orElse(null);
        book.setBaseLanguage(language);
        bookRepo.save(book);
        return DataClass.Fields.BASE_LANGUAGE+DataClass.ReturnMessages.UPDATE_SUCCESS;
    }
    public String addLanguageToBook(String name,String language){
        if(!bookRepo.existsByName(name)) return DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST;
        Book book = bookRepo.findByName(name);
        book.setBaseLanguage(language);
        bookRepo.save(book);
        return DataClass.Fields.BASE_LANGUAGE+DataClass.ReturnMessages.UPDATE_SUCCESS;
    }
    public List<Book> getBooksOfGenre(String genre){
        return bookRepo.findAllByGenre(genre);
    }
    public List<String> getBookNamesOfGenre(String genre){
        List<String> returnList = new ArrayList<>();
        for(Book book:getBooksOfGenre(genre))
            returnList.add(book.getName());

        return returnList;
    }
}
