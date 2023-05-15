package com.parmeshwar.goodreads.repository;

import org.springframework.stereotype.Repository;

import com.parmeshwar.goodreads.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book,Integer>{

}
