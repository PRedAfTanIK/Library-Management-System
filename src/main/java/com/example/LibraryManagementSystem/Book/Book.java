package com.example.LibraryManagementSystem.Book;

public class Book {
    private int id;
    private String name;
    private String genre;
    private int authorId;
    private int copiesSold;
    private double rating;
    private String baseLanguage;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(int id, String name, String genre, int authorId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.authorId = authorId;
    }

    public Book(int id, String name, String genre, int authorId, int copiesSold, double rating, String baseLanguage) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.authorId = authorId;
        this.copiesSold = copiesSold;
        this.rating = rating;
        this.baseLanguage = baseLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getBaseLanguage() {
        return baseLanguage;
    }

    public void setBaseLanguage(String baseLanguage) {
        this.baseLanguage = baseLanguage;
    }
}
