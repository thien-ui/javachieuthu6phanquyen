package com.hutech.Nguyentansang.repository;


import com.hutech.Nguyentansang.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

}

