package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DataClass;
import com.example.LibraryManagementSystem.model.Author;
import com.example.LibraryManagementSystem.LibraryService;
import com.example.LibraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    private LibraryService libraryService;

//    @Autowired
//    public void setLibraryService(LibraryService libraryService){
//        this.libraryService = libraryService;
//    }

    @PostMapping("/addByObject")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return new ResponseEntity<>(libraryService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(libraryService.getAllBooks(),HttpStatus.OK);
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getBook(@RequestParam("id")Integer id){
        Book book = libraryService.getBook(id);
        if(book.equals(null))
            return new ResponseEntity<>(DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST,
                    HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<?> getBook(@PathVariable("name")String name){
        Book book = libraryService.getBook(name);
        if(book.equals(null))
            return new ResponseEntity<>(DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST,
                    HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @GetMapping("/getAuthorOfBookWithId")
    public ResponseEntity<?> getAuthorOfBook(@RequestParam("id")Integer id){
            Author author = libraryService.getAuthorOfBook(id);
            if(author.equals(null))
                return new ResponseEntity<>(DataClass.Fields.BOOK+DataClass.ReturnMessages.ITEM_DOESNT_EXIST,HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(author,HttpStatus.OK);
    }
    @GetMapping("/booksOfGenreType/{genre}")
    public ResponseEntity<?> booksOfGenre(@PathVariable("genre")String genre){
        List<Book> returnList = libraryService.getBooksOfGenre(genre);
        if(returnList.size() == 0)
            return new ResponseEntity<>(DataClass.ReturnMessages.NO_ENTRIES_PRESENT+genre,HttpStatus.OK);
        return new ResponseEntity<>(returnList,HttpStatus.OK);
    }
    @GetMapping("/bookNamesOfGenreType/{genre}")
    public ResponseEntity<?> bookNamesOfGenre(@PathVariable("genre")String genre){
        List<String> returnList = libraryService.getBookNamesOfGenre(genre);
        if(returnList.size() == 0)
            return new ResponseEntity<>(DataClass.ReturnMessages.NO_ENTRIES_PRESENT+genre,HttpStatus.OK);
        return new ResponseEntity<>(returnList,HttpStatus.OK);
    }

    @PutMapping("/CopiesSoldOfBook")
    public ResponseEntity<String> updateCopiesSold(@RequestParam("id")Integer id,
                                   @RequestParam("number")Integer number){
        return new ResponseEntity<>(libraryService.updateCopiesSold(id,number),HttpStatus.OK);
    }
    @PutMapping("/CopiesSoldOfBook/{name}={number}")
    public ResponseEntity<String> updateCopiesSold(@PathVariable("name")String name,
                                   @PathVariable("number")Integer number){
        return new ResponseEntity<>(libraryService.updateCopiesSold(name,number),HttpStatus.OK);
    }
    @PutMapping("/addBaseLanguage/{id}={language}")
    public ResponseEntity<String> putBaseLanguage(@PathVariable("id")Integer id,
                                  @PathVariable("language")String language){
        return new ResponseEntity<>(libraryService.addLanguageToBook(id,language),HttpStatus.OK);
    }
    @PutMapping("/addBaseLanguage/{name}={language}")
    public ResponseEntity<String> putBaseLanguage(@PathVariable("name")String name,
                                  @PathVariable("language")String language){
        return new ResponseEntity<>(libraryService.addLanguageToBook(name,language),HttpStatus.OK);
    }
}
