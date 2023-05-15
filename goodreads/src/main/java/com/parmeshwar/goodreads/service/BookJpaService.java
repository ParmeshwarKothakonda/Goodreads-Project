package com.parmeshwar.goodreads.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.parmeshwar.goodreads.repository.BookJpaRepository;
import com.parmeshwar.goodreads.repository.BookRepository;
import com.parmeshwar.goodreads.model.Book;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class BookJpaService implements BookRepository {

  @Autowired
  private BookJpaRepository bookJpaRepository; 

  @Override
  public ArrayList<Book> getBooks() {
    List<Book> bookList = bookJpaRepository.findAll();
    ArrayList<Book> books = new ArrayList<>(bookList);
    return books;
  }

  @Override
  public Book getBookById(int bookId) {
    
    try{
        Book book = bookJpaRepository.findById(bookId).get();
        return book;
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Book addBook(Book book) {

      bookJpaRepository.save(book);
      return book;
  }

  @Override

  public String addMultipleBooks(ArrayList<Book> multipleBooks){
    int count = multipleBooks.size();

    for(Book eachBook : multipleBooks){
      bookJpaRepository.save(eachBook);
    }

    String returnMessage = String.format("Succesfully added %d books!!",count);
    return returnMessage;
  }

  @Override
  public Book updateBook(int bookId, Book book) {
    try{
        Book newBook = bookJpaRepository.findById(bookId).get();

        if(book.getName() != null){
          newBook.setName(book.getName());
        }
        
        if(book.getAuthor() != null){
            newBook.setAuthor(book.getAuthor());
          }
        
        if(book.getDescription() != null){
            newBook.setDescription(book.getDescription());
          }

        if(book.getImageUrl() != null){
          newBook.setImageUrl(book.getImageUrl());
        }

        bookJpaRepository.save(newBook);
        return newBook;
    }
    catch(Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public void deleteBook(int bookId) {
    try{
      bookJpaRepository.deleteById(bookId);
    }
    catch(Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
      
  }
}