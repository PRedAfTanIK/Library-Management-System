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

//    @PostMapping("/addByPars")
//    public String addBook(@RequestParam("id")Integer id,
//                          @RequestParam("name")String name){
//        return bookService.addBook(new Book(id,name));
//    }

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
    @GetMapping("/getBook")
    public Book getBook(@RequestParam("id")Integer id){
        return bookService.getBook(id);
    }
    @GetMapping("/getBook/{name}")
    public Book getBook(@PathVariable("name")String name){
        return bookService.getBook(name);
    }
    @GetMapping("/getAuthor")
    public Author getAuthorOfBook(@RequestParam("id")Integer id){
        int authorId = bookService.getBook(id).getAuthorId();
        return (new AuthorController()).getAuthor(authorId);
    }
}
