package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.LibraryService;
import com.example.LibraryManagementSystem.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    private LibraryService libraryService;

//    @Autowired
//    public void setLibraryService(LibraryService libraryService){
//        this.libraryService = libraryService;
//    }

    @PostMapping("/addByObject")
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(libraryService.addAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("/Info")
    public ResponseEntity<Author> getAuthor(@RequestParam("id")Integer id){
        Author author = libraryService.getAuthor(id);
        if(author.equals(null)) return new ResponseEntity<>(new Author(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }
    @GetMapping("/Info/{name}")
    public ResponseEntity<Author> getAuthor(@PathVariable("name")String name){
        Author author = libraryService.getAuthor(name);
        if(author.equals(null)) return new ResponseEntity<>(new Author(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(libraryService.getAuthor(name),HttpStatus.OK);
    }
    @GetMapping("/InfoAll")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return new ResponseEntity<>(libraryService.getAllAuthors(),HttpStatus.OK);
    }
    @GetMapping("/ratingList")
    public ResponseEntity<List<List<String>>> getAllRatings(){
       return new ResponseEntity<>(libraryService.getAllRatings(),HttpStatus.OK);
    }

}
