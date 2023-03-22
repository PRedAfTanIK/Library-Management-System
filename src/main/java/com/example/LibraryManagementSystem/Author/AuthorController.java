package com.example.LibraryManagementSystem.Author;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    AuthorService authorService = new AuthorService();

    @PostMapping("/addByParameters")
    public String addAuthor(@RequestParam("id")Integer id,
                            @RequestParam("name")String name,
                            @RequestParam("numberOfBooks")int books,
                            @RequestParam("rating")Double ratings){
        return authorService.addAuthor(new Author(id,name,books,ratings));
    }
    @PostMapping("/addByObject")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @GetMapping("/Info")
    public Author getAuthor(@RequestParam("id")Integer id){
        return authorService.getAuthor(id);
    }
    @GetMapping("/Info/{name}")
    public Author getAuthor(@PathVariable("name")String name){
        return authorService.getAuthor(name);
    }
    @GetMapping("/InfoAll")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping("/ratingList")
    public List<List<String>> getAllRatings(){
       return authorService.getAllRatings();
    }

}
