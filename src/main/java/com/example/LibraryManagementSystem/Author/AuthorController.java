package com.example.LibraryManagementSystem.Author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    AuthorService authorService = new AuthorService();

    @PostMapping("/addByParameters")
    public ResponseEntity<String> addAuthor(@RequestParam("id")Integer id,
                                    @RequestParam("name")String name,
                                    @RequestParam("numberOfBooks")int books,
                                    @RequestParam("rating")Double ratings){
        return new ResponseEntity<>(authorService.addAuthor(new Author(id,name,books,ratings)),HttpStatus.CREATED);
    }
    @PostMapping("/addByObject")
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.addAuthor(author),HttpStatus.CREATED);
    }

    @GetMapping("/Info")
    public ResponseEntity<Author> getAuthor(@RequestParam("id")Integer id){
        return new ResponseEntity<>(authorService.getAuthor(id),HttpStatus.OK);
    }
    @GetMapping("/Info/{name}")
    public Author getAuthor(@PathVariable("name")String name){
        return authorService.getAuthor(name);
    }
    @GetMapping("/InfoAll")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return new ResponseEntity<>(authorService.getAllAuthors(),HttpStatus.OK);
    }
    @GetMapping("/ratingList")
    public ResponseEntity<List<List<String>>> getAllRatings(){
       return new ResponseEntity<>(authorService.getAllRatings(),HttpStatus.OK);
    }

}
