package com.hutech.Nguyentansang.controller;


import com.hutech.Nguyentansang.entity.Book;
import com.hutech.Nguyentansang.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping("/books")
    public class BookController {
        @Autowired
        private BookService bookService;

        @Autowired
        private com.hutech.Nguyentansang.services.categoryService categoryService;
        @GetMapping
        public String showAllBooks(Model model) {
            List<Book> books = bookService.getAllBook();
            model.addAttribute("books",books);
            return "book/list";
        }

        @GetMapping("/add")
        public String addBookForm(Model model) {
            model.addAttribute("book",new Book());
            model.addAttribute("categories",categoryService.getAllCategory());
            return "book/add";
        }
        @PostMapping("/add")
        public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model)
        {
            if(bindingResult.hasErrors()) {
                model.addAttribute("categories", categoryService.getAllCategory());
                return "book/add";
            }

            bookService.addBook(book);
            return "redirect:/books";
        }
        @GetMapping("/edit/{id}")
        public String editBookForm(@PathVariable("id") Long id, Model model) {
            Book book = bookService.getBookById(id);
            if(book != null) {
                model.addAttribute("book",book);
                model.addAttribute("categories",categoryService.getAllCategory());
                return "book/edit";
            }
            return "redirect:/books";
        }
        @PostMapping("/edit/{id}")
        public String editBook(@PathVariable("id") Long id, BindingResult bindingResult, @Valid Book book, Model model) {
            Book theBook = bookService.getBookById(id);
            if(bindingResult.hasErrors()) {
                model.addAttribute("categories", categoryService.getAllCategory());
                return "book/edit";
            }else if (theBook == null) {
                return "redirect/books";
            }
            theBook.setTitle(book.getTitle());
            theBook.setAuthor(book.getAuthor());
            theBook.setPrice(book.getPrice());
            theBook.setCategory(book.getCategory());
            bookService.updateBook(theBook);
            return "redirect:/books";
        }
        @GetMapping("/delete/{id}")
        public String deleteBook(@PathVariable("id")Long id, Model model) {
            bookService.deleteBook(id);
            return "redirect:/books";
        }

}
