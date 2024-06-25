package com.hutech.Nguyentansang.services;

import com.hutech.Nguyentansang.entity.Book;
import com.hutech.Nguyentansang.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

}
