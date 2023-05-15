package com.parmeshwar.goodreads.repository;

import java.util.ArrayList;

import com.parmeshwar.goodreads.model.Book;

public interface BookRepository {
    ArrayList<Book> getBooks(); //GET ALL

    Book getBookById(int bookId); //GET EACH
    
    Book addBook(Book book); //ADD EACH

    String addMultipleBooks(ArrayList<Book> multipleBooks); //ADD MULTIPLE
    
    Book updateBook(int bookId, Book book); //UPDATE 
    
    void deleteBook(int bookId); //DELETE

}