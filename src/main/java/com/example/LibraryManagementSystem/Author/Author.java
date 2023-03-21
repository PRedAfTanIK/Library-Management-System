package com.example.LibraryManagementSystem.Author;

public class Author {
    private int id;
    private String name;
    private int numberOfBooks;
    private double rating;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
        this.numberOfBooks = 0;
        this.rating = 0;
    }

    public Author(int id, String name, int numberOfBooks, double rating) {
        this.id = id;
        this.name = name;
        this.numberOfBooks = numberOfBooks;
        this.rating = rating;
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

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
