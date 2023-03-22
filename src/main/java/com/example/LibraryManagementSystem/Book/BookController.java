package com.example.LibraryManagementSystem.Book;

import com.example.LibraryManagementSystem.Author.Author;
import com.example.LibraryManagementSystem.Author.AuthorController;
import com.example.LibraryManagementSystem.Author.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    BookService bookService = new BookService();
    @PostMapping("/addByObject")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping("/addByPars")
    public String addBook(@RequestParam("id")Integer id,
                          @RequestParam("name")String name,
                          @RequestParam("genre")String genre,
                          @RequestParam("author id")Integer authorId){
        (new AuthorService()).updateBookCountForAuthor(authorId);
        return bookService.addBook(new Book(id,name,genre,authorId));
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getById")
    public Book getBook(@RequestParam("id")Integer id){
        return bookService.getBook(id);
    }
    @GetMapping("/get/{name}")
    public Book getBook(@PathVariable("name")String name){
        return bookService.getBook(name);
    }
    @GetMapping("/getAuthorOfBookWithId")
    public Author getAuthorOfBook(@RequestParam("id")Integer id){
        int authorId = bookService.getBook(id).getAuthorId();
        return (new AuthorController()).getAuthor(authorId);
    }

    @PutMapping("/CopiesSoldOfBook")
    public String updateCopiesSold(@RequestParam("id")Integer id,
                                   @RequestParam("number")Integer number){
        return bookService.updateCopiesSold(id,number);
    }
    @PutMapping("/CopiesSoldOfBook/{name}={number}")
    public String updateCopiesSold(@PathVariable("name")String name,
                                   @PathVariable("number")Integer number){
        return bookService.updateCopiesSold(name,number);
    }
    @PutMapping("/addBaseLanguage/{id}={language}")
    public String putBaseLanguage(@PathVariable("id")Integer id,
                                  @PathVariable("language")String language){
        return bookService.addLanguageToBook(id,language);
    }
    @PutMapping("/addBaseLanguage/{name}={language}")
    public String putBaseLanguage(@PathVariable("name")String name,
                                  @PathVariable("language")String language){
        return bookService.addLanguageToBook(name,language);
    }
}
